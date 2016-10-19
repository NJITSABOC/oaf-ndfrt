
package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.abn.node.Node;
import edu.njit.cs.saboc.blu.core.abn.ParentNodeDetails;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.AbNListenerConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.listeners.EntitySelectionAdapter;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.listeners.EntitySelectionListener;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNListenerConfiguration extends AbNListenerConfiguration {
    
    public NDFTargetAbNListenerConfiguration(NDFTargetAbNConfiguration config) {
        super(config);
    }
    
    @Override
    public EntitySelectionListener<Node> getChildGroupListener() {
        return new EntitySelectionAdapter<>();
    }

    @Override
    public EntitySelectionListener<ParentNodeDetails> getParentGroupListener() {
        return new EntitySelectionAdapter<>();
    }
}
