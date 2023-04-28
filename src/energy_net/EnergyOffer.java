package energy_net;

public class EnergyOffer extends EnergyOperation{
	
	private double pricePerKW; 

	public EnergyOffer(Consumer owner, int energy, double price) {
		super(owner, energy);
		// TODO Auto-generated constructor stub
		this.pricePerKW = price;
	}

	public double getPricePerKW() {
		return pricePerKW;
	}
	
	public String toString() {
		return "Owner IP Adress: " + super.getOwner().getIp() + "\n" + "Energy Amount: " + super.getRequestedOrOfferedEnergy() + 
				"\n" + "Price " + (pricePerKW*super.getRequestedOrOfferedEnergy()) + "\n" + "\n";
	}
	
	
	
}
