package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.pareataxonomy.configuration.PAreaTaxonomyTextConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.configuration.NDFRTEntityNameConfiguration;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomyTextConfiguration extends PAreaTaxonomyTextConfiguration {
    
    public NDFPAreaTaxonomyTextConfiguration(PAreaTaxonomy taxonomy) {
        super(new NDFRTEntityNameConfiguration(), taxonomy);
    }
}
