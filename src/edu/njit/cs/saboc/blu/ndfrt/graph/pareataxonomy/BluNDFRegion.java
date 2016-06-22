
package edu.njit.cs.saboc.blu.ndfrt.graph.pareataxonomy;

import edu.njit.cs.saboc.blu.core.graph.BluGraph;
import edu.njit.cs.saboc.blu.core.graph.pareataxonomy.RegionEntry;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFRegion;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Chris O
 */
public class BluNDFRegion extends RegionEntry<NDFRegion, BluNDFArea> {
    
    public BluNDFRegion(NDFRegion region, String regionName,
            int width, int height, BluGraph g, BluNDFArea area, Color c, boolean treatAsArea) {

        super(region, regionName, width, height, g, area, c, treatAsArea);
    }
    
    public BluNDFRegion(NDFRegion region, String regionName,
            int width, int height, BluGraph g, BluNDFArea p, Color c, boolean treatAsArea, JLabel label) {

        super(region, regionName, width, height, g, p, c, treatAsArea);
        
        this.remove(partitionLabel);
        
        this.partitionLabel = label;
        
        this.add(label);
    }
}
