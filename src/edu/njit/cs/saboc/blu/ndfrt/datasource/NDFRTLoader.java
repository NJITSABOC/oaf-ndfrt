package edu.njit.cs.saboc.blu.ndfrt.datasource;

import edu.njit.cs.saboc.blu.core.datastructure.hierarchy.Hierarchy;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFConcept;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRelationship;
import edu.njit.cs.saboc.blu.ndfrt.conceptdata.NDFRole;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Chris O
 */
public class NDFRTLoader {
    public NDFRTDataSource loadNDFRTDataSource(String location, long versionNumber) {
        HashMap<Long, NDFConcept> concepts = loadConcepts(location, versionNumber);
        
        HashMap<Long, NDFRole> relationships = loadRelationshipTypes(location, versionNumber);
        
        Hierarchy<NDFConcept> hierarchy = loadConceptHierarchy(location, versionNumber, concepts);
        
        initializeRelationships(location, versionNumber, concepts, relationships);
        
        return new NDFRTDataSource(hierarchy, relationships);
    }
    
    private HashMap<Long, NDFConcept> loadConcepts(String location, long versionNumber) {

        HashMap<Long, NDFConcept> concepts = new HashMap<>();

        concepts.put(0L, new NDFConcept(0, "NDF RT ROOT (not a real concept)"));

        try {
            Scanner scanner = new Scanner(new File(location + "/DTS_CONCEPT_ARCHIVE.full"));

            scanner.nextLine(); // Skip column names

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                String[] parts = line.split("\t");

                long versionNum = Long.parseLong(parts[2]);

                if (versionNum == versionNumber) {
                    long conceptGID = Long.parseLong(parts[3]);
                    String name = parts[6];

                    concepts.put(conceptGID, new NDFConcept(conceptGID, name));
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return concepts;
    }
    
    private HashMap<Long, NDFRole> loadRelationshipTypes(String location, long versionNumber) {
        HashMap<Long, NDFRole> roles = new HashMap<>();
        
        try {
            Scanner scanner = new Scanner(new File(location + "/DTS_ROLE_TYPE_ARCHIVE.full"));

            scanner.nextLine(); // Skip column names

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                String[] parts = line.split("\t");

                long versionNum = Long.parseLong(parts[2]);

                if (versionNum == versionNumber) {
                    long roleGID = Long.parseLong(parts[3]);
                    String name = parts[6];

                    roles.put(roleGID, new NDFRole(roleGID, name));
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return roles;
    }
    
    private Hierarchy<NDFConcept> loadConceptHierarchy(String location, long versionNumber, HashMap<Long, NDFConcept> concepts) {
        Hierarchy<NDFConcept> conceptHierarchy = new Hierarchy<>(concepts.get(0L));

        try {
            Scanner scanner = new Scanner(new File(location + "/DTS_DIRECT_SUPS_ARCHIVE.full"));

            scanner.nextLine(); // Skip column names

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");

                long versionNum = Long.parseLong(parts[2]);

                if (versionNum == versionNumber) {
                    long childGID = Long.parseLong(parts[3]);
                    long parentGID = Long.parseLong(parts[4]);

                    conceptHierarchy.addEdge(concepts.get(childGID), concepts.get(parentGID));
                }

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return conceptHierarchy;
    }
    
    private void initializeRelationships(String location, long versionNumber, 
            HashMap<Long, NDFConcept> concepts,
            HashMap<Long, NDFRole> roles) {
        try {
            Scanner scanner = new Scanner(new File(location + "/DTS_COMPLETE_ROLE_CON_ARCHIVE.full"));

            scanner.nextLine(); // Skip column names

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                
                long versionNum = Long.parseLong(parts[2]);
                
                if (versionNum == versionNumber) {
                    long sourceGID = Long.parseLong(parts[4]);
                    long typeGID = Long.parseLong(parts[5]);
                    long targetGID = Long.parseLong(parts[6]);

                    concepts.get(sourceGID).addAttributeRelationship(new NDFRelationship(roles.get(typeGID), concepts.get(targetGID)));
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
