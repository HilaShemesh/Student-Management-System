
public class CsElectiveCourse extends Course{ // you need to add inheritance

	// constructor
	public CsElectiveCourse(String name, int number, int credit) {
		super(name, number, credit);
	}
	
	// returns final grade
	public int computeFinalGrade(int grade){
		if(grade<0 || grade>100)
			throw new IllegalArgumentException();
		if(grade < 56) // failed at the course- will not get bonus
			return grade;
		//add the bonus
		double gradeBonus = grade * 0.1;
		double finalG = grade + gradeBonus;
		int value = (int)finalG;
		value = value + 5;
		if(value > 100)
			return 100; // after bonus we can't return a grade that is bigger than 100
		return value;
	}

}
