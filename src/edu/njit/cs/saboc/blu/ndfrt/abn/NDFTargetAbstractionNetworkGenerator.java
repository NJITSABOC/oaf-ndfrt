package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.GroupHierarchy;
import edu.njit.cs.saboc.blu.core.abn.targetbased.GenericRelationship;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetworkGenerator;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datasource.NDFRTDataSource;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbstractionNetworkGenerator extends TargetAbstractionNetworkGenerator<
        NDFConcept, 
        NDFRole, 
        NDFConceptHierarchy,
        NDFTargetGroup, 
        NDFTargetAbstractionNetwork> {

    private NDFRTDataSource dataSource;
    
    public NDFTargetAbstractionNetworkGenerator(NDFRTDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public HashSet<GenericRelationship<NDFRole, NDFConcept>> getConceptRelationships(NDFConcept concept) {
        return (HashSet<GenericRelationship<NDFRole, NDFConcept>>)(HashSet<?>)concept.getAttributeRelationships(); // Hax
    }

    public NDFConceptHierarchy getTargetHierarchy(NDFConcept root) {
        return dataSource.getConceptHierarchy().getSubhierarchyRootedAt(root);
    }

    public NDFTargetGroup createGroup(int id, NDFConcept root, HashSet<Integer> parentIds, 
            NDFConceptHierarchy groupHierarchy, HashMap<NDFConcept, HashSet<NDFConcept>> incomingRelSources) {
        
        return new NDFTargetGroup(id, root, parentIds, groupHierarchy, incomingRelSources);
    }

    protected NDFTargetAbstractionNetwork createTargetAbstractionNetwork(
            NDFTargetGroup targetGroup, HashMap<Integer, NDFTargetGroup> groups, 
            GroupHierarchy<NDFTargetGroup> groupHierarchy) {    
        
        return new NDFTargetAbstractionNetwork(targetGroup, groups, groupHierarchy, dataSource);
    }
    
    protected NDFConceptHierarchy createGroupHierarchy(NDFConcept root) {
        return new NDFConceptHierarchy(root);
    }
    
}
