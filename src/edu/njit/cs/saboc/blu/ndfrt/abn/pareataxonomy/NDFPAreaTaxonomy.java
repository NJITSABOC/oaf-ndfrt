package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.GroupHierarchy;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.GenericPAreaTaxonomy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomy extends GenericPAreaTaxonomy<NDFPAreaTaxonomy, NDFPArea, NDFArea, 
        NDFRegion, NDFConcept, NDFRole, NDFConceptHierarchy> {
    
    public NDFPAreaTaxonomy(
            NDFConceptHierarchy conceptHierarchy,
            NDFPArea rootPArea,
            ArrayList<NDFArea> areas,
            HashMap<Integer, NDFPArea> pareas,
            GroupHierarchy<NDFPArea> pareaHierarchy) {
        
        super(conceptHierarchy, rootPArea, areas, pareas, pareaHierarchy);
    }
    
    public NDFPAreaTaxonomy getReduced(int min, int max) {
        return null;
    }
    
}
