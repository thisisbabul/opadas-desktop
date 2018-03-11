package view.patient;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.PatientManager;
import model.Patient;
import view.common.LoginForm;

public class PatientInfo extends JFrame implements ActionListener{

	private JLabel lblName, lblAddress, lblMobile, lblRefPerson;
	private JTextField tfName, tfMobile, tfRefPerson;
	private JTextArea taAddress;
	
	private JButton btnTakeAppointment, btnClear;
	private JPanel c;
	private GridLayout gridLayout;
	private PatientManager pm;
	
	public PatientInfo(String msg) {
		super(msg);
		initComponents();	
	}
	
	private void initComponents() {
		setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              
        pm = new PatientManager();
        
        lblName = new JLabel("Name:");  
        lblAddress = new JLabel("Address:");
        lblMobile = new JLabel("Mobile:");
        lblRefPerson = new JLabel("Reference Person:");
       
        
        tfName = new JTextField(15);
        taAddress = new JTextArea(2,2);
        JScrollPane scrollPane = new JScrollPane(taAddress);
        
        tfMobile = new JTextField(15);
        tfRefPerson = new JTextField(11);
        
        btnTakeAppointment = new JButton("Take Appointment");
        btnClear = new JButton("Clear");
        
        c = new JPanel(new GridLayout(5,2,10,10));
        
        c.add(lblName);
        c.add(tfName);
        c.add(lblAddress);
        c.add(scrollPane);
        c.add(lblMobile);
        c.add(tfMobile);
        c.add(lblRefPerson);
        c.add(tfRefPerson);
        c.add(btnClear);
        c.add(btnTakeAppointment);
        
        add(c);
        
        btnTakeAppointment.addActionListener(this);
        btnClear.addActionListener(this);
    }
	
	public static void main(String[] args) {
		PatientInfo frame = new PatientInfo("Patient Information");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnTakeAppointment)) {
			String name = tfName.getText().toString();
			String address = taAddress.getText().toString();
			String mobile = tfMobile.getText().toString();
			String refperson = tfRefPerson.getText().toString();
			Random rand = new Random();
	        String password = String.valueOf(rand.nextInt(1000));
	        
			Patient patient = new Patient(name, address, mobile, password, refperson);
			
			boolean isInserted = pm.insert(patient);
			
			if(isInserted) {
				JOptionPane.showMessageDialog(this, "User is created\nUsername is "+mobile+" and password is "+password);
				LoginForm frame = new LoginForm("Login Form");
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int height = screenSize.height;
				int width = screenSize.width;
				frame.setSize(width / 3, height / 4);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "User is not created");
			}
		}
	}

}
