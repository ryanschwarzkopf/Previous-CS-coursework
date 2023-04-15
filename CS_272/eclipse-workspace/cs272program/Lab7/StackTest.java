package lab7;

public class StackTest {

	public static void main(String[] args) {
		LinkStack<Integer> j = new LinkStack<Integer>();
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 4;
		Integer e = 5;
		j.push(a);
		j.push(b);
		j.pop();
		j.push(c);
		j.pop();
		System.out.println(j.top());
		j.pop();
		//System.out.println(j.top());
		System.out.println(j.isEmpty());
		j.push(d);
		j.push(e);
		System.out.println(j.size() + "\n");
		
		ArrayListStack<Integer> k = new ArrayListStack<Integer>();
		k.push(a);
		k.push(b);
		k.pop();
		k.push(c);
		k.pop();
		System.out.println(k.top());
		k.pop();
		//System.out.println(k.top());
		System.out.println(k.isEmpty());
		k.push(d);
		k.push(e);
		System.out.println(k.size());
	}
	
}
