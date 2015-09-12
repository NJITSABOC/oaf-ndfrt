
package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.GroupHierarchy;
import edu.njit.cs.saboc.blu.core.abn.aggregate.AggregateableConceptGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class ReducedNDFTargetGroup extends NDFTargetGroup implements AggregateableConceptGroup<NDFConcept, NDFTargetGroup> {

    private GroupHierarchy<NDFTargetGroup> reducedGroupHierarchy;
    
    public ReducedNDFTargetGroup(NDFTargetGroup group, HashSet<Integer> parentIds, GroupHierarchy<NDFTargetGroup> reducedGroupHierarchy) {
        
        super(group.getId(), (NDFConcept)group.getRoot(), parentIds, group.getGroupNDFConceptHierarchy(), group.getGroupIncomingRelSources());
        
        this.reducedGroupHierarchy = reducedGroupHierarchy;
    }
    
    public GroupHierarchy<NDFTargetGroup> getAggregatedGroupHierarchy() {
        return reducedGroupHierarchy;
    }
    
    public HashSet<NDFTargetGroup> getAggregatedGroups() {
        return new HashSet(reducedGroupHierarchy.getNodesInHierarchy());
    }
    
    public HashSet<NDFConcept> getAllGroupsConcepts() {
        HashSet<NDFConcept> allConcepts = new HashSet<NDFConcept>();
        allConcepts.addAll(this.getGroupIncomingRelSources().keySet());
        
        for(NDFTargetGroup reducedGroup : reducedGroupHierarchy.getNodesInHierarchy()) {
            allConcepts.addAll(reducedGroup.getGroupIncomingRelSources().keySet());
        }
        
        return allConcepts;
    }

    public HashSet<NDFConcept> getAllGroupsSourceConcepts() {
        HashSet<NDFConcept> allConcepts = new HashSet<NDFConcept>();
        allConcepts.addAll(this.getSourceConcepts());

        for (NDFTargetGroup reducedGroup : reducedGroupHierarchy.getNodesInHierarchy()) {
            allConcepts.addAll(reducedGroup.getSourceConcepts());
        }

        return allConcepts;
    }
    
}
