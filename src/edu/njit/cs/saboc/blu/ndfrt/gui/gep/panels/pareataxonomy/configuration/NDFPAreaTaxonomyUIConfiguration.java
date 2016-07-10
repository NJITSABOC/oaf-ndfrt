
package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration;

import edu.njit.cs.saboc.blu.core.abn.node.Node;
import edu.njit.cs.saboc.blu.core.gui.dialogs.concepthierarchy.ConceptPainter;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.NodeOptionsPanel;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.pareataxonomy.configuration.PAreaTaxonomyUIConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.abnselection.NDFDisplayFrameListener;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomyUIConfiguration extends PAreaTaxonomyUIConfiguration {
    
    private final NDFPAreaTaxonomyConfiguration config;
    private final NDFDisplayFrameListener listener;
    
    public NDFPAreaTaxonomyUIConfiguration(NDFPAreaTaxonomyConfiguration config, NDFDisplayFrameListener listener) {
        super(config, new NDFPAreaTaxonomyListenerConfiguration());
        
        this.config = config;
        this.listener = listener;
    }

    @Override
    public NodeOptionsPanel getPartitionedNodeOptionsPanel() {
        return new NodeOptionsPanel() {

            @Override
            public void setContents(Node node) {
               
            }

            @Override
            public void clearContents() {
              
            }
        };
    }

    @Override
    public NodeOptionsPanel getNodeOptionsPanel() {
        return new NodeOptionsPanel() {

            @Override
            public void setContents(Node node) {
               
            }

            @Override
            public void clearContents() {
                
            }
        };
    }

    @Override
    public ConceptPainter getConceptHierarchyPainter() {
        return new ConceptPainter();
    }
}
