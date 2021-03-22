package ch.bztf;

import java.util.ArrayList;

/**
 * 
 */
public class Student implements Comparable<Student>
{
    public String name_;
    public String school_class_;

    public ArrayList<Double> grades_;
    int age_;


    /**
     * 
     * @param name
     * @param last_name
     * @throws Exception
     */
    Student(String name, String school_class, ArrayList<Double> grades) throws Exception
    {
        if (grades.size() != 5) {
            throw new Exception("Must specify 5 grades");
        }
        name_ = name;
        school_class_ = school_class;
        grades_ = grades;
    }


    /**
     * 
     * Gebe alles schueler in der konsole aus und berechne
     * den notendurchscnitt jedes schuelers gleich mit der methode meanGrades().
     * 
     * @return name and last name in one string
     */
    public String toString()
    {
        return name_ + " (" + school_class_ + ") " + meanGrades();
    }

    /**
     * 
     * @param other
     * @return
     */
    public int compareTo(Student other)
    {
        if (name_.equals(other.name_)) {
            return 0;
        }

        return 1;
    }


    public Double meanGrades()
    {
        double sum = 0; // summe der noten
        for (var grade : grades_) {
            sum += grade; // loope durch alle noten und summiere die noten
        }

        if (grades_.size() > 0) { // teste division durch null
            return sum / grades_.size(); // ermittle durchscnitt der noten
        } else {
            return 0.0;
        }
    }


    /**
     * 
     * @param other
     * @return
     */
    public Boolean equals(Student other)
    {
        return false;
        // return name_.equals(other.name_)
            //    && last_name_.equals(other.last_name_);
    }
}
