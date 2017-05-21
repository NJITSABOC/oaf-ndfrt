package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetGroup;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.targetbased.configuration.TargetAbNTextConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.gui.gep.configuration.NDFRTEntityNameConfiguration;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNTextConfiguration extends TargetAbNTextConfiguration {
    
    public NDFTargetAbNTextConfiguration(TargetAbstractionNetwork targetAbN) {
        
        super(new NDFRTEntityNameConfiguration(), targetAbN);
    }

    @Override
    public String getNodeHelpDescription(TargetGroup node) {
        return "[TARGET GROUP HELP TEXT]";
    }
}
