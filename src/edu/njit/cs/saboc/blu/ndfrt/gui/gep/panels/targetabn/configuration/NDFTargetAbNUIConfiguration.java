package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.AbNUIConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.AbNListenerConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.NodeDashboardPanel;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.abn.AbstractAbNDetailsPanel;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNUIConfiguration extends AbNUIConfiguration<NDFTargetAbstractionNetwork, 
        NDFTargetGroup, NDFConcept, NDFTargetAbNConfiguration, 
        AbNListenerConfiguration<NDFTargetAbstractionNetwork, NDFTargetGroup, NDFConcept>> {
    
    public NDFTargetAbNUIConfiguration() {
        super(null);
    }

    @Override
    public AbstractAbNDetailsPanel<NDFTargetAbstractionNetwork> createAbNDetailsPanel() {
        return null;
    }

    @Override
    public boolean hasGroupDetailsPanel() {
        return false;
    }

    @Override
    public NodeDashboardPanel<NDFTargetGroup, NDFConcept, NDFTargetAbNConfiguration> createGroupDetailsPanel() {
        return null;
    }
}
