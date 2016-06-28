package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomy;
import edu.njit.cs.saboc.blu.ndfrt.gui.abnselection.NDFDisplayFrameListener;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomyConfigurationFactory {
    public static NDFPAreaTaxonomyConfiguration getConfigurationFor(PAreaTaxonomy taxonomy, NDFDisplayFrameListener displayListener) {
        
        NDFPAreaTaxonomyConfiguration pareaTaxonomyConfiguration = new NDFPAreaTaxonomyConfiguration(taxonomy);
        pareaTaxonomyConfiguration.setUIConfiguration(new NDFPAreaTaxonomyUIConfiguration(pareaTaxonomyConfiguration, displayListener));
        pareaTaxonomyConfiguration.setTextConfiguration(new NDFPAreaTaxonomyTextConfiguration(taxonomy));

        return pareaTaxonomyConfiguration;
    }
}
