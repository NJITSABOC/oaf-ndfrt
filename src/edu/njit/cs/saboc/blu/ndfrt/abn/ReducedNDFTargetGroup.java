
package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.reduced.ReducingGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class ReducedNDFTargetGroup extends NDFTargetGroup implements ReducingGroup<NDFConcept, NDFTargetGroup> {

    private HashSet<NDFTargetGroup> reducedGroups;
    
    public ReducedNDFTargetGroup(NDFTargetGroup group, HashSet<Integer> parentIds, HashSet<NDFTargetGroup> reducedGroups) {
        
        super(group.getId(), (NDFConcept)group.getRoot(), parentIds, group.getGroupNDFConceptHierarchy(), group.getGroupIncomingRelSources());
        
        this.reducedGroups = reducedGroups;
    }
    
    public HashSet<NDFTargetGroup> getReducedGroups() {
        return reducedGroups;
    }
    
    public HashSet<NDFConcept> getAllGroupsConcepts() {
        HashSet<NDFConcept> allConcepts = new HashSet<NDFConcept>();
        allConcepts.addAll(this.getGroupIncomingRelSources().keySet());
        
        for(NDFTargetGroup reducedGroup : reducedGroups) {
            allConcepts.addAll(reducedGroup.getGroupIncomingRelSources().keySet());
        }
        
        return allConcepts;
    }

    public HashSet<NDFConcept> getAllGroupsSourceConcepts() {
        HashSet<NDFConcept> allConcepts = new HashSet<NDFConcept>();
        allConcepts.addAll(this.getSourceConcepts());

        for (NDFTargetGroup reducedGroup : reducedGroups) {
            allConcepts.addAll(reducedGroup.getSourceConcepts());
        }

        return allConcepts;
    }
    
}
