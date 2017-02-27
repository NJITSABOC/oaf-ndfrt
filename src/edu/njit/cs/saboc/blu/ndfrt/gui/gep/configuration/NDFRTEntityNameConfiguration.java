package edu.njit.cs.saboc.blu.ndfrt.gui.gep.configuration;

import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.OntologyEntityNameConfiguration;

/**
 *
 * @author Chris O
 */
public class NDFRTEntityNameConfiguration implements OntologyEntityNameConfiguration {
    
    @Override
    public String getConceptTypeName(boolean plural) {
        if(plural) {
            return "Concepts";
        } else {
            return "Concept";
        }
    }
    
    @Override
    public String getParentConceptTypeName(boolean plural) {
        if(plural) {
            return "Parents";
        } else {
            return "Parent";
        }
    }
    
    @Override
    public String getChildConceptTypeName(boolean plural) {
        if(plural) {
            return "Children";
        } else {
            return "Child";
        }
    }
    
    @Override
    public String getPropertyTypeName(boolean plural) {
        if(plural) {
            return "Roles";
        } else {
            return "Role";
        }
    }
}
