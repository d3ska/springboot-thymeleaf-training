package pl.deska.springbootthymeleaf.model;

import java.util.Objects;

public class Car {

    private Long id;
    private String mark;
    private String model;

    public Car(Long id, String mark, String model) {
        this.id = id;
        this.mark = mark;
        this.model = model;
    }


    public Car() {
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public boolean isEmpty(){
        if(mark.isEmpty() || model.isEmpty() || mark.isBlank() || model.isBlank() || id == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(mark.toLowerCase(), car.mark.toLowerCase()) &&
                Objects.equals(model.toLowerCase(), car.model.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model);
    }
}
