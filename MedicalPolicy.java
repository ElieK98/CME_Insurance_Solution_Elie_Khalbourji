import java.util.*;
import java.time.*;
import java.lang.Exception;



public class MedicalPolicy extends Policy{
	private String PolicyName="MedicalPolicy";
	ArrayList<Beneficiary> beneficiaries;
	

	MedicalPolicy(LocalDate Effective,LocalDate Expiry,ArrayList<Beneficiary> beneficiaries){
		
		super(Effective,Expiry);
		this.beneficiaries=beneficiaries;
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
		double Premium=0;
		for(int i=0;i<beneficiaries.size();i++){
			if(beneficiaries.get(i).age()<10 && beneficiaries.get(i).age()>0){
				Premium+=15.0;
			}
			if(beneficiaries.get(i).age()>=11 || beneficiaries.get(i).age()<=45){
				Premium+=30.0;
			}
			if(beneficiaries.get(i).age()>45){
				Premium+=63.0;
			}
		}
		return Premium;
	}

	public Boolean IsValid(){
		int s=0;
		for(int i=0;i<beneficiaries.size();i++){
			if(beneficiaries.get(i).getRelationship()==Relationship.Self){
				++s;
			}
		}
		if(Effective.isBefore(Expiry) && s==1 && !beneficiaries.isEmpty()){
			
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
		result.append("Beneficiaries"+NL);
		for(int i=0;i<beneficiaries.size();i++){
			
			result.append(beneficiaries.get(i)+NL);
			result.append("##############"+NL);
		}
		return result.toString();
		
		
	}


}