package com.reservation.rail;
import java.util.ArrayList;

 class Train {
    private int lower =5;
    private int middle =5;
    private int upper=5;
    private int sideupper=2;
    private int sidelower=3;

    private int rac=5;
    private int wl=5;
    
    private int totalCapacity = lower + middle + upper + sideupper + sidelower;
    ArrayList<Ticket> confirmList = new ArrayList<>();
    ArrayList<Ticket> racList = new ArrayList<>();
    ArrayList<Ticket> wlList = new ArrayList<>();
   


    boolean isLowerBerthAvailable(){
        return lower>0;
    }
    void consumeLower(){
        lower=lower-1;
    }
    boolean isMiddleBerthAvailable(){
        return middle>0;
    }
    void consumeMiddle(){
        middle=middle-1;
    }boolean isUpperBerthAvailable(){
        return upper>0;
    }
    void consumeUpper(){
        upper=upper-1;
    }boolean isSideLowerBerthAvailable(){
        return sidelower>0;
    }
    void consumeSideLower(){
        sidelower=sidelower-1;
    }boolean isSideUpperBerthAvailable(){
        return sideupper>0;
    }
    void consumeSideUpper(){
        sideupper=sideupper-1;
    }

    boolean isWlAvailable(){
        return wl>0;
    }
    void consumeWl(){
        wl=wl-1;
    }boolean isRacAvailable(){
        return rac>0;
    }
    void consumeRac(){
        rac=rac-1;
    }
     
    boolean isNotFull(){
        return (totalCapacity>0);
    }
    void printAvailableTickets(){
        System.out.println("\nLower berth:"+lower+"\nUpper berth "+upper+"\nMiddle berth: "+middle+"\nSide lower"+sidelower+"\nSide upper"+sideupper+"\n RAC "+rac+"\n WL "+wl);
    }

    boolean allocateLower(Passenger p ){
        if(isLowerBerthAvailable()) {
                consumeLower();
                Ticket t=new Ticket(p, "LOWER");
                confirmList.add(t);
                return true;
        }
        return false;
    }
    boolean allocateUpper(Passenger p ){
        if(isUpperBerthAvailable()) {
                consumeUpper();
                Ticket t=new Ticket(p, "UPPER");
                confirmList.add(t);
                return true;
        }
        return false;
    }
    boolean allocateMiddle(Passenger p ){
        if(isMiddleBerthAvailable()) {
                consumeMiddle();
                Ticket t=new Ticket(p, "MIDDLE");
                confirmList.add(t);
                return true;
        }
        return false;
    }
    boolean allocateSideLower(Passenger p ){
        if(isSideLowerBerthAvailable()) {
                consumeSideLower();
                Ticket t=new Ticket(p, "SIDELOWER");
                confirmList.add(t);
                return true;
        }
        return false;
    }
    boolean allocateSideUpper(Passenger p ){
        if(isSideUpperBerthAvailable()) {
                consumeSideUpper();
                Ticket t=new Ticket(p, "SIDEUPPER");
                confirmList.add(t);
                return true;
        }
        return false;
    }
    boolean allocateRac(Passenger p ){
        if(isRacAvailable()) {
                consumeRac();
                Ticket t=new Ticket(p,"RAC");
                t.rac=true;
                racList.add(t);
                return true;
        }
        return false;
    }
    boolean allocateWl(Passenger p ){
        if(isWlAvailable()) {
                consumeWl();
                Ticket t=new Ticket(p, "WL");
                t.wl=true;
                wlList.add(t);
                return true;
        }
        return false;
    }
    boolean allocateAvailable(Passenger p){
        if(allocateLower(p)) return true;
        else if (allocateMiddle(p)) return true;
        else if (allocateUpper(p))return true;
        else if (allocateSideLower(p)) return true;
        else if (allocateSideUpper(p)) return true;
        else if (allocateRac(p)) return true;
        else if (allocateWl(p)) return true;
        else {
            System.out.println("No more tickets for this train");
            return false;
        }
     }
    //update logic
}

