package edu.njit.cs.saboc.blu.ndfrt.gui.graphframe;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.SinglyRootedNodeLabelCreator;
import edu.njit.cs.saboc.blu.core.gui.graphframe.GenericInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.abn.ReducedNDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.graph.NDFTargetGraph;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration.NDFTargetAbNConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.utils.drawing.TargetAbNPainter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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

        Thread loadThread = new Thread(() -> {
            gep.showLoading();
            
            SinglyRootedNodeLabelCreator labelCreator;

            if (data.isReduced()) {
                labelCreator = new SinglyRootedNodeLabelCreator<NDFTargetGroup>() {
                    public String getCountStr(NDFTargetGroup targetGroup) {
                        ReducedNDFTargetGroup reduced = (ReducedNDFTargetGroup) targetGroup;

                        if (reduced.getAggregatedGroups().isEmpty()) {
                            return String.format("(I:%d) (D:%d)", targetGroup.getConceptCount(), targetGroup.getSourceConcepts().size());
                        }

                        return String.format("(I:%d) (D:%d) [G:%d]", reduced.getAllGroupsConcepts().size(), reduced.getAllGroupsSourceConcepts().size(), reduced.getAggregatedGroups().size());
                    }
                };
            } else {
                labelCreator = new SinglyRootedNodeLabelCreator<NDFTargetGroup>() {
                    public String getCountStr(NDFTargetGroup targetGroup) {
                        return String.format("(I:%d) (D:%d)", targetGroup.getConceptCount(), targetGroup.getSourceConcepts().size());
                    }
                };
            }

            BluGraph graph = new NDFTargetGraph(parentFrame, data, labelCreator);

            SwingUtilities.invokeLater(() -> {
                displayAbstractionNetwork(graph,
                        new TargetAbNPainter(),
                        new NDFTargetAbNConfiguration());

                updateHierarchyInfoLabel(data);

                tabbedPane.validate();
                tabbedPane.repaint();
            });
        });
        
        loadThread.start();
    }
}
