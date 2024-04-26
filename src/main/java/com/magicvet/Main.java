package main.java.com.magicvet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    static String PASSWORD = "d";
    static Scanner SCANNER = new Scanner (System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[A-Z][a-zA-Z-]+$";
    public static void main(String[] args) {
       run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }

    }
    static boolean auth() {
    boolean accepted = false;
        for (int i = 0; i < 3; i++) {
        System.out.print("Password: ");
        String input = SCANNER.nextLine();

        if (PASSWORD.equals(input)) {
            accepted = true;
            break;
        } else {
            System.out.println("Access denied. Please check your password.");
        }
    }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");

        return accepted;
    }

    static void registerNewClient() {

        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();
        String firstName;
        String lastName;


        if (!isEmailValid (email)) {
            System.out.println("Provided email is invalid.");
        } else {
            System.out.print("First name: ");
            firstName = SCANNER.nextLine();
            if (!isNameValid (firstName)) {
                System.out.println("Provided First name is invalid.");
            } else {
                System.out.print("Last name: ");
                lastName = SCANNER.nextLine();
                if (!isNameValid (lastName)) {
                    System.out.println("Provided Last name is invalid.");
                } else {
                    Client client = buildClient(firstName, lastName, email);
                    System.out.println("New client: " + client.firstName + " " + client.lastName + " ( " + client.email + " )");
                }
            }
        }
    }

     static Client buildClient(String firstName, String lastName, String email) {
        Client client = new Client();
         client.email = email;
         client.firstName = firstName;
         client.lastName = lastName;

         return client;
    }

     static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }

    static boolean isNameValid(String nameFirstOrLast) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(nameFirstOrLast);
        return  matcher.matches();
    }

}