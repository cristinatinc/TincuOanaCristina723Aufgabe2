import Model.Spieler;
import Model.Verein;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Controller.Controller;
import View.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IRepository<Spieler> repo1 = new InMemoryRepository<Spieler>();
        IRepository<Verein> repo2 = new InMemoryRepository<Verein>();

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(repo1, repo2);
        ConsoleView consoleView = new ConsoleView(controller);
        consoleView.start();
        scanner.close();
        }

}