package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;


public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (!Authenticator.auth()) return;
        Client client = clientService.registerNewClient();

        if (client == null) return;
        System.out.print("Want you to add a pet now? (Y/N): ");
        String input = Main.SCANNER.nextLine();

        if (input.equalsIgnoreCase("Y")) {
            System.out.println("Adding a new pet.");
            Pet pet = petService.registerNewPet();

            if (pet !=null) {
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");
            }
            System.out.println(client);
            System.out.println(pet);




        }
    }
}
