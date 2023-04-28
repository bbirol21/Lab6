package energy_net;

public class EnergyOffer extends EnergyOperation implements Comparable {
	
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
				"\n" + "Price " + (pricePerKW*super.getRequestedOrOfferedEnergy()) + "\n" +  "\n";
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
//	public int compareTo(EnergyRequest o) {
//		// TODO Auto-generated method stub
//		if (this.getPreference().equals(LOW.PRICE) && o.getPreference().equals(HIGH.PRICE)) {
//			return -1;
//		}
//		
//		if (this.getPreference().equals(o.getPreference)) {
//			if (this.getOwner().getDistance() < o.getOwner().getDistance()) {
//				return -1;
//			}
//			else {
//				return 1;
//			}
//		}
//		return 1;
//	}
// program gives error thats why commented out
	
	
	
	
	
}
