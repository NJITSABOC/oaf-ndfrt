package edu.njit.cs.saboc.blu.ndfrt.utils;

import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import java.util.Comparator;

/**
 *
 * @author Chris O
 */
public class NDFConceptNameComparator implements Comparator<NDFConcept> {
    public int compare(NDFConcept a, NDFConcept b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
