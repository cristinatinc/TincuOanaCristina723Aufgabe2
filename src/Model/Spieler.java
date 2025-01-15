package Model;

public class Spieler implements HasID{
    private Integer id;
    private String name;
    private Integer age;
    private String position;
    private int marktwert;

    @Override
    public String toString() {
        return "Spieler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", marktwert=" + marktwert +
                '}';
    }

    public Spieler(Integer id, String name, Integer age, String position, int marktwert) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.marktwert = marktwert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getMarktwert() {
        return marktwert;
    }

    public void setMarktwert(int marktwert) {
        this.marktwert = marktwert;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
