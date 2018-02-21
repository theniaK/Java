import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class InputScreen extends JFrame {
	
	private JTextField nameField;
	private JButton addStudentButton;
	private JComboBox comboBox;
	private JButton printButton;
	private JPanel panel;
	private Registry registry;
	private JTextArea textArea;
	
	public InputScreen (Registry aRegistry){
		registry = aRegistry;
		addStudentButton = new JButton ("Add Student");
		printButton = new JButton ("PrintAllStudents");
		nameField = new JTextField(20);
		comboBox = new JComboBox (registry.getCourseNames());
		textArea = new JTextArea (5,20);
		panel = new JPanel();
		
		
		panel.add(nameField);
		panel.add(comboBox);
		panel.add(addStudentButton);
		panel.add(printButton);
		panel.add(textArea);

		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		addStudentButton.addActionListener(listener);
		printButton.addActionListener(listener);
		
		
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("University Registration System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource()== addStudentButton){
				String name = nameField.getText();
				Student s = new Student (name);
				String selectedCourseName = comboBox.getSelectedItem().toString();
				Course selectedCourse = registry.getCourse(selectedCourseName);
				selectedCourse.addStudent(s);
		}
			else {
				textArea.setText(registry.getCourseStudents());
			}
		}
	}

}
