package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.AbNConfiguration;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNConfiguration extends AbNConfiguration<NDFTargetAbNDataConfiguration, NDFTargetAbNUIConfiguration, NDFTargetAbNTextConfiguration> {
    
    public NDFTargetAbNConfiguration() {
        super(new NDFTargetAbNDataConfiguration(), new NDFTargetAbNUIConfiguration(), new NDFTargetAbNTextConfiguration());
    }
}
