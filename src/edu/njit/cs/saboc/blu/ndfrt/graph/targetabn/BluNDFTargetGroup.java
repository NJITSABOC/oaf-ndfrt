package edu.njit.cs.saboc.blu.ndfrt.graph.targetabn;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphEdge;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphGroupLevel;
import edu.njit.cs.saboc.blu.core.graph.nodes.SinglyRootedNodeEntry;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import java.util.ArrayList;

/**
 *
 * @author Chris O
 */
public class BluNDFTargetGroup extends SinglyRootedNodeEntry<NDFTargetGroup> {
    
    public BluNDFTargetGroup(NDFTargetGroup group, BluGraph g, int pX, GraphGroupLevel parent, ArrayList<GraphEdge> ie) {
        super(group, g, null, pX, parent, ie);
    }
}
