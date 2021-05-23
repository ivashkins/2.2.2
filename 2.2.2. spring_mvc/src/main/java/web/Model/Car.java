package web.Model;

public class Car {
    private String model;
    private String series;
    private int age;

    public Car(String model, String series, int age) {
        this.model = model;
        this.series = series;
        this.age = age;
    }

    @Override
    public String toString() {
        return  model  +
                " " + series  +
                " : age=" + age ;
    }
}
