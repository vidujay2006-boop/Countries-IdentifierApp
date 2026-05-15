package main.exercise3;

/**
 * Units 4 & 5 – API calls and String processing.
 * This class handles fetching country data from the REST API and parsing it.
 */
public class CountryService {

    private RestCountriesWrapper rcw = new RestCountriesWrapper();

    public Country getCountry(String name) {

        String data = null;

        // FIX 1: Wrapped API call in try/catch — getCountryByName throws a checked Exception
        try {
            data = rcw.getCountryByName(name, "name,capital,population,region,languages");
        } catch (Exception e) {
            System.err.println("API call failed for: " + name);
            e.printStackTrace();
            return null;
        }

        // FIX 2: Added null/empty check before processing
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("No data returned for country: " + name);
        }

        String capital = extract(data, "capital");
        String region = extract(data, "region");
        String languages = extract(data, "languages");

        // FIX 3: Wrapped parseLong in try/catch to handle non-numeric population
        long population = 0;
        try {
            population = Long.parseLong(extract(data, "population"));
        } catch (NumberFormatException e) {
            System.err.println("Could not parse population for: " + name);
        }

        return new Country(name, capital, population, region, languages);
    }

    private String extract(String data, String field) {
        int fieldIndex = data.indexOf(field);

        // FIX 4: Return "N/A" if field not found instead of crashing
        if (fieldIndex == -1) {
            return "N/A";
        }

        int start = fieldIndex + field.length() + 3;

        // FIX 5: Search for "}" as well as "," — last field has no trailing comma
        int endComma = data.indexOf(",", start);
        int endBrace = data.indexOf("}", start);

        int end;
        if (endComma == -1 && endBrace == -1) {
            return "N/A";
        } else if (endComma == -1) {
            end = endBrace;
        } else if (endBrace == -1) {
            end = endComma;
        } else {
            end = Math.min(endComma, endBrace);
        }

        return data.substring(start, end)
                .replaceAll("[\"}]", "")
                .trim();
    }
}
