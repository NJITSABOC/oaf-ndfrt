package edu.njit.cs.saboc.blu.ndfrt.gui.graphframe;

import edu.njit.cs.saboc.blu.core.abn.node.Node;
import edu.njit.cs.saboc.blu.core.abn.targetbased.AggregateTargetGroup;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetGroup;
import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.targetabn.TargetBluGraph;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.SinglyRootedNodeLabelCreator;
import edu.njit.cs.saboc.blu.core.gui.graphframe.GenericInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration.NDFTargetAbNConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.utils.drawing.TargetAbNPainter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class NDFTargetAbNInternalGraphFrame extends GenericInternalGraphFrame {


    public NDFTargetAbNInternalGraphFrame(final JFrame parentFrame, final TargetAbstractionNetwork data) {
        super(parentFrame, "NDF RT Ingredient Summary");

        this.setTitle("TEST FRAME");

        replaceInternalFrameDataWith(data);
    }
    
    public TargetBluGraph getGraph() {
        return (TargetBluGraph)super.getGraph();
    }

    private void updateHierarchyInfoLabel(TargetAbstractionNetwork data) {               
        setHierarchyInfoText("TEST");
    }

    public final void replaceInternalFrameDataWith(TargetAbstractionNetwork targetAbN) {

        Thread loadThread = new Thread(() -> {
            gep.showLoading();
            
            SinglyRootedNodeLabelCreator labelCreator;

            if (targetAbN.isAggregated()) {
                labelCreator = new SinglyRootedNodeLabelCreator () {
                    public String getCountStr(Node node) {
                        AggregateTargetGroup aggregateGroup = (AggregateTargetGroup) node;

                        if (aggregateGroup.getAggregatedNodes().isEmpty()) {
                            return String.format("(I:%d) (D:%d)", aggregateGroup.getConceptCount(), aggregateGroup.getIncomingRelationshipSources().size());
                        }

                        return String.format("(I:%d) (D:%d) [G:%d]", 
                                aggregateGroup.getConceptCount(), 
                                aggregateGroup.getIncomingRelationshipSources().size(), 
                                aggregateGroup.getAggregatedNodes().size());
                    }
                };
            } else {
                labelCreator = new SinglyRootedNodeLabelCreator() {
                    public String getCountStr(TargetGroup targetGroup) {
                        return String.format("(I:%d) (D:%d)", targetGroup.getConceptCount(), targetGroup.getIncomingRelationshipSources().size());
                    }
                };
            }

            BluGraph graph = new TargetBluGraph(parentFrame, targetAbN, labelCreator);

            SwingUtilities.invokeLater(() -> {
                displayAbstractionNetwork(graph,
                        new TargetAbNPainter(),
                        new NDFTargetAbNConfiguration(targetAbN));

                updateHierarchyInfoLabel(targetAbN);

                tabbedPane.validate();
                tabbedPane.repaint();
            });
        });
        
        loadThread.start();
    }
}
