
import java.util.*;

public class PlaneManagement {

    static Scanner input = new Scanner(System.in); //Creating new scanner to get input


    public static Ticket[] tickets=new Ticket[52]; //MAXIMUM TICKET COUNT TO STORE INFORMATION IS 52



//To store buy and cancel seat information
    public static int [][] seat_index = new int[4][];


//Main method
    public static void main(String[] args) {

        //Declaring array

        seat_index[0] = new int[14];
        seat_index[1] = new int[12];
        seat_index[2] = new int[12];
        seat_index[3] = new int[14];


        System.out.println("Status of seats: ");

    //To display seat status
        for (int i = 0; i < seat_index.length; ++i) {
            for (int j = 0; j < seat_index[i].length; ++j) {
                System.out.print(seat_index[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(" "); //To print gap between seat status and welcome message

        System.out.println("\'Welcome to the Plane Management application.\'"); // Backslash included to display with the inverted comma.

        // MENU OPTION
        boolean option_response = false;
        while (!option_response) {

            star_design();          //Calling method to display multiple stars
            System.out.println("*                 MENU OPTIONS                   *");
            star_design();        //Calling method to display multiple stars
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            star_design();       //Calling method to display multiple stars
            System.out.println("");
            System.out.print("Please select an option: ");


            boolean valid_response = false;
            while (!valid_response) {       // Valid_response added to loop till proper input received
                char option = input.next().charAt(0);

                   switch (option) {
                       case '1':
                           buy_seat();
                           valid_response = true;
                           break;

                       case '2':
                           cancel_seat();
                           valid_response = true;
                           break;

                       case '3':
                           find_first_available();
                           valid_response = true;
                           break;

                       case '4':
                           show_seating_plan();
                           valid_response = true;
                           break;

                       case '5':
                           print_ticket_info();
                           valid_response = true;
                           break;

                       case '6':
                           search_ticket();
                           valid_response = true;
                           break;

                       case '0':
                           System.out.println("Program is exiting.");
                           System.exit(0);

                       default:
                           System.out.println("Invalid option entered.");
                           System.out.print("Please select an option: ");

                        }
                    }

            }
         }



    //Method to star_design
    public static void star_design() {
        String repeatedstar = String.valueOf('*').repeat(50);   //To create multiple star design
        System.out.println(repeatedstar);
    }


    //Buy seat method
    private static void buy_seat() {
        Scanner input = new Scanner(System.in);
        char row_letter;
        int seat_number;
        int price=0;


            System.out.println("Enter your details ");
            System.out.print("Enter your Name: ");
            String name=input.nextLine();

            System.out.print("Enter you Surname: ");
            String surname=input.nextLine();

            System.out.print("Enter your email: ");
            String email=input.nextLine();


        boolean seat_status=false;
        while (!seat_status) {
            System.out.print("Enter the ROW LETTER: ");
            row_letter = input.next().toUpperCase().charAt(0);     //To uppercase is added to convert input to uppercase
            int i;
            int num_seats;
                //To consider letter inputs as number
                switch (row_letter) {

                    case 'A':
                        i=0;
                        num_seats=14;
                    //Calling buyseat_validation method
                        buyseat_validation(name,surname,email,i,row_letter,num_seats );
                        seat_status=true;
                        break;


                    case 'B':

                        i=1;
                        num_seats=12;
                        buyseat_validation(name,surname,email,i,row_letter,num_seats );  //Calling buyseat_validation method
                        seat_status=true;
                        break;

                    case 'C':

                        i=2;
                        num_seats=12;
                        buyseat_validation(name,surname,email,i,row_letter,num_seats );  //Calling buyseat_validation method
                        seat_status=true;
                        break;

                    case 'D':

                        i=3;
                        num_seats=14;
                        buyseat_validation(name,surname,email,i,row_letter,num_seats ); //Calling buyseat_validation method
                        seat_status=true;
                        break;

                    default:
                        System.out.println("ROWLETTER is invalid ");
                        break;

            }

        }
    }


    //cancel seat method
    private static void cancel_seat() {
        Scanner input = new Scanner(System.in);
        char row_letter;

        boolean cancel_status=false;
        while (!cancel_status) {
            System.out.print("Enter the ROW LETTER: ");
            row_letter = input.next().toUpperCase().charAt(0);     //To uppercase is added to convert input to uppercase
            int num_seat;
            int i;
                //To consider letter inputs as number
                switch (row_letter) {
                    case 'A':

                        num_seat=14;
                        i=0;
                        cancelseat_validation(row_letter,num_seat,i); //Calling cancelseat_validation method
                        cancel_status=true;

                        break;



                    case 'B':
                        num_seat=12;
                        i=1;
                        cancelseat_validation(row_letter,num_seat,i); //Calling cancelseat_validation method
                        cancel_status=true;

                        break;

                    case 'C':
                        num_seat=12;
                        i=2;
                        cancelseat_validation(row_letter,num_seat,i); //Calling cancelseat_validation method
                        cancel_status=true;
                        break;

                    case 'D':
                        num_seat=14;
                        i=3;
                        cancelseat_validation(row_letter,num_seat,i); //Calling cancelseat_validation method
                        cancel_status=true;

                        break;


                    default:
                        System.out.println("Invalid row letter.");

                }

            }
        }



    //find first available method
    private static void find_first_available() {
            char[] row={'A','B','C','D'};
            for(int i=0;i<seat_index.length;i++){
                for(int j=0;j<seat_index[i].length;j++){
                    if(seat_index[i][j]==0){
                        System.out.println("First available seat found at row " + row[i] + ",seat " + (j+1));
                        return;  //To stop after finding first available seat
                    }

                }
            }
             System.out.println("No any other available seat is found");
    }


    private static void show_seating_plan() {
        for(int i=0; i<seat_index.length; i++) {
            for(int j=0; j<seat_index[i].length; j++){
                if(seat_index[i][j]==1) {
                    System.out.print("X ");

                }else if(seat_index[i][j]==0){
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
    }

    private static void print_ticket_info(){
            int total=0;
            System.out.println("All the information of sold tickets: ");
            System.out.println();

            for(Ticket ticket:tickets) {
                if (ticket != null) {
                    ticket.full_ticket_info();
                    total += ticket.getPrice();
                    System.out.println("");

                }
            }
            System.out.println("Total amount of sold tickets: "+total);
    }

    private static void search_ticket(){

        System.out.print("Enter the Rowletter(A,B,C or D): ");
        char row_letter=input.next().toUpperCase().charAt(0);

        System.out.print("Enter the Seatnumber: ");
        int seat_number=input.nextInt();

        boolean ticketFound=false;
        for(Ticket ticket:tickets){
            if(ticket!=null && ticket.getRow()==row_letter && ticket.getSeat()==seat_number){
                System.out.println("Seat is booked and below is the information ");
                System.out.println("");
                ticket.full_ticket_info();
                ticketFound=true;
            }
        }
        if (!ticketFound) {
            System.out.println("Seat is available");
        }
    }

    private static void  ticket_price(String name,String surname,String email,int i,char row_letter, int seat_number,boolean correct_response) {
        int price = 0;

        if ((row_letter >= 'A' && row_letter <= 'D') && (seat_number >= 1 && seat_number <= 5)) {
            price = 200;

        } else if ((row_letter >= 'A' && row_letter <= 'D') && (seat_number >= 6 && seat_number <= 9)) {
            price = 150;

        } else {
            price = 180;
        }

        System.out.println("You have to pay £" + price);

        System.out.println("Are you confirm to buy the seat " + row_letter + seat_number);
        System.out.print("if yes enter Y or else enter N: ");

        boolean yes_no_response=false;
        while(!yes_no_response) {
            int response = input.next().toUpperCase().charAt(0);
            if (response == 'Y') {

            //Create new Person object
                Person person=new Person(name,surname,email);

            //Creating new Ticket object
                Ticket ticket= new Ticket(seat_number,row_letter,price,person);

            //Calling addTicket method
                addTicket(ticket);
                ticket.save();
                seat_index[i][seat_number-1] = 1;
                System.out.println("Seat is booked for you");
                yes_no_response=true;

            } else if (response == 'N') {
                System.out.println("Your request cancelled");
                yes_no_response=true;
            } else {
                System.out.print("Enter Y or N: ");
            }
        }
    }



        private static void buyseat_validation(String name,String surname,String email, int i,char row_letter,int num_seats){

            try{
                boolean correct_response = false;
                while (!correct_response) {

                    System.out.print("Enter the SEAT NUMBER: ");
                    int seat_number = input.nextInt();

                        if ((seat_number-1) < num_seats  && seat_number > 0) {     // to get seat_number within specific range
                            if (seat_index[i][seat_number - 1] == 0) {
                        //calling ticket_price method
                                ticket_price(name,surname,email,i,row_letter, seat_number,correct_response);
                                correct_response = true;

                            } else {
                                System.out.println("Seat is already booked ");
                                System.out.println("Do you want to enter SEAT NUMBER again:(yes or no)?  ");
                                System.out.print("If yes enter Y else N:  ");

                                boolean yes_no_response=false;
                                while(!yes_no_response) {
                                    char answer = input.next().toUpperCase().charAt(0);
                                    if (answer == ('Y')) {
                                        yes_no_response=true;
                                    } else if (answer == ('N')) {
                                        correct_response = true;
                                        yes_no_response=true;
                                    } else {
                                        System.out.println("Enter y or N: ");

                                    }
                                }

                            }

                        } else {
                            System.out.println("Seat number is invalid");
                            System.out.println("Do you want enter the SEAT NUMBER again? (yes or no:) ");

                            boolean yes_no_response=false;
                            while(!yes_no_response) {
                                System.out.print("If yes enter Y else N: ");
                                char answer = input.next().toUpperCase().charAt(0);
                                if (answer == ('Y')) {
                                    yes_no_response = true;

                                }else if (answer == ('N')) {
                                    correct_response = true;
                                    yes_no_response = true;

                                } else{
                                    System.out.println("");
                                }
                            }
                        }

                     }
                }catch (InputMismatchException e){
                        System.out.println("Integer input required");

                }
            }


        private  static void addTicket(Ticket ticket){
            for(int i=0 ; i<tickets.length; i++){
                if(tickets[i]==null){
                    tickets[i]=ticket;
                    break;
                }
            }
        }


            private static void cancelseat_validation(char row_letter,int num_seat, int i){
                boolean correct_response = false;
                while (!correct_response) {

                    try {
                        System.out.print("Enter the SEAT NUMBER: ");
                        int seat_number = input.nextInt();

                        if ((seat_number-1) < num_seat && seat_number>0) {     // To get the input within correct range
                                if (seat_index[i][seat_number - 1] == 1) {

                            //CALLING removeTicket METHOD
                                    removeTicket(row_letter,seat_number);
                                    seat_index[i][seat_number - 1] = 0;
                                    correct_response = true;


                                } else if (seat_index[i][seat_number - 1] == 0) {
                                    System.out.println("Selected seat is not booked");
                                    System.out.print("Do you want to enter SEAT NUMBER again (yes or no): ");
                                    System.out.print("If yes enter Y else N:  ");

                                    boolean response = false;
                                    while (!response) {
                                        char answer = input.next().toUpperCase().charAt(0);
                                        if (answer == ('Y')) {
                                            response=true;
                                        } else if (answer == ('N')) {
                                            correct_response = true;
                                            response = true;

                                        } else {
                                            System.out.print("Enter y or n: ");

                                        }
                                    }
                                }
                            }

                        else {
                            System.out.println("Seat number is invalid");
                         }

                    } catch (InputMismatchException e) {
                        System.out.println("Integer input required");
                    }
                }

            }


            private static void removeTicket(char row_letter,int seat_number){
                    int index_to_remove=-1; //Assigned a value to check whether already booked seat found

                //Find the index of the ticket to remove
                    for(int i=0; i<tickets.length; i++){
                        if(tickets[i]!=null && tickets[i].getRow()==row_letter && tickets[i].getSeat()==seat_number){
                            index_to_remove=i;
                            break;
                        }
                    }

                //Remove the ticket for the found index
                    if(index_to_remove!= -1){
                        System.out.println("Seat "+row_letter+seat_number+ " is cancelled");
                        tickets[index_to_remove]=null;
                    }
                    else{
                        System.out.println("Ticket for the seat "+row_letter+seat_number+" is not found");
                    }
            }
}













