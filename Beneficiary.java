import java.util.*;
import java.time.*;

enum Relationship{
	Self,
	Spouse,
	Son,
	Daughter,
}
enum Gender{
	Male,
	Female,
}

public class Beneficiary{
	private String name;
	private Relationship r;
	private Gender g;
	private LocalDate Birthdate;
	
	
	Beneficiary(String name,Relationship r,Gender g, LocalDate Birthdate){
		this.name=name;
		this.r=r;
		this.g=g;
		this.Birthdate=Birthdate;
	}
	public String getName(){
		return name;
	}
	public Relationship getRelationship(){
		return r;
	}
	
	public Gender getGender(){
		return g;
	}
	public int age(){
		
		return Period.between(Birthdate,LocalDate.now()).getYears();
	}
	public LocalDate getBirthdate(){
		return Birthdate;
	}
	@Override
	public String toString(){
		StringBuilder result=new StringBuilder();
		String NL=System.getProperty("line.separator");
		if(this.getRelationship()!=Relationship.Self){
			result.append("Name: "+name+NL);
			
			result.append("Relationship: "+r+NL);
		
			result.append("Gender: "+g+NL);
			
			result.append("Date of birth: "+Birthdate);
		}
		else{result.append(NL);}
		return result.toString();
	}
	

}