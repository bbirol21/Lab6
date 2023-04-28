package energy_net;

import java.util.Objects;

public class Consumer {

	protected String ip;
	protected String name;
	protected double balance;
	
	public Consumer(String ip, String name, double balance) {
		this.ip = ip;
		this.name = name;
		this.balance = balance;
	}
	
	public boolean addAmount (double amount) {
		balance += amount;
		return true;
	}
	
	public String getIp() {
		return ip;
	}

	public boolean deductAmount (double amount) {
		if(balance - amount < 0) {
			return false;
		}
		balance -= amount;
		return true;
	}

	public boolean equals(Consumer obj) {
		if (this.getIp() == obj.getIp()) {
			return true;
		}	
		return false;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Consumer name: " + name + "\n" +  "IP Adress: " + ip + "\n" + "Balance: " + balance + "\n" + "\n";
	}
	
	
	
}
