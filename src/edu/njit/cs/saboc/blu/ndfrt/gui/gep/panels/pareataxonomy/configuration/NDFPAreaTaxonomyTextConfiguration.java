package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.Area;
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
    public String getNodeHelpDescription(PArea parea) {
        return "*** PAREA HELP TEXT ***";
    }
    
    @Override
    public String getContainerHelpDescription(Area container) {
        return "*** AREA HELP TEXT ***";
    }

    @Override
    public String getPropertyTypeName(boolean plural) {
        return NDFRTEntityNameUtils.getPropertyTypeName(plural);
    }
}
