package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetGroup;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.targetbased.configuration.TargetAbNTextConfiguration;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNTextConfiguration extends TargetAbNTextConfiguration {
    
    public NDFTargetAbNTextConfiguration() {
        super(new NDFRTEntityNameConfiguration());
    }

    @Override
    public String getNodeHelpDescription(TargetGroup node) {
        return "[TARGET GROUP HELP TEXT]";
    }
}
