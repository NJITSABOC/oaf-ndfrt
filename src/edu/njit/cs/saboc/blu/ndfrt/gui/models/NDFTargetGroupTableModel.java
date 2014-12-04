package edu.njit.cs.saboc.blu.ndfrt.gui.models;

import edu.njit.cs.saboc.blu.ndfrt.abn.NDFTargetGroup;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.utils.NDFConceptNameComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chris O
 */
public class NDFTargetGroupTableModel extends AbstractTableModel {

    private String[] columnNames = new String[]{"Concept Name", "Concept Id", "Source Concepts"};
    private Object[][] data = new Object[0][0];


    public NDFTargetGroupTableModel() {

    }
    
    public void updateConceptList(NDFTargetGroup group) {
        
        ArrayList<NDFConcept> sortedConcepts = new ArrayList<NDFConcept>(group.getGroupNDFConceptHierarchy().getNodesInHierarchy());
        Collections.sort(sortedConcepts, new NDFConceptNameComparator());
        
        data = new Object[sortedConcepts.size()][columnNames.length];
        
        HashMap<NDFConcept, HashSet<NDFConcept>> incomingRelSources = group.getGroupIncomingRelSources();

        for (int r = 0; r < sortedConcepts.size(); r++) {
            NDFConcept concept = sortedConcepts.get(r);
            
            data[r][0] = concept.getName();
            data[r][1] = concept.getId();
            
            if(incomingRelSources.containsKey(concept)) {
                ArrayList<NDFConcept> sortedSources = new ArrayList<NDFConcept>(incomingRelSources.get(concept));
                Collections.sort(sortedSources, new NDFConceptNameComparator());
                
                String sourceNames = "";

                for(NDFConcept sourceConcept : sortedSources) {
                    sourceNames += (sourceConcept.getName() + "\n");
                }
                
                data[r][2] = sourceNames.substring(0, sourceNames.length() - 1);
            } else {
                data[r][2] = "";
            }
        }
        
        this.fireTableDataChanged();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    } 
}