package edu.njit.cs.saboc.blu.ndfrt.gui.gep.panels.targetabn.configuration;

import edu.njit.cs.saboc.blu.core.abn.node.Node;
import edu.njit.cs.saboc.blu.core.abn.ParentNodeDetails;
import edu.njit.cs.saboc.blu.core.gui.dialogs.concepthierarchy.ConceptPainter;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.configuration.AbNUIConfiguration;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.NodeOptionsPanel;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.NodeDashboardPanel;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.abn.SimpleAbNDetailsPanel;
import edu.njit.cs.saboc.blu.core.gui.gep.panels.details.models.OAFAbstractTableModel;
import edu.njit.cs.saboc.blu.core.gui.graphframe.AbNDisplayManager;

/**
 *
 * @author Chris O
 */
public class NDFTargetAbNUIConfiguration extends AbNUIConfiguration {
    
    public NDFTargetAbNUIConfiguration(NDFTargetAbNConfiguration config, AbNDisplayManager displayManager) {
        super(displayManager, new NDFTargetAbNListenerConfiguration(config));
    }

    @Override
    public OAFAbstractTableModel getParentNodeTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OAFAbstractTableModel getChildNodeTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeOptionsPanel getNodeOptionsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConceptPainter getConceptHierarchyPainter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SimpleAbNDetailsPanel createAbNDetailsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasGroupDetailsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeDashboardPanel createGroupDetailsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
