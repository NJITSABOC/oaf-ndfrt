package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.GenericPAreaTaxonomy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFPAreaTaxonomy extends GenericPAreaTaxonomy<NDFPArea, NDFArea, NDFRegion, NDFConcept, NDFRole> {
    
    public NDFPAreaTaxonomy(
            NDFConceptHierarchy conceptHierarchy,
            NDFPArea rootPArea,
            ArrayList<NDFArea> areas,
            HashMap<Integer, NDFPArea> pareas,
            HashMap<Integer, HashSet<Integer>> pareaHierarchy) {
        
        super(conceptHierarchy, rootPArea, areas, pareas, pareaHierarchy);
    }
}
