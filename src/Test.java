// add your pledge of honor statement here

public class Test {
	public static void main(String[] args) {
	    // Create an EnergyMarket object with 20 percent as profit percentage
	    EnergyMarket energyMarket = new EnergyMarket(0.2);

	    // Create some consumers and prosumers
	    Consumer consumer1 = new Consumer("192.168.0.1", "Abdul", 20);
	    Consumer consumer2 = new Consumer("192.168.0.2", "Berke", 13.4);
	    Consumer consumer3 = new Consumer("192.168.0.1", "Abdulrezzak", 40);

	    Prosumer prosumer1 = new Prosumer("192.168.1.1", "Can", 10.0);
	    Prosumer prosumer2 = new Prosumer("192.168.1.2", "Dogan", 8.0, 15);

	    // Add consumers and prosumers to the EnergyMarket
	    energyMarket.addConsumerOrProsumer(consumer1);
	    energyMarket.addConsumerOrProsumer(consumer2);
	    energyMarket.addConsumerOrProsumer(consumer3);
	    energyMarket.addConsumerOrProsumer(prosumer1);
	    energyMarket.addConsumerOrProsumer(prosumer2);
	    
	    // Create some energy requests (some with preferred IP some with no preferred IP)
	    EnergyRequest energyRequest1 = new EnergyRequest(consumer2, 3, "192.168.1.2");
	    EnergyRequest energyRequest2 = new EnergyRequest(consumer3, 5);
	    EnergyRequest energyRequest3 = new EnergyRequest(consumer2, 4, "192.168.1.2");
	    EnergyRequest energyRequest4 = new EnergyRequest(consumer2, 2);

	    // Add energy requests to the EnergyMarket
	    energyMarket.addEnergyRequest(energyRequest1);
	    energyMarket.addEnergyRequest(energyRequest2);
	    energyMarket.addEnergyRequest(energyRequest3);
	    energyMarket.addEnergyRequest(energyRequest4);

	    // Create some energy offers
	    EnergyOffer energyOffer1 = new EnergyOffer(prosumer1, 2, 2.2);
	    EnergyOffer energyOffer2 = new EnergyOffer(prosumer2, 3, 2.0);
	    EnergyOffer energyOffer3 = new EnergyOffer(prosumer1, 4, 3);
	    EnergyOffer energyOffer4 = new EnergyOffer(prosumer2, 20, 10.0);

	    // Add energy offers to the EnergyMarket
	    energyMarket.addEnergyOffer(energyOffer1);
	    energyMarket.addEnergyOffer(energyOffer2);
	    energyMarket.addEnergyOffer(energyOffer3);
	    energyMarket.addEnergyOffer(energyOffer4);
	    
	    System.out.println(energyMarket);
	}

}
