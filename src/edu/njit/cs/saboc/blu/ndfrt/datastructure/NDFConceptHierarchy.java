package edu.njit.cs.saboc.blu.ndfrt.datastructure;

import edu.njit.cs.saboc.blu.core.datastructure.hierarchy.SingleRootedHierarchy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Den
 */
public class NDFConceptHierarchy extends SingleRootedHierarchy<NDFConcept> {
    public NDFConceptHierarchy(NDFConcept root) {
        super(root);
    }
    
    public NDFConceptHierarchy(NDFConcept root, HashMap<NDFConcept, HashSet<NDFConcept>> conceptHierarchy) {
        super(root, conceptHierarchy);
    }
    
    public NDFConceptHierarchy(NDFConcept root, NDFConceptHierarchy hierarchy) {
        super(root, hierarchy.children);
    }
    
    public SingleRootedHierarchy<NDFConcept> getSubhierarchyRootedAt(NDFConcept root) {
        return new NDFConceptHierarchy(root, this.children);
    }
    
    public HashSet<NDFConcept> getConceptsInHierarchy() {
        return super.getNodesInHierarchy();
    }
}
