public class StudentGradeAverageComparator implements Comparator {
	// compares between obj1 and obj2
	public int compare(Object obj1, Object obj2) {
		if(!(obj1 instanceof Student & obj2 instanceof Student))
			throw new IllegalArgumentException();
		Student s1 = (Student) obj1; Student s2 = (Student) obj2;
		double s1A = s1.calculateAverage();
		double s2A = s2.calculateAverage();
		if(s1A > s2A)
			return -1;
		if(s1A < s2A)
			return 1;
		else
			return 0;

	}
}
