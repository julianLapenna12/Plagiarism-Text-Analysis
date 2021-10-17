package cpen221.mp1.similarity;

import cpen221.mp1.Document;
import cpen221.mp1.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Set<Document>> returnGroups = new HashSet<Set<Document>>();
        ArrayList<Set<Document>> groupings = new ArrayList<Set<Document>>();
        ArrayList<Document> allDocumentsList = new ArrayList<Document>();

        double [][] comparisons = new double[allDocuments.size()][allDocuments.size()];
        double [] pair = new double[3];
        int currentGroups = allDocuments.size();
        int lowestNum =1;
        boolean sameGroup = false;

        DocumentSimilarity docSim = new DocumentSimilarity();


        for(int i = 0; i < allDocuments.size(); i++) {
            allDocumentsList.add((Document) allDocuments.toArray()[i]);
        }

        for(int i = 0; i < allDocuments.size(); i++) {
            for(int j = i+1; j < allDocuments.size(); j++) {
                comparisons[i][j] = docSim.documentDivergence((Document) allDocumentsList.get(i),(Document) allDocumentsList.get(j));
            }
        }

        for(int i = 0; i < allDocuments.size(); i++) {
            Set<Document> group = new HashSet<Document>();
            group.add((Document) allDocumentsList.get(i));
            groupings.add(i, group);
        }

        while (currentGroups > numberOfGroups) {
            do {
                sameGroup = false;
                pair = findNthLowestPair(comparisons, lowestNum);
                try {
                    if (findIndex((int)pair[1], groupings, allDocumentsList) == findIndex((int)pair[2], groupings, allDocumentsList)){
                        sameGroup = true;
                    }
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
                lowestNum++;
            } while(sameGroup);

            try {
                merge(findIndex((int)pair[1], groupings, allDocumentsList), findIndex((int)pair[2], groupings, allDocumentsList), groupings);
            }
            catch (Exception e){
                System.out.println("Arrays not found");
            }

            currentGroups = groupings.size();
        }

        returnGroups = makeSet(groupings);

        return returnGroups;
    }

    /**
     * Finds the Nth lowest value in a 2D array of type double
     *
     * @param pairs is the array for which the method is searching.  Array needs to have values above or equal to 0, have the same
     *              number of rows and columns, and only to provide values when the column is greater than the row - means no
     *              arrays of size 1, only of size 2 or greater.
     * @param pairNum is N, which is used to indicate returning the Nth lowest number,
     *                rather than just the lowest.  Must be lower than or equal to the number of values in the array
     * @returns A double array of size 3 with the Nth lowest value as the first index, and the index of
     * that value within the given array as the second and third indecies.
    */
    private static double [] findNthLowestPair(double[][] pairs, int pairNum) {
        double [][] pairCopy = new double[pairs.length][pairs.length];
        double []smallest = {Double.MAX_VALUE, 0, 0};
        double [] temp = {Double.MAX_VALUE, 0, 0};

        for(int i = 0; i < pairs.length; i++) {
            for(int j = i +1; j < pairs.length; j++) {
                pairCopy[i][j] = pairs[i][j];
            }
        }

        for (int m = 0; m < pairNum; m++) {
            for (int i = 0; i < pairs.length; i++) {
                for (int j = i+1; j < pairs.length; j++) {
                    if (pairCopy[i][j] < smallest[0]) {
                        smallest[0] = pairs[i][j];
                        smallest[1] = i;
                        smallest[2] = j;
                    }
                }
            }
            for(int i = 0; i < smallest.length; i++) {
                temp[i] = smallest[i];
            }
            pairCopy[(int)smallest[1]][(int)smallest[2]] = Double.MAX_VALUE;
            smallest[0] = Double.MAX_VALUE;
        }


        return temp;
    }

    /**
     * Finds a document at a specified index (original document) in a list, in a list of sets of other documents
     *
     * @param inputIndex Index of document in list
     * @param groups List of sets
     * @param originalDocuments List where original document is searched for
     * @return Index of the set with the original document in groups
     * @throws NotFoundException when the original document cannot be found in groups
     */
    private static int findIndex(int inputIndex, ArrayList<Set<Document>> groups, List<Document> originalDocuments) throws NotFoundException {
        int index = 0;

        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).contains((Document) originalDocuments.get(inputIndex))) {
                return i;
            }
        }


        throw new cpen221.mp1.exceptions.NotFoundException("index not found");
    }

    /**
     * Merges two sets in a list of sets
     *
     * @param index1 Index of the first set, greater than or equal to 0 and less than the length of the list
     * @param index2 Index of the second set, greater than or equal to 0, and less than the length of the list
     * @param groups List of sets, must have at least 2 elements
     */
    private static void merge(int index1, int index2, ArrayList<Set<Document>> groups) {
        int [] indecies = new int[2];
        Set<Document> temp = new HashSet<Document>();
        temp.addAll(groups.get(index1));
        temp.addAll(groups.get(index2));

        indecies = orderLowest(index1, index2);

        groups.remove(indecies[0]);
        groups.remove(indecies[1] -1 );

        groups.add(temp);
    }

    /**
     * Turns a list of sets into a set of sets
     *
     * @param input list of sets to be changed
     * @return a set of sets with all the elements of input
     */
    private static Set<Set<Document>> makeSet(ArrayList<Set<Document>> input) {
        Set<Set<Document>> returnSet = new HashSet<Set<Document>>();
        for (int i = 0; i < input.size(); i++) {
            returnSet.add(input.get(i));
        }
        return returnSet;
    }

    /**
     * Orders two integers from lowest to highest
     *
     * @param num1 First integer to be ordered, cannot be null
     * @param num2 Second integer to be ordered, cannot be null
     * @return An integer array of size 2 ordered lowest to highest
     *
     */
    private static int[] orderLowest(int num1, int num2) {
        int [] ordered = new int[2];
        if (num1 < num2) {
            ordered[0] = num1;
            ordered[1] = num2;
            return ordered;
        }
        ordered[0] = num2;
        ordered[1] = num1;
        return ordered;
    }

}

