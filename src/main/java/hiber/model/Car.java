package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;



    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public Car() {

    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
               "id=" + id +
               ", series=" + series +
               ", model='" + model + '\'' +
               '}';
    }
}
