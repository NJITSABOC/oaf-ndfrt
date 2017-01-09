
package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration;

import edu.njit.cs.saboc.blu.core.abn.node.Node;
import edu.njit.cs.saboc.blu.core.gui.dialogs.concepthierarchy.ConceptPainter;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.NodeOptionsPanel;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.pareataxonomy.configuration.PAreaTaxonomyUIConfiguration;
import edu.njit.cs.saboc.blu.core.gui.graphframe.AbNDisplayManager;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomyUIConfiguration extends PAreaTaxonomyUIConfiguration {
    
    private final NDFPAreaTaxonomyConfiguration config;
    
    public NDFPAreaTaxonomyUIConfiguration(
            NDFPAreaTaxonomyConfiguration config, 
            AbNDisplayManager displayManager) {
        
        super(config, displayManager, new NDFPAreaTaxonomyListenerConfiguration(config));
        
        this.config = config;
    }

    @Override
    public NodeOptionsPanel getPartitionedNodeOptionsPanel() {
        return new NodeOptionsPanel<>();
    }

    @Override
    public NodeOptionsPanel getNodeOptionsPanel() {
        return new NodeOptionsPanel<>();
    }

    @Override
    public ConceptPainter getConceptHierarchyPainter() {
        return new ConceptPainter();
    }
}
