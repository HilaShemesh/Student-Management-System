
public class Link {

	// fields
	private Object data;
	private Link next;

	// constructor
	public Link(Object data) {
		this.data = data;
		this.next = null;
	}

	// constructor
	public Link(Object data, Link next) {
		this.data = data;
		this.next = next;
	}

	// returns data
	public Object getData() {
		return this.data;
	}

	// returns next link 
	public Link getNext() {
		return this.next;
	}

	// sets next link
	public void setNext(Link next) {
		this.next = next;
	}

	// sets link's data
	public Object setData(Object data) {
		Object temp = this.data;
		this.data = data;
		return temp;
	}

	// returns a representation
	public String toString() {
		return "Data: " + this.data.toString();
	}

	// returns if other equals to this
	public boolean equals(Object other) {
		if(other == null)
			throw new IllegalArgumentException();
		if(!(other instanceof Link))
			return false;
		Link otherLink = (Link)other;
		if(!(otherLink.getData().equals(this.getData()))) 
			return false;
		return true;
	}


}
