package edu.njit.cs.saboc.blu.ndfrt.gui.graphframe;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.options.GraphOptions;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.GroupOptionsPanelConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.AbNPainter;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.GroupEntryLabelCreator;
import edu.njit.cs.saboc.blu.core.gui.graphframe.GenericInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPArea;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPAreaTaxonomy;
import edu.njit.cs.saboc.blu.ndfrt.graph.NDFPAreaBluGraph;
import javax.swing.JFrame;

/**
 *
 * @author Chris O
 */
public class NDFPAreaInternalGraphFrame extends GenericInternalGraphFrame {

    public NDFPAreaInternalGraphFrame(final JFrame parentFrame, final NDFPAreaTaxonomy data,
            boolean areaGraph, boolean conceptCounts) {

        super(parentFrame, "NDF RT Partial-area Taxonomy");
        
        replaceInternalFrameDataWith(data, areaGraph, conceptCounts, null);
    }

    public NDFPAreaBluGraph getGraph() {
        return (NDFPAreaBluGraph)super.getGraph();
    }

    private void updateHierarchyInfoLabel(NDFPAreaTaxonomy data) {
        
        setHierarchyInfoText(String.format("Areas: %d | Partial-areas: %d | Classes: %d",
                data.getAreas().size(), 
                data.getGroups().keySet().size(), 
                data.getConceptHierarchy().getNodesInHierarchy().size()));
    }

    public final void replaceInternalFrameDataWith(NDFPAreaTaxonomy data,
            boolean areaGraph, boolean conceptCountLabels, GraphOptions options) {
        
        GroupEntryLabelCreator labelCreator;
        
        if(data.isReduced()) {
            labelCreator = new GroupEntryLabelCreator<NDFPArea>() {
                public String getCountStr(NDFPArea parea) {
                    return String.format("(%d) [%d]", parea.getConceptCount(), 0);
                }
            };
        } else {
            labelCreator = new GroupEntryLabelCreator<NDFPArea>();
        }
        
        BluGraph newGraph = new NDFPAreaBluGraph(parentFrame, data, areaGraph,conceptCountLabels, options, labelCreator);

        initializeGraphTabs(newGraph, new AbNPainter(), 
                null, 
                new GroupOptionsPanelConfiguration() {
                    
                });

        updateHierarchyInfoLabel(data); 
    }
}

