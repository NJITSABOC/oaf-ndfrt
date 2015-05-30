package edu.njit.cs.saboc.blu.ndfrt.graph.layout;

import SnomedShared.generic.GenericContainerPartition;
import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphEdge;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphGroupLevel;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphLevel;
import edu.njit.cs.saboc.blu.core.graph.layout.GraphLayoutUtilities;
import edu.njit.cs.saboc.blu.core.graph.nodes.GenericGroupEntry;
import edu.njit.cs.saboc.blu.core.graph.pareataxonomy.GenericNoRegionsPAreaGraphLayout;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFArea;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPArea;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPAreaTaxonomy;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFRegion;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy.BluNDFArea;
import edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy.BluNDFPArea;
import edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy.BluNDFRegion;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.JLabel;

/**
 *
 * @author Chris O
 */
public class NDFNoRegionsPAreaLayout extends GenericNoRegionsPAreaGraphLayout<
        NDFPAreaTaxonomy, NDFArea, NDFPArea, NDFRegion, 
        BluNDFArea, BluNDFPArea, BluNDFRegion,
        NDFConcept, NDFRole, NDFConceptHierarchy> {

    @Override
    protected BluNDFPArea createPAreaPanel(NDFPArea p, BluNDFRegion parent, int x, int y, int pAreaX, GraphGroupLevel pAreaLevel) {
         BluNDFPArea pAreaPanel = new BluNDFPArea(p, graph, parent, pAreaX, pAreaLevel, new ArrayList<GraphEdge>());

        //Make sure this panel dimensions will fit on the graph, stretch the graph if necessary
        graph.stretchGraphToFitPanel(x, y, GenericGroupEntry.ENTRY_WIDTH, GenericGroupEntry.ENTRY_HEIGHT);

        //Setup the panel's dimensions, etc.
        pAreaPanel.setBounds(x, y, GenericGroupEntry.ENTRY_WIDTH, GenericGroupEntry.ENTRY_HEIGHT);

        parent.add(pAreaPanel, 0);

        return pAreaPanel;
    }

    @Override
    protected BluNDFArea createAreaPanel(NDFArea a, int x, int y, int width, int height, Color c, int areaX, GraphLevel parentLevel) {
        BluNDFArea areaPanel = new BluNDFArea(a, graph, areaX, parentLevel, new Rectangle(x, y, width, height));

        graph.stretchGraphToFitPanel(x, y, width, height);

        areaPanel.setBounds(x, y, width, height);
        areaPanel.setBackground(c);

        graph.add(areaPanel, 0);

        return areaPanel;
    }

    @Override
    protected BluNDFRegion createRegionPanel(NDFRegion region, String regionName, BluNDFArea ap, int x, int y, int width, int height, Color c, boolean treatRegionAsArea, JLabel label) {
        
        BluNDFRegion regionPanel = new BluNDFRegion(region, regionName, width, height, graph, ap, c, treatRegionAsArea, label);

        graph.stretchGraphToFitPanel(x, y, width, height);

        regionPanel.setBounds(x, y, width, height);

        ap.add(regionPanel, 0);

        return regionPanel;
    }

    @Override
    protected ArrayList<String> getAreaRelationshipNames(NDFArea a) {
        ArrayList<String> relNames = new ArrayList<String>();
        
        for(NDFRole role : a.getRelationships()) {
            relNames.add(role.getName());
        }
        
        Collections.sort(relNames);
        
        return relNames;
    }

    @Override
    protected JLabel createRegionLabel(NDFPAreaTaxonomy taxonomy, HashSet<NDFRole> relationships, String countString, int width, int maxRels) {
        
        Canvas canvas = new Canvas();
        FontMetrics fontMetrics = canvas.getFontMetrics(new Font("SansSerif", Font.BOLD, 14));
        
        ArrayList<String> allRelsUsed = new ArrayList<String>();
        
        for(NDFRole role : relationships) {
            allRelsUsed.add(role.getName());
        }
        
        Collections.sort(allRelsUsed);
        
        int longestRelNameWidth = -1;
        
        for (String propertyLabel : allRelsUsed) {
            int propertyNameWidth = fontMetrics.stringWidth(propertyLabel);

            if (propertyNameWidth > longestRelNameWidth) {
                longestRelNameWidth = propertyNameWidth;
            }
        }
        
        longestRelNameWidth += fontMetrics.stringWidth("OP: ");
        
        if (fontMetrics.stringWidth(countString) > longestRelNameWidth) {
            longestRelNameWidth = fontMetrics.stringWidth(countString);
        }

        if (relationships.size() > 1) {
            longestRelNameWidth += fontMetrics.charWidth(',');
        }

        if (longestRelNameWidth > width) {
            width = longestRelNameWidth + 4;
        }
        
        ArrayList<String> entries = new ArrayList<String>();
        
        if(allRelsUsed.isEmpty()) {
            entries.add("\u2205");
        } else {
            entries = allRelsUsed;
            
            entries.add(countString);
        }

        return GraphLayoutUtilities.createFittedPartitionLabel(entries.toArray(new String[0]), width, fontMetrics);
    }

    @Override
    public JLabel createPartitionLabel(GenericContainerPartition partition, int width) {
        String countStr = "";
        
        if(graph.showingConceptCountLabels()) {
            
        } else {
            if(partition.getGroups().size() == 1) {
                countStr = "1 Partial-area";
            } else {
                countStr = String.format("%d Partial-areas", partition.getGroups().size());
            }
        }
        
        return createRegionLabel(taxonomy, ((NDFRegion)partition).getRelationships(), countStr, width, -1);
    }
    
    public NDFNoRegionsPAreaLayout(BluGraph graph, NDFPAreaTaxonomy taxonomy) {
        super(graph, taxonomy);
    }
}
