package edu.njit.cs.saboc.blu.ndfrt.datasource;

import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFRTDataSource {
    private NDFConceptHierarchy conceptHierarchy;
    
    private HashMap<Long, NDFConcept> concepts;
    
    private HashMap<Long, NDFRole> roles;
    
    public NDFRTDataSource(NDFConceptHierarchy conceptHierarchy, HashMap<Long, NDFConcept> concepts, HashMap<Long, NDFRole> roles) {
        this.conceptHierarchy = conceptHierarchy;
        this.concepts = concepts;
        this.roles = roles;
    }
    
    public NDFConceptHierarchy getConceptHierarchy() {
        return conceptHierarchy;
    }
    
    public NDFConcept getConceptFromId(long id) {
        return concepts.get(id);
    }
    
    public NDFRole getRoleFromId(long id) {
        return roles.get(id);
    }
    
    public HashSet<NDFConcept> getConceptParents(NDFConcept concept) {
        return conceptHierarchy.getParents(concept);
    }
    
    public HashSet<NDFConcept> getConceptChildren(NDFConcept concept) {
        return conceptHierarchy.getChildren(concept);
    }
}
