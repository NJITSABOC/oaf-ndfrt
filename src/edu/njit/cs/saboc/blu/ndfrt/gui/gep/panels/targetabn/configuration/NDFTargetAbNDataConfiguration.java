package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.data.BLUAbNDataConfiguration;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.ArrayList;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNDataConfiguration implements BLUAbNDataConfiguration<NDFTargetAbstractionNetwork, NDFTargetGroup, NDFConcept>{

    @Override
    public ArrayList<NDFConcept> getSortedConceptList(NDFTargetGroup group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
