
public class MathElectiveCourse extends Course{ // you need to add inheritance

	// constructor
	public MathElectiveCourse(String name, int number, int credit) {
		super(name, number, credit);
	}
	
	// returns final grade
	public int computeFinalGrade(int grade){
		if(grade<0 || grade>100)
			throw new IllegalArgumentException();
		if(grade < 56) //failed at the course- will not get bonus
			return grade;
		//add the bonus
		grade = grade + 5;
		if(grade > 100) 
			return 100; // after bonus we can't return a grade that is bigger than 100
		return grade;
	}

}
