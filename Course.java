
public class Course {
	private String name;
	private int number;
	private int credit;
	// constructor
	public Course(String name, int number, int credit){
		if(!stringValidation(name) || number < 1 || credit <= 0) //check course fields validation
			throw new IllegalArgumentException();
		this.name = name;
		this.number = number;
		this.credit = credit;

	}
	//check string validation of the string
	private boolean stringValidation(String s) {
		boolean ans = true;
		if(s == null)
			ans = false;
		if(s.equals(""))
			ans = false;
		for(int i = 0; i < s.length() & ans; i++) {
			char c = s.charAt(i);
			if(!((c == ' ') || (c>='0' & c<='9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) // check each char
				ans = false;
		}
		return ans;
	}

	// returns course's name
	public String getCourseName(){
		return name;
	}

	// returns course's number
	public int getCourseNumber(){
		return number;
	}

	// returns course's credit
	public int getCourseCredit(){
		return credit;
	}

	// returns a string representation
	public String toString(){
		return "Course: " + this.name + " " + this.number + " " + this.credit + ". ";
	}

	// returns if other equals to this
	public boolean equals(Object other){
		return (other instanceof Course && ((Course) other).number == this.number);

	}
	// returns final grade
	public int computeFinalGrade(int grade){
		if(grade<0 || grade>100)
			throw new IllegalArgumentException();
		return grade;
	}

}
