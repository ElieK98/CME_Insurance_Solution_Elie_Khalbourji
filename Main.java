import java.util.*;
import java.time.*;

public class Main{
	
	public static void DisplayAllPolicies(ArrayList<Policy> policies){
		System.out.println("All available policies: \n");
		for(int i=0;i<policies.size();i++){
			if(policies.get(i).IsValid()){
			
				System.out.println(policies.get(i));
			}
			System.out.println("\n");
		}

	}
	public static void PoliciesWithPremiumConstraint(ArrayList<Policy> policies){
		System.out.println("Policies whose premium is between 500 USD and 2000 USD: \n");
		for(int i=0;i<policies.size();i++){
			if(policies.get(i).getPremium()>=500 && policies.get(i).getPremium()<=2000 && policies.get(i).IsValid()){
				System.out.println(policies.get(i));
			}
			System.out.println("\n");
		}
	
	}
	public static void DisplayClaimsForPolicyNo(ArrayList<Claim> c,String givenPolicy){
		
		int claimCount=0;
		double claimSum=0;
		double min=0;
		double max=0;
		ArrayList<Double> claimedAmounts=new ArrayList<Double>();
		
		
		for(int i=0;i<c.size();i++){
			if(c.get(i).getPolicyNo().equals(givenPolicy) && c.get(i).CheckClaim()){
				claimedAmounts.add(c.get(i).getClaimedAmount());
				claimCount++;
				claimSum+=c.get(i).getClaimedAmount();
			}
		}
		Collections.sort(claimedAmounts);
		System.out.println();
		System.out.println("Showing only valid claims for Policy# "+givenPolicy);
		System.out.println("Number of claims: "+claimCount);
		System.out.println("Sum of all claims: "+claimSum);
		System.out.println("Minimum claimed Amount: "+ claimedAmounts.get(0));
		System.out.println("Maximum claimed Amount: "+ claimedAmounts.get(claimedAmounts.size()-1));
		System.out.println();

	}

	public static void main(String[] args){
		
		ArrayList<Policy> policies=new ArrayList<Policy>();
		Beneficiary s=new Beneficiary("Spouse",Relationship.Spouse,Gender.Female,LocalDate.of(1995,10,4));
		Beneficiary m=new Beneficiary("Self",Relationship.Self,Gender.Male,LocalDate.of(1998,10,25));
		Beneficiary j=new Beneficiary("Joseph",Relationship.Son,Gender.Male,LocalDate.of(2025,6,15));
		
		ArrayList<Beneficiary> b=new ArrayList<Beneficiary>();
		b.add(s);
		b.add(m);
		b.add(j);

		
		Policy M1=new MedicalPolicy(LocalDate.of(2020,10,11),LocalDate.of(2021,10,11),b);
		
		policies.add(M1);
		
		
		Policy T1=new TravelPolicy(LocalDate.of(2019,10,9),LocalDate.of(2020,11,9),"Lebanon","Dubai",15,true);
		
		policies.add(T1);

		
		Policy m1=new MotorPolicy(LocalDate.of(2018,5,6),LocalDate.of(2020,7,8),"BMW",10000);
		
		policies.add(m1);

		
		ArrayList<Beneficiary> b1=new ArrayList<Beneficiary>();
		Beneficiary l=new Beneficiary("Self",Relationship.Self,Gender.Male,LocalDate.of(1998,10,25));
		Beneficiary d=new Beneficiary("Rita",Relationship.Daughter,Gender.Female,LocalDate.of(2024,10,11));
		b1.add(l);
		b1.add(d);
		b1.add(m);
		
		
		Policy M2=new MedicalPolicy(LocalDate.of(2018,10,11),LocalDate.of(2022,10,11),b1);
		
		policies.add(M2);
		
		
		Policy T2=new TravelPolicy(LocalDate.of(2019,10,9),LocalDate.of(2022,10,9),"Lebanon","Abu Dabi",31,true);
		
		policies.add(T2);

		
		Policy m2=new MotorPolicy(LocalDate.of(2018,5,6),LocalDate.of(2020,5,6),"Mercedes",18000);
		
		policies.add(m2);
		
		
		ArrayList<Beneficiary> b2=new ArrayList<Beneficiary>();
		Beneficiary l1=new Beneficiary("John",Relationship.Son,Gender.Male,LocalDate.of(2023,10,10));
		Beneficiary d1=new Beneficiary("Lea",Relationship.Daughter,Gender.Female,LocalDate.of(2024,10,11));	
		b2.add(l1);
		b2.add(d1);
		
		
		Policy M3=new MedicalPolicy(LocalDate.of(2018,10,11),LocalDate.of(2022,10,12),b2);
		
		policies.add(M3);

		
		Policy m3=new MotorPolicy(LocalDate.of(2017,6,7),LocalDate.of(2021,7,8),"Volkswagen",9000);
		
		policies.add(m3);
		
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		DisplayAllPolicies(policies);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		PoliciesWithPremiumConstraint(policies);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		Claim c1=new Claim(M1,LocalDate.of(2021,6,6),"{2020}-{MedicalPolicy}-{1}",100);
		Claim c2=new Claim(M1,LocalDate.of(2021,7,6),"{2020}-{MedicalPolicy}-{1}",50);
		Claim c3=new Claim(M1,LocalDate.of(2021,8,6),"{2020}-{MedicalPolicy}-{2}",200);
		Claim c4=new Claim(M1,LocalDate.of(2021,9,6),"{2020}-{MedicalPolicy}-{1}",150);
		Claim c5=new Claim(M1,LocalDate.of(2021,11,12),"{2020}-{MedicalPolicy}-{1}",100);

		Claim c6=new Claim(T1,LocalDate.of(2019,12,6),"{2020}-{TravelPolicy}-{2}",200);
		Claim c7=new Claim(T1,LocalDate.of(2020,1,2),"{2020}-{TravelPolicy}-{2}",100);
		Claim c8=new Claim(T1,LocalDate.of(2020,1,3),"{2020}-{TravelPolicy}-{10}",150);
		Claim c9=new Claim(T1,LocalDate.of(2019,12,6),"{2020}-{TravelPolicy}-{2}",200);
		Claim c10=new Claim(T1,LocalDate.of(2019,6,6),"{2020}-{TravelPolicy}-{2}",300);
		
		Claim c11=new Claim(m2,LocalDate.of(2018,6,7),"{2020}-{MotorPolicy}-{6}",500);
		Claim c12=new Claim(m2,LocalDate.of(2019,1,5),"{2020}-{MotorPolicy}-{6}",800);
		Claim c13=new Claim(m2,LocalDate.of(2020,8,9),"{2020}-{MotorPolicy}-{6}",1000);
		Claim c14=new Claim(m2,LocalDate.of(2019,3,4),"{2021}-{MotorPolicy}-{6}",200);
		Claim c15=new Claim(m2,LocalDate.of(2018,4,5),"{2020}-{MotorPolicy}-{6}",500);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		ArrayList<Claim> c=new ArrayList<Claim>();
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.add(c7);
		c.add(c8);
		c.add(c9);
		c.add(c10);
		c.add(c11);
		c.add(c12);
		c.add(c13);
		c.add(c14);
		c.add(c15);			
		
		DisplayClaimsForPolicyNo(c,"{2020}-{TravelPolicy}-{2}");
		System.out.println("*************************************");
		DisplayClaimsForPolicyNo(c,"{2020}-{MotorPolicy}-{6}");
		System.out.println("*************************************");
		DisplayClaimsForPolicyNo(c,"{2020}-{MedicalPolicy}-{1}");
		
		
		
		
	}

}