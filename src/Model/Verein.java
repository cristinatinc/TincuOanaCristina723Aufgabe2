package Model;

import java.util.ArrayList;
import java.util.List;

public class Verein implements HasID{
    private Integer id;
    private String name;
    private String stadt;
    private List<Spieler> spieler;

    @Override
    public String toString() {
        return "Verein{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadt='" + stadt + '\'' +
                ", spieler=" + spieler +
                '}';
    }

    public Verein(Integer id, String name, String stadt) {
        this.id = id;
        this.name = name;
        this.stadt = stadt;
        this.spieler = new ArrayList<Spieler>();
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public List<Spieler> getSpieler() {
        return spieler;
    }

    public void setSpieler(List<Spieler> spieler) {
        this.spieler = spieler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return 0;
    }
}
