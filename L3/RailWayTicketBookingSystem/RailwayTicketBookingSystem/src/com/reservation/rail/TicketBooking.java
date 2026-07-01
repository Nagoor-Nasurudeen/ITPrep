package com.reservation.rail;
import java.util.Scanner;
 class  TicketBooking{
    String name ;
    int age;
    int gender;
    String prefBerth;
    Train t = new  Train();
    void printMenu(){
        System.out.println("\n Welcome to Railway Reservation System \n 1. Book ticket 2. View available ticket 3. View booked ticket 4. Cancel ticket 5. Exit");

    }
    Passenger getUserDetails(Scanner sc){
        sc.nextLine();
        System.out.println("Enter user name");
        name=sc.nextLine();
        System.out.println("Enter Your age");
        age=sc.nextInt();
        System.out.println("Enter your gender 0 for male 1 for female");
        gender=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your preferred berth (LOWER,UPPER,MIDDLE,SIDELOWER,SIDEUPPER)");
        prefBerth=sc.next();
        prefBerth=prefBerth.toUpperCase();
        return new Passenger(name,age,gender,prefBerth);

    }
    boolean bookTicket(Passenger p ,Train train){
        if (p.age<5) {
            System.out.println("Childrens below 5 years are not allowed get seat");
            return false;
        }else if (p.age>=60) {
            if(train.allocateLower(p)) return true;
            else return train.allocateAvailable(p);
        }                                                        //IF BLOCK IS NOT NESTED CORRECTLY
        if(p.prefBerth.toUpperCase().equals("LOWER")){
            if(train.allocateLower(p))  return true;
            else return train.allocateAvailable(p);
        }else if (p.prefBerth.toUpperCase().equals("UPPER")){
            if(train.allocateUpper(p))  return true;
            else return train.allocateAvailable(p); 
        }else if (p.prefBerth.toUpperCase().equals("MIDDLE")){
            if(train.allocateMiddle(p))  return true;
            else return train.allocateAvailable(p);
        }else if (p.prefBerth.toUpperCase().equals("SIDELOWER")){
            if(train.allocateSideLower(p))  return true;
            else return train.allocateAvailable(p);
        }else if (p.prefBerth.toUpperCase().equals("SIDEUPPER")){
            if(train.allocateSideUpper(p))  return true;
            else return train.allocateAvailable(p);
        }else return train.allocateAvailable(p);
        
    }

    void cancelTicket(int passengerId,Train train){
        int seat;
        String berth;
        for(int i=0;i<train.confirmList.size();i++){
            if (train.confirmList.get(i).id == passengerId) {
                seat=train.confirmList.get(i).seat;
                berth=train.confirmList.get(i).berth;
                train.confirmList.remove(i);
                if(train.racList.size()>0) {
                    Ticket firstRacTicket= train.racList.removeFirst();
                    firstRacTicket.rac=false;  //change berth needed
                    firstRacTicket.seat=seat;
                    firstRacTicket.berth=berth;
                    if(train.wlList.size()>0){
                        Ticket firstWlTicket=train.wlList.removeFirst();
                        train.racList.add(firstWlTicket);
                        firstWlTicket.rac=true;
                        firstWlTicket.wl=false;
                    }
                    train.confirmList.add(firstRacTicket);
                }
                System.out.println("Successfully cancelled");
                return;
            }
        }
           
        System.out.println("Passenger id not found");
    }

    void printBookedTickets(Train train){
        for (Ticket ticket :train.confirmList) {
            System.out.println(ticket.toString());
        }
        for (Ticket ticket :train.racList) {
            System.out.println(ticket.toString());
        }for (Ticket ticket :train.wlList) {
            System.out.println(ticket.toString());
        }
    }
    void printAvailableTickets(Train train){    
        train.printAvailableTickets();
    }

}