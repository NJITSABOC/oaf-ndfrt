package edu.njit.cs.saboc.blu.ndfrt.datasource;

import edu.njit.cs.saboc.blu.core.ontology.ConceptHierarchy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import java.util.Map;

/**
 *
 * @author Chris O
 */
public class NDFRTDataSource {
    private final ConceptHierarchy conceptHierarchy;
    
    private final Map<Long, NDFConcept> concepts;
    
    private final Map<Long, NDFRole> roles;
    
    public NDFRTDataSource(ConceptHierarchy conceptHierarchy, Map<Long, NDFConcept> concepts, Map<Long, NDFRole> roles) {
        this.conceptHierarchy = conceptHierarchy;
        this.concepts = concepts;
        this.roles = roles;
    }
    
    public ConceptHierarchy getConceptHierarchy() {
        return conceptHierarchy;
    }
    
    public NDFConcept getConceptFromId(long id) {
        return concepts.get(id);
    }
    
    public NDFRole getRoleFromId(long id) {
        return roles.get(id);
    }
}
