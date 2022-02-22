package numberguess;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public abstract class Main extends JFrame implements ActionListener {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Number Guesser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("File");
		JMenu m2 = new JMenu("Help");
		JMenu m3 = new JMenu("About");
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);

		JPanel panel = new JPanel(); // the panel is not visible in output
		JLabel label = new JLabel("Enter Number");
		JTextField tf = new JTextField(3);// accepts up to 10 characters
		JTextArea ta = new JTextArea();
		frame.getContentPane().add(BorderLayout.CENTER, ta);
		
		JButton guess = new JButton("Guess");
		guess.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == guess) {
					String sguess = tf.getText();

					try {
						Random rand = new Random();
						int upperbound = 101;
						int intRand = rand.nextInt(upperbound);

						int guess = Integer.parseInt(sguess);
						if (guess == intRand) {
							
							ta.setText("Correct!");
							
							return;
						} else {
							
							ta.setText("Wrong!" + "\n" + "Correct Answer: " + intRand);
						}
					} catch (NumberFormatException ex) {
						ex.printStackTrace();
					}

				}

			}

		});

		panel.add(label); // Components Added using Flow Layout
		panel.add(tf);
		panel.add(guess);

		// Adding Components to the frame.
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.setVisible(true);

	}

}
