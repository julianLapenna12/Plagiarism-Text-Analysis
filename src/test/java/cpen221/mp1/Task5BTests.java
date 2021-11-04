package cpen221.mp1;

import cpen221.mp1.similarity.GroupingDocuments;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5BTests {

    private static Document rightHoJeeves, rightHoJeeves2, carryOnJeeves, theSignOfTheFour, lupin, voyageOfTheBeagle, frankenstein, theLastMan, theHeirOfMondolfo, theAgeOfInnocence, the3Musketeers, theCountOfMonteCristo, lesMis, macbeth, empty;

    @BeforeAll
    private static void createDocuments() {
        rightHoJeeves = new Document("Right Ho, Jeeves", "resources/RightHoJeeves.txt");
        rightHoJeeves2 = new Document("Right Ho, Jeeves", "resources/RightHoJeeves.txt");
        carryOnJeeves = new Document("Carry On, Jeeves", "resources/CarryOnJeeves.txt");
        theSignOfTheFour = new Document("The Sign of the Four", "resources/TheSignOfTheFour.txt");
        lupin = new Document("Lupin", "resources/Lupin.txt");
        voyageOfTheBeagle = new Document("The Voyage of the Beagle", "resources/TheVoyageOfTheBeagle.txt");
        frankenstein = new Document("Frankenstein", "resources/Frankenstein.txt");
        theLastMan = new Document("The Last Man", "resources/TheLastMan.txt");
        theHeirOfMondolfo = new Document("The Heir of Mondolfo", "resources/TheHeirOfMondolfo.txt");
        theAgeOfInnocence = new Document("The Age of Innocence", "resources/TheAgeOfInnocence.txt");
        the3Musketeers = new Document("The Three Musketeers", "resources/TheThreeMusketeers.txt");
        theCountOfMonteCristo = new Document("The Count of Monte Cristo", "resources/TheCountOfMonteCristo.txt");
        lesMis = new Document("Les miserables", "resources/LesMiserables.txt");
        macbeth = new Document("Macbeth", "resources/Macbeth.txt");
        empty = new Document("Empty", "resources/Empty.txt");
    }

    @ParameterizedTest
    @MethodSource("groupingTestProvider")
    @Timeout(40)
    public void testGrouping(Set<Document> documentSet, int numGroups, Set<Set<Document>> expectedGroups) {
        assertEquals(
                expectedGroups,
                GroupingDocuments.groupBySimilarity(documentSet, numGroups)
        );
    }

    private static Stream<Arguments> groupingTestProvider() {
        return Stream.of(
                Arguments.of(
                        Set.of(rightHoJeeves),
                        1,
                        Set.of(Set.of(rightHoJeeves))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves),
                        1,
                        Set.of(Set.of(rightHoJeeves, carryOnJeeves))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves),
                        2,
                        Set.of(Set.of(rightHoJeeves), Set.of(carryOnJeeves))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves, rightHoJeeves2),
                        2,
                        Set.of(Set.of(rightHoJeeves, rightHoJeeves2), Set.of(carryOnJeeves))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, empty),
                        2,
                        Set.of(Set.of(empty), Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, empty),
                        2,
                        Set.of(Set.of(empty), Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, lupin, voyageOfTheBeagle, frankenstein, theLastMan, theHeirOfMondolfo, theAgeOfInnocence, the3Musketeers, theCountOfMonteCristo, lesMis, macbeth, empty),
                        2,
                        Set.of(Set.of(empty), Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, lupin, voyageOfTheBeagle, frankenstein, theLastMan, theHeirOfMondolfo, theAgeOfInnocence, the3Musketeers, theCountOfMonteCristo, lesMis, macbeth))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, lupin, voyageOfTheBeagle, frankenstein, theLastMan, theHeirOfMondolfo, theAgeOfInnocence, the3Musketeers, theCountOfMonteCristo, lesMis, macbeth, empty),
                        8,
                        Set.of(Set.of(empty), Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, lupin), Set.of(macbeth), Set.of(theCountOfMonteCristo), Set.of(theAgeOfInnocence), Set.of(voyageOfTheBeagle, frankenstein, theLastMan), Set.of(theHeirOfMondolfo), Set.of(the3Musketeers, lesMis))
                ),

                Arguments.of(
                        Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, lupin, voyageOfTheBeagle, frankenstein, theLastMan, theHeirOfMondolfo, theAgeOfInnocence, the3Musketeers, theCountOfMonteCristo, lesMis, macbeth),
                        5,
                        Set.of(Set.of(rightHoJeeves, carryOnJeeves, theSignOfTheFour, lupin, theAgeOfInnocence), Set.of(macbeth), Set.of(voyageOfTheBeagle, frankenstein, theLastMan), Set.of(theHeirOfMondolfo), Set.of(the3Musketeers, lesMis, theCountOfMonteCristo))
                )
        );
    }

}
