package hogerlager;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HogerLagerApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private final int myNrToGuess = new Random().nextInt(10) +1;
    private  final JTextField myJTextField = new JTextField();
    private final JButton myJButton = new JButton("Guess");
    private int myTurns;

    HogerLagerApp() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(myJTextField, BorderLayout.NORTH);
        add(myJButton, BorderLayout.SOUTH);
        myJButton.addActionListener(event -> myGuess() );
        pack();
    }

    private void myGuess() {
        myTurns++;
        try {
            int inputNr = Integer.parseInt(myJTextField.getText());
            if (inputNr == myNrToGuess) {
                JOptionPane.showMessageDialog(this, "Found in " + myTurns + " turns.");
            } else {
                JOptionPane.showMessageDialog(this, inputNr < myNrToGuess ? "Higher" : "Lower");
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Enter a number.");
        }
    }

    public static void main(String[] args) {
        new HogerLagerApp().setVisible(true);
    }
}
