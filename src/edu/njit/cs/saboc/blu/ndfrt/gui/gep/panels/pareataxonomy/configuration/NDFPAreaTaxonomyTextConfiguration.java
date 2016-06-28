package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration;

import edu.njit.cs.saboc.blu.core.abn.node.Node;
import edu.njit.cs.saboc.blu.core.abn.node.PartitionedNode;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PArea;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.pareataxonomy.configuration.PAreaTaxonomyTextConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.configuration.NDFRTEntityNameUtils;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomyTextConfiguration extends PAreaTaxonomyTextConfiguration {
    
    public NDFPAreaTaxonomyTextConfiguration(PAreaTaxonomy taxonomy) {
        super(taxonomy);
    }

    @Override
    public String getConceptTypeName(boolean plural) {
        return NDFRTEntityNameUtils.getConceptTypeName(plural);
    }

    @Override
    public String getParentConceptTypeName(boolean plural) {
        return NDFRTEntityNameUtils.getParentConceptTypeName(plural);
    }

    @Override
    public String getChildConceptTypeName(boolean plural) {
        return NDFRTEntityNameUtils.getChildConceptTypeName(plural);
    }

    @Override
    public String getNodeHelpDescription(Node node) {
        PArea parea = (PArea)node;
        
        return "*** PAREA HELP TEXT ***";
    }
    
    @Override
    public String getContainerHelpDescription(PartitionedNode container) {
        return "*** AREA HELP TEXT ***";
    }

}
