package edu.njit.cs.saboc.blu.ndfrt.gui.abnselection;

import edu.njit.cs.saboc.blu.core.gui.graphframe.FrameCreationListener;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.gui.graphframe.NDFTargetAbNInternalGraphFrame;
import javax.swing.JFrame;

/**
 *
 * @author Chris O
 */
public abstract class NDFDisplayFrameListener implements FrameCreationListener {
    
    private JFrame mainFrame;
    
    public NDFDisplayFrameListener(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public NDFTargetAbNInternalGraphFrame addNewTargetAbNGraphFrame(NDFTargetAbstractionNetwork data) {
        NDFTargetAbNInternalGraphFrame igf = new NDFTargetAbNInternalGraphFrame(mainFrame, data);

        this.displayFrame(igf);

        return igf;
    }
}