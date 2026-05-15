package main.exercise3;

/**
 * Unit 9 - GUI.
 * This class uses Swing (Unit 9) to build the main GUI window.
 * Event handling (Unit 9) is used via ActionListener on the search button.
 * BorderLayout (Unit 9) is used to organise components in the window.
 */

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CountryService service = new CountryService();
    private FavouriteManager manager = new FavouriteManager();

    public MainFrame() {
        setTitle("Country Explorer");
        setSize(600, 400);
        // FIX 1: Added setDefaultCloseOperation so program exits properly when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextField input = new JTextField();
        JButton search = new JButton("Search");

        JTextArea output = new JTextArea();

        search.addActionListener(e -> {
            // FIX 2: Added try/catch so bad input shows error instead of crashing
            try {
                Country c = service.getCountry(input.getText());
                output.setText(
                    // FIX 3: Added getName() which was missing from output
                    "Name: " + c.getName() +
                    "\nCapital: " + c.getCapital() +
                    "\nPopulation: " + c.getPopulation() +
                    "\nRegion: " + c.getRegion() +
                    "\nLanguages: " + c.getLanguages()
                );
                manager.add(c);
            } catch (Exception ex) {
                output.setText("Error: Could not find country \"" + input.getText() + "\".\nPlease check the name and try again.");
            }
        });

        add(input, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
        add(search, BorderLayout.SOUTH);

        setVisible(true);
    }
}
