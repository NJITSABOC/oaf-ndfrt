package edu.njit.cs.saboc.blu.ndfrt.gui.abnselection;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.core.gui.graphframe.FrameCreationListener;
import edu.njit.cs.saboc.blu.ndfrt.gui.graphframe.NDFPAreaInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.gui.graphframe.NDFTargetAbNInternalGraphFrame;
import javax.swing.JFrame;

/**
 *
 * @author Chris O
 */
public abstract class NDFDisplayFrameListener implements FrameCreationListener {
    
    private final JFrame mainFrame;
    
    public NDFDisplayFrameListener(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public NDFTargetAbNInternalGraphFrame addNewTargetAbNGraphFrame(TargetAbstractionNetwork data) {
        NDFTargetAbNInternalGraphFrame igf = new NDFTargetAbNInternalGraphFrame(mainFrame, data);

        this.displayFrame(igf);

        return igf;
    }
    
    public NDFPAreaInternalGraphFrame addNewPAreaTaxonomyGraphGraph(PAreaTaxonomy taxonomy) {
        NDFPAreaInternalGraphFrame igf = new NDFPAreaInternalGraphFrame(mainFrame, taxonomy);
        
        this.displayFrame(igf);
        
        return igf;
    }
}