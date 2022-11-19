
public class StudentNameComparator implements Comparator {

	// compares between obj1 and obj2 in terms of name
	public int compare(Object obj1, Object obj2) {
		if(!(obj1 instanceof Student && obj2 instanceof Student))
			
			throw new IllegalArgumentException();
		Student s1 = (Student) obj1; Student s2 = (Student) obj2;
		//for last names
		String last1 = s1.getLastName(); 
		String last2 = s2.getLastName();
		int lastRes = compareHelper(last1, last2);
		if(lastRes != 0) // if last names are not equal
			return lastRes;
		//for first names
		String first1 = s1.getFirstName();
		String first2 = s2.getFirstName();
		return compareHelper(first1, first2);
	}
	
	private int compareHelper(String s1, String s2) {
		for(int i = 0; i < s1.length() && i < s2.length(); i++){
			if(s1.charAt(i) > s2.charAt(i))
				return 1;
			if(s1.charAt(i) < s2.charAt(i))
				return -1;
		}
		if(s1.length() > s2.length())
			return 1;
		if(s1.length() < s2.length())
			return -1;
		return 0;
	}
	

}
