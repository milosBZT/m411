package ch.bztf;

public class User implements Comparable<User>
{
    public String name_;
    public String last_name_;


    User(String name, String last_name)
    {
        name_ = name;
        last_name_ = last_name;
    }


    public String toString()
    {
        return name_ + " " + last_name_;
    }

    /**
     * 
     * @param other
     * @return
     */
    public int compareTo(User other)
    {
        if (name_.equals(other.name_)) {
            return 0;
        }

        return 1;
    }
}
