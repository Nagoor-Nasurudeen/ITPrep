import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TicketBooking ticketBooking = new TicketBooking();
        ticketBooking.printMenu();
        Train train = new Train();
        Passenger p;
        while (true) {
            System.out.println("\nEnter the option ");
            int option=sc.nextInt();
            if (option==5) break;
            switch (option) {
                
                case 1:
                    p=ticketBooking.getUserDetails(sc);
                    if(ticketBooking.bookTicket(p,train)) System.out.println("Ticket booked successfully.");
                    break;
                case 2:
                    ticketBooking.printAvailableTickets(train);
                    break;
                case 3:
                    ticketBooking.printBookedTickets(train);
                    break;
                case 4:
                    System.out.println("Enter passenger id ");
                    int id=sc.nextInt();
                    ticketBooking.cancelTicket(id, train);
                    break;
                default:
                    System.out.println("Enter Number between 1 - 5");
                    break;
            }
        }
        System.out.println("Exited Rail reservation system");
    }
}

// bookTicket(Passenger passenger);

// cancelTicket(int passengerId);

// printBookedTickets();

// printAvailableTickets();


 class Train {
    private int lower =0;
    private int middle =0;
    private int upper=0;
    private int sideupper=0;
    private int sidelower=1;

    private int rac=2;
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
        return "Passenger id: "+id+ "\nName: "+name+"\nGender: "+gender+"\nAllocated Berth: "+berth+"\nSeat"+seat+"\nRAC "+rac+"\nWL: "+wl ;
    }
}

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


