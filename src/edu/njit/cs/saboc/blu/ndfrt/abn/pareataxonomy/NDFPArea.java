package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PArea;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFPArea extends PArea<NDFConcept, NDFRole, NDFConceptHierarchy, NDFPArea> {
    
    public NDFPArea(int id,
            NDFConceptHierarchy conceptHierarchy, 
            HashSet<Integer> parentIds,
            HashSet<NDFRole> relationships) {
        
        super(id, conceptHierarchy.getRoot(), conceptHierarchy, parentIds, relationships);
    }
    
    public HashSet<NDFRole> getRelsWithoutInheritanceInfo() {
        return relationships;
    }
}
