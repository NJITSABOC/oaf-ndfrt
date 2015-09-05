package edu.njit.cs.saboc.blu.ndfrt.graph;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.options.GraphOptions;
import edu.njit.cs.saboc.blu.core.gui.gep.utils.drawing.GroupEntryLabelCreator;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPArea;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFPAreaTaxonomy;
import edu.njit.cs.saboc.blu.ndfrt.graph.layout.NDFNoRegionsPAreaLayout;
import edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy.BluNDFPArea;
import javax.swing.JFrame;

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
            ((NDFNoRegionsPAreaLayout)layout).doLayout(showConceptCountLabels);
        }

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
