package energy_net;

public class Prosumer extends Consumer{
	
	private int distance = 10;
	
	public Prosumer(String ip, String name, double balance) {
		super(ip, name, balance);
		// TODO Auto-generated constructor stub
	}
	
	public Prosumer(String ip, String name, double balance, int distance) {
		super(ip, name, balance);
		this.distance = distance;
		// TODO Auto-generated constructor stub
	}
	
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public String toString() {
		return "Prosumer name: " + name + "\n" +  "IP Adress: " + ip + "\n" + "Balance: " + balance + "\n" + "Distance: " + distance + "\n" + "\n";
	}
	
	

}
