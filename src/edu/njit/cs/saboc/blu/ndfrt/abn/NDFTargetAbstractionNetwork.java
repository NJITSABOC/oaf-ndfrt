package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.GroupHierarchy;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import java.util.HashMap;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbstractionNetwork extends TargetAbstractionNetwork<NDFTargetGroup, NDFTargetAbstractionNetwork> {
   
    public NDFTargetAbstractionNetwork(
            NDFTargetGroup rootGroup,
            HashMap<Integer, NDFTargetGroup> groups,
            GroupHierarchy<NDFTargetGroup> groupHierarchy) {
        
        super(rootGroup, groups, groupHierarchy);
    }
    
    public NDFTargetAbstractionNetwork getReduced(int smallest, int largest) {
        return super.createReducedTargetAbN(new NDFTargetAbstractionNetworkGenerator(null), new NDFReducedTargetAbNGenerator(), smallest, largest);
    }

}
