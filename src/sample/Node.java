package sample;

public class Node<T> {

    private T info;
    private Node<T> ref;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getRef() {
        return ref;
    }

    public void setRef(Node<T> ref) {
        this.ref = ref;
    }
}