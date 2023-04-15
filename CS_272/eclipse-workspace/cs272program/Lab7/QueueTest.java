package lab7;

public class QueueTest {

	public static void main(String[] args) {
		LinkedQueue<Integer> j = new LinkedQueue<Integer>();
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 4;
		Integer e = 5;
		j.enqueue(a);
		j.enqueue(b);
		j.dequeue();
		j.enqueue(c);
		j.dequeue();
		System.out.println(j.front());
		j.dequeue();
		//System.out.println(j.top());
		System.out.println(j.isEmpty());
		j.enqueue(d);
		j.enqueue(e);
		System.out.println(j.size() + "\n");
	}

}
