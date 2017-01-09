package edu.njit.cs.saboc.blu.ndfrt.gui.abnselection;

import edu.njit.cs.saboc.blu.core.abn.disjoint.DisjointAbstractionNetwork;
import edu.njit.cs.saboc.blu.core.abn.disjoint.DisjointNode;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PArea;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.diff.DiffPAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.abn.tan.Cluster;
import edu.njit.cs.saboc.blu.core.abn.tan.ClusterTribalAbstractionNetwork;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.core.gui.graphframe.AbNDisplayManager;
import edu.njit.cs.saboc.blu.core.gui.graphframe.FrameCreationAction;
import edu.njit.cs.saboc.blu.ndfrt.gui.graphframe.NDFPAreaInternalGraphFrame;
import edu.njit.cs.saboc.blu.ndfrt.gui.graphframe.NDFTargetAbNInternalGraphFrame;
import javax.swing.JFrame;

/**
 *
 * @author Chris O
 */
public class NDFAbNFrameManager extends AbNDisplayManager {
    
    private final JFrame mainFrame;
    
    public NDFAbNFrameManager(JFrame mainFrame, FrameCreationAction fca) {
        super(fca);
        
        this.mainFrame = mainFrame;
    }

    @Override
    public void displayPAreaTaxonomy(PAreaTaxonomy taxonomy) {
        NDFPAreaInternalGraphFrame igf = new NDFPAreaInternalGraphFrame(mainFrame, taxonomy);
        
         super.getFrameCreationAction().displayFrame(igf);
    }

    @Override
    public void displayDiffPAreaTaxonomy(DiffPAreaTaxonomy diffPAreaTaxonomy) {
       
    }

    @Override
    public void displayTribalAbstractionNetwork(ClusterTribalAbstractionNetwork tan) {
        
    }

    @Override
    public void displayDisjointPAreaTaxonomy(DisjointAbstractionNetwork<DisjointNode<PArea>, PAreaTaxonomy<PArea>, PArea> disjointTaxonomy) {
        
    }

    @Override
    public void displayDisjointTribalAbstractionNetwork(DisjointAbstractionNetwork<DisjointNode<Cluster>, ClusterTribalAbstractionNetwork<Cluster>, Cluster> disjointTaxonomy) {
        
    }

    @Override
    public void displayTargetAbstractionNetwork(TargetAbstractionNetwork targetAbN) {
        NDFTargetAbNInternalGraphFrame igf = new NDFTargetAbNInternalGraphFrame(mainFrame, targetAbN);

        super.getFrameCreationAction().displayFrame(igf);
    }
}