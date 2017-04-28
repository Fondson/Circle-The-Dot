//import java.util.EmptyQueueException;

public class LinkedQueue<E> implements Queue<E> {
  
  private static class Elem<T> {
    
    private T value;
    private Elem<T> next;
    
    private Elem( T value, Elem<T> next ) {
      this.value = value;
      this.next = next;
    }
  }
  
  private Elem<E> front;
  private Elem<E> rear;
  
  public E peek()throws EmptyQueueException{
    if (isEmpty()){
      throw new EmptyQueueException("Cannot peek an element from an empty stack");
    }
    else{
    return front.value;
    }
  }
  
  public void enqueue( E o )throws NullPointerException{
   if (o==null){
      throw new NullPointerException ("Cannot add a null element to the queue"); 
    }
    else{
      Elem<E> newElem;
      newElem = new Elem<E>( o, null );
      
      if ( rear == null ) {
        front = rear = newElem;
      } else {
        rear.next = newElem;
        rear = newElem;
      }
    }
  }
  public E dequeue() throws EmptyQueueException {
    if (rear == null){
      throw new EmptyQueueException ("Cannot remove element from empty queue.");
    }
    else{
      
      E result = front.value;
      if ( front != null & front.next == null ) {
        front = rear = null;
      } else {
        front = front.next;
      }
      return result;
    //}
  }
  }
  
  
  public boolean isEmpty() {
    return front == null;
  }
  
}
