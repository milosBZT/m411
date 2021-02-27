package ch.bztf;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args)
    {
        Person person = new Person("Stallman", "Richard", true, LocalDate.of(1960, 12, 31));

        String s = "Dies ist " + person.getFullName() +
                    ". Das Geschlecht ist " + person.getGeschlechtText() + "." +
                    " Alter ist: " + person.getAlter() + ".";

        System.out.println(s);
    }
}
