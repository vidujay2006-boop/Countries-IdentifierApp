package main.exercise3;

/**
 * This class represents a Country object storing data retrieved from the REST API.
 * Encapsulation (Unit 3) is used via private fields and public getters.
 */
public class Country {

    private String name;
    private String capital;
    private long population;
    private String region;
    private String languages;

    public Country(String name, String capital, long population, String region, String languages) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.region = region;
        this.languages = languages;
    }

    // FIX: Was cut off as "public String getNa" — completed the method
    public String getName() { return name; }
    public String getCapital() { return capital; }
    public long getPopulation() { return population; }
    public String getRegion() { return region; }
    public String getLanguages() { return languages; }
}
