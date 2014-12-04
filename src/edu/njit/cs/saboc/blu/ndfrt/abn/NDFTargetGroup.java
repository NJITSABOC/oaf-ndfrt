package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFTargetGroup extends TargetGroup<NDFConcept, NDFConcept> {
    
    public NDFTargetGroup(int id, NDFConcept root, int conceptCount, HashSet<Integer> parents, 
            NDFConceptHierarchy groupHierarchy, HashMap<NDFConcept, HashSet<NDFConcept>> incomingRelSources) {
        
        super(id, root, conceptCount, parents, groupHierarchy, incomingRelSources);
    }
    
    public NDFConceptHierarchy getGroupNDFConceptHierarchy() {
        return (NDFConceptHierarchy)super.getGroupHierarchy();
    }
}
