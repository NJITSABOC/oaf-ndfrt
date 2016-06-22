package edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.edges.GraphLevel;
import edu.njit.cs.saboc.blu.core.graph.pareataxonomy.AreaEntry;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFArea;
import java.awt.Rectangle;

/**
 *
 * @author Chris O
 */
public class BluNDFArea extends AreaEntry<NDFArea> {
    public BluNDFArea(NDFArea area, BluGraph g, int aX, GraphLevel parent, Rectangle prefBounds) {
        super(area, g, aX, parent, prefBounds);
    }
}
