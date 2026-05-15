package main.exercise3;

import java.awt.Graphics;

/**
 * Unit 8 – Graphics and Polymorphism.
 * This class implements the Drawable interface (Unit 7) using polymorphism (Unit 8).
 * The draw method uses 2D graphics (Unit 8) to render a population bar on screen.
 */
public class PopulationBar implements Drawable {

    private Country country;

    public PopulationBar(Country country) {
        this.country = country;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        int width = (int) (country.getPopulation() / 1_000_000); // scaling population for display
        g.fillRect(x, y, width, 20); // draw the bar
        g.drawString(country.getName(), x, y - 5); // draw the country's name above the bar
    }
}
