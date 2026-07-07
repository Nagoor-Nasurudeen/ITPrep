package com.taxibooking;

//javac -d bin .\src\com\taxibooking\App.java
//java -cp bin com.taxibooking.App

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Taxibooking taxibooking =new Taxibooking();
        Taxi taxi1=new Taxi("Taxi A", 1);
        Taxi taxi2= new Taxi("Taxi B",2 );
        Taxi taxi3 = new Taxi("Taxi C",3 );
        while (true) {
            System.out.println("Welcome to Taxi Booking System\n");
            System.out.print("Enter your name (enter 0 for exit) ");
            String name=sc.nextLine();
            if(name.charAt(0)=='0') break; 
            
            System.out.print("Enter source (A, B, C, D, E, F) ");
            int source =sc.nextLine().toUpperCase().charAt(0)-64;
            
            System.out.print("Enter destination ");
            int dest = sc.nextLine().toUpperCase().charAt(0)-64;
            Customer customer=new Customer(name, source, dest);
            taxibooking.bookTaxi(customer, source, dest);
        
        }
        sc.close();;
       System.out.println("Exited from Taxi boooking system");

    }
 
}

class Taxi{
    String taxiName;
    int taxiNo;
    int earnings=0;
    LocalTime booked=null;
    Customer currentCustomer;
    int lastBookedStation=1;
    int lastTravelDuration=1;  //mins

    
    Taxi(String name,int taxiNo){
        this.taxiName=name;
        this.taxiNo=taxiNo;
        Taxibooking.taxiList.add(this);
    }

    boolean isTaxiAvailable(){
        
        if(booked==null){
           // booked=LocalTime.now();
            return true;
        }else{
            long duration = Math.abs(ChronoUnit.MINUTES.between(booked, LocalTime.now()));
            if (duration>(Taxibooking.unitTravelDuration*lastTravelDuration)) {
                return true;
            }else{
                return false;
            }

        }
    }
    void TaxiEarnings(){
        System.out.println("\nTaxi name :"+taxiName+"\nTaxi No "+taxiNo+"\nEarnings "+earnings+"\nBooked Time "+booked+"\nBooked stop "+lastBookedStation+"\nTravel duration "+lastTravelDuration);
    }
   
    
   

}

class TaxiMap{
    
    Taxi taxi;
    int nearByLocation;
    TaxiMap(Taxi taxi,int nearByLocation){
        this.taxi=taxi;
        this.nearByLocation=nearByLocation;
    }
    int getNearByLocation(){
        return nearByLocation;
    }
}

class Taxibooking{
    static int distanceBet = 15;  //km
    static int minFare=100;   //for first 5km
    static int addFare=10;
    static int unitTravelDuration=1;  //change to 60 min 
    static ArrayList<Taxi> taxiList=new ArrayList<>();
    void bookTaxi(Customer customer,int source,int dest){
        Taxi taxi=nearbyTaxi(source);
        if(taxi != null){
            
            int fare= ((Math.abs(dest-source)*distanceBet)-5)*addFare+minFare; 
            System.out.println("Fare "+fare);
            taxi.earnings=taxi.earnings+fare;
            taxi.booked=LocalTime.now();
            taxi.lastTravelDuration=Math.abs(dest-source);
            taxi.currentCustomer=customer;
            taxi.lastBookedStation=dest;
            System.out.println("Taxi with name "+taxi.taxiName+" is booked for the customer "+customer.name);
            taxi.TaxiEarnings();
        }else System.out.println("Taxi are not available at the moment");
    }
    Taxi nearbyTaxi(int source){
        ArrayList<TaxiMap> taxiMaps=new ArrayList<>();
        for(Taxi taxi :taxiList){
            if(taxi.isTaxiAvailable()) taxiMaps.add(new TaxiMap(taxi, Math.abs(source-taxi.lastBookedStation)));
            
        }
        if(taxiMaps.size()>0) {
            taxiMaps.sort(Comparator.comparingInt(TaxiMap::getNearByLocation));
            return taxiMaps.get(0).taxi;
        }
       
        return null;
    }
}

class Customer{
    String name;
    int source;
    int dest;
    Customer(String name,int source,int dest){
        this.name=name;
        this.source=source;
        this.dest=dest;
    }
}