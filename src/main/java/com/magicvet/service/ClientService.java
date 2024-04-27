package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String NAME_PATTERN = "^[A-Z][a-zA-Z-]+$";

    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        String firstName;
        String lastName;

        if (!isEmailValid (email)) {
            System.out.println("Provided email is invalid.");
            return client;
        }

        System.out.print("First name: ");
        firstName = Main.SCANNER.nextLine();

        if (!isNameValid (firstName)) {
            System.out.println("Provided First name is invalid.");
            return client;
        }

        System.out.print("Last name: ");
        lastName = Main.SCANNER.nextLine();

        if (!isNameValid (lastName)) {
            System.out.println("Provided Last name is invalid.");
            return client;
        }

        client = buildClient(firstName, lastName, email);
        System.out.println("New client: " + client.getFirstName() + " "
                + client.getLastName() + " ( " + client.getEmail() + " )");

        return client;

    }


    private static Client buildClient(String firstName, String lastName, String email) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }

    private static boolean isNameValid(String nameFirstOrLast) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(nameFirstOrLast);
        return  matcher.matches();
    }

}
