
public class Grade {

	private Course course;
	private int grade;
	// constructor
	public Grade(Course course, int grade){
		if(course == null || grade < 0 || grade > 100)
			throw new IllegalArgumentException();
		this.course = course;
		this.grade = grade;
	}

	// returns the course
	public Course getCourse() {
		return this.course;
	}

	// returns course's grade
	public int getGrade() {
		return this.grade;
	}

	// sets course's grade
	public int setGrade(int grade) {
		if(grade < 0 || grade > 100)
			throw new IllegalArgumentException();
		int temp = this.grade; // keep the old grade
		this.grade = grade; //change value
		return temp; 
	}

	// returns a string representation
	public String toString(){
		return course.toString() + "grade: " + this.grade + ". ";
	}

	// returns if other equals to this
	public boolean equals(Object other){
		if(other == null)
			throw new IllegalArgumentException();
		boolean ans = true;
		if(!(other instanceof Grade)) 
			ans = false;
		Grade otherGrade = (Grade)other;
		if(!(this.getCourse().equals(otherGrade.getCourse()))) // if the courses are not equal
			ans = false;
		if(otherGrade.getGrade() != this.getGrade()) // if the grades are not equal
			ans = false;

		return ans;

	}
	// returns final grade
	public int computeFinalGrade(){
		Course c = this.course;
		return c.computeFinalGrade(grade);
	}


}
