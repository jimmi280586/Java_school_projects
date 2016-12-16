package src.system.gui.result;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Compare extends JFrame{

	private static final long serialVersionUID = 1322513418602582531L;

	public Compare(){}
	
	public static void compareResult(JPanel display, String value){
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setText(value);// actual text
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setBounds(1, 1, 534, 1000);
		text.setFont(new Font("Arial", Font.PLAIN, 13));
		display.add(text);
		display.repaint();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 60, 534, 550);
		scrollPane.add(text);
		scrollPane.setViewportView(text);
		display.add(scrollPane);
	}
}
