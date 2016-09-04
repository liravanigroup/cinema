package pl.com.bottega.cinema.domain;

public class Cinema {

    private String city;
    private String name;

    public Cinema() {
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                '}';
    }
}
