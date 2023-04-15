package lab7;

public interface QueueInterface<T> {
	public void enqueue(T t);
	public T dequeue();
	public T front();
	public int size();
	public boolean isEmpty();
}