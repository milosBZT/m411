package ch.bztf;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

// Erstellen Sie eine Klasse (ein Datentyp) "Person":
// Attribute: "name" (string), "vorname" (string) "maennlich" (boolean)
// Methoden: getFullName(): gibt einen String in der Form "name vorname" zurück
// getGeschlechtText(): gibt "männlich" oder "weiblich" zurück, je nach Wert von "maennlich)
// Erstellen Sie ein Hauptprogramm, welches:
// ein Objekt der Klasse "Person" instanziert
// die Werte für name, vorname und maennlich setzt
// Einen String erzeugt in der Form "Dies ist [objekt.getFullName()]. Das Geschlecht ist [objekt.getGeschlechtText()]".
// (optional): Ergänzen Sie Ihre Klasse:
// um das Attribut "gebursdatum" (Typ: LocalDate, siehe https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)
// um eine Methode "getAlter()" (int), welche das aktuelle Alter der Person zurückgibt.
// Erstellen Sie ein Person-Objekt mit Geburtsdatum am 08.04.1979 und geben Sie das Alter aus
public class Person
{
    private String name;
    private String vorname;
    private boolean maennlich;
    LocalDate geburtstag;

    public Person(String name,
                  String vorname,
                  boolean maennlich,
                  LocalDate geburtstag
    ){
        this.name = name;
        this.vorname = vorname;
        this.maennlich = maennlich;
        this.geburtstag = geburtstag;
    }


    public int getAlter()
    {
        LocalDate t0 = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(this.geburtstag, t0);
    }

    public String getFullName()
    {
        return name + " " + vorname;
    }

    public String getGeschlechtText()
    {
        return (maennlich) ? "Maennlich" : "Weiblich";
    }
}
