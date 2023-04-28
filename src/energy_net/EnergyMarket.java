package energy_net;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class EnergyMarket {

	//key, value
	
	private Map<String, Consumer> consumers;
    private Map<String, Prosumer> prosumers;
    private ArrayList<EnergyRequest> energyRequests;
    private ArrayList<EnergyOffer> energyOffers;
    private Set<Transaction> transactions;
    private double marketBalance;
    private double profitPercentage;
    
    
    public EnergyMarket(double profitPercentage) {
        this.consumers = new HashMap<>();
        this.prosumers = new HashMap<>();
        this.energyRequests = new ArrayList<>();
        this.energyOffers = new ArrayList<>();
        this.transactions = new HashSet<>();
        this.marketBalance = 0.0;
        this.profitPercentage = profitPercentage; // default profit percentage is 10%
    }
    
    
    public void addConsumerOrProsumer(Object consumerOrProsumer) {
    	if (consumerOrProsumer instanceof Prosumer) {
            Prosumer prosumer = (Prosumer) consumerOrProsumer;
            prosumers.put(prosumer.getIp(), prosumer);
        }
    	else if (consumerOrProsumer instanceof Consumer && !(consumerOrProsumer instanceof Prosumer)) {
            Consumer consumer = (Consumer) consumerOrProsumer;
            consumers.put(consumer.getIp(), consumer);
        } 
    }
    
    
    public Object findConsumerOrProsumerByIp(String ipAddress) {
        if (prosumers.containsKey(ipAddress)) {
        	return prosumers.get(ipAddress);
        }
    	else if (consumers.containsKey(ipAddress)) {
            return consumers.get(ipAddress);
        }
        return null;
    }
    
    
    public void addEnergyRequest(EnergyRequest eR) {
        energyRequests.add(eR);
        trade();
    }
    
    public void addEnergyOffer(EnergyOffer eO) {
        energyOffers.add(eO);
        trade();
    }
    
    //hashset rastgele
    //linkedset senin verdiğin düzene göre
    //treeset 
    
    
    public boolean addTransaction(EnergyRequest eR, EnergyOffer eO, double energy) {
    	
    	double price = energy*eO.getPricePerKW();
    	
    	Consumer consumer = eR.getOwner();
    	Prosumer prosumer = (Prosumer) eO.getOwner();
    	
    	if (consumer.getBalance() < price) {
            return false;
        }
    	
    	consumer.setBalance(consumer.getBalance() - price);
    	
        double energyMarketProfit = profitPercentage * price /100;
        marketBalance += energyMarketProfit;

        
        double prosumerDeposit = price - energyMarketProfit;
        prosumer.deposit(prosumerDeposit);
        
    	Transaction tr = new Transaction(eR, eO, energy, price);
    	transactions.add(tr);
    	return true;
    }
    
    
    public EnergyOffer searchOfferByProsumerIp(String prosumerIp) {
        for (EnergyOffer offer : energyOffers) {
            if (offer.getOwner().getIp().equals(prosumerIp)) {
                return offer;
            }
        }
        return null;
    }
    
    
    public void trade() {
        for (int i = 0; i< energyRequests.size(); i++) {
        	EnergyRequest request=energyRequests.get(i);
            while (request.getRequestedOrOfferedEnergy() > 0) {
                EnergyOffer offer = null;
                
                if (request.getIpAdress() != null) {
                    offer = searchOfferByProsumerIp(request.getIpAdress());
                }
                
                if (offer == null) {
                    for (EnergyOffer o : energyOffers) {
                        if (o.getRequestedOrOfferedEnergy() > 0) {
                            offer = o;
                        }
                    }
                }
                if (offer == null) {
                    break;
                }
                
                int tradedAmount = Math.min(request.getRequestedOrOfferedEnergy(), offer.getRequestedOrOfferedEnergy());
                
                if (addTransaction(request, offer, tradedAmount)) {
                    request.setRequestedOrOfferedEnergy(request.getRequestedOrOfferedEnergy() - tradedAmount);
                    offer.setRequestedOrOfferedEnergy(offer.getRequestedOrOfferedEnergy() - tradedAmount);
                    
                    if (offer.getRequestedOrOfferedEnergy() == 0) {
                        energyOffers.remove(offer);
                    }
                    
                    if (request.getRequestedOrOfferedEnergy() == 0) {
                        energyRequests.remove(request);
                    }
                }
                
                else {
                    break;
                }
            }
        }
    }

    
//    public void trade() {
//        Iterator<EnergyRequest> requestIterator = energyRequests.iterator();
//
//        while (requestIterator.hasNext()) {
//            EnergyRequest energyRequest = requestIterator.next();
//            int requestAmount = energyRequest.getRequestedOrOfferedEnergy();
//
//            while (requestAmount > 0) {
//                EnergyOffer energyOffer = null;
//                
//                // Look for an offer from the preferred IP address
//                if (energyRequest.getIpAdress() != null) {
//                    for (EnergyOffer offer : energyOffers) {
//                        if (offer.getOwner().getIp().equals(energyRequest.getIpAdress()) && offer.getRequestedOrOfferedEnergy() > 0) {
//                            energyOffer = offer;
//                            break;
//                        }
//                    }
//                }
//                
//                // If no offer was found, look for any offer with energy available
//                if (energyOffer == null) {
//                    for (EnergyOffer offer : energyOffers) {
//                        if (offer.getRequestedOrOfferedEnergy() > 0) {
//                            energyOffer = offer;
//                            break;
//                        }
//                    }
//                }
//                
//                // If no offer is found, break out of the inner loop
//                if (energyOffer == null) {
//                    break;
//                }
//                
//                // Determine the amount to trade
//                int tradedAmount = Math.min(requestAmount, energyOffer.getRequestedOrOfferedEnergy());
//                
//                if (addTransaction(energyRequest, energyOffer, tradedAmount)) {
//                	energyRequest.setRequestedOrOfferedEnergy(energyRequest.getRequestedOrOfferedEnergy() - tradedAmount);
//                	energyOffer.setRequestedOrOfferedEnergy(energyOffer.getRequestedOrOfferedEnergy() - tradedAmount);
//                  
//                  if (energyOffer.getRequestedOrOfferedEnergy() == 0) {
//                      energyOffers.remove(energyOffer);
//                  }
//                  
//                  if (energyRequest.getRequestedOrOfferedEnergy() == 0) {
//                      energyRequests.remove(energyRequest);
//                  }
//              }
//              
//              else {
//                  break;
//              }
//          }
//        }
//    }
//

	@Override
	public String toString() {
		String str = "---------------------------" + "\n";
		str += "Consumers and Prosumers: " + "\n";
		for(Consumer con : consumers.values()) {
			str += con;
		}
		for(Prosumer pro : prosumers.values()) {
			str += pro;
		}
		str += "---------------------------" + "\n";
		str += "Current Energy Requests: " + "\n";
		for(EnergyRequest eR : energyRequests) {
			str += eR;
		}
		str += "---------------------------" + "\n";
		str += "Current Energy Offers: " + "\n";
		for(EnergyOffer eO : energyOffers) {
			str += eO;
		}
		str += "---------------------------" + "\n";
		str += "Transactions: " + "\n";
		for(Transaction tr : transactions) {
			str += tr;
		}
		str += "---------------------------" + "\n";
		str += "Market Balance: " + marketBalance + "\n" + "END";
		return str;
	}
    
    

}
