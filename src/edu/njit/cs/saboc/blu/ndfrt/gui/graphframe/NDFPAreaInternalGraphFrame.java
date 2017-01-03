package edu.njit.cs.saboc.blu.ndfrt.gui.graphframe;

import edu.njit.cs.saboc.blu.core.abn.node.SinglyRootedNode;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.AggregatePArea;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.graph.AbstractionNetworkGraph;
import edu.njit.cs.saboc.blu.core.graph.pareataxonomy.PAreaTaxonomyGraph;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.AbNPainter;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.SinglyRootedNodeLabelCreator;
import edu.njit.cs.saboc.blu.core.gui.graphframe.GenericInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration.NDFPAreaTaxonomyConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration.NDFPAreaTaxonomyConfigurationFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Chris O
 */
public class NDFPAreaInternalGraphFrame extends GenericInternalGraphFrame<PAreaTaxonomy> {

    public NDFPAreaInternalGraphFrame(
            JFrame parentFrame, 
            PAreaTaxonomy data) {

        super(parentFrame, "NDF-RT Partial-area Taxonomy");
        
        replaceInternalFrameDataWith(data);
    }

    private void updateHierarchyInfoLabel(PAreaTaxonomy data) {
        setHierarchyInfoText(String.format("Areas: %d | Partial-areas: %d | Classes: %d",
                data.getAreas().size(), 
                data.getPAreas().size(),
                data.getSourceHierarchy().size()));
    }

    public final void replaceInternalFrameDataWith(PAreaTaxonomy taxonomy) {
        
        Thread loadThread = new Thread(new Runnable() {
            public void run() {
                getAbNExplorationPanel().showLoading();
                
                SinglyRootedNodeLabelCreator labelCreator;

                if (taxonomy.isAggregated()) {
                    labelCreator = new SinglyRootedNodeLabelCreator() {
                        public String getCountStr(SinglyRootedNode node) {
                            
                            AggregatePArea parea = (AggregatePArea)node;
                            return String.format("(%d) [%d]", parea.getConceptCount(), parea.getAggregatedNodes().size());
                        }
                    };
                } else {
                    labelCreator = new SinglyRootedNodeLabelCreator();
                }
                
                NDFPAreaTaxonomyConfiguration config = NDFPAreaTaxonomyConfigurationFactory.getConfigurationFor(taxonomy, null);

                AbstractionNetworkGraph newGraph = new PAreaTaxonomyGraph(getParentFrame(), taxonomy, labelCreator, config);
                
                SwingUtilities.invokeLater(() -> {
                    displayAbstractionNetwork(newGraph, new AbNPainter(), config);
                    
                    updateHierarchyInfoLabel(taxonomy);
                });
            }
        });
        
        loadThread.start();
    }
}

