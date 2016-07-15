package edu.njit.cs.saboc.blu.ndfrt.datasource;

import edu.njit.cs.saboc.blu.core.datastructure.hierarchy.Hierarchy;
import edu.njit.cs.saboc.blu.core.ontology.Ontology;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Chris O
 */
public class NDFRTDataSource extends Ontology {

    private final Map<Long, NDFConcept> concepts;
    
    private final Map<Long, NDFRole> roles;
    
    public NDFRTDataSource(Hierarchy<NDFConcept> conceptHierarchy, Map<Long, NDFRole> roles) {
        super(conceptHierarchy);

        this.concepts = new HashMap<>();
        
        conceptHierarchy.getNodes().forEach( (concept) -> {
            concepts.put(concept.getID(), concept);
        });
        
        this.roles = roles;
    }
    
    public NDFConcept getConceptFromId(long id) {
        return concepts.get(id);
    }
    
    public NDFRole getRoleFromId(long id) {
        return roles.get(id);
    }
}
