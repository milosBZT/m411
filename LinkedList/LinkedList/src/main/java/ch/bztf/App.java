package ch.bztf;

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
        LinkedList<User> ll = new LinkedList<User>();

        ll.append(new User("Richard", "Stallman", 67));
        ll.append(new User("Larry", "Wall", 66));
        ll.append(new User("Bjarne", "Stroustroup", 70));

        /**
         * Implement homework for find() with predicate
         */
        var found = ll.find(user -> user.last_name_.equals("Stroustroup"));
        System.out.println(
            Colors.CYAN_BRIGHT
            + "Found node with predicate: " + found
            + Colors.RESET    
        );

        /**
         * Implement Homework for sorted append.
         */
        var comp = new Comparator<User>() {
            @Override
            public int compare(User lhs, User rhs) {
                return lhs.last_name_.compareTo(rhs.last_name_);
            }   
        };

        ll.sortedAppend(new User("Milos", "Poplasen", 31), comp);
        System.out.println(ll);

        /**
         * Implement Homework fo consumer
         */
        var consumer = new Consumer<Node<User>>() {
            public int net_age = 0;
            public int n_users = 0;

            @Override
            public void accept(Node<User> node) {
                net_age += node.data().age_;
                ++n_users;   
            }
        };

        ll.forEach(consumer);
        System.out.println(
            Colors.GREEN_BRIGHT
            + "\nmean age of users: "
            + consumer.net_age / consumer.n_users
            + Colors.RESET    
        );
    }
}
