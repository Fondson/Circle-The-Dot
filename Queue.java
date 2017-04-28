public interface Queue<E> {
    public boolean isEmpty();
    public void enqueue( E o ) throws NullPointerException;
    public E dequeue() throws EmptyQueueException;
}
