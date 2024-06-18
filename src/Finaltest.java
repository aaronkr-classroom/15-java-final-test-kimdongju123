import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finaltest extends JFrame implements ActionListener {
private JTextField display;
private String operator;
private double num1, num2, result;
	
public Finaltest () {
	setTitle("Finaltest");
	setSize(400, 600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	JMenuBar menuBar = new JMenuBar();
	
	JMenu fileMenu = new JMenu("File");
	JMenu editMenu = new JMenu("Edit");
	JMenu helpMenu = new JMenu("Help");
	
	JMenuItem newfileItem = new JMenuItem("New");
	JMenuItem openfileItem = new JMenuItem("Open");
	JMenuItem exitItem = new JMenuItem("Exit");
	
	fileMenu.add(newfileItem);
	fileMenu.add(openfileItem);
	fileMenu.add(exitItem);
	
	JMenuItem copyItem = new JMenuItem("Copy");
	JMenuItem pasteItem = new JMenuItem("paste");
	
	editMenu.add(copyItem);
	editMenu.add(pasteItem);
	
	JMenuItem aboutItem = new JMenuItem("About");
	
	helpMenu.add(aboutItem);
	
	menuBar.add(fileMenu);
	menuBar.add(editMenu);
	menuBar.add(helpMenu);
	
	setJMenuBar(menuBar);
	
	display = new JTextField();
	display.setFont(new Font("Arial", Font.PLAIN, 24));
	display.setHorizontalAlignment(JTextField.RIGHT);
	display.setEditable(false);

	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(5, 4, 10, 10));
	
	String[] buttonLabels = {
			"7","8","9","/",
			"4","5","6","*",
			"1","2","3","-",
			"0",".","=","+",
			"c"
			
	};
	
	for(String label : buttonLabels) {
		JButton button = new JButton(label);
		button.setFont(new Font("Arial", Font.PLAIN, 24));
		button.addActionListener(this);
		panel.add(button);
	}
	add(display, BorderLayout.NORTH);
	add(panel);
	
	setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	String command = e.getActionCommand();
	
	if(command.charAt(0) == 'C') {
		display.setText("");
		num1 = num2 = result =0;
		operator = "";
	}else if (command.charAt(0) == '=') {
		num2 = Double.parseDouble(display.getText());
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case"-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		display.setText(String.valueOf(result));
		num1 = result;
	}else if (command.charAt(0) == '/' || command.charAt(0) == '*' ||
			command.charAt(0) == '-' || command.charAt(0) == '+') {
		operator = command;
		num1 = Double.parseDouble(display.getText());
		display.setText("");
		
	}else {
		display.setText(display.getText()+ command);
	}
}

public static void main(String[]args) {
	new Finaltest();
}
	
}
