package ch.bztf;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * LinkedList
 */
public class LinkedList<T extends Comparable<T>>
{
    private Node<T> begin_node_;
    private Node<T> last_node_;
    // private BiPredicate<T, T> find_predicate_ = null;
    int size_ = 0;

    /**
     * 
     */
    public LinkedList() {
        begin_node_ = null;
        last_node_ = null;
    }

    /**
     * 
     * @return
     */
    public int size() {
        return size_;
    }

    /**
     * 
     * Fuege neue Objekte in die LinkedList ein. Passe dabei immer die
     * tail node an um das ende zu wissen und schnelle appends zu machen.
     * 
     * @param value
     */
    public void append(T value) {
        Node<T> node = new Node<T>(value);

        // wenn die liste noch leer ist.
        if (begin_node_ == null && last_node_ == null) {
            begin_node_ = node;
            last_node_ = node;
        }

        last_node_.setNext(node); // fuege unser objekt am schluss ein
        node.setPrev(last_node_); // setze als vorherige node die alte tail node
        last_node_ = node; // setze uns ans ende
        last_node_.setNext(null); // setze den next pointer auf null
        ++size_; // update groesse der liste
    }


    /**
     * Inserts element at position found by provided
     * comparator object.
     * 
     * @param value
     * @param comp
     */
     public void sortedAppend(T value, Comparator<T> comp)
    {
        Node<T> node_at = null;
        for (var node = begin_node_; node != null; node = node.next()) {
            if (comp.compare(value, node.data()) < 0) {
                node_at = node;
                break;
            }
        }

        if (node_at != null) {
            swap(insert(value, node_at), node_at);
        } else {
            append(value);
        }
    }


    /**
     * 
     * @param l
     * @param r
     */
    public void swap(Node<T> l, Node<T> r)
    {
        var tmp = new Node<T>(l.data());
        tmp.setPrev(l.prev());
        tmp.setNext(l.next());

        if (l == begin_node_) {
            begin_node_ = r;
        }
        else if (r == begin_node_) {
            begin_node_ = l;
        }
    
        if (l == last_node_) {
            last_node_ = r;
        }
        else if (r == last_node_) {
            last_node_ = l;
        }

        if (r.prev() != null) {
            r.prev().setNext(l);
        }

        if (r.next() != null) {
            r.next().setPrev(l);
        }

        if (tmp.next() != null) {
            tmp.next().setPrev(r);
        }

        if (tmp.prev() != null) {
            tmp.prev().setNext(r);
        }

        l.setNext(r.next());
        l.setPrev(r.prev());
        r.setNext(tmp.next());
        r.setPrev(tmp.prev());
    }


    /**
     * Finds a node by means of applying provided callback
     * to each element of list.
     * 
     * @param fn
     * @return
     */
    public Node<T> find(Function<T, Boolean> fn)
    {
        for (Node<T> n = begin_node_; n != null; n = n.next()) {
            if (fn.apply(n.data())) {
                return n;
            }
        }
        return null;
    }


    /**
     * Implements find method that uses default equality check.
     * @param value
     * @return
     */
    public Node<T> find(Node<T> node)
    {
        for (Node<T> n = begin_node_; n != null; n = n.next()) {
            if (n.equals(node)) {
                System.out.println("found: " + n.data());
                return n;
            }
        }
        return null;
    }


    /**
     * 
     * @param pos
     * @param value
     */
    public Node<T> insert(T value, Node<T> node_at)
    {
        var node = new Node<T>(value);
        if (node_at != null) {
            insert_(node, node_at);
            return node;
        } else {
            return null;
        }
    }


    /**
     * 
     * @param pos_node
     * @param value
     */
    public void insert(T value, Function<T, Boolean> fn)
    {
        var node = new Node<T>(value);
        var pos_node = find(fn);
        if (pos_node != null) {
            insert_(node, pos_node);
        }
    }

    /**
     * Implements core method for inserting node 
     * 
     * @param node_at
     */
    private void insert_(Node<T> node, Node<T> node_at)
    {
        if (node_at == null) {
            return;
        }

        var next = node_at.next();
        node_at.setNext(node);
        node.setPrev(node_at);
        node.setNext(next);

        if (next != null) {
            next.setPrev(node);
        } else {
            last_node_ = node;
        }

        ++size_;
    }


    /**
     * Moves node to a new position.
     * 
     * @param node
     * @param fn
     */
    public void move(Node<T> node, Function<T, Boolean> fn)
    {
        var node_at = find(fn);
        insert(node.data(), node_at);
        remove_(node);
    }


    /**
     * 
     * @param value
     */
    public void remove(Node<T> target_node)
    {
        var node = find(target_node);
        if (node != null) {
            remove_(node);
        }
    }

    /**
     * Removes a node if found
     * 
     * @param node node to remove
     */
    public void remove(Function<T, Boolean> fn)
    {
        var node = find(fn);
        if (node != null) {
            remove_(node);
        }
    }


    /**
     * 
     * @param node
     */
    private void remove_(Node<T> node)
    {
        if (node.next() == null) {
            last_node_ = node.prev();
            node.prev().setNext(null);
        } else {
            node.prev().setNext(node.next());
            node.next().setPrev(node.prev());
        }
        --size_;
    }


    /**
     * Provides convenience looping through node elements.
     * 
     * @param fn callback to apply on each element
     */
     public void forEach(Consumer<Node<T>> fn)
    {
        for (Node<T> n = begin_node_; n != null; n = n.next()) {
            fn.accept(n);
        }
    }


    /**
     * Provides convenience looping through node elements.
     * 
     * @param <U>
     * @param fn callback to apply on each element
     */
    public <U> void forEach(Function<Node<T>, U> fn)
    {
        for (Node<T> n = begin_node_; n != null; n = n.next()) {
            fn.apply(n);
        }
    }


    /**
     * Dump nicely formatted linked list information and content
     */
    public String toString()
    {
        var color = Colors.YELLOW_BOLD;
        String s = Colors.WHITE_BOLD + "\nDumping linked list: "
                   + color
                   + "0x" + Integer.toHexString(System.identityHashCode(this))
                   + "\n";

        s += Colors.WHITE_BOLD + "linked list size: " + color + size_ + "\n";
        s += Colors.WHITE_BOLD + "linked list content: {\n    ";
        Node<T> begin = begin_node_;
        int c = 0;

        while (begin != null) {
            // print 1 elements in one row
            if (c != 0 && c % 1 == 0) {
                s += color + "\n    ";
            }
            s += color + begin.toString() + Colors.RESET + ", ";
            begin = begin.next();
            ++c;
        }

        return s.substring(0, s.lastIndexOf(',')) + Colors.RESET + "\n}";
    }


    /**
     * Set current predicate function that is used for testing equality.
     * 
     * @deprecated due to nicer `find(Function fn)` implementation.
     * @param pred
     */
    // public void setFindPrdicate_(BiFunction<T, T, Boolean> fn)
    // {
    //     var predicate = new BiPredicate<T, T>() {
	// 		@Override
	// 		public boolean test(T arg0, T arg1) {
    //             return fn.apply(arg0, arg1);
	// 		}
    //     };
    //     // pred
    //     find_predicate_ = predicate;
    // }

}