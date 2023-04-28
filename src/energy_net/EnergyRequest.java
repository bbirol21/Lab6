package energy_net;

public class EnergyRequest extends EnergyOperation {
	
	private String ipAdress;
	private EnergyPreference pref = EnergyPreference.LOW_PRICE;

	public EnergyRequest(Consumer owner, int energy) {
		super(owner, energy);
		// TODO Auto-generated constructor stub
	}
	
	public EnergyRequest(Consumer owner, int energy, String ip) {
		super(owner, energy);
		// TODO Auto-generated constructor stub
		this.ipAdress = ip;
	}
	
	public EnergyRequest(Consumer owner, int energy, EnergyPreference pref) {
		super(owner, energy);
		// TODO Auto-generated constructor stub
		this.pref = pref;
	}

	public String getIpAdress() {
		return ipAdress;
	}
	
	public String toString() {
		return "Owner IP Adress: " + super.getOwner().getIp() + "\n" + "Energy Amount: " + super.getRequestedOrOfferedEnergy() + 
				"\n" + "Preferred IP: " + ipAdress + "\n" + "IDSİ: " + super.getId() +"\n" + "Energy Preference: " + pref + "\n" + "\n";
	}

	public EnergyPreference getPref() {
		return pref;
	}
	
	
}
