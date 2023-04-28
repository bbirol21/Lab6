package energy_net;

public class EnergyOperation {
	
	private static int idCounter = 0;
	private int id = 0;
	private int requestedOrOfferedEnergy;
	private Consumer owner;

	public EnergyOperation(Consumer owner, int energy) {
		this.id = ++idCounter;
		this.owner = owner;
		this.requestedOrOfferedEnergy = energy;
	}
	
	public void decreaseEnergy(double amount) {
		requestedOrOfferedEnergy -= amount;
	}

	public int getId() {
		return id;
	}

	public int getRequestedOrOfferedEnergy() {
		return requestedOrOfferedEnergy;
	}

	public void setRequestedOrOfferedEnergy(int requestedOrOfferedEnergy) {
		this.requestedOrOfferedEnergy = requestedOrOfferedEnergy;
	}

	public Consumer getOwner() {
		return owner;
	}
	
}
