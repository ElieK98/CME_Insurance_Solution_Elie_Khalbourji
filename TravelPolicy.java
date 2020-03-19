import java.util.*;
import java.time.*;
import java.lang.Exception;


class TravelPolicy extends Policy{
	
	private String Departure;
	private String Destination;
	private Boolean Family; 
	private int nbr_of_days;
	private String PolicyName="TravelPolicy";
	
	TravelPolicy(LocalDate Effective,LocalDate Expiry,String Departure,String Destination,int nbr_of_days,Boolean Family){
		
		super(Effective,Expiry);
		
		this.Departure=Departure;
		this.Destination=Destination;
		this.nbr_of_days=nbr_of_days;
		this.Family=Family;
		if(!this.IsValid()){System.out.println("Cannot add policy because it is invalid.");}
		else{System.out.println("Policy "+ this.getPolicyNo() +" was added successfully!");}

	}
	public String getPolicyName(){
		return this.PolicyName;
	}

	public double getPremium(){
		if(Family){return nbr_of_days*10;}
		return nbr_of_days*5;
		
	}

	public Boolean IsValid(){
		if(nbr_of_days<30 && Effective.isBefore(Expiry)){
			
			return true;
		}
		

		return false;
				
	}
	
	@Override
	public String toString(){
		StringBuilder result=new StringBuilder();
		String NL=System.getProperty("line.separator");
		result.append("Id: "+ this.Id+NL);
		result.append("-----------"+NL);
		result.append("Effective: "+ Effective+NL);
		result.append("-----------"+NL);
		result.append("Expiry: "+Expiry+NL);
		result.append("-----------"+NL);
		result.append("Policy No: "+this.getPolicyNo()+NL);
		result.append("-----------"+NL);
		result.append("Premium: "+getPremium()+" USD"+NL);
		result.append("-----------"+NL);
		result.append("Family Coverage: "+Family+NL);
		result.append("-----------"+NL);
		result.append("Departure country: "+ Departure+NL);
		result.append("-----------"+NL);
		result.append("Destination country: "+Destination+NL);
		result.append("-----------"+NL);
		result.append("Number of days: "+ nbr_of_days);
		return result.toString();
		
		
	}


}