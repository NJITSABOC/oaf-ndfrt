package edu.njit.cs.saboc.blu.ndfrt.abn;

import edu.njit.cs.saboc.blu.core.abn.targetbased.TargetAbstractionNetwork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbstractionNetwork extends TargetAbstractionNetwork<NDFTargetGroup> {
    
    public NDFTargetAbstractionNetwork(ArrayList<NDFTargetContainer> containers,
            HashMap<Integer, NDFTargetGroup> groups,
            HashMap<Integer, HashSet<Integer>> groupHierarchy) {
        
        super(containers, groups, groupHierarchy);
    }
}
