package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.AbNConfiguration;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNConfiguration extends AbNConfiguration {
    
    public NDFTargetAbNConfiguration(TargetAbstractionNetwork targetAbN) {
        super(targetAbN);
    }
    
    public TargetAbstractionNetwork getAbstractionNetwork() {
        return (TargetAbstractionNetwork)super.getAbstractionNetwork();
    }
}
