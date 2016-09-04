package pl.com.bottega.cinema.domain;

public class Cinema {

    private String city;
    private String name;

    public Cinema(String city, String name) {
        this.city = city;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "city='" + city + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
