package edu.njit.cs.saboc.blu.ndfrt.conceptdata;

import edu.njit.cs.saboc.blu.core.abn.targetbased.GenericRelationship;

/**
 *
 * @author Chris O
 */
public class NDFRelationship extends GenericRelationship<NDFRole, NDFConcept> {
    public NDFRelationship(NDFRole type, NDFConcept target) {
        super(type, target);
    }
}
