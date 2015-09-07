package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.GroupHierarchy;
import edu.njit.cs.saboc.blu.core.abn.targetbased.AggregateTargetAbNGenerator;
import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.datasource.NDFRTDataSource;
import java.util.HashMap;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbstractionNetwork extends TargetAbstractionNetwork<NDFTargetGroup, NDFTargetAbstractionNetwork> {
   
    private final NDFRTDataSource dataSource;
    
    public NDFTargetAbstractionNetwork(
            NDFTargetGroup rootGroup,
            HashMap<Integer, NDFTargetGroup> groups,
            GroupHierarchy<NDFTargetGroup> groupHierarchy, 
            NDFRTDataSource dataSource) {
        
        super(rootGroup, groups, groupHierarchy);
        
        this.dataSource = dataSource;
    }
    
    public NDFTargetAbstractionNetwork getReduced(int smallest) {
        
        AggregateTargetAbNGenerator<NDFTargetGroup, ReducedNDFTargetGroup, NDFTargetAbstractionNetwork> aggregateAbNGenerator = 
                new AggregateTargetAbNGenerator<>();
        
        return aggregateAbNGenerator.createReducedTargetAbN(this, 
                new NDFTargetAbstractionNetworkGenerator(dataSource), 
                new NDFReducedTargetAbNGenerator(), smallest);
    }

}
