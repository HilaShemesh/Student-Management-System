import java.util.Iterator;

public class LinkedList implements List {

	private Link first;
	private Link last;

	// constructor
	public LinkedList() {
		first = null;
		last = null;
	}

	// adds a given object to the list
	public void add(Object element) {
		nullCheck(element);
		if (isEmpty()) {
			first = new Link(element);
			last = first;
		} else {
			Link newLast = new Link(element);
			last.setNext(newLast);
			last = newLast;
		}
	}

	// adds a given object to a specific index
	public void add(int index, Object element) {
		rangeCheck(index);
		nullCheck(element);
		if (index == 0) {
			first = new Link(element, first);
			if (last == null)
				last = first;
		} else {
			Link prev = null;
			Link curr = first;
			for (int i = 0; i < index; i = i + 1) {
				prev = curr;
				curr = curr.getNext();
			}
			Link toAdd = new Link(element, curr);
			prev.setNext(toAdd);
			if (index == size())
				last = toAdd;
		}
	}

	// returns if the list is empty
	public boolean isEmpty() {
		return(first == null && last == null);	
	}

	// returns element's data in a specific index

	public Object get(int index) {
		rangeCheck(index);
		Link curr = first;
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		return curr.getData();
	}

	// returns the size of the list
	public int size() {
		int counter = 0;
		for(Link curr = first; curr != null; curr = curr.getNext())
			counter = counter + 1;
		return counter;
	}

	// returns if a specific element is contained in the list
	public boolean contains(Object element) {
		boolean ans = false;
		LinkedListIterator it = (LinkedListIterator) this.iterator();
		while(!ans && it.hasNext()) {
			Object temp = it.next();
			if(temp.equals(element))
				ans = true;
		}
		return ans;
	}

	// sets a given element in a specific index
	public Object set(int index, Object element) {
		rangeCheck(index);
		Link curr = first;
		while (index > 0) {
			index = index - 1;
			curr = curr.getNext();
		}
		Object temp = curr.getData();
		curr.setData(element);
		return temp;
	}

	// returns a string representation
	public String toString() {
		String result = "";
		Iterator it = this.iterator();
		while(it.hasNext()) {
			Object element = it.next();
			result = result + element;
		}
		result = result;
		return result;
	}

	// returns if other equals to this
	public boolean equals(Object other) {
		nullCheck(other);
		boolean isEqual = true;
		if(!(other instanceof LinkedList)) //check type of other
			return false;
		LinkedList otherLink = (LinkedList)other;
		if(otherLink.size() != this.size()) // compare sizes
			return false;
		//compare each link of the other list to this list
		LinkedListIterator it1 = (LinkedListIterator) this.iterator();
		LinkedListIterator it2 = (LinkedListIterator) otherLink.iterator();
		if(isEqual) {
			while(isEqual && it1.hasNext() && it2.hasNext()) {
				Object temp1 = it1.next();
				Object temp2 = it2.next();
				if(!temp1.equals(temp2))
					isEqual = false;
			}
		}
		return isEqual;
	}

	// find the minimum data in the list
	private Link findMin(Comparator comp, Link link) { 
		Link min = link;
		while(link != null) {
			if(comp.compare(link.getData(),min.getData()) < 0) // check which link has the bigger data
				min = link;
			link = link.getNext();
		}
		return min;
	}
	// swap links
	private static void swap(Link l1, Link l2) { 
		Object temp = l1.getData();
		l1.setData(l2.getData());
		l2.setData(temp);
	}

	// sorts the list by comp
	public void sortBy(Comparator comp) {
		nullCheck(comp);
		for(Link curr = first; curr != null; curr = curr.getNext()) {
			Link min = findMin(comp, curr); // find minimum link 
			if(min != curr)
				swap(min, curr); //swap between links
		}
	}

	// returns an iterator
	public Iterator iterator() {
		return new LinkedListIterator(first);
	}


	// throws an exception if the given index is not in range
	private void rangeCheck(int index) {
		if (index < 0 | index >= size())
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
	}


	// throws an exception if the given element is null
	private void nullCheck(Object element) {
		if (element == null)
			throw new NullPointerException();
	}	
}
