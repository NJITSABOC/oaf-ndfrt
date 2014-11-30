
package edu.njit.cs.saboc.blu.ndfrt.graph.targetabn;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.nodes.GenericPartitionEntry;

/**
 *
 * @author Chris O
 */
public class BluNDFTargetPartition extends GenericPartitionEntry {

    public BluNDFTargetPartition(int width, int height, BluNDFTargetContainer parent, BluGraph g) {
        super(null, "", width, height, g, parent, null, true);
    }
}