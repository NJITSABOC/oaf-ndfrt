package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.GenericPArea;
import edu.njit.cs.saboc.blu.core.datastructure.hierarchy.SingleRootedHierarchy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFPArea extends GenericPArea<NDFConcept, NDFRole, NDFPArea> {
    
    public NDFPArea(int id,
            SingleRootedHierarchy<NDFConcept> conceptHierarchy, 
            HashSet<Integer> parentIds,
            HashSet<NDFRole> relationships) {
        
        super(id, conceptHierarchy.getRoot(), conceptHierarchy, parentIds, relationships);
    }
    
    public HashSet<NDFRole> getRelsWithoutInheritanceInfo() {
        return relationships;
    }
}
