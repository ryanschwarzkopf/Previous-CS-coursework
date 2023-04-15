package Lab4;
/*********************************************************************
 * IntNodeTest tests all of the methods in IntNode.java
 * 
 * @author rschw
 *
 * @ version Sep 22, 2022
 * 
 ********************************************************************/
public class IntNodeTest {
	public static void main(String[] args) {
		IntNode a = new IntNode();
		a.addNodeAfterThis(5);
		a.addNodeAfterThis(8);
		a.addNodeAfterThis(3);
		a.addNodeAfterThis(10);
		a.addNodeAfterThis(3144);
		System.out.println(a.toString()); //Expected: 0->3144->10->3->8->5
		System.out.println(IntNode.listLength(a));
		System.out.println("a sorted: " + IntNode.listSort(a).toString()); // Expected: 0->3->5->8->10->3144
		
		IntNode b = new IntNode(15, a);
		b.removeNodeAfterThis(); // removes 0
		b.removeNodeAfterThis(); // removes 3
		System.out.println("\nb: " + b.toString()); //Expected: 15->5->8->10->3144
		System.out.println(IntNode.search(b, 15)); // True
		System.out.println(IntNode.search(b, 3)); // False
		System.out.println(IntNode.search(b, 3144)); // True
		System.out.println(IntNode.search(b, 7)); // False
		IntNode.listSort(b); // note that sorting b also changes the order of a because IntNode a is in b's list
		System.out.println("b sorted: " + b.toString());
		System.out.println("a sorted: " + a.toString());
		System.out.println("a+b: " + IntNode.merge(a, b).toString());
	}
}
