package com.reservation.rail;

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








