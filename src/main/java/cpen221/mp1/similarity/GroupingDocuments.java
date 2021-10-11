package cpen221.mp1.similarity;

import cpen221.mp1.Document;
import cpen221.mp1.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.*;

public class GroupingDocuments {

    /* ------- Task 5 ------- */

    /**
     * Group documents by similarity
     * @param allDocuments the set of all documents to be considered,
     *                     is not null
     * @param numberOfGroups the number of document groups to be generated
     * @return groups of documents, where each group (set) contains similar
     * documents following this rule: if D_i is in P_x, and P_x contains at
     * least one other document, then P_x contains some other D_j such that
     * the divergence between D_i and D_j is smaller than (or at most equal
     * to) the divergence between D_i and any document that is not in P_x.
     */
    public static Set<Set<Document>> groupBySimilarity(Set<Document> allDocuments, int numberOfGroups) {
        // TODO: Implement this method
        ArrayList<Set<Document>> groupings = new ArrayList<Set<Document>>();
        Set<Document> group = new HashSet<Document>();
        double [] pair = new double[3];
        int currentGroups = 1;

        double [][] comparisons = new double[allDocuments.size()][allDocuments.size()];

        for(int i = 0; i < allDocuments.size(); i++) {
            for(int j = i; j < allDocuments.size(); j++) {
                comparisons[i][j] = DocumentSimilarity.documentDivergence((Document) allDocuments.toArray()[i],(Document) allDocuments.toArray()[j]);
            }
        }

        for(int i = 0; i < allDocuments.size(); i++) {
            group.add((Document) allDocuments.toArray()[i]);
            groupings.add(i, group);
        }

        while (currentGroups < numberOfGroups) {
            pair = findNthLowestPair(comparisons, allDocuments.size(), currentGroups-1);

            try {
                merge(findIndex((int)pair[1], groupings, allDocuments), findIndex((int)pair[2], groupings, allDocuments), groupings);
            }
            catch (Exception e){
                System.out.println("Arrays not found");
            }

            numberOfGroups = calculateNumberOfGroups(groupings);
        }

        return null;
    }

    private static double[] findNthLowestPair(double[][] pairs, int size, int pairNum) {
        double [] smallest = {1, 1, 1}; //first index is for value of comparison, next two are for indexes of comparison
        for (int m = 0; m < pairNum; m++) {
            for (int i = 0; i < size; i++) {
                for (int j = i; j < size; j++) {
                    if (pairs[i][j] < smallest[0]) {
                        smallest[0] = pairs[i][j];
                        smallest[1] = i;
                        smallest[2] = j;
                    }
                }
            }
            pairs[(int)smallest[1]][(int)smallest[2]] = 1;
            smallest[0] = 1;
        }
        return smallest;
    }

    private static int findIndex(int inputIndex, ArrayList<Set<Document>> groups, Set originalDocuments) throws NotFoundException {
        int index = 0;

        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).contains(originalDocuments.toArray()[i])) {
                return i;
            }
        }


        throw new cpen221.mp1.exceptions.NotFoundException("index not found");
    }

    private static void merge(int index1, int index2, ArrayList<Set<Document>> groups) {
        Set<Document> temp = new HashSet<Document>();
        temp.addAll(groups.get(index1));
        temp.addAll(groups.get(index2));
        groups.add(index1, temp);
        groups.remove(index2);
    }

    private static int calculateNumberOfGroups(ArrayList groups) {
        return groups.size();
    }

}
