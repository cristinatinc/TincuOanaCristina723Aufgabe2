package View;

import Controller.Controller;
import Model.Spieler;
import Model.Verein;
import Repository.IRepository;
import Repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Controller controller;

    public ConsoleView(Controller controller){
        this.controller = controller;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        System.out.println("Welcome to Euro 2024!");

        do{

            System.out.println("\nChoose");
            System.out.println("1. Create Spieler ");
            System.out.println("2. View all Spielers (Read)");
            System.out.println("3. Update Spieler");
            System.out.println("4. Delete Spieler");

            System.out.println("5. Create Verein");
            System.out.println("6. View all Vereins (Read)");
            System.out.println("7. Update Verein");
            System.out.println("8. Delete Verein");
            System.out.println("9. Add Spieler to Verein");

            System.out.println("10. Filer nach Verein ");
            System.out.println("11. ");
            System.out.println("12. ");
            System.out.println("0. Exit ");
            System.out.println("Please enter your choice: ");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "0":
                    // Exit
                    System.out.println("The Application is ending....");
                    break;

                case "1":
                    // Create
                    addSpieler(scanner);
                    break;

                case "2":
                    // Read
                    readSpielers();
                    break;

                case "3":
                    // Update
                    updateSpielers(scanner);
                    break;

                case "4":
                    // Delete
                    deleteSpieler(scanner);
                    break;

                case "5":
                    // create
                    addVerein(scanner);
                    break;

                case "6":
                    // read
                    readVereine();
                    break;

                case "7":
                    // update
                    updateVereine(scanner);
                    break;

                case "8":
                    // delete
                    deleteVerein(scanner);
                    break;

                case "9":
                    // add to Verein list
                    addSpielerToVerein(scanner);
                    break;

                case "10":
                    // filtering
                    filterMethod(scanner);
                    break;

                case "11":
                    filter2(scanner);
                    break;

                case "12":

                    break;


                case "13":

                    break;

                default:
                    System.out.println("Invalid Option. Please try again.");
                    break;
            }

        }while (!userChoice.equals("0"));
    }

    private void addSpieler(Scanner scanner){
        System.out.println("Enter ID");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter position");
        String position = scanner.nextLine();
        System.out.println("Enter marktwert");
        int marktwert = Integer.parseInt(scanner.nextLine());

        Spieler spieler = new Spieler(id, name, age, position, marktwert);
        controller.addSpieler(spieler);
    }

    private void readSpielers(){
        List<Spieler> Spielers = controller.getSpielers();
        Spielers.forEach(System.out::println);
    }

    private void updateSpielers(Scanner scanner){
        controller.showSpielers();
        System.out.println("Id of the Spieler to update:");
        Integer updateID = scanner.nextInt();
        scanner.nextLine();

        Spieler objToUpdate = controller.getSpielerByID(updateID);
        if (objToUpdate == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.println("New name (leave blank to keep current):");
        String temp1 = scanner.nextLine();
        String newName = temp1.isEmpty() ? objToUpdate.getName() : temp1;

        System.out.println("New age (leave blank to keep current):");
        String temp2 = scanner.nextLine();
        int newAge = temp2.isEmpty() ? objToUpdate.getAge() : Integer.parseInt(temp2);

        System.out.println("New positiom (leave blank to keep current):");
        String temp3 = scanner.nextLine();
        String newPosition = temp3.isEmpty() ? objToUpdate.getPosition() : temp3;

        System.out.println("New marktwert (leave blank to keep current):");
        String temp4 = scanner.nextLine();
        int newMarktwert = temp4.isEmpty() ? objToUpdate.getMarktwert() : Integer.parseInt(temp2);


        objToUpdate.setName(newName);
        objToUpdate.setAge(newAge);
        objToUpdate.setPosition(newPosition);
        objToUpdate.setMarktwert(newMarktwert);

        controller.updateSpieler(objToUpdate);
        System.out.println("Successfull update!");
    }


    private void deleteSpieler(Scanner scanner){
        controller.showSpielers();
        System.out.println("Id of the Spieler to delete:");
        Integer SpielerIDdelete = scanner.nextInt();
        scanner.nextLine();
        Spieler SpielerToDelete = controller.getSpielerByID(SpielerIDdelete);
        controller.deleteSpieler(SpielerToDelete);
    }

    private void addVerein(Scanner scanner){
        System.out.println("Enter ID");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();

        Verein verein = new Verein(id, name, address);
        controller.addVerein(verein);
    }

    private void readVereine(){
        List<Verein> clients = controller.getVereins();
        clients.forEach(System.out::println);
    }

    private void updateVereine(Scanner scanner){
        controller.showVereins();
        System.out.println("Id of the Verein to update:");
        Integer updateID = scanner.nextInt();
        scanner.nextLine();

        Verein objToUpdate = controller.getVereinByID(updateID);
        if (objToUpdate == null) {
            System.out.println("Verein not found!");
            return;
        }

        System.out.println("New name (leave blank to keep current):");
        String temp1 = scanner.nextLine();
        String newName = temp1.isEmpty() ? objToUpdate.getName() : temp1;

        System.out.println("New stadt (leave blank to keep current):");
        String temp2 = scanner.nextLine();
        String newAddress = temp2.isEmpty() ? objToUpdate.getStadt() : temp2;

        objToUpdate.setName(newName);
        objToUpdate.setStadt(newAddress);

        controller.updateVerein(objToUpdate);
        System.out.println("Successfull update!");
    }

    private void deleteVerein(Scanner scanner){
        controller.showVereins();
        System.out.println("Id of the Verein to delete:");
        Integer idDelete = scanner.nextInt();
        scanner.nextLine();
        Verein clientToDelete = controller.getVereinByID(idDelete);
        controller.deleteVerein(clientToDelete);
    }

    private void addSpielerToVerein(Scanner scanner){
        controller.showVereins();
        System.out.println("Enter id of the Verein");
        Integer VereinID = scanner.nextInt();
        scanner.nextLine();
        controller.showSpielers();
        System.out.println("Enter Spieler id:");
        Integer SpielerID = scanner.nextInt();
        scanner.nextLine();

        controller.addSpielerToVerein(SpielerID, VereinID);
    }


    private void filterMethod(Scanner scanner){
        System.out.println("Enter stadt to filter by");
        String season = scanner.nextLine();
        controller.vereinNachStadt(season);
    }

    private void filter2(Scanner scanner){
        System.out.println("Enter verein to filter by");
        String season = scanner.nextLine();
        controller.spielerImVErein(season);
    }
}
