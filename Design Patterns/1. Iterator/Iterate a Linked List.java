import java.util.Iterator;

//Iterable interface Java source code

// public interface Iterable<T> {
//     Iterator<T> iterator();
// }

//Iterator interface Java source code

// public interface Iterator<E> {
//     boolean hasNext();
//     E next();
// }

public class Main {
    public static void main(String[] args)
    {
        MyLinkedList list = new MyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        //Our ask is to be able to iterate the LinkedList using this for loop
        for(int val : list)
        {
            System.out.print(val+"->");
        }
        System.out.println(".");

        //The above for loop is a syntactical sugar
        //The following code is executed internally

        // Iterator<Integer> itr = list.iterator();
        // while(itr.hasNext()==true)
        // {
        //     int val = itr.next();
        // }
    }
    static class MyLinkedList implements Iterable<Integer>
    {
        //To iterate the LinkedList using for loop, we need to implemet
        // iterable in our designed class
        //Here <Integer> because our LinkedList has integer values

        static class Node
        {
            int data;
            Node next;
        }
        Node head;
        Node tail;
        int size;

        void addLast(int data)
        {
            Node temp = new Node();
            temp.data = data;
            temp.next = null;
            if(size==0)
            {
                head = tail = temp;
            }
            else
            {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        //This linkedlist which implements iterable interface should mandatorily have iterator() defined

        public Iterator<Integer> iterator()
        {
            //the return type of this function is Iterator, so we need to include a new class which implements
            // iterator interface as well
            return new LinkedListIterator(head);
            //the head we are passing goes to LinkedListIterator's constructor
        }
    }

    static class LinkedListIterator implements Iterator<Integer>
    {
        //this class should define hasnext and next function as it implements Iterator

        //constructor
        Node temp;
        LinkedListIterator(Node temp)
        {
            this.temp = temp;
        }
        public boolean hasNext()
        {
            if(temp == null)
                return false;
            else
                return true;
        }

        public Integer next()
        {
            int rv= temp.data;
            //move temp forward
            temp = temp.next;
            return rv;
        }
    }
}
