package edu.njit.cs.saboc.blu.ndfrt.gui.abnselection;

import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomy;
import edu.njit.cs.saboc.blu.core.abn.pareataxonomy.PAreaTaxonomyGenerator;
import edu.njit.cs.saboc.blu.ndfrt.abn.pareataxonomy.NDFRTPAreaTaxonomyFactory;
import edu.njit.cs.saboc.blu.ndfrt.datasource.NDFRTDataSource;
import edu.njit.cs.saboc.blu.ndfrt.datasource.NDFRTLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Chris
 */
public class NDFRTVersionSelectPanel extends JPanel {
    private final JLabel statusLabel;
    
    public NDFRTVersionSelectPanel(final NDFAbNFrameManager displayListener) {
        JButton loadButton = new JButton("Load NDF RT Release");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                File selectedFolder = showReleaseFolderSelectionDialog();
                
                if(selectedFolder != null && selectedFolder.getAbsolutePath().endsWith("\\data\\77")) {
                    NDFRTLoader loader = new NDFRTLoader();
                    
                    System.out.println("LOADING NDF RT RELEASE...");
                    
                    NDFRTDataSource dataSource = loader.loadNDFRTDataSource(selectedFolder.getAbsolutePath(), 167503724543L);
                    
                    System.out.println("GENERATING NDF RT PAREA TAXONOMY...");
                    
                    PAreaTaxonomyGenerator generator = new PAreaTaxonomyGenerator();
                    
                    PAreaTaxonomy taxonomy = generator.derivePAreaTaxonomy(
                            new NDFRTPAreaTaxonomyFactory(dataSource), 
                            dataSource.getConceptHierarchy());
                    
                    System.out.println("TAXONOMY METRICS: Areas: " + taxonomy.getAreaTaxonomy().getAreas().size());
                    
                    
                    displayListener.displayPAreaTaxonomy(taxonomy);
                }
            }
        });
        
        this.statusLabel = new JLabel("Select a NDF RT Release");
        
        this.add(loadButton);
        this.add(statusLabel);
    }
    
    private File showReleaseFolderSelectionDialog() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                
                // TODO: Check that there is actually a release... 
                
                File file = chooser.getSelectedFile();

                return file;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
    
}
