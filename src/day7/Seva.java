package day7;

public class Seva {
	public static void main(String[] args) {
		Corporation corporation = new Corporation();
		Municipality municiplaity = new Municipality();
		TalukOffice taluk = new TalukOffice();
		RTO rto = new RTO();
		
		DeathCertificateService dc = new DeathCertificateService(corporation, municiplaity, taluk, rto);
		BirthCertificateService bc = new BirthCertificateService(corporation, municiplaity, taluk, rto);
		CommunityCertificate cc = new CommunityCertificate(corporation, municiplaity, taluk, rto);
		
		CommonServiceCenter sc = new CommonServiceCenter();
		
		sc.setCommand(1, dc);
		sc.setCommand(2, bc);
		sc.setCommand(3, cc);
		
		sc.executeCommand(3);//this is what my parents will do....
		
	}
}

class CommonServiceCenter{
	Service c[] = new Service[5];
	
	public CommonServiceCenter() {
		for(int i=0;i<5;i++) {
			c[i] = new DummyService();
		}
	}
	
	public void setCommand(int slot,Service service) {
		this.c[slot]=service;
	}
	public void executeCommand(int slot) {
		this.c[slot].execute();
	}
}
class DummyService extends Service{
	@Override
	public void execute() {
		System.out.println("I am dummy yet to be operational...");
	}
}

abstract class Service{
	public Service() {
		// TODO Auto-generated constructor stub
	}
	private Corporation corporation; private Municipality municiplaity; private TalukOffice taluk; private RTO rto;
	
	public Service(Corporation corporation, Municipality municiplaity, TalukOffice taluk, RTO rto) {
		this.corporation = corporation;
		this.municiplaity = municiplaity;
		this.taluk = taluk;
		this.rto = rto;
	}
	
	 public Corporation getCorporation() {
			return corporation;
	}

	public Municipality getMuniciplaity() {
		return municiplaity;
	}

	public TalukOffice getTaluk() {
		return taluk;
	}

	public RTO getRto() {
		return rto;
	}

	public abstract void execute();
}

class DeathCertificateService extends Service{
	public DeathCertificateService(Corporation corporation, Municipality municiplaity, TalukOffice taluk, RTO rto) {
		super(corporation, municiplaity, taluk, rto);
	}
	@Override
	public void execute() {
		System.out.println("logic of get death certificate............");
		//business logic
		getCorporation().apply();getCorporation().validateDeath();getCorporation().issueCertificate();
	}
}
class BirthCertificateService extends Service{
	public BirthCertificateService(Corporation corporation, Municipality municiplaity, TalukOffice taluk, RTO rto) {
		super(corporation, municiplaity, taluk, rto);
	}
	
	public void execute() {
		System.out.println("logic of get birth certificate.............");
		getMuniciplaity().giveProof();getMuniciplaity().getCertificate();
	}
}

class CommunityCertificate extends Service{
	public CommunityCertificate(Corporation corporation, Municipality municiplaity, TalukOffice taluk, RTO rto) {
		super(corporation, municiplaity, taluk, rto);
	}
	
	public void execute() {
		System.out.println("logic of getting community certificate.............");
		getTaluk().apply();getTaluk().getCertificate();
	}
}

class Corporation{
	
	public void apply() {
		System.out.println("Applying for death certificate....");
	}
	
	public void validateDeath() {
		System.out.println("Officer validating Death.............");
	}
	
	public void issueCertificate() {
		System.out.println("Death Certificate issued.........");
	}
}

class Municipality{
	
	public void giveProof() {
		System.out.println("Giving Proof....");
	}
	
	public void getCertificate() {
		System.out.println("Birth Certificate issued........");
	}
}

class TalukOffice{
	public void apply() {
		System.out.println("apply for community certificate....");
	}
	public void getCertificate() {
		System.out.println("Obtain Community Certificate.....");
	}
}

class RTO{
	public void applyLicense() {
		System.out.println("Apply for driving license...");
	}
	
	public void driveTest() {
		System.out.println("Driving test...");
	}
	
	public void getLicense() {
		System.out.println("License issued...");
	}
}
