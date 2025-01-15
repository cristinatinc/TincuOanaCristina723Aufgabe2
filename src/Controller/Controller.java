package Controller;

import Model.Verein;
import Model.Spieler;
import Repository.IRepository;

import java.util.List;

/**
 * Controller class that manages operations on Spieler and Verein entities using their respective repositories.
 */
public class Controller {

    private final IRepository<Spieler> spielerRepo;
    private final IRepository<Verein> vereinRepo;

    /**
     * Constructs a Controller with the given Spieler and Verein repositories.
     *
     * @param repo1 the repository for Spieler entities
     * @param repo2 the repository for Verein entities
     */
    public Controller(IRepository<Spieler> repo1, IRepository<Verein> repo2) {
        this.spielerRepo = repo1;
        this.vereinRepo = repo2;
        initializeRepository();
    }

    /**
     * Initializes the repository with predefined Spieler and Verein data.
     */
    public void initializeRepository() {
        Spieler p1 = new Spieler(1, "Ana", 24, "p1", 100);
        Spieler p2 = new Spieler(2, "Bogdan", 30, "p4", 120);
        Spieler p3 = new Spieler(3, "ALexia", 32, "p2", 30);
        Spieler p4 = new Spieler(4, "Rares", 18, "p3", 60);

        spielerRepo.create(p1);
        spielerRepo.create(p2);
        spielerRepo.create(p3);
        spielerRepo.create(p4);

        Verein verein1 = new Verein(1, "A", "Cluj");
        Verein verein2 = new Verein(2, "B","Sibiu");
        Verein verein3 = new Verein(3, "C", "Floresti");

        vereinRepo.create(verein1);
        vereinRepo.create(verein2);
        vereinRepo.create(verein3);

        addSpielerToVerein(1, 2);
        addSpielerToVerein(1, 1);
        addSpielerToVerein(4, 1);
        addSpielerToVerein(2, 3);
    }

    /**
     * Adds a Spieler entity to the repository.
     *
     * @param spieler the Spieler to add
     */
    public void addSpieler(Spieler spieler) {
        spielerRepo.create(spieler);
    }

    /**
     * Retrieves all Spieler entities from the repository.
     *
     * @return a list of all Spielers
     */
    public List<Spieler> getSpielers() {
        return spielerRepo.getAll();
    }

    /**
     * Updates an existing Spieler in the repository.
     *
     * @param Spieler the Spieler to update
     */
    public void updateSpieler(Spieler Spieler) {
        spielerRepo.update(Spieler.getId(), Spieler);
    }

    /**
     * Deletes a Spieler entity from the repository.
     *
     * @param Spieler the Spieler to delete
     */
    public void deleteSpieler(Spieler Spieler) {
        spielerRepo.delete(Spieler.getId());
    }

    /**
     * Displays all Spielers in the repository.
     */
    public void showSpielers() {
        List<Spieler> Spielers = spielerRepo.getAll();
        Spielers.forEach(System.out::println);
    }

    /**
     * Retrieves a Spieler entity by its ID.
     *
     * @param id the ID of the Spieler
     * @return the Spieler with the specified ID
     */
    public Spieler getSpielerByID(int id) {
        return spielerRepo.read(id);
    }

    /**
     * Adds a Verein entity to the repository.
     *
     * @param Verein the Verein to add
     */
    public void addVerein(Verein Verein) {
        vereinRepo.create(Verein);
    }

    /**
     * Deletes a Verein entity from the repository.
     *
     * @param Verein the Verein to delete
     */
    public void deleteVerein(Verein Verein) {
        vereinRepo.delete(Verein.getId());
    }

    /**
     * Retrieves all Verein entities from the repository.
     *
     * @return a list of all Vereins
     */
    public List<Verein> getVereins() {
        return vereinRepo.getAll();
    }

    /**
     * Displays all Vereins in the repository.
     */
    public void showVereins() {
        List<Verein> vereins = vereinRepo.getAll();
        vereins.forEach(System.out::println);
    }

    /**
     * Updates an existing Verein in the repository.
     *
     * @param Verein the Verein to update
     */
    public void updateVerein(Verein Verein) {
        vereinRepo.update(Verein.getId(), Verein);
    }

    /**
     * Retrieves a Verein entity by its ID.
     *
     * @param id the ID of the Verein
     * @return the Verein with the specified ID
     */
    public Verein getVereinByID(int id) {
        return vereinRepo.read(id);
    }

    /**
     * Adds a Spieler to a Verein's list of Spielers.
     *
     * @param SpielerId   the ID of the Spieler
     * @param VereinID the ID of the Verein
     */
    public void addSpielerToVerein(Integer SpielerId, Integer VereinID) {
        Verein Verein = vereinRepo.read(VereinID);
        Spieler Spieler = spielerRepo.read(SpielerId);
        Verein.getSpieler().add(Spieler);
    }

    public void vereinNachStadt(String stadt){
        vereinRepo.getAll().stream()
                .filter(verein -> verein.getStadt().equals(stadt))
                .forEach(System.out::println);
    }

}

