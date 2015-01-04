package edu.njit.cs.saboc.blu.ndfrt.gui.abnselection;

import edu.njit.cs.saboc.blu.ndfrt.abn.NDFReducedTargetAbNGenerator;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetwork;
import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetAbstractionNetworkGenerator;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRelationship;
import edu.njit.cs.saboc.blu.ndfrt.datasource.NDFRTDataSource;
import edu.njit.cs.saboc.blu.ndfrt.datasource.NDFRTLoader;
import edu.njit.cs.saboc.blu.ndfrt.datastructure.NDFConceptHierarchy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Chris
 */
public class NDFRTVersionSelectPanel extends JPanel {
    private JLabel statusLabel;
    
    public NDFRTVersionSelectPanel(final NDFDisplayFrameListener displayListener) {
        JButton loadButton = new JButton("Load NDF RT Release");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                File selectedFolder = showReleaseFolderSelectionDialog();
                
                if(selectedFolder != null && selectedFolder.getAbsolutePath().endsWith("\\data\\77")) {
                    NDFRTLoader loader = new NDFRTLoader();
                    
                    System.out.println("LOADING NDF RT RELEASE...");
                    
                    NDFRTDataSource dataSource = loader.loadNDFRTDataSource(selectedFolder.getAbsolutePath(), 167503724543L);
                    
                    System.out.println("FINDING NO DOSAGE DRUGS...");
                    
                    HashSet<NDFConcept> concepts = getNoDosageDrugs(dataSource.getConceptHierarchy().getConceptsInHierarchy());        
                            
                    NDFTargetAbstractionNetworkGenerator targetAbNGen = new NDFTargetAbstractionNetworkGenerator(dataSource);

                    System.out.println("GENERATING TARGET ABN...");
                    
                    
                    NDFTargetAbstractionNetwork abn = targetAbNGen.deriveTargetAbstractionNetwork(concepts, 
                            dataSource.getRoleFromId(165356240921L), dataSource.getConceptFromId(165356241075L));
                    
                    abn = abn.getReduced(10, 3000);
                    
                    //NDFTargetAbstractionNetwork abn = targetAbNGen.deriveTargetAbstractionNetwork(concepts, 
                    //        dataSource.getRoleFromId(165356240978L), dataSource.getConceptFromId(165356241521L));
                    
                    System.out.println("CREATING BLUGRAPH...");
                    
                    displayListener.addNewTargetAbNGraphFrame(abn);
                    
                    
                    /*
                    
                    NDFPAreaTaxonomyGenerator generator = new NDFPAreaTaxonomyGenerator(
                            (NDFConceptHierarchy) dataSource.getConceptHierarchy().getSubhierarchyRootedAt(dataSource.getConceptFromId(165356241073l)));

                    NDFPAreaTaxonomy taxonomy = (NDFPAreaTaxonomy) generator.derivePAreaTaxonomy();

                    displayListener.addNewPAreaTaxonomyGraphGraph(taxonomy);
                    */
                }
            }
        });
        
        this.statusLabel = new JLabel("Select a NDF RT Release");
        
        this.add(loadButton);
        this.add(statusLabel);
    }
    
    private HashSet<NDFConcept> getNoDosageDrugs(HashSet<NDFConcept> concepts) {
        HashSet<NDFConcept> noDosageDrugs = new HashSet<NDFConcept>();
        
        for(NDFConcept concept : concepts) {
            if(!concept.getAttributeRelationships().isEmpty()) {
                boolean hasDosage = false;
                
                for(NDFRelationship rel : concept.getAttributeRelationships()) {
                    if(rel.getType().getId() == 165356240941L) {
                        hasDosage = true;
                        break;
                    }
                }
                
                if(!hasDosage) {
                    noDosageDrugs.add(concept);
                }
            }
        }
        
        return noDosageDrugs;
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
