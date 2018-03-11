package view.common;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.AdminManager;
import controller.DoctorManager;
import controller.PatientManager;
import view.admin.Dashboard;
import view.doctor.DoctorDashboard;
import view.patient.PatientQueue;

public class LoginForm extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblEmailMobile, lblPassword, lblRole;
	private JTextField tfEmailMobile;
	private JPasswordField tfPassword;
	private JButton btnLogin, btnClear;
	private JPanel common;
	private JComboBox cmbxRole;

	private AdminManager am;
	private PatientManager pm;
	private DoctorManager dm;
	private PatientQueue pq;
	
	private String username = null;
	private String password = null;

	public LoginForm(String msg) {
		super(msg);

		// data
		am = new AdminManager();
		pm = new PatientManager();
		dm = new DoctorManager();
		pq = new PatientQueue();
		// UI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		lblEmailMobile = new JLabel("Username or Mobile");
		lblPassword = new JLabel("Password");
		lblRole = new JLabel("Select Role");
		tfEmailMobile = new JTextField(12);
		tfPassword = new JPasswordField(12);
		cmbxRole = new JComboBox();
		cmbxRole.addItem("Admin");
		cmbxRole.addItem("Doctor");
		cmbxRole.addItem("Pharmacist");
		cmbxRole.addItem("Patient");

		btnClear = new JButton("Clear");
		btnLogin = new JButton("Login");
		common = new JPanel(new GridLayout(4, 2, 20, 20));
		common.add(lblEmailMobile);
		common.add(tfEmailMobile);
		common.add(lblPassword);
		common.add(tfPassword);
		common.add(lblRole);
		common.add(cmbxRole);
		common.add(btnClear);
		common.add(btnLogin);
		// common.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "Login
		// User"));
		add(common);

		// setAction
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		username = tfEmailMobile.getText().toString();
		password = tfPassword.getText().toString();
		String role = cmbxRole.getSelectedItem().toString();

		if (role.equals("Admin")) {
			
			if (e.getSource().equals(btnLogin)) {
				if (am.isUsernamePassword(username, password)) {
					Dashboard frame = new Dashboard("Dashboard - Admin");
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screenSize.height;
					int width = screenSize.width;
					frame.setSize(width / 2, height / 2);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Username or password incorrect!!!");
				}
			}
		}else if(role.equals("Doctor")) {
			if (e.getSource().equals(btnLogin)) {
				if (dm.isUsernamePassword(username, password)) {
					DoctorDashboard frame = new DoctorDashboard("Dashboard");
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screenSize.height;
					int width = screenSize.width;
					frame.setSize(width/2, height/2);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Username or password incorrect!!!");
				}
			}
		}else if(role.equals("Pharmacist")) {
			
		}else if(role.equals("Patient")) {
			if (e.getSource().equals(btnLogin)) {
				if (pm.isUsernamePassword(username, password)) {
					PatientQueue frame = new PatientQueue("Patient Queue");
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screenSize.height;
					int width = screenSize.width;
					frame.setSize(width/2, height/2);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Username or password incorrect!!!");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginForm frame = new LoginForm("Login Form");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width / 3, height / 4);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
