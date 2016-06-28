
package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.InheritableProperty;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.InheritableProperty.InheritanceType;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomyFactory;
import edu.njit.cs.saboc.blu.core.ontology.Concept;
import edu.njit.cs.saboc.blu.core.ontology.ConceptHierarchy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRelationship;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Chris O
 */
public class NDFRTPAreaTaxonomyFactory implements PAreaTaxonomyFactory {
    
    private final Map<Concept, Set<InheritableProperty>> properties = new HashMap<>();
    
    public NDFRTPAreaTaxonomyFactory(ConceptHierarchy hierarchy) {
        
        Map<Concept, Set<NDFRole>> uniqueRoles = new HashMap<>();
        
        hierarchy.getConceptsInHierarchy().forEach( (concept) -> {
            NDFConcept ndfConcept = (NDFConcept)concept;
            
            Set<NDFRelationship> rels = ndfConcept.getAttributeRelationships();
            
            uniqueRoles.put(ndfConcept, new HashSet<>());
            
            rels.forEach( (rel) -> {
                uniqueRoles.get(ndfConcept).add(rel.getType());
            });
        });
        
        uniqueRoles.forEach((sourceConcept, sourceConceptRels) -> {

            properties.put(sourceConcept, new HashSet<>());

            Set<NDFRole> parentRoles = new HashSet<>();

            Set<Concept> parents = hierarchy.getParents(sourceConcept);

            parents.forEach((parent) -> {
                parentRoles.addAll(uniqueRoles.get(parent));
            });

            sourceConceptRels.forEach((role) -> {
                if (parentRoles.stream().anyMatch((parentRole) -> parentRole.equals(role))) {
                    properties.get(sourceConcept).add(new NDFInheritableProperty(role, InheritanceType.Inherited));
                } else {
                    properties.get(sourceConcept).add(new NDFInheritableProperty(role, InheritanceType.Introduced));
                }
            });
        });
    }

    @Override
    public Set<InheritableProperty> getRelationships(Concept c) {
        return properties.get(c);
    }
}
