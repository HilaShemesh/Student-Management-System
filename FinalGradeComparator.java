
public class FinalGradeComparator implements Comparator {

	public int compare(Object obj1, Object obj2) {
		if(!(obj1 instanceof Grade) && !(obj2 instanceof Grade)) //validation check
			throw new IllegalArgumentException();
		Grade s1 = (Grade) obj1; Grade s2 = (Grade) obj2;
		//calculate final grades
		int final1 = s1.computeFinalGrade(); 
		int final2 = s2.computeFinalGrade();
		//result
		if(final1 > final2)
			return -1;
		if(final2 > final1)
			return 1;
		else
			return 0;
	
	}
}
