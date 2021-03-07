package ch.bztf;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
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
     * @param value
     */
    public void append(T value) {
        Node<T> node = new Node<T>(value);

        if (begin_node_ == null && last_node_ == null) {
            begin_node_ = node;
            last_node_ = node;
        }

        last_node_.setNext(node);
        node.setPrev(last_node_);
        last_node_ = node;
        last_node_.setNext(null);
        ++size_;
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
    public Node<T> find(T value)
    {
        for (Node<T> n = begin_node_; n != null; n = n.next()) {
            if (n.data().equals(value)) {
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
    public void insert(T value, Node<T> node)
    {
        var pos_node = find(value);
        if (pos_node != null) {
            insert_(pos_node, node);
        } 
    }


    /**
     * 
     * @param pos_node
     * @param node
     */
    public void insert(Node<T> node, Function<T, Boolean> fn)
    {
        var pos_node = find(fn);
        if (pos_node != null) {
            insert_(pos_node, node);
        }
    }

    /**
     * Implements core method for inserting node 
     * 
     * @param found
     */
    private void insert_(Node<T> found, Node<T> node)
    {
        if (found == null) {
            return;
        }
 
        var next = found.next();
        found.setNext(node);
        node.setPrev(found);
        node.setNext(next);

        if (next != null) {
            next.setPrev(node);
        } else {
            last_node_ = node;
        }

    }


    /**
     * 
     * @param value
     */
    public void remove(T value)
    {
        var node = find(value);
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
    }

    /**
     * 
     */
    public String toString() {
        String s = "";
        Node<T> begin = begin_node_;
        while (begin != null) {
            s += begin.toString() + ", ";
            begin = begin.next();
        }

        return s.substring(0, s.lastIndexOf(','));
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