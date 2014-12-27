package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.GenericRegion;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;

/**
 *
 * @author Chris O
 */
public class NDFRegion extends GenericRegion<NDFConcept, NDFRole, NDFPArea> {
    public NDFRegion(NDFPArea firstPArea) {
        super(firstPArea);
    }
}
