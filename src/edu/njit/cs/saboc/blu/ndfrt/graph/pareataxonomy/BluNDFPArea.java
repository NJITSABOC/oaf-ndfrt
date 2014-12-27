package edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphEdge;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphGroupLevel;
import edu.njit.cs.saboc.blu.core.graph.pareataxonomy.GenericBluPArea;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPArea;
import java.util.ArrayList;

/**
 *
 * @author Chris O
 */
public class BluNDFPArea extends GenericBluPArea<NDFPArea, BluNDFRegion>{
    public BluNDFPArea(NDFPArea parea, BluGraph g, BluNDFRegion r, int pX, GraphGroupLevel parent, ArrayList<GraphEdge> ie) {
        super(parea, g, r, pX, parent, ie);
    }
}
