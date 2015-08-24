package edu.njit.cs.saboc.blu.ndfrt.gui.graphframe;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.GroupEntryLabelCreator;
import edu.njit.cs.saboc.blu.core.gui.graphframe.GenericInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.abn.ReducedNDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.graph.NDFTargetGraph;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.listeners.NDFTargetGroupOptionsConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.utils.drawing.TargetAbNPainter;
import javax.swing.JFrame;

public class NDFTargetAbNInternalGraphFrame extends GenericInternalGraphFrame {


    public NDFTargetAbNInternalGraphFrame(final JFrame parentFrame, final NDFTargetAbstractionNetwork data) {
        super(parentFrame, "NDF RT Ingredient Summary");

        this.setTitle("TEST FRAME");

        replaceInternalFrameDataWith(data);
    }
    
    public NDFTargetGraph getGraph() {
        return (NDFTargetGraph)super.getGraph();
    }

    private void updateHierarchyInfoLabel(NDFTargetAbstractionNetwork data) {               
        setHierarchyInfoText("TEST");
    }

    public void replaceInternalFrameDataWith(NDFTargetAbstractionNetwork data) {
        
        GroupEntryLabelCreator labelCreator;
        
        if (data.isReduced()) {
            labelCreator = new GroupEntryLabelCreator<NDFTargetGroup>() {
                public String getCountStr(NDFTargetGroup targetGroup) {
                    ReducedNDFTargetGroup reduced = (ReducedNDFTargetGroup)targetGroup;
                    
                    if(reduced.getAggregatedGroups().isEmpty()) {
                        return String.format("(I:%d) (D:%d)", targetGroup.getConceptCount(), targetGroup.getSourceConcepts().size());
                    }
                    
                    return String.format("(I:%d) (D:%d) [G:%d]", reduced.getAllGroupsConcepts().size(), reduced.getAllGroupsSourceConcepts().size(), reduced.getAggregatedGroups().size());
                }
            };
        } else {
            labelCreator = new GroupEntryLabelCreator<NDFTargetGroup>() {
                public String getCountStr(NDFTargetGroup targetGroup) {                   
                    return String.format("(I:%d) (D:%d)", targetGroup.getConceptCount(), targetGroup.getSourceConcepts().size());
                }
            };
        }
        
        BluGraph graph = new NDFTargetGraph(parentFrame, data, labelCreator);

        initializeGraphTabs(graph, 
                new TargetAbNPainter(), 
                new NDFTargetGroupOptionsConfiguration(parentFrame, this, data));

        updateHierarchyInfoLabel(data);

        tabbedPane.validate();
        tabbedPane.repaint();
    }
    
}
