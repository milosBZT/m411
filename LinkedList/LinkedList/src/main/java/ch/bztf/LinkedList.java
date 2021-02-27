package ch.bztf;

/**
 * LinkedList
 */
public class LinkedList<T>
{
    private Node<T> begin_node_;
    private Node<T> last_node_;
    int size_ = 0;

    /**
     * 
     */
    public LinkedList()
    {
        begin_node_ = null;
        last_node_ = null;
    }

    /**
     * 
     * @return
     */
    public int size()
    {
        return size_;
    }

    /**
     * 
     * @param value
     */
    public void append(T value)
    {
        Node<T> node = new Node<T>(value);

        if (begin_node_ == null && last_node_ == null) {
            begin_node_ = node;
            last_node_ = node;
        }

        last_node_.setNext(node);
        last_node_ = node;
        ++size_;
    }


    public void dumbAppend(T value)
    {
        Node<T> node = new Node<T>(value);
        Node<T> begin = begin_node_;

        if (begin_node_ == null) {
            begin_node_ = node;
            return;
        }

        for (;;) {
            if (begin.next() == null) {
                begin.setNext(node);
                return;
            }
            begin = begin.next();
        }
    }


    /**
     * 
     * @param pos
     * @param value
     */
    public void insert(int pos, T value)
    {

    }


    public String toString()
    {
        String s = "";
        Node<T> begin = begin_node_;
        while (begin != null) {
            s += begin.data() + ", ";
            begin = begin.next();
        }

        // return s;
        return s.substring(0, s.lastIndexOf(','));
    }
}