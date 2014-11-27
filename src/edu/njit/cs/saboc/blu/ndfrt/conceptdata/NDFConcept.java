package edu.njit.cs.saboc.blu.ndfrt.conceptdata;

import SnomedShared.Concept;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFConcept extends Concept {
    
    private HashSet<NDFRelationship> attributeRelationships = new HashSet<NDFRelationship>();
    
    public NDFConcept(long id, String name) {
        super(id, name);
    }
    
    public void addRelationship(NDFRelationship relationship) {
        attributeRelationships.add(relationship);
    }
    
    public HashSet<NDFRelationship> getAttributeRelationships() {
        return attributeRelationships;
    }
}
