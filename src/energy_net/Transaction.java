package energy_net;

import java.util.Objects;

public class Transaction {

	private String conc_Id;
	private EnergyRequest eR;
	private EnergyOffer eO;
	private double energy;
	private double price;
	
	public Transaction (EnergyRequest eR, EnergyOffer eO, double energy, double price) {
		this.eR = eR;
		this.eO = eO;
		this.energy = energy;
		this.price = price;
		this.conc_Id = eR.getId() + "_" + eO.getId();
	}


	@Override
	public boolean equals(Object obj) {
		return conc_Id.equals(obj);
	}


	public String getConc_Id() {
		return conc_Id;
	}


	public EnergyRequest geteR() {
		return eR;
	}


	public EnergyOffer geteO() {
		return eO;
	}


	public double getEnergy() {
		return energy;
	}


	@Override
	public String toString() {
		return "ID: " + conc_Id + "\n" + "Buyer IP Adress: " + eR.getOwner().getIp() + 
				"\n" + "Seller IP Adress: " + eO.getOwner().getIp() + "\n" + "Energy Amount: " + energy + "\n" + "Price: " 
				+ price + "\n" + "\n";
	}
	
	
	
}
