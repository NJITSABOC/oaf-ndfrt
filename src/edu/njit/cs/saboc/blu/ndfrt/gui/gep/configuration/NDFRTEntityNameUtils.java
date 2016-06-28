package edu.njit.cs.saboc.blu.ndfrt.gui.gep.configuration;

/**
 *
 * @author Chris O
 */
public class NDFRTEntityNameUtils {
    public static String getConceptTypeName(boolean plural) {
        if(plural) {
            return "Concepts";
        } else {
            return "Concept";
        }
    }
    
    public static String getParentConceptTypeName(boolean plural) {
        if(plural) {
            return "Parents";
        } else {
            return "Parent";
        }
    }
    
    public static String getChildConceptTypeName(boolean plural) {
        if(plural) {
            return "Children";
        } else {
            return "Child";
        }
    }
    
    public static String getRelationshipTypeName(boolean plural) {
        if(plural) {
            return "Roles";
        } else {
            return "Role";
        }
    }
}
