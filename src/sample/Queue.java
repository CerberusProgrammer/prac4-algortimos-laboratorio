package sample;

public class Queue<T> {

    private Node<T> start = null;
    private Node<T> end = null;
    private int size = 0;

    public boolean isEmpty() {
        return start == null;
    }

    public void insert(T data) {
        Node<T> node = new Node<T>();
        node.setInfo(data);
        node.setRef(null);

        if (start == null)
            start = node;
        else
            end.setRef(node);
        size++;
        end = node;
    }

    public Node<T> remove() {
        Node<T> node = start;

        if (start != end) {
            start = start.getRef();
        } else {
            start = null;
            end = null;
        }
        size--;
        return node;
    }

    public Node<T> front() {
        Node<T> datoAuxiliar = null;
        if (start != null) {
            datoAuxiliar = start;
        }
        return datoAuxiliar;
    }

    public int size() {
        return size;
    }
}