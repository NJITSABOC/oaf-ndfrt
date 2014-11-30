package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.targetbased.GenericRelationship;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetworkGenerator;
import edu.njit.cs.saboc.blu.core.datastructure.hierarchy.SingleRootedHierarchy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import edu.njit.cs.saboc.blu.ndfrt.datasource.NDFRTDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbstractionNetworkGenerator extends TargetAbstractionNetworkGenerator<NDFConcept, NDFTargetGroup, 
        NDFTargetAbstractionNetwork, NDFRole> {
    
    private NDFRTDataSource dataSource;
    
    public NDFTargetAbstractionNetworkGenerator(NDFRTDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public HashSet<GenericRelationship<NDFRole, NDFConcept>> getConceptRelationships(NDFConcept concept) {
        return (HashSet<GenericRelationship<NDFRole, NDFConcept>>)(HashSet<?>)concept.getAttributeRelationships(); // Hax
    }

    public SingleRootedHierarchy<NDFConcept> getTargetHierarchy(NDFConcept root) {
        return dataSource.getConceptHierarchy().getSubhierarchyRootedAt(root);
    }

    public NDFTargetGroup createGroup(int id, NDFConcept root, int conceptCount, HashSet<Integer> parentIds) {
        return new NDFTargetGroup(id, root, conceptCount, parentIds);
    }

    protected NDFTargetAbstractionNetwork createTargetAbstractionNetwork(
            NDFTargetGroup targetGroup, HashMap<Integer, NDFTargetGroup> groups, 
            HashMap<Integer, HashSet<Integer>> groupHierarchy) {    
        
        return new NDFTargetAbstractionNetwork(targetGroup, new ArrayList<NDFTargetContainer>(), groups, groupHierarchy);
    }
}
