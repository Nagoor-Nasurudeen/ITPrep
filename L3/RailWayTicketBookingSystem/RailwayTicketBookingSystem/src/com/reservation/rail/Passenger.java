package com.reservation.rail;

 class Passenger{
    static int counter=1;
    int userId;
    String name;
    int age;
    int gender; //0 for male 1 for female
    String prefBerth;
    Passenger(String name,int age,int gender,String prefBerth){
        userId=counter;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.prefBerth=prefBerth;
        counter=counter+1;
    }
}
