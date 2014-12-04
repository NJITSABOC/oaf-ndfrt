package edu.njit.cs.saboc.blu.ndfrt.gui.dialogs.panels;

import edu.njit.cs.saboc.blu.core.gui.dialogs.panels.GroupDetailsPanel;
import edu.njit.cs.saboc.blu.core.gui.utils.renderers.MultiLineTextRenderer;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.gui.models.NDFTargetGroupTableModel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Chris O
 */
public class NDFTargetGroupDetailsPanel extends GroupDetailsPanel {
    
    private NDFTargetGroupTableModel conceptListModel;
    private JTable groupConceptTable;
    

    public NDFTargetGroupDetailsPanel(NDFTargetAbstractionNetwork abn) {
        super(abn, GroupDetailsPanel.GroupType.Target);
        
        this.initialize();
    }

    protected void initialize() {       
        groupConceptTable = new JTable(conceptListModel = new NDFTargetGroupTableModel());
        groupConceptTable.setDefaultRenderer(String.class, new MultiLineTextRenderer());
        
        JPanel conceptListPanel = new JPanel(new BorderLayout());
        conceptListPanel.setBorder(BorderFactory.createTitledBorder("Target Group Concept List"));
        
        conceptListPanel.add(new JScrollPane(groupConceptTable));
        
        super.setConceptsComponent(conceptListPanel);
    }
    
    public void setConceptList(NDFTargetGroup group) {
        conceptListModel.updateConceptList(group);
    }
}
