import java.util.Scanner;

public class Person {
   private String name, surname, email  ;

    static Scanner input = new Scanner(System.in); //Creating new scanner to get input

//CONTRUCTOR
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;}

    //SETTERS
        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
         }

        public void setEmail(String email) {
            this.email = email;
        }


    //GETTERS
        public  String getName() {
            return name;
        }

        public  String getSurname() {
            return surname;
        }

        public  String getEmail() {
            return email;
        }


//        public static void person_details(String name, String surname,String email){
    public  void person_details(){
            System.out.println("Surname: "+surname);
            System.out.println("Name: "+name);
            System.out.println("Email: "+email);
        }



}
