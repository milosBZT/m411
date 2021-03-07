package ch.bztf;

import java.util.function.BiPredicate;

/**
 * Node
 */
public class Node<T extends Comparable<T>>
{
    private T data;
    private Node<T> next;
    private Node<T> prev;


    /**
     * 
     * @param data
     */
    public Node(T data)
    {
        this.data = data;
        next = null;
        prev = null;
    }


    /**
     * 
     * @return
     */
    public T data()
    {
        return this.data;
    }


    /**
     * 
     * @return
     */
    public Node<T> prev()
    {
        return this.prev;
    }

    /**
     * 
     * @return
     */
    public Node<T> next()
    {
        return this.next;
    }



    /**
     * 
     * @param next
     */
    public void setNext(Node<T> next)
    {
        this.next = next;
    }


    /**
     * 
     * @param next
     */
    public void setPrev(Node<T> prev)
    {
        this.prev = prev;
    }


    public String toString()
    {
        return data.toString();
    }


    /**
     * 
     * @param pred
     * @param lhs
     * @param rhs
     * @return
     */
    public boolean equals(BiPredicate<T, T> pred, T lhs, T rhs)
    {
        return pred.test(lhs, rhs);
    }


    /**
     * 
     * @param other
     * @return
     */
    public boolean equals(Node<T> other)
    {
        return  (0 == data().compareTo(other.data()));
    }
}