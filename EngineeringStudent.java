
public class EngineeringStudent extends Student{ // you need to add inheritance
	private static final int CREDIT_ES = 160;
	// constructor
	public EngineeringStudent(String firstName, String lastName, int id) {
		super(firstName, lastName, id);
	}
	
	// returns total credit required
	public int getTotalCreditRequired(){
		return CREDIT_ES;
	}

}
