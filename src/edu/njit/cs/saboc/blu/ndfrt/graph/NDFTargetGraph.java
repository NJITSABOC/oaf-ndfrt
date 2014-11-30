package edu.njit.cs.saboc.blu.ndfrt.graph;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.graph.layout.NDFTargetAbstractionLayout;
import javax.swing.JFrame;

/**
 *
 * @author Chris O
 */
public class NDFTargetGraph extends BluGraph {

    public NDFTargetGraph(final JFrame parentFrame, final NDFTargetAbstractionNetwork hierarchyData) {

        super(hierarchyData, true, true);

        layout = new NDFTargetAbstractionLayout(this, hierarchyData);

        ((NDFTargetAbstractionLayout)layout).doLayout();
    }
}
