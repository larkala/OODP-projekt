package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class CourseMomentFrame extends JFrame{

	JCheckBox exam, project, assignment;
	JPanel roomPanel, lastDatePanel, examDatePanel, examGradePanel;
	JPanel examPanel, assignmentPanel, projectPanel;
	JTextField roomField;
	JDateChooser lastAppDateField, examDateField;
	JComboBox examGradeField, assignmentGradeField, projectGradeField;
	GridLayout g = new GridLayout(1,2);
	String[] grades1 = {"--", "A","B","C","D","E"};
	String[] grades2 = {"U","G"};
	GridBagConstraints gbc = new GridBagConstraints();
	
	 public CourseMomentFrame() {
		 
		 JPanel checkBoxPanel = new JPanel();
		 checkBoxPanel.setLayout(new GridLayout(1,3));
		 
		 exam = new JCheckBox("Tenta");
		 project = new JCheckBox("Projekt");
		 assignment = new JCheckBox("Inlämmningsuppgifter");
		 
		 checkBoxPanel.add(exam);
		 checkBoxPanel.add(project);
		 checkBoxPanel.add(assignment);
		 
		 setLayout(new GridBagLayout());

		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridx = 0;
		 gbc.insets = new Insets(10, 0, 10, 0);

		 ///////////////Tentaflik/////////
		 
		 examPanel = new JPanel();
		 examPanel.setLayout(new GridLayout(4,1));
		 
		 roomPanel = new JPanel();
		 roomPanel.setLayout(g);
		 roomField = new JTextField();
		 JLabel roomLabel = new JLabel("Tentamenssal: ");
		 roomPanel.add(roomLabel);
		 roomPanel.add(roomField);
		 
		 lastDatePanel = new JPanel();
		 lastDatePanel.setLayout(g);
		 lastAppDateField = new JDateChooser();
		 JLabel lastAppDateLabel = new JLabel("Sista anmälningsdatum: ");
		 lastDatePanel.add(lastAppDateLabel);
		 lastDatePanel.add(lastAppDateField);
		 
		 examDatePanel = new JPanel();
		 examDatePanel.setLayout(g);
		 examDateField = new JDateChooser();
		 JLabel examDateLabel = new JLabel("Tentamendatum: ");
		 examDatePanel.add(examDateLabel);
		 examDatePanel.add(examDateField);
		 
		 examGradePanel = new JPanel();
		 examGradePanel.setLayout(g);
		 examGradeField = new JComboBox(grades1);
		 JLabel examGradeLabel = new JLabel("Tentabetyg: ");
		 examGradePanel.add(examGradeLabel);
		 examGradePanel.add(examGradeField);
		 
		 examPanel.add(examDatePanel);
		 examPanel.add(roomPanel);
		 examPanel.add(lastDatePanel);
		 examPanel.add(examGradePanel);
		 
		 ////////////////Inluppflik///////////////////////////
		 
		 assignmentPanel = new JPanel();
		 assignmentPanel.setLayout(new GridLayout(1, 1));
		 assignmentGradeField = new JComboBox(grades2);
		 JLabel assignmentLabel = new JLabel("Inlämningsuppgiftsbetyg (för hela momentet): ");
		 assignmentPanel.add(assignmentLabel);
		 assignmentPanel.add(assignmentGradeField);
		 
		 ///////////////projektflik////////////////////////
		 
		 projectPanel = new JPanel();
		 projectPanel.setLayout(new GridLayout(1, 1));
		 projectGradeField = new JComboBox(grades1);
		 JLabel projectLabel = new JLabel("Projektbetyg: ");
		 projectPanel.add(projectLabel);
		 projectPanel.add(projectGradeField);
		 
		 /////////////////////////////////////////////
		 ItemListener l = new BoxListener();
		 
		 exam.addItemListener(l);
		 project.addItemListener(l);
		 assignment.addItemListener(l);
		 add(checkBoxPanel,gbc);
		 
	}
	 
	 private class BoxListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(exam.isSelected())
				add(examPanel,gbc);
			if(assignment.isSelected())
				add(assignmentPanel,gbc);
			if(project.isSelected()) 
				add(projectPanel,gbc);
			if(!exam.isSelected())
				remove(examPanel);
			if(!assignment.isSelected()) 
				remove(assignmentPanel);
			if(!project.isSelected())
				remove(projectPanel);
			revalidate();
			repaint();
		}
		 
	 }
	
}
