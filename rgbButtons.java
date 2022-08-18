import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class rgbButtons implements ActionListener {

	private JFrame frame;
	private JPanel panel;

	public rgbButtons() {

		frame = new JFrame();
		panel = new JPanel();
		JButton button = new JButton("Red");
		JButton button2 = new JButton("Green");
		JButton button3 = new JButton("Blue");

		button.addActionListener(this::actionPerformed);
		button.setBounds(100, 100, 25, 10);

		button2.addActionListener(this::actionPerformed2);
		button2.setBounds(100, 130, 25, 10);

		button3.addActionListener(this::actionPerformed3);
		button3.setBounds(100, 160, 25, 10);

		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(button);
		panel.add(button2);
		panel.add(button3);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Red Blue Green Application");
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new rgbButtons();

	}// Main Method

	@Override
	public void actionPerformed(ActionEvent e) {
		// changes color to red
		panel.setBackground(new Color(255, 0, 0)); // Color (red pixels, green pixels, blue pixels)
	}

	public void actionPerformed2(ActionEvent e) {
		// changes color to green
		panel.setBackground(new Color(0, 255, 0));
	}

	public void actionPerformed3(ActionEvent e) {
		// changes color to blue
		panel.setBackground(new Color(0, 0, 255));
	}

}// End Of Class rgbButtons
