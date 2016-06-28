package edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.InheritableProperty;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;

/**
 *
 * @author Chris O
 */
public class NDFInheritableProperty extends InheritableProperty<Long, NDFRole> {
    
    public NDFInheritableProperty(NDFRole role, InheritanceType inheritance) {
        super(role.getID(), role, inheritance);
    }

    @Override
    public String getName() {
        return super.getPropertyType().getName();
    }

    @Override
    public String getIDAsString() {
        return super.getID().toString();
    }
}
