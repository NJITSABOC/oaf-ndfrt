package edu.njit.cs.saboc.blu.ndfrt.gui.gep.listeners;

import SnomedShared.generic.GenericConceptGroup;
import SnomedShared.generic.GenericContainerPartition;
import edu.njit.cs.saboc.blu.core.abn.AbstractionNetwork;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.GEPActionListener;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.gui.dialogs.NDFTargetGroupDetailsDialog;
import javax.swing.JFrame;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNGEPListener implements GEPActionListener {
    private final JFrame parentFrame;
    
    public NDFTargetAbNGEPListener(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    public void containerPartitionSelected(GenericContainerPartition partition, boolean treatedAsContainer, AbstractionNetwork abn) {
        
    }

    public void groupSelected(GenericConceptGroup group, AbstractionNetwork abn) {
        NDFTargetGroupDetailsDialog dialog = new NDFTargetGroupDetailsDialog(parentFrame, (NDFTargetGroup) group, 
            (NDFTargetAbstractionNetwork) abn);
    }
}
