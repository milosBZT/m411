package ch.bztf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Hello world!
 */
public final class App
{
    private App() {}
    public static void main(String[] args)
    {
        /**
         * @Erklaerung der Aufgabe:
         * 
         * Es wurde eine LinkedList als datenstrukture gewaehlt. Es wurde kein simples
         * Array gewaehlt, weil die Schuelerlist sowieso nicht eine gewisse Anzahl ueberschreitet,
         * welche die linked list langsam machen wuerde. Zusaetlich ist es dadurch moeglich schueler
         * leicht aus der Liste zu loeschen und neue einzufuegen oder eine beliebige anzahl anzuhaengen.
         * 
         */

        LinkedList<Student> ll = new LinkedList<Student>();

        try {
            /**
             * Befuelle die linked list mit schuelern im try block weil eine
             * exception geworfen wird wenn nicht genau 5 noten angebeben wurden.
             */
            ll.append(new Student("Max Muster", "Sek 3a", new ArrayList<Double>(Arrays.asList(5.0, 4.5, 3.0, 4.8, 5.2))));
            ll.append(new Student("Doris Pfister", "Sek 2a", new ArrayList<Double>(Arrays.asList(6.0, 5.5, 5.0, 4.5, 5.0))));
            ll.append(new Student("Mia Zuber", "Sek 3a", new ArrayList<Double>(Arrays.asList(3.0, 5.0, 5.0, 4.5, 3.5))));           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ll);
    }
}
