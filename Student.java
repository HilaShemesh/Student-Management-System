public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private LinkedList courseList;
	private LinkedList gradeList;
	private static final int CREDIT_S = 120;


	// constructor
	public Student(String firstName, String lastName, int id) {
		if(stringValidation(lastName) == false || stringValidation(firstName) == false || id < 1) //check student fields validations
			throw new IllegalArgumentException();

		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.courseList = new LinkedList();
		this.gradeList = new LinkedList();
	}
	// check string validation
	private boolean stringValidation(String s) {
		boolean ans = true;
		if(s == null)
			ans = false;
		if(s.equals(""))
			ans = false;
		for(int i = 0; i < s.length() & ans; i++) {
			char c = s.charAt(i);
			if(!((c == ' ') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) // check each char
				ans = false;
		}
		return ans;
	}

	// returns first name
	public String getFirstName() {
		return this.firstName;
	}

	// returns last name
	public String getLastName() {
		return this.lastName;
	}

	// returns id
	public int getId() {
		return this.id;
	}
	
	public LinkedList getgrade() {
		return gradeList;
	}

	// returns if this is registered to course
	public boolean isRegisteredTo(Course course) {
		if(courseList.contains(course))
			return true;
		return false;
	}

	// registers this to course
	public boolean registerTo(Course course) {
		if(isRegisteredTo(course) == true)
			return false;
		else {
			courseList.add(course);
			return true;
		}

	}

	// returns the average
	public double calculateAverage() {
		double creditSum = 0;
		double gradeSum = 0;
		LinkedListIterator it = (LinkedListIterator) gradeList.iterator(); // iterate over all of the student's grades
		while(it.hasNext()) {
			Grade g = (Grade) it.next();
			int grade = g.getGrade(); 
			double credit = g.getCourse().getCourseCredit(); // take course credit
			creditSum = creditSum + credit; // sum up all the credits that the student has in total
			gradeSum = gradeSum + (grade * credit); // calculation 
		}
		if(creditSum == 0)
			return 0;
		return gradeSum / creditSum;
	}

	// adds grade to student
	public boolean addGrade(Course course, int grade) {
		if(!isRegisteredTo(course))
			return false;
		for(Object i : this.gradeList) {
			Grade g = (Grade) i;
			if(g.getCourse().equals(course))
				return false;
		}
		Grade newG = new Grade(course, grade); // create the grade and adding it to the gradeList
		gradeList.add(newG);	
		return true;
	}

	// sets a grade
	public int setGrade(Course course, int grade) {
		int ans = 0;	
		for(Object i : this.gradeList) {
			Grade g = (Grade) i;
//			if(g == null)
//				throw new IllegalArgumentException();
			int oldGrade = g.getGrade(); //every grade in the list
			Course c = g.getCourse(); 
			if(course.equals(c)) { // if we found the course
				g.setGrade(grade);
				ans = oldGrade;
			}
		}
		return ans;
	}

	// returns a string representation
	public String toString() {
		return "First Name: " + this.firstName + ", Last Name: " + this.lastName + ", Id: "+ this.id + ". \nCourses List- " 
		+ this.courseList + "\nGrades List- " + this.gradeList + "\n";
				
	}

	// returns if other equals to this
	public boolean equals(Object other){
		if(other == null)
			throw new IllegalArgumentException();
		int myId = this.id;
		if(!(other instanceof Student))
			return false;
		Student newOther = (Student) other;
		if(newOther.id == myId)
			return true;
		return false;
	
	}

	// returns total credit required
	public int getTotalCreditRequired() {
		return CREDIT_S;
	}

	// returns final grade
	public double computeFinalGrade() {
		gradeList.sortBy(new FinalGradeComparator()); // sort the grades list from the highest final grade to the lowest
		LinkedListIterator it = (LinkedListIterator) gradeList.iterator();
		double totalCred = 0;
		double gradesum = 0;
		double tempCredit = 0;
		int studentTypeCreditLimit = this.getTotalCreditRequired();
		while(it.hasNext() && totalCred < studentTypeCreditLimit) {
			Grade g = (Grade) it.next();
			//if the student pass the course add it to the calculation 
			if(g.getGrade() >= 56) {
				tempCredit = g.getCourse().getCourseCredit();
				gradesum = gradesum + (tempCredit * g.computeFinalGrade());
				totalCred = totalCred + tempCredit;
			}
		}
		// if we did not reached the minimum credit for getting the degree
		if(totalCred < studentTypeCreditLimit)
			return -1;
		return gradesum / totalCred;
	}
}
