package com.reservation.rail;

class Ticket{
    static int counter=1;
    int id;
    String name;
    int gender;
    String berth;
    int seat;
    boolean rac =false;
    boolean wl=false;
    Ticket(Passenger p,String berth){
        id=p.userId;
        name=p.name;
        gender=p.gender;
        this.berth=berth;
        seat=counter;
        counter=counter+1;
    }
    
    @Override
    public String toString(){
        String strGender = gender==0 ?"Male": "Female";
        return "Passenger id: "+id+ "\nName: "+name+"\nGender: "+strGender+"\nAllocated Berth: "+berth+"\nSeat"+seat+"\nRAC "+rac+"\nWL: "+wl ;
    }
}
