package pl.com.bottega.cinema.domain;

public class Cinema {

    private String city;
    private String name;

    public Cinema(String city, String name) {
        this.city = city;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cinema cinema = (Cinema) o;

        if (!city.equals(cinema.city)) return false;
        return name.equals(cinema.name);

    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 32 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "city='" + city + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
