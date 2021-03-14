package ch.bztf;

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
        LinkedList<User> ll = new LinkedList<User>();
        // var ll = new LinkedList<Double>();

        // ll.append(234.0);
        // ll.append(354687.34);
        // ll.append(12.0);

        // var found = ll.find(234.0);
        // System.out.println(found);
        // System.out.println(ll);

        ll.append(new User("Richard", "Stallman"));
        ll.append(new User("Larry", "Wall"));
        ll.append(new User("Bjarne", "Stroustroup"));

        ll.insert(new User("Ken", "Thompson"), (User user) -> {
            return user.last_name_.equals("Stroustroup");
        });

        // ll.remove((User user) -> {
        //     return user.last_name_.equals("Stroustroup");
        // });


        var found = ll.find((User user) -> {
            return user.name_.equals("Bjarne")
                   && user.last_name_.equals("Stroustroup");
        });


        ll.append(new User("Howard", "Hinnant"));

        var ken = ll.find((User user) -> { return user.name_.equals("Ken"); });

        System.out.println(ll);

        ll.move(ken, (User user) -> { return user.name_.equals("Howard"); });

        ll.remove(new Node<User>(new User("Larry", "Wall")));




        // var ken = new User("Ken", "Thompson");

        // ll.setFindPrdicate_((User lhs, User rhs) -> {
        //         return lhs.name_.equals(rhs.name_)
        //                && lhs.last_name_.equals(rhs.last_name_);
        //     }
        // );

        // System.out.println("found node: " + found);

        // if (found != null) {
        //     System.out.println("prev: " + found.prev());
        //     System.out.println("next: " + found.next());    
        // }

    //     // System.out.println("Linked list size: " + ll.size());
        System.out.println(ll);
    //     // System.out.println("duration: " + duration + "s");



    }
}
