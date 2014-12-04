package edu.njit.cs.saboc.blu.ndfrt.gui.dialogs;

import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.gui.dialogs.panels.NDFTargetGroupDetailsPanel;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Chris O
 */
public class NDFTargetGroupDetailsDialog extends JDialog {
    
    public NDFTargetGroupDetailsDialog(JFrame parentFrame, NDFTargetGroup group, NDFTargetAbstractionNetwork abn) {
        super(parentFrame);
        
        this.setTitle("Target Group Details for: " + group.getRoot().getName());
        
        NDFTargetGroupDetailsPanel panel = new NDFTargetGroupDetailsPanel(abn);
        
        panel.setConceptList(group);
        
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(panel, BorderLayout.CENTER);

        this.add(contentPanel);

        this.setResizable(true);
        this.setSize(768, 600);
        this.setLocationRelativeTo(parentFrame);
        this.setVisible(true);
    }
}
