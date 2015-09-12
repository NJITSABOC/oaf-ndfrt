package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.GroupHierarchy;
import edu.njit.cs.saboc.blu.core.abn.aggregate.AggregateAbNGenerator;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFReducedTargetAbNGenerator extends AggregateAbNGenerator<NDFTargetGroup, ReducedNDFTargetGroup> {
    protected ReducedNDFTargetGroup createReducedGroup(NDFTargetGroup targetGroup, HashSet<Integer> reducedParentIds, GroupHierarchy<NDFTargetGroup> reducedGroups) {
        return new ReducedNDFTargetGroup(targetGroup, reducedParentIds, reducedGroups);
    }
}
