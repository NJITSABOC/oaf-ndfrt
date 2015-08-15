
package edu.njit.cs.saboc.blu.ndfrt.gui.gep.listeners;

import edu.njit.cs.saboc.blu.core.gui.gep.panels.BLUGraphConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.AbstractNodePanel;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.gui.graphframe.NDFTargetAbNInternalGraphFrame;
import javax.swing.JFrame;

/**
 *
 * @author Chris O
 */
public class NDFTargetGroupOptionsConfiguration extends BLUGraphConfiguration {

    public NDFTargetGroupOptionsConfiguration(
            final JFrame parentFrame, 
            final NDFTargetAbNInternalGraphFrame graphFrame,
            final NDFTargetAbstractionNetwork abn) {

    }
    
    @Override
    public boolean hasGroupDetailsPanel() {
        return false;
    }

    @Override
    public AbstractNodePanel createGroupDetailsPanel() {
        return null;
    }
    
    @Override
    public boolean hasContainerDetailsPanel() {
        return false;
    }

    @Override
    public AbstractNodePanel createContainerDetailsPanel() {
        return null;
    }
}
