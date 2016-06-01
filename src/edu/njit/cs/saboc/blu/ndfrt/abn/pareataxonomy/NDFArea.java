package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.Area;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFArea extends Area<NDFConcept, NDFRole, NDFConceptHierarchy, NDFPArea, NDFRegion> {
    public NDFArea(int id, HashSet<NDFRole> rels) {
        super(id, rels);
    }
    
    protected NDFRegion createRegion(NDFPArea parea) {
        return new NDFRegion(parea);
    }
}
