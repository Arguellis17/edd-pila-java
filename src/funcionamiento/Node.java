
package funcionamiento;


public class Node <E>{
    
     private E data;
    private Node<E> next;

    public Node(E ele) {
        data = ele;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
