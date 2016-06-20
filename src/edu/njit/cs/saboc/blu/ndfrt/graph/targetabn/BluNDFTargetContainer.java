package edu.njit.cs.saboc.blu.ndfrt.graph.targetabn;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphLevel;
import edu.njit.cs.saboc.blu.core.graph.nodes.PartitionedNodeEntry;
import java.awt.Rectangle;

/**
 *
 * @author Chris O
 */
public class BluNDFTargetContainer extends PartitionedNodeEntry {

    public BluNDFTargetContainer(BluGraph g, int aX, GraphLevel parent, Rectangle prefBounds) {
        super(null, g, aX, parent, prefBounds);
    }
}