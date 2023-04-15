package lab7;

public interface StackInterface<T> {
	public T pop();
	public void push(T t);
	public T top();
	public int size();
	public boolean isEmpty();
}
