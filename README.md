[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/XAsZORds)
# IMPORTANT

For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```
## IMPORTANT NOTE 2: After you complete the tasks, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# COMP 132: Advanced Programming

# Lab-6 Prelab: EnergyNet: Energy Trading System Simulation

**Objective:**

To practice with the concepts of Java **Collections Framework**, including List, Sets, Maps, Collection class and its methods, and Comparable interface, by simulating a simple energy trading system that operates in a smart grid.

**Overview:**

Energy trading is the buying and selling of energy, traditionally through a centralized market. Smart grids, which are modern energy systems that use digital technologies to monitor, control, and optimize the generation, transmission, and distribution of electricity, allow for a more sustainable and efficient use of energy. Consumers are the end-users of energy, while prosumers also produce energy through renewable sources such as solar panels or wind turbines. Prosumers can be consumers when needed. Through energy trading, consumers and prosumers can interact with the grid in a more flexible and efficient manner, reducing waste and supporting the integration of renewable energy sources.

**The EnergyNet System details:**

You are going to implement the Energy Trading System Simulation as instructed below. You have to define the correct access modifiers, data types, constructors (maybe multiple per class), methods signatures, and boundaries (for example not allowing negative values in some cases), if not specified. All fields are required (cannot be empty and you have to initialize the object with them) unless specified otherwise. Getters and setters must be coded only when needed. You may override toString methods for some classes to match the sample output.

In the given template, you have to create a package called energy_net, where you will put your code. You are given a test code, Test.java, in the default package that you will use to check whether your output matches the sample output. 

Note that we may test your code with any other test code and it should work correctly.


## Consumer class:

Implement a class for Consumer, which should have the following properties:
- A string IP address which is used as a unique id.
- Name ``(String)``.
- The balance of the consumer ``(double)``.
- The consumer has a method that adds the amount to the balance and another method that deducts the specified amount from the balance. It returns true if the deduction was successful.
Make Consumer overrides equals method so we can check whether two consumers are the same using their IP addresses.

## Prosumer class:

Implement a class for Prosumer, which inherits from Consumer (because each Prosumer is a Consumer as well) and has a property that represents the distance of the prosumer to the center of the smart grid as a positive integer value with a default value of 10. 

Prosumer has a method to deposit money into his/her balance.


## EnergyOperation class:

Implement an EnergyOperation class with the following properties:
- Auto-incremented integer id. The id should be incremented by one each time an object of the class is created; in other words, each time its constructor is called. So, the increment in the value of the ID is handled by the class itself.
- The owner of the operation which can be Prosumer or Consumer.
- The requested or offered energy amount in Kilowatts as an integer value.

This class has one method used to decrease the energy amount by a specific value sent as a parameter. This class will be used as a super class for other classes and we cannot make instances out of it.

## EnergyRequest class:

Implement a class for EnergyRequest as a subclass of EnergyOperation, which should have the following property:
- Some consumers may prefer to buy energy from their friends or relatives. For that reason, we will add an optional attribute indicating the preferred IP address, as String, to buy energy from, with no default value. We can initialize an energy request with or without the preferred IP address. In other words, your class definition should allow the initialization of an object with the preferred IP address or without it.


## EnergyOffer class:

Implement a class for EnergyOffer as a subclass of EnergyOperation, which should have the following extra property:
- The price per Kilowatt ``(double)``.


## Transaction class:

Implement a class for Transaction, which should have the following properties:

- A string id constructed as the string value of the EnergyRequest id concatenated with the string value of the EnergyOffer id. For example, if the EnergyRequest id is 25 and the EnergyOffer id is 67, the transaction id is “25_67”. It should be done in the constructor, i.e. it is not sent as a parameter.
- The energy offer reference.
- The energy request reference.
- The traded energy amount as an integer.
- The price of the traded energy amount ``(double)``.

Make Transaction overrides equals method so we can check whether two transactions are the same using their ids.


## EnergyMarket class:

Create a class for EnergyMarket, which should use Java collections to manage the consumers, prosumers, energy requests, offers, and transactions.

Attributes:
- To manage consumers and prosumers, we will use a single Map with IP addresses as keys and the Consumer or Prosumer objects as values.
- To manage energy requests and offers, we are using an ArrayList for each one.
- To manage transactions, use a Set to ensure each transaction is unique. The uniqueness of a transaction is determined by its id.
- An attribute that represents the money earned by the system owner ``(double)``.
- An attribute represents the percentage earned from each transaction ``(double)``.

Methods:	
- A method to add a new Consumer or Prosumer object to the HashMap of consumers and prosumers. This method takes one parameter (Consumer) and returns nothing.
- A method to search for a consumer or prosumer using an IP address. It should return the consumer or prosumer reference if found, or null if not found.
- A method that receives an energy request and adds it to the ArrayList of energy requests and calls the trade method. Nothing will be returned and the parameter is EnergyRequest reference.
- A method that adds a new EnergyOffer object to the ArrayList of energy offers and calls the trade method. Nothing will be returned and the parameter is EnergyOffer reference.
- A method for creating a new Transaction object and adding it to the HashSet of transactions. The method checks the consumer’s balance to make sure he/she has enough money. If the consumer has enough money, we deduct the money from his/her balance and create the Transaction object. 

The profit percentage of the transaction will be added to the balance of the EnergyMarket and the left deducted money will be deposited to the prosumer account. 

This method returns true if the transaction was created successfully, and false otherwise. The following lines explain **some** of the operations needed in this method:

```
energy market balance += profitPercentage * transaction.totalPrice
prosumer.deposit(transaction.totalPrice - profitPercentage * transaction.totalPrice )
```

- A method to search for an offer using the prosumer’s IP address. It will return the first matched offer if found or null if not found.
- trade: This method is responsible for matching energy requests and offers. The method is described in Algorithm 1. Note that pseudocode is used in algorithm 1. In other words, the used names in the algorithm might not match the names you have in your code. This method has no input and nothing is returned.

```
- For each energy request:
  - while energy request amount greater than zero:
    - Initialize energy offer object with null value
    - If energy request has preferred IP address
      - Assign the offer made by the preferred IP to energy offer 
    - If energy offer is null and we have other energy offers
      - Select the first energy offer with energy amount more than 0
    - If energy offer is null
      - Break
    - Traded amount  = minimum amount of energy between the request and the offer
    - Create a transaction with the energy offer and the energy request
    - If the transaction was created:
      - Update the energy request and energy offer amounts
      - Remove the energy offer if its energy amount is zero.
      - Remove the energy request if its energy amount is zero.
    - Else
      - Break
```
<p align="center">Algorithm 1. Trading Algorithm in EnergyNet</p>


## Sample Output:

```console

---------------------------------------------
Prosumers and Consumers:
Name: Berke
IP Address: 192.168.0.2
Balance: 4.00

Name: Can
IP Address: 192.168.1.1
Balance: 23.12
Distance to center: 10

Name: Abdulrezzak
IP Address: 192.168.0.1
Balance: 27.00

Name: Dogan
IP Address: 192.168.1.2
Balance: 12.80
Distance to center: 15

Current Energy Requests:
Owner IP Address: 192.168.0.2
Energy Amount: 3
Preferred IP: 192.168.1.2

Owner IP Address: 192.168.0.2
Energy Amount: 2
Preferred IP: null

Current Energy Offers:
Owner IP Address: 192.168.1.2
Energy Amount: 20
Price: 10.0

Transactions:
ID: 3_7
Buyer IP Address: 192.168.0.2
Seller IP Address: 192.168.1.1
Energy Amount: 1
Price =3.00

ID: 2_6
Buyer IP Address: 192.168.0.1
Seller IP Address: 192.168.1.2
Energy Amount: 2
Price =4.00

ID: 2_7
Buyer IP Address: 192.168.0.1
Seller IP Address: 192.168.1.1
Energy Amount: 3
Price =9.00

ID: 1_6
Buyer IP Address: 192.168.0.2
Seller IP Address: 192.168.1.2
Energy Amount: 1
Price =2.00

ID: 1_5
Buyer IP Address: 192.168.0.2
Seller IP Address: 192.168.1.1
Energy Amount: 2
Price =4.40

Energy Market Balance: 4.48
---------------------------------------------
End of simulation

```
