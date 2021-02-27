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
        Node<Integer> node = new Node<Integer>(30);


        LinkedList<Integer> ll = new LinkedList<Integer>();

        // ll.append(45);
        // ll.append(1245);
        // ll.append(76);
        // ll.append(38475);

        long start_time = System.nanoTime();

        for (int i = 0; i < 1e6; ++i) {
            // ll.append(i);
            ll.dumbAppend(i);
        }
        long end_time = System.nanoTime();
        double duration = (end_time - start_time) / 1e9;  //divide by 1000000 to get milliseconds.

        // ll.dumbAppend(45);
        // ll.dumbAppend(1245);
        // ll.dumbAppend(76);
        // ll.dumbAppend(38475);


        // System.out.println(ll);
        // System.out.println("linked list size: " + ll.size());
        System.out.println("duration: " + duration + "s");
    }
}
