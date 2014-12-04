package edu.njit.cs.saboc.blu.ndfrt.gui.graphframe;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.gui.graphframe.GenericInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.graph.NDFTargetGraph;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.listeners.NDFTargetAbNGEPListener;
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
        
        BluGraph graph = new NDFTargetGraph(parentFrame, data);

        initializeGraphTabs(graph, 
                new TargetAbNPainter(), 
                new NDFTargetAbNGEPListener(parentFrame), 
                new NDFTargetGroupOptionsConfiguration(parentFrame, this, data));

        updateHierarchyInfoLabel(data);

        tabbedPane.validate();
        tabbedPane.repaint();
    }
    
}
