package edu.njit.cs.saboc.blu.ndfrt.graph;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.ShowHideGroupEntryListener;
import edu.njit.cs.saboc.blu.core.graph.options.GraphOptions;
import edu.njit.cs.saboc.blu.core.gui.dialogs.ContainerResize;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.GroupEntryLabelCreator;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPArea;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPAreaTaxonomy;
import edu.njit.cs.saboc.blu.ndfrt.graph.layout.NDFNoRegionsPAreaLayout;
import edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy.BluNDFPArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Chris O
 */
public class NDFPAreaBluGraph extends BluGraph {

    public NDFPAreaBluGraph(final JFrame parentFrame, final NDFPAreaTaxonomy taxonomy, boolean areaGraph, 
            boolean conceptLabels, GraphOptions options, GroupEntryLabelCreator<NDFPArea> labelCreator) {
        
        super(taxonomy, areaGraph, conceptLabels, labelCreator);

        if (areaGraph) {
            layout = new NDFNoRegionsPAreaLayout(this, taxonomy);
            ((NDFNoRegionsPAreaLayout)layout).doLayout(options, showConceptCountLabels);
        }

        partitionMenu = new JPopupMenu();
        partitionMenu.setFocusable(true);

        JMenuItem menuItem2 = new JMenuItem("Select PAreas to Show / Hide");
        menuItem2.addActionListener(new ShowHideGroupEntryListener(this));

        JMenuItem menuItem5 = new JMenuItem("Resize Region");

        menuItem5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                new ContainerResize(parentFrame, currentPartition, NDFPAreaBluGraph.this);
                partitionMenu.setVisible(false);
            }
        });

        partitionMenu.add(menuItem2);
        partitionMenu.add(menuItem5);
    }

    public NDFPAreaTaxonomy getPAreaHierarchyData() {
        return (NDFPAreaTaxonomy) getAbstractionNetwork();
    }

    public BluNDFPArea getRootPArea() {
        NDFPAreaTaxonomy hierarchy = (NDFPAreaTaxonomy)abstractionNetwork;
        NDFPArea rootPArea = hierarchy.getRootPArea();
        return (BluNDFPArea)layout.getGroupEntries().get(rootPArea.getId());
    }
}
