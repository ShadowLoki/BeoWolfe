package edu.apcs.control;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ControlWindow extends JFrame{
	
	private JButton button;
	private JLabel label;
	private JSlider slider;
	
	public ControlWindow() {
		super("Control Window");
		button = new JButton("Button");
		label = new JLabel("Ping Pong");
		slider = new JSlider(0, 100);
		
		this.setSize(400, 400);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button.setVerticalAlignment((int) JButton.RIGHT_ALIGNMENT);
		
		add(button);
		add(label);
		
		bindActions();
	}
	
	public void bindActions() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText("This is Ping Pong");
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ControlWindow().setVisible(true);
			}
		});
	}
}
