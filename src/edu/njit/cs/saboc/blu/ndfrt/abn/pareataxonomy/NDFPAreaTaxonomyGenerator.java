package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.GroupHierarchy;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomyGenerator;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.RelationshipEquality;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRelationship;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomyGenerator extends PAreaTaxonomyGenerator<NDFPAreaTaxonomy, NDFPArea, NDFArea, NDFRegion, 
        NDFConcept, NDFRole, NDFConceptHierarchy> {
   
    private NDFConceptHierarchy hierarchy;
    
    public NDFPAreaTaxonomyGenerator(NDFConceptHierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }
    
    @Override
    protected NDFConceptHierarchy getConceptHierarchy() {
        return hierarchy;
    }
    
    
    @Override
    protected RelationshipEquality<NDFRole> getRelationshipEquality() {
        return new RelationshipEquality<NDFRole>() {
            public boolean equalsNoInheritance(HashSet<NDFRole> a, HashSet<NDFRole> b) {
                return a.equals(b);
            }

            public boolean equalsInheritance(HashSet<NDFRole> a, HashSet<NDFRole> b) {
                return a.equals(b);
            }
        };
    }

    @Override
    protected HashSet<NDFRole> getDefiningConceptRelationships(NDFConcept concept) {
        HashSet<NDFRole> roles = new HashSet<NDFRole>();
        
        for(NDFRelationship rel : concept.getAttributeRelationships()) {
            roles.add(rel.getType());
        }
        
        return roles;
    }

    @Override
    protected NDFConceptHierarchy initPAreaConceptHierarchy(NDFConcept root) {
        return new NDFConceptHierarchy(root);
    }

    @Override
    protected NDFPArea createPArea(int id, NDFConceptHierarchy pareaHierarchy, HashSet<Integer> parentIds, HashSet<NDFRole> relationships) {
        return new NDFPArea(id, pareaHierarchy, parentIds, relationships);
    }

    @Override
    protected NDFArea createArea(int id, HashSet<NDFRole> relationships) {
        return new NDFArea(id, relationships);
    }

    @Override
    protected NDFPAreaTaxonomy createPAreaTaxonomy(
            NDFConceptHierarchy conceptHierarchy, NDFPArea rootPArea, ArrayList<NDFArea> areas, 
            HashMap<Integer, NDFPArea> pareas, GroupHierarchy<NDFPArea> pareaHierarchy) {
       
            return new NDFPAreaTaxonomy((NDFConceptHierarchy)conceptHierarchy, rootPArea, areas, pareas, pareaHierarchy);
    }
}
