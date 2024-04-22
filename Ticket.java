import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Ticket {

    String row;
    int seat;
    double price;
    person person;

     Ticket(String row,int seat,double price,person person){
         this.row=row;
         this.seat=seat;
         this.price=price;
         this.person= person;


    }

    public String getRow() {

         return row;
    }

    public void setRow(String row) {

         this.row = row;
    }

    public int getSeat() {

         return seat;
    }

    public void setSeat(int seat) {

         this.seat = seat;
    }

    public double getPrice() {

         return price;
    }

    public void setPrice(double price) {

         this.price = price;
    }

    public person getPerson() {

         return person;
    }

    public void setPerson(person person) {

         this.person = person;
    }

    public String getTicket() {
        return "Row: " + row+ " Seat: " + seat  + " Price: " + price;
    }

    public void printTicketInfo(){
        System.out.println("Information of Ticket");
        System.out.println("Row:"+row);
        System.out.println("Seat:"+seat);
        System.out.println("Price:"+price);
        System.out.println("Information of Person");
        System.out.println("Name:"+person.getName());
        System.out.println("Surname:"+person.getSurName());
        System.out.println("Email:"+person.getEmail());
    }
    public void save(){
         String fileName=row+seat+".txt";
         try{
             FileWriter writer=new FileWriter(fileName);
             writer.write("Information of the ticket:\n");
             writer.write("Row: " + row + "\n");
             writer.write("Seat: " + seat + "\n");
             writer.write("Price: " + price + "\n");
             writer.write("Information of the person:\n");
             writer.write("Name: " + person.getName() + "\n");
             writer.write("Surname: " + person.getSurName() + "\n");
             writer.write("Email: " + person.getEmail() + "\n");
             writer.close();

         }catch (IOException e){
             System.out.println("An error occurred");
             e.printStackTrace();
         }
    }
}

