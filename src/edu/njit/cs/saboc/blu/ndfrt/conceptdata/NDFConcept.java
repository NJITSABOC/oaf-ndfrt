package edu.njit.cs.saboc.blu.ndfrt.conceptdata;

import edu.njit.cs.saboc.blu.core.ontology.Concept;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Chris O
 */
public class NDFConcept extends Concept<Long> {
    
    private final Set<NDFRelationship> attributeRelationships = new HashSet<>();
   
    private final String name;
       
    public NDFConcept(long id, String name) {
        super(id);

        if (name.contains("[")) {
            name = name.substring(0, name.lastIndexOf("["));
        }

        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String getIDAsString() {
        return getID().toString();
    }
    
    public void addAttributeRelationship(NDFRelationship attributeRelationship) {
        this.attributeRelationships.add(attributeRelationship);
    }

    public Set<NDFRelationship> getAttributeRelationships() {
        return attributeRelationships;
    }
}
