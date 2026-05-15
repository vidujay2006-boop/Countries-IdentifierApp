package main.exercise3;

/**
 * Unit 6 - Sets and Maps.
 * A HashSet (Unit 6) is used to store favourite countries, preventing duplicates automatically.
 */

import java.util.*;

public class FavouriteManager {

    private Set<Country> favourites = new HashSet<>();

    public void add(Country c) {
        favourites.add(c); // FIX 1: Added missing semicolon
    }

    // FIX 2: Renamed getFavourite() to getFavourites() — plural to match the Set
    public Set<Country> getFavourites() {
        return favourites;
    }
}
