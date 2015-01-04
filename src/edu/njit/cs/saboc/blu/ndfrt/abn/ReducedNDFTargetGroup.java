
package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.reduced.ReducingGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class ReducedNDFTargetGroup extends NDFTargetGroup implements ReducingGroup<NDFTargetGroup> {
    
    private HashSet<NDFTargetGroup> reducedGroups;
    
    public ReducedNDFTargetGroup(NDFTargetGroup group, HashSet<Integer> parentIds, HashSet<NDFTargetGroup> reducedGroups) {
        
        super(group.getId(), (NDFConcept)group.getRoot(), parentIds, group.getGroupNDFConceptHierarchy(), group.getGroupIncomingRelSources());
        
        this.reducedGroups = reducedGroups;
    }
    
    public HashSet<NDFTargetGroup> getReducedGroups() {
        return reducedGroups;
    }
}
