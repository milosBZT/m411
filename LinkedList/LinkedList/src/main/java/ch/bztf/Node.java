package ch.bztf;

/**
 * Node
 */
public class Node<T>
{
    private T data;
    private Node<T> next;


    /**
     * 
     * @param data
     */
    public Node(T data)
    {
        this.data = data;
        next = null;
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
}