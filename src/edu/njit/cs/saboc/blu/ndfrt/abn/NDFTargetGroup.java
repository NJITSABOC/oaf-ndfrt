package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFTargetGroup extends TargetGroup<NDFConcept, NDFConcept> {
    
    public NDFTargetGroup(int id, NDFConcept root, int conceptCount, HashSet<Integer> parents) {
        super(id, root, conceptCount, parents);
    }
}
