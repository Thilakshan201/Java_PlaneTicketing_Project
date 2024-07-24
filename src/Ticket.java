import java.io.FileWriter;
import java.io.IOException;

public class Ticket {

    private int seat;
    private char row;
    private int price;
    private Person person;


    //Constructors
    public Ticket(int seat, char row, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //SETTERS
    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    //GETTERS
    public char getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public float getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }


    public void full_ticket_info() {
        person.person_details();
        System.out.println("Seat: " + row + seat);
        System.out.print("Price: " + price);
        System.out.println("");
    }

    public void save(){

            String filename = getRow() + getSeat() + ".txt";
            String ticketInfo = "Ticket Information for the Seat " + getRow() + getSeat() + "\n"+
                    "----------------------------------\n" +
                    "\tRow: " + getRow() + "\n" +
                    "\tSeat: " + getSeat() + "\n" +
                    "\tPrice: " + getPrice() + "\n" +
                    "\nPerson Information:\n" +
                    "\tFirst Name: " + person.getName() + "\n" +
                    "\tSurname: " + person.getSurname() + "\n" +
                    "\tEmail: " + person.getEmail() + "\n";
            try {
                FileWriter newFile = new FileWriter(filename);
                newFile.write(ticketInfo);
                newFile.close();
                System.out.println("\nTicket information saved to file: " + filename);
            } catch (IOException e){
                System.out.println("An error occurred while saving ticket information to file: " + e.getMessage());
            }
        }
}







