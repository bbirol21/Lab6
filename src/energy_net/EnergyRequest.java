package energy_net;

public class EnergyRequest extends EnergyOperation {
	
	private String ipAdress;

	public EnergyRequest(Consumer owner, int energy) {
		super(owner, energy);
		// TODO Auto-generated constructor stub
	}
	
	public EnergyRequest(Consumer owner, int energy, String ip) {
		super(owner, energy);
		// TODO Auto-generated constructor stub
		this.ipAdress = ip;
	}

	public String getIpAdress() {
		return ipAdress;
	}
	
	public String toString() {
		return "Owner IP Adress: " + super.getOwner().getIp() + "\n" + "Energy Amount: " + super.getRequestedOrOfferedEnergy() + 
				"\n" + "Preferred IP: " + ipAdress + "\n" + "IDSİ: " + super.getId() + "\n" + "\n";
	}
	
	
}
