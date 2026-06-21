public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

// bookTicket(Passenger passenger);

// cancelTicket(int passengerId);

// printBookedTickets();

// printAvailableTickets();


 class TrainCapcity {
    private int lower =5;
    private int middle =5;
    private int upper=5;
    private int sideupper=5;
    private int sidelower=5;

    private int rac=5;
    private int wl=5;
    //getter setters
    int get_lower(){
        return lower;
    }
    int get_middle(){
        return middle;
    }
    int get_upper(){
        return upper;
    }
    int get_sideupper(){
        return sideupper;
    }
    int get_sidelower(){
        return sidelower;
    }
    int get_rac(){
        return rac;
    }
    int get_wl(){

        return wl;
    }
    int set_lower(){  //returns 0 for success 1 for failure
        
        lower = lower-1;
        return (int) lower>=0;
    }
    void set_middle(){
        ;
    }
}


 class User{
    String name;
    int age;
    int gender; //0 for male 1 for female
    String preferedBerth;
}

class Ticket{
    int id=0;
    String berth;
    String message;
    boolean rac =false;
    boolean wl=false;

}

 class  TicketBooking{
    int bookTicket(User user){
        if (user.age<5) return -1;
        else if (user.age>=60) {
            

        }
    }
}

class TicketCancelling{

}

