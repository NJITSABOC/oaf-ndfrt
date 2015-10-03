package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.pareataxonomy.configuration;

import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.pareataxonomy.BLUGenericPAreaTaxonomyConfiguration;

/**
 *
 * @author Den
 */
public class NDFPAreaTaxonomyConfiguration extends BLUGenericPAreaTaxonomyConfiguration {
    public NDFPAreaTaxonomyConfiguration() {
        super(new NDFPAreaTaxonomyDataConfiguration(), new NDFPAreaTaxonomyUIConfiguration(), new NDFPAreaTaxonomyTextConfiguration());
    }
}
