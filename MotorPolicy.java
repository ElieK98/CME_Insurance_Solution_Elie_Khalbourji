import java.util.*;
import java.time.*;
import java.lang.Exception;

class MotorPolicy extends Policy{
	private double VehiclePrice;
	private String VehicleName;
	private String PolicyName="MotorPolicy";
	
	MotorPolicy(LocalDate Effective,LocalDate Expiry,String VehicleName,double VehiclePrice){
		
		super(Effective,Expiry);
		this.VehicleName=VehicleName;
		this.VehiclePrice=VehiclePrice;
		if(!this.IsValid()){
		System.out.println("Cannot add policy because it is invalid.");
		
		}else{
			System.out.println("Policy "+ this.getPolicyNo() +" was added successfully!");
		}
		
	
	}
	public String getPolicyName(){
		return this.PolicyName;
	}

	public double getPremium(){
		return VehiclePrice*0.2;
		
	}

	public Boolean IsValid(){
		if(Effective.isBefore(Expiry)){
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
		result.append("Vehicle Name: "+VehicleName+NL);
		result.append("-----------"+NL);
		result.append("Vehicle Price: "+VehiclePrice+ " USD"+NL);
		result.append("-----------"+NL);
		result.append("Premium: "+getPremium()+" USD");
		return result.toString();
		
		
		
		
	}


}