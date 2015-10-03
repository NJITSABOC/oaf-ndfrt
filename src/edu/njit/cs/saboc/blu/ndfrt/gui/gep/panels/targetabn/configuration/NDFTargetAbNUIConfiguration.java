package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.ui.BLUAbNUIConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.ui.listener.BLUAbNListenerConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.AbstractNodePanel;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.abn.AbstractAbNDetailsPanel;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNUIConfiguration extends BLUAbNUIConfiguration<NDFTargetAbstractionNetwork, 
        NDFTargetGroup, NDFConcept, NDFTargetAbNConfiguration, 
        BLUAbNListenerConfiguration<NDFTargetAbstractionNetwork, NDFTargetGroup, NDFConcept>> {
    
    public NDFTargetAbNUIConfiguration() {
        super(null);
    }

    @Override
    public AbstractAbNDetailsPanel<NDFTargetAbstractionNetwork> createAbNDetailsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasGroupDetailsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractNodePanel<NDFTargetGroup, NDFConcept, NDFTargetAbNConfiguration> createGroupDetailsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
