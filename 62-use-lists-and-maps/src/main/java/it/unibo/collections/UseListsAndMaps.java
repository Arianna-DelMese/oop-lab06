package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {

        
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        final int START_ARRL = 1000;
        final int END_ARRL = 2000;

        ArrayList<Integer> arrL = new ArrayList<>();
        for (int i = START_ARRL; i < END_ARRL; i++){
            arrL.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linkL = new LinkedList<>(arrL);
        //linkL.addAll(arrL); non serve se lo metto sopra
        IO.println(linkL);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        int temp = arrL.getFirst();
        arrL.set(0, arrL.getLast());
        arrL.set(arrL.size()-1, temp);
        IO.println(arrL);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : arrL){
            IO.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        final int START_ZERO = 0;
        final int END_LIST1 = 100000;

        long time = System.nanoTime();

        for (int i = START_ZERO; i < END_LIST1; i++){
            arrL.add(0, i);
        }

        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Operation 1 Array took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();

        for (int i = START_ZERO; i < END_LIST1; i++){
            linkL.add(0, i);
        }

        time = System.nanoTime() - time;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Operation 2 Linked took "
                + time
                + "ns ("
                + millis2
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        final int END_LIST2 = 1000;

        time = System.nanoTime();

        for (int i = START_ZERO; i < END_LIST2; i++){
            arrL.get(arrL.size()/2);
        }

        time = System.nanoTime() - time;
        final var millis3 = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Operation 3 Array middle took "
                + time
                + "ns ("
                + millis3
                + "ms)"
        );

        time = System.nanoTime();

        for (int i = START_ZERO; i < END_LIST2; i++){
            linkL.get(linkL.size()/2);
        }

        time = System.nanoTime() - time;
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Operation 4 Linked middle took "
                + time
                + "ns ("
                + millis4
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Long AFRICA_POP = 1110635000L;
        final Long AMERICAS_POP = 972005000L;
        final Long ANTARTICA_POP = 0L;
        final Long ASIA_POP = 4298723000L;
        final Long EUROPE_POP = 742452000L;
        final Long OCEANIA_POP = 38304000L;

        Map<String, Long> mapC = new HashMap<>();
        mapC.put("Africa", AFRICA_POP);
        mapC.put("Americas", AMERICAS_POP);
        mapC.put("Antartica", ANTARTICA_POP);
        mapC.put("Asia", ASIA_POP);
        mapC.put("Europe", EUROPE_POP);
        mapC.put("Oceania", OCEANIA_POP);
        /*
         * 8) Compute the population of the world
         */
        Long wPop = 0L;
        for (Long i : mapC.values()){
            wPop += i;
        }
        IO.println(wPop);
    }
}
