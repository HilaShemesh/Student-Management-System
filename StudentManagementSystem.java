public class StudentManagementSystem {
	private LinkedList courseSystemList;
	private LinkedList studentList;
	private int studentsNum;
	private int coursesNum;

	public StudentManagementSystem() {
		this.courseSystemList = new LinkedList();
		this.studentList = new LinkedList();
		this.studentsNum = 0;
		this.coursesNum = 0;

	}

	public boolean addStudent(Student student){
		LinkedListIterator it = (LinkedListIterator) studentList.iterator();
		while(it.hasNext()) {
			Student s = (Student) it.next();
			if(s.equals(student)) 
				return false; // if student already exist
		}
		studentList.add(student);
		studentsNum++;
		return true;	
	}

	public boolean addCourse(Course course){
		LinkedListIterator it = (LinkedListIterator) courseSystemList.iterator();
		while(it.hasNext()) {
			Course s = (Course) it.next();
			if(s.equals(course))
				return false; // if course already exist
		}
		courseSystemList.add(course);
		coursesNum++;
		return true;	
	}
		

	public boolean register(Student student, Course course){
		if(!(courseSystemList.contains(course) && studentList.contains(student)))
			return false;
		if(student.isRegisteredTo(course))
			return false;
		else
			student.registerTo(course);
		return true;
	}

	public boolean addGradeToStudent(Student student, Course course, int grade){
		return (studentList.contains(student) && courseSystemList.contains(course)) && student.addGrade(course, grade);
	}

	public LinkedList getFirstKStudents(Comparator comp, int k){
		if(studentList.size() < k || k < 0)
			throw new IllegalArgumentException();
		if(comp == null)
			throw new IllegalArgumentException();
		
		studentList.sortBy(comp); // sort the list
		LinkedListIterator it = (LinkedListIterator) studentList.iterator();
		LinkedList sorted = new LinkedList();
		while(it.hasNext() && k > 0) {
			Student s =  (Student) it.next();
			sorted.add(s); //insert k times to the new list
			k--; 
		}
		return sorted;
	}

	public double computeFinalGrade(Student student){
		if(studentList.contains(student))
			return student.computeFinalGrade();
		
		return -1;
	}

	public int getNumberOfStudents() {
		return studentsNum;
	}

	public int getNumberOfCourses() {
		return coursesNum;
	}
}
