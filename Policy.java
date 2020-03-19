
import java.util.*;
import java.time.*;
import java.lang.Exception;


public abstract class Policy implements PolicyContract
{	protected int Id;
	private static int Idcounter=1;
	protected LocalDate Effective;
	protected LocalDate Expiry;
	protected String PolicyNo;

	Policy(LocalDate Effective, LocalDate Expiry){
		
		this.Id=Idcounter++;
		this.Effective=Effective;
		this.Expiry=Expiry;
		this.PolicyNo=this.getPolicyNo();
		
	}
	public String getPolicyNo(){
		return "{"+Calendar.getInstance().get(Calendar.YEAR)+"}-{"+this.getPolicyName()+"}-{"+this.Id+"}";
	}
	public abstract String getPolicyName();	
	public abstract double getPremium();
	public abstract Boolean IsValid();
	
}