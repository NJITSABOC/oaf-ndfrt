package edu.njit.cs.saboc.blu.ndfrt.datasource;

import edu.njit.cs.saboc.blu.core.datastructure.hierarchy.Hierarchy;
import edu.njit.cs.saboc.blu.core.ontology.ConceptHierarchy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Chris O
 */
public class NDFConceptHierarchy extends ConceptHierarchy<NDFConcept> {
    public NDFConceptHierarchy(Set<NDFConcept> roots) {
        super(roots);
    }
    
    public NDFConceptHierarchy(NDFConcept root) {
        this(Collections.singleton(root));
    }
    
    public NDFConceptHierarchy(Set<NDFConcept> roots, Map<NDFConcept, Set<NDFConcept>> hierarchy) {
        super(roots, hierarchy);
    }
    
    public NDFConceptHierarchy(NDFConcept root, Map<NDFConcept, Set<NDFConcept>> hierarchy) {
        this(Collections.singleton(root), hierarchy);
    }
    
    public NDFConceptHierarchy(Hierarchy<NDFConcept> hierarchy) {
        super(hierarchy.getRoots(), hierarchy.getAllChildRelationships());
    }
}
