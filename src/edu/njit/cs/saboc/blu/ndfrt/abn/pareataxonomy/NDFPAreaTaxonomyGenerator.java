package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.GenericPAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomyGenerator;
import edu.njit.cs.saboc.blu.core.datastructure.hierarchy.SingleRootedHierarchy;
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
public class NDFPAreaTaxonomyGenerator extends PAreaTaxonomyGenerator <NDFPArea, NDFArea, NDFRegion, NDFConcept, NDFRole> {
   
    private NDFConceptHierarchy hierarchy;
    
    public NDFPAreaTaxonomyGenerator(NDFConceptHierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }
    
    @Override
    protected SingleRootedHierarchy<NDFConcept> getConceptHierarchy() {
        return hierarchy;
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
    protected SingleRootedHierarchy<NDFConcept> initPAreaConceptHierarchy(NDFConcept root) {
        return new NDFConceptHierarchy(root);
    }

    @Override
    protected NDFPArea createPArea(int id, SingleRootedHierarchy<NDFConcept> pareaHierarchy, HashSet<Integer> parentIds, HashSet<NDFRole> relationships) {
        return new NDFPArea(id, pareaHierarchy, parentIds, relationships);
    }

    @Override
    protected NDFArea createArea(int id, HashSet<NDFRole> relationships) {
        return new NDFArea(id, relationships);
    }

    @Override
    protected GenericPAreaTaxonomy<NDFPArea, NDFArea, NDFRegion, NDFConcept, NDFRole> createPAreaTaxonomy(
            SingleRootedHierarchy<NDFConcept> conceptHierarchy, NDFPArea rootPArea, ArrayList<NDFArea> areas, 
            HashMap<Integer, NDFPArea> pareas, HashMap<Integer, HashSet<Integer>> pareaHierarchy) {
       
            return new NDFPAreaTaxonomy((NDFConceptHierarchy)conceptHierarchy, rootPArea, areas, pareas, pareaHierarchy);
    }
}
