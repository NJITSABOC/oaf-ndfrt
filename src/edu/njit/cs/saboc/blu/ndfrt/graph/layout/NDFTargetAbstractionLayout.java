package edu.njit.cs.saboc.blu.ndfrt.graph.layout;

import SnomedShared.generic.GenericConceptGroup;
import SnomedShared.generic.GenericContainerPartition;
import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphEdge;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphGroupLevel;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphLane;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphLevel;
import edu.njit.cs.saboc.blu.core.graph.layout.BluGraphLayout;
import edu.njit.cs.saboc.blu.core.graph.layout.GraphLayoutConstants;
import edu.njit.cs.saboc.blu.core.graph.nodes.SinglyRootedNodeEntry;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetContainer;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.abn.ReducedNDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.graph.targetabn.BluNDFTargetContainer;
import edu.njit.cs.saboc.blu.ndfrt.graph.targetabn.BluNDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.graph.targetabn.BluNDFTargetPartition;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import javax.swing.JLabel;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbstractionLayout extends BluGraphLayout<NDFTargetContainer, BluNDFTargetContainer, BluNDFTargetGroup> {

    private NDFTargetAbstractionNetwork targetAbN;
    
    public NDFTargetAbstractionLayout(BluGraph graph, NDFTargetAbstractionNetwork targetAbN) {
        super(graph);
        
        this.targetAbN = targetAbN;
    }

    public void doLayout() {
        ArrayList<ArrayList<NDFTargetGroup>> groupLevels = new ArrayList<ArrayList<NDFTargetGroup>>();

        NDFTargetGroup root = targetAbN.getRootGroup();
        
        HashMap<NDFTargetGroup, Integer> parentGroupCount = new HashMap<NDFTargetGroup, Integer>(); 
        
        parentGroupCount.put(root, 0);
        
        for(GenericConceptGroup group : targetAbN.getGroups().values()) {
            parentGroupCount.put((NDFTargetGroup)group, group.getParentIds().size());
        }
        
        Queue<NDFTargetGroup> queue = new LinkedList<NDFTargetGroup>();
        queue.add(root);
        
        HashMap<NDFTargetGroup, Integer> groupDepths = new HashMap<NDFTargetGroup, Integer>();

        while(!queue.isEmpty()) {
            NDFTargetGroup group = queue.remove();
            
            HashSet<Integer> parentIds = group.getParentIds();
            
            int maxParentDepth = -1;
            
            for(int parentId : parentIds) {
                NDFTargetGroup parentGroup = (NDFTargetGroup)targetAbN.getGroups().get(parentId);
                
                int parentDepth = groupDepths.get(parentGroup);
                
                if(parentDepth > maxParentDepth) {
                    maxParentDepth = parentDepth;
                }
            }
            
            int depth = maxParentDepth + 1;
            
            groupDepths.put(group, depth);
            
            if(groupLevels.size() < depth + 1) {
                groupLevels.add(new ArrayList<NDFTargetGroup>());
            }
            
            groupLevels.get(depth).add(group);

            HashSet<NDFTargetGroup> childGroups = targetAbN.getChildGroups(group);
            
            for(NDFTargetGroup childGroup : childGroups) {

                int parentCount = parentGroupCount.get(childGroup) - 1;
                
                if(parentCount == 0) {
                    queue.add(childGroup);
                } else {
                    parentGroupCount.put(childGroup, parentCount);
                }
            }
        }
        
        int level = 0;
        
        for(ArrayList<NDFTargetGroup> levelGroups : groupLevels) {
            
            
            Collections.sort(levelGroups, new Comparator<NDFTargetGroup>() {
                public int compare(NDFTargetGroup a, NDFTargetGroup b) {
                    int aConceptCount;
                    
                    
                    if(a instanceof ReducedNDFTargetGroup) {
                        aConceptCount = ((ReducedNDFTargetGroup)a).getAllGroupsConcepts().size();
                    } else {
                        aConceptCount = a.getConceptCount();
                    }
                    
                    int bConceptCount;
                    
                    if (b instanceof ReducedNDFTargetGroup) {
                        bConceptCount = ((ReducedNDFTargetGroup)b).getAllGroupsConcepts().size();
                    } else {
                        bConceptCount = b.getConceptCount();
                    }
                    
                    if(aConceptCount != bConceptCount) {
                        return bConceptCount - aConceptCount;
                    } else {
                        return a.getRoot().getName().compareToIgnoreCase(b.getRoot().getName());
                    }
                }
            });
            
        }
        
        int containerX = 0;  // The first area on each line is given an areaX value of 0.
        int containerY = 0;  // The first row of areas is given an areaY value of 0.
        int x = 0;
        int y = 20;
        
        int areaId = 0;

        addGraphLevel(new GraphLevel(0, graph, new ArrayList<GraphLane>())); // Add the first level of areas (the single pArea 0-relationship level) to the data representation of the graph.

        for (ArrayList<NDFTargetGroup> groupLevel : groupLevels) {  // Loop through the areas and generate the diagram for each of them
            int maxRows = 0;
            int width = 0;

            int groupCount = groupLevel.size();

            int groupEntriesWide = Math.min(14, groupCount);

            int levelWidth = groupEntriesWide * (SinglyRootedNodeEntry.ENTRY_WIDTH + GraphLayoutConstants.GROUP_CHANNEL_WIDTH);

            width += levelWidth + 20;

            int height = (int) (Math.ceil((double) groupCount / groupEntriesWide))
                    * (SinglyRootedNodeEntry.ENTRY_HEIGHT + GraphLayoutConstants.GROUP_ROW_HEIGHT);

            width += 20;
            height += 60 + GraphLayoutConstants.GROUP_ROW_HEIGHT;

            GraphLevel currentLevel = levels.get(containerY);

            BluNDFTargetContainer containerEntry = createContainerPanel(x, y, width, height, containerX, currentLevel);

            containerEntries.put(areaId++, containerEntry);

            // Add a data representation for this new area to the current area Level obj.
            currentLevel.addContainerEntry(containerEntry);

            // Generates a column of lanes to the left of this area.
            addColumn(containerX, currentLevel.getLevelY(), generateColumnLanes(-3,
                    GraphLayoutConstants.CONTAINER_CHANNEL_WIDTH - 5, 3, null));

            int [] groupX = new int[(int)Math.ceil((double)groupLevel.size() / (double)groupEntriesWide)];

            int x2 = (int) (1.5 * GraphLayoutConstants.GROUP_CHANNEL_WIDTH);
            int y2 = 30;

            int clusterX = 0;
            int clusterY = 0;

            BluNDFTargetPartition currentPartition = createPartitionPanel(containerEntry, 0, 0, width, height);
            
            containerEntry.addPartitionEntry(currentPartition);

            currentPartition.addGroupLevel(new GraphGroupLevel(0, currentPartition)); // Add a new pAreaLevel to the data representation of the current Area object.

            containerEntry.addRow(0, generateUpperRowLanes(-4,
                    GraphLayoutConstants.GROUP_ROW_HEIGHT - 5, 3, containerEntry));

            int i = 0;

            for (NDFTargetGroup group : groupLevel) {
                
                HashSet<NDFConcept> drugIngredients = new HashSet<NDFConcept>();
                HashSet<NDFConcept> ppDrugs = new HashSet<NDFConcept>();
                
                for(Entry<NDFConcept, HashSet<NDFConcept>> entry : group.getGroupIncomingRelSources().entrySet()) {
                    drugIngredients.add(entry.getKey());
                    ppDrugs.addAll(entry.getValue());
                }
                
                System.out.println(String.format("%s (I:%d) (D:%d)", group.getRoot().getName(), drugIngredients.size(), ppDrugs.size()));
                
                GraphGroupLevel currentClusterLevel = currentPartition.getGroupLevels().get(clusterY);
                
                BluNDFTargetGroup targetGroupEntry = createGroupPanel(group, currentPartition, x2, y2, clusterX, currentClusterLevel);

                currentPartition.getVisibleGroups().add(targetGroupEntry);

                currentPartition.addColumn(groupX[clusterY], generateColumnLanes(-3,
                        GraphLayoutConstants.GROUP_CHANNEL_WIDTH - 2, 3, containerEntry));

                groupEntries.put(group.getId(), targetGroupEntry);    // Store it in a map keyed by its ID...

                currentClusterLevel.addGroupEntry(targetGroupEntry);

                if ((i + 1) % groupEntriesWide == 0 && i < groupLevel.size() - 1) {
                    y2 += SinglyRootedNodeEntry.ENTRY_HEIGHT + GraphLayoutConstants.GROUP_ROW_HEIGHT;
                    x2 = (int) (1.5 * GraphLayoutConstants.GROUP_CHANNEL_WIDTH);
                    clusterX = 0;
                    
                    groupX[clusterY]++;
                    
                    clusterY++;

                    if (currentPartition.getGroupLevels().size() <= clusterY) {
                        currentPartition.addGroupLevel(new GraphGroupLevel(clusterY, currentPartition)); // Add a new pAreaLevel to the data representation of the current Area object.
                        
                        containerEntry.addRow(clusterY, generateUpperRowLanes(-4,
                                GraphLayoutConstants.GROUP_ROW_HEIGHT - 5, 3, containerEntry));
                    }
                } else {
                    x2 += (SinglyRootedNodeEntry.ENTRY_WIDTH + GraphLayoutConstants.GROUP_CHANNEL_WIDTH);
                    clusterX++;
                    groupX[clusterY]++;
                }

                i++;
            }

            x = 0;  // Reset the x coordinate to the left
            y += height + GraphLayoutConstants.CONTAINER_ROW_HEIGHT;

            containerY++;    // Update the areaY variable to reflect the new row.
            containerX = 0;  // Reset the areaX variable.
            
            System.out.println(containerY);
            System.out.println();

            addGraphLevel(new GraphLevel(containerY, graph,
                    generateUpperRowLanes(-5, GraphLayoutConstants.CONTAINER_ROW_HEIGHT - 7, 3, null))); // Add a level object to 
        }
        
        this.centerGraphLevels(this.getGraphLevels());
    }
    
    
     protected BluNDFTargetGroup createGroupPanel(NDFTargetGroup p, BluNDFTargetPartition parent, int x, int y, int groupX, GraphGroupLevel clusterLevel) {
        BluNDFTargetGroup targetGroupEntry = new BluNDFTargetGroup(p, graph, groupX, clusterLevel, new ArrayList<GraphEdge>());

        //Make sure this panel dimensions will fit on the graph, stretch the graph if necessary
        graph.stretchGraphToFitPanel(x, y, SinglyRootedNodeEntry.ENTRY_WIDTH, SinglyRootedNodeEntry.ENTRY_HEIGHT);

        //Setup the panel's dimensions, etc.
        targetGroupEntry.setBounds(x, y, SinglyRootedNodeEntry.ENTRY_WIDTH, SinglyRootedNodeEntry.ENTRY_HEIGHT);

        parent.add(targetGroupEntry, 0);

        return targetGroupEntry;
    }

    protected BluNDFTargetContainer createContainerPanel(int x, int y, int width, int height, int areaX, GraphLevel parentLevel) {
        BluNDFTargetContainer targetPanel = new BluNDFTargetContainer(graph, areaX, parentLevel, new Rectangle(x, y, width, height));

        graph.stretchGraphToFitPanel(x, y, width, height);

        targetPanel.setBounds(x, y, width, height);

        graph.add(targetPanel, 0);

        return targetPanel;
    }

    protected BluNDFTargetPartition createPartitionPanel(BluNDFTargetContainer container, int x, int y, int width, int height) {

        BluNDFTargetPartition partitionPanel = new BluNDFTargetPartition(width, height, container, graph);

        graph.stretchGraphToFitPanel(x, y, width, height);

        partitionPanel.setBounds(x, y, width, height);

        container.add(partitionPanel, 0);

        return partitionPanel;
    }
    
    public JLabel createPartitionLabel(GenericContainerPartition partition, int width) {
        return new JLabel();
    }
}