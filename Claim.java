import java.util.*;
import java.time.*;

public class Claim{
	private static int Idcounter=1;
	private int Id;
	private LocalDate Incurred;
	private double ClaimedAmount;
	private String PolicyNo;
	private Policy policy;
	

	Claim(Policy policy, LocalDate Incurred,String PolicyNo, double ClaimedAmount){
		this.Id++;
		this.policy=policy;
		this.Incurred=Incurred;
		this.ClaimedAmount=ClaimedAmount;
		this.PolicyNo=PolicyNo;
		this.CheckClaim();	
	}
	public Boolean CheckClaim(){
		Boolean check=true;		
		if(!PolicyNo.equals(policy.getPolicyNo())){
			check=false;
			System.out.println("Cannot Submit a claim for Policy# "+this.PolicyNo+" because it does not exist");
		}
		if(!(Incurred.isAfter(policy.Effective) && Incurred.isBefore(policy.Expiry) && policy.IsValid())){
			System.out.println("Claim is rejected because Policy# "+this.PolicyNo+" is inactive or expired");
			check=false;
		}
		return check;
	}

	public String getPolicyNo(){

		return this.PolicyNo;
	}
	public double getClaimedAmount(){
		return this.ClaimedAmount;
	}


}