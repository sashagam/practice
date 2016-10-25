package fruitEntity;


import javax.persistence.*;

@Entity(name = "fruit")
@NamedQueries({
        @NamedQuery( name = "Fruit.getAll", query = "SELECT f FROM fruit f")
})
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "calories", nullable = false)
    private double calories;

    public Fruit(){
    }

    public Fruit(String name, String color, double calories) {
        this.name = name;
        this.color = color;
        this.calories = calories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
