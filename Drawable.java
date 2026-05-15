package main.exercise3;

import java.awt.Graphics;

/**
 * Unit 7 – Interface for drawable objects.
 * An interface (Unit 7) is used here to define a contract for all drawable components.
 */
public interface Drawable {
    void draw(Graphics g, int x, int y);
}
