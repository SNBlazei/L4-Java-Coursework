
import java.util.Scanner;


public class PlaneManagement {
    final static int[] A = new int[14];
    final static int[] B = new int[12];
    final static int[] C = new int[12];
    final static int[] D = new int[14];

    static Ticket[] tickets = new Ticket[52];

    static int ticketCount;
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");

        while (true) {
            System.out.println("""
                    **************************************************
                    *                  MENU OPTIONS                  *
                    **************************************************
                          1) Buy a seat
                          2) Cancel a seat
                          3) Find first available seat
                          4) Show seating plan
                          5) Print ticket information and total sales
                          6) Search ticket
                          0) Quit
                    **************************************************
                    """
            );

            int option;
            try {
                System.out.println("Please enter the option : ");
                option = input.nextInt();
            }catch (Exception e){
                System.out.println("Invalid input.please enter valid input:");
                input.nextLine();
                continue;
            }


            switch (option) {
                case 1 -> buy_seat();
                case 2 -> cancel_seat();
                case 3 -> find_first_available();
                case 4 -> show_seating_plan();
                case 5 -> print_tickets_info();
                case 6 -> search_ticket();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid input.Please enter valid input");
            }
        }
    }

    static void buy_seat() {
        String rowLetter;
        int seatNumber = 0;

        while (true) {
            System.out.println("Enter the row letter(A,B,C or D) :");
            rowLetter = input.next();
            if (rowLetter.equalsIgnoreCase("A")
                    || rowLetter.equalsIgnoreCase("B")
                    || rowLetter.equalsIgnoreCase("C")
                    || rowLetter.equalsIgnoreCase("D")) {

                rowLetter = rowLetter.toUpperCase();
                break;
            } else {
                System.out.println("Invalid seat row!");
            }
        }

        seatLoop:
        while (true) {
            System.out.println("Enter the seat number : ");
            try {
                seatNumber = Integer.parseInt(input.next());

            } catch (Exception e) {
                System.out.println(" ");
            }

            switch (rowLetter) {
                case "A", "D" -> {
                    if (seatNumber < 1 || seatNumber > 14) {
                        System.out.println("Invalid seat number !!!");
                    } else {
                        break seatLoop;
                    }
                }
                case "B", "C" -> {
                    if (seatNumber < 1 || seatNumber > 12) {
                        System.out.println("Invalid seat number !!!");
                    } else {
                        break seatLoop;
                    }
                }
            }
        }

        switch (rowLetter) {
            case "A" -> {
                if (A[seatNumber - 1] == 0) {
                    A[seatNumber - 1] = 1;
                    System.out.println("Done!");
                } else {
                    System.out.println("Already bought! Select another seat!");
                }
            }


            case "B" -> {
                if (B[seatNumber - 1] == 0) {
                    B[seatNumber - 1] = 1;
                    System.out.println("Done!");
                } else {
                    System.out.println("Already bought! Select another seat!");
                }
            }
            case "C" -> {
                if (C[seatNumber - 1] == 0) {
                    C[seatNumber - 1] = 1;
                    System.out.println("Done!");
                } else {
                    System.out.println("Already bought! Select another seat!");
                }
            }
            case "D" -> {
                if (D[seatNumber - 1] == 0) {
                    D[seatNumber - 1] = 1;
                    System.out.println("Done!");
                } else {
                    System.out.println("Already bought! Select another seat!");
                }
            }
        }

        System.out.println("Enter the name of person:");
        String name = input.next();
        System.out.println("Enter the surname of person");
        String surName = input.next();
        System.out.println("Enter the email of person:");
        String Email = input.next();

        person Person = new person(name, surName, Email);

        double price;

        if (seatNumber <= 5) {
            price = 200;
        } else if (seatNumber <= 9) {
            price = 150;

        } else {
            price = 150;
        }
        Ticket ticket = new Ticket(rowLetter, seatNumber, price, Person);

        tickets[ticketCount] = ticket;
        ticketCount++;

        ticket.save();

    }

    static void cancel_seat() {
        String rowLetter;
        int seatNumber = 0;
        while (true) {
            System.out.println("Enter the row letter(A,B,C or D) :");
            rowLetter = input.next();
            if (rowLetter.equalsIgnoreCase("A")
                    || rowLetter.equalsIgnoreCase("B")
                    || rowLetter.equalsIgnoreCase("C")
                    || rowLetter.equalsIgnoreCase("D")) {

                rowLetter = rowLetter.toUpperCase();
                break;
            } else {
                System.out.println("Invalid seat row!");
            }
        }

        seatLoop:
        while (true) {
            System.out.println("Enter the seat number : ");
            try {
                seatNumber = Integer.parseInt(input.next());
            } catch (Exception e) {
                System.out.println(" ");
            }

            switch (rowLetter) {
                case "A", "D" -> {
                    if (seatNumber < 1 || seatNumber > 14) {
                        System.out.println("Invalid seat number !!!");
                    } else {
                        break seatLoop;
                    }
                }
                case "B", "C" -> {
                    if (seatNumber < 1 || seatNumber > 12) {
                        System.out.println("Invalid seat number !!!");
                    } else {
                        break seatLoop;
                    }
                }
            }
        }

        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getRow().equalsIgnoreCase(rowLetter) && tickets[i].getSeat() == seatNumber) {
                for(int j = i; j < ticketCount - 1; j++){
                    tickets[j] = tickets[j + 1];
                }
                tickets[ticketCount - 1] = null;
                ticketCount--;
                break;
            }
        }

        switch (rowLetter) {
            case "A" -> {
                if (A[seatNumber - 1] == 0) {
                    System.out.println("Seat is available:");
                } else {
                    A[seatNumber - 1] = 0;
                }
                System.out.println("Seat " + rowLetter + (seatNumber) + " has been canceled and made available");
            }
            case "B" -> {
                if (B[seatNumber - 1] == 0) {
                    System.out.println("Seat is available:");
                } else {
                    B[seatNumber - 1] = 0;
                }
                System.out.println("Seat " + rowLetter + (seatNumber) + " has been canceled and made available");
            }
            case "C" -> {
                if (C[seatNumber - 1] == 0) {
                    System.out.println("Seat is available:");
                } else {
                    C[seatNumber - 1] = 0;
                }
                System.out.println("Seat " + rowLetter + (seatNumber) + " has been canceled and made available");
            }
            case "D" -> {
                if (D[seatNumber - 1] == 0) {
                    System.out.println("Seat is available");
                } else {
                    D[seatNumber - 1] = 0;
                }
                System.out.println("Seat " + rowLetter + (seatNumber) + " has been canceled and made available");
            }
        }
    }

    static void find_first_available() {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                System.out.println("Available seat:A" + (i + 1));
                return;
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 0) {
                System.out.println("Available seat:B" + (i + 1));
                return;

            }
        }
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0) {
                System.out.println("Available seat:C" + (i + 1));
                return;
            }
        }
        for (int i = 0; i < D.length; i++) {
            if (D[i] == 0) {
                System.out.println("Available seat:D" + (i + 1));
                return;
            }

        }
        System.out.println("No available seat");
    }


    static void show_seating_plan() {
        for (int seatNumber : A) {
            System.out.print(seatNumber == 0 ? "O" : "X");
        }
        System.out.println();

        for (int seatNumber : B) {
            System.out.print(seatNumber == 0 ? "O" : "X");
        }
        System.out.println();

        for (int seatNumber : C) {
            System.out.print(seatNumber == 0 ? "O" : "X");
        }
        System.out.println();

        for (int seatNumber : D) {
            System.out.print(seatNumber == 0 ? "O" : "X");
        }
        System.out.println();
    }

    static void print_tickets_info() {

        double totalPrice=0.0;
        int ticketNumber=1;
        System.out.println("tickets that have been sold during the session:");

        for(Ticket ticket:tickets){
            if(ticket!=null){
                System.out.println("Ticket "+ticketNumber+" :");
                System.out.println(ticket.getTicket());
                totalPrice+=ticket.getPrice();
                ticketNumber++;
            }
        }
        System.out.println("Total sales: £" + totalPrice);
    }

    static void search_ticket() {
        String rowLetter;
        int seatNumber = 0;

        while (true) {
            System.out.println("Enter the row letter(A,B,C or D) :");
            rowLetter = input.next();
            if (rowLetter.equalsIgnoreCase("A")
                    || rowLetter.equalsIgnoreCase("B")
                    || rowLetter.equalsIgnoreCase("C")
                    || rowLetter.equalsIgnoreCase("D")) {

                rowLetter = rowLetter.toUpperCase();
                break;
            } else {
                System.out.println("Invalid seat row!");
            }
        }

        seatLoop:
        while (true) {
            System.out.println("Enter the seat number : ");
            try {
                seatNumber = Integer.parseInt(input.next());
            } catch (Exception e) {
                System.out.println(" ");
            }

            switch (rowLetter) {
                case "A", "D" -> {
                    if (seatNumber < 1 || seatNumber > 14) {
                        System.out.println("Invalid seat number:");
                    } else {
                        break seatLoop;
                    }

                }
                case "B","C"->{
                    if(seatNumber<1 || seatNumber>12){
                        System.out.println("Invalid seat number:");

                    }else{
                        break seatLoop;
                    }
                }
            }
        }
        for(Ticket ticket:tickets){
            if(ticket!=null &&ticket.getRow().equalsIgnoreCase(rowLetter)&& ticket.getSeat()==seatNumber){
                ticket.printTicketInfo();
                return;
            }
        }
        System.out.println("This seat is available:");

    }
}
