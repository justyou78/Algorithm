package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		
		//ll을 iterator에 결합!
		Iterator it = ll.iterator();

		
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
		System.out.println(ll.toString());

	}
}
