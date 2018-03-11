package view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import controller.DoctorManager;
import model.Admin;
import model.Doctor;

public class DoctorProfile extends JFrame implements ActionListener {

	private JLabel lblSearch, lblId, lblName, lblUsername, lblPassword, lblPhone, lblEmail, lblEducation, lblSpecialist,
			lblExperience, lblChamber;
	private JPanel crud_panel, view_panel, doctorList_panel, full_panel, search_panel, crudView_Panel;
	private JTextField tfSearch, tfId, tfName, tfUsername, tfPhone, tfEmail, tfEducation, tfExperience;
	private JTextArea taChamber;
	private JComboBox cmbxSpecialist;
	private JPasswordField tfpassword;
	private JButton btnAdd, btnEdit, btnDelete, btnSearch;
	private JTable doctorUserTable;

	private DoctorManager dm;

	public DoctorProfile(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());

		dm = new DoctorManager();

		crud_panel = new JPanel(new GridLayout(10, 1, 10, 10));
		view_panel = new JPanel(new GridLayout(10, 2, 10, 10));
		doctorList_panel = new JPanel();
		full_panel = new JPanel(new GridLayout(2, 1, 10, 10));
		search_panel = new JPanel(new GridLayout(1, 2, 20, 10));
		crudView_Panel = new JPanel(new GridLayout(1, 2, 20, 10));

		lblSearch = new JLabel("Search User:");
		lblId = new JLabel("Id:");
		lblName = new JLabel("Name:");
		lblUsername = new JLabel("Username:");
		lblPassword = new JLabel("Password:");
		lblPhone = new JLabel("Phone:");
		lblEmail = new JLabel("Email:");
		lblEducation = new JLabel("Education:");
		lblSpecialist = new JLabel("Specialist:");
		lblExperience = new JLabel("Experience:");
		lblChamber = new JLabel("Chamber:");

		tfSearch = new JTextField();
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfName = new JTextField();
		tfUsername = new JTextField();
		tfpassword = new JPasswordField();
		tfPhone = new JTextField();
		tfEmail = new JTextField();
		tfEducation = new JTextField();
		cmbxSpecialist = new JComboBox();
		cmbxSpecialist.addItem("Dentist");
		cmbxSpecialist.addItem("Medicine");
		tfExperience = new JTextField();
		taChamber = new JTextArea();

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);

		search_panel.add(tfSearch);
		search_panel.add(btnSearch);

		crud_panel.add(lblSearch);
		crud_panel.add(search_panel);
		crud_panel.add(btnAdd);
		crud_panel.add(btnEdit);
		crud_panel.add(btnDelete);
		crud_panel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "User Create, Read, Update and Delete"));

		view_panel.add(lblId);
		view_panel.add(tfId);
		view_panel.add(lblName);
		view_panel.add(tfName);
		view_panel.add(lblUsername);
		view_panel.add(tfUsername);
		view_panel.add(lblPassword);
		view_panel.add(tfpassword);
		view_panel.add(lblPhone);
		view_panel.add(tfPhone);
		view_panel.add(lblEmail);
		view_panel.add(tfEmail);
		view_panel.add(lblEducation);
		view_panel.add(tfEducation);
		view_panel.add(lblSpecialist);
		view_panel.add(cmbxSpecialist);
		view_panel.add(lblExperience);
		view_panel.add(tfExperience);
		view_panel.add(lblChamber);
		view_panel.add(taChamber);

		view_panel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "User Information"));

		crudView_Panel.add(crud_panel);
		crudView_Panel.add(view_panel);
		full_panel.add(crudView_Panel);

		doctorList_panel.setLayout(new BorderLayout());
		doctorList_panel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "User List"));
		String[] columns = { "Id", "Name", "Username", "Password", "Phone", "Email", "Education", "Specialist",
				"Experience", "Chamber" };
		Object[][] data = dm.getDoctorUserList();
		doctorUserTable = new JTable(data, columns);
		doctorList_panel.add(doctorUserTable.getTableHeader(), BorderLayout.NORTH);
		doctorList_panel.add(doctorUserTable, BorderLayout.CENTER);
		doctorUserTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
			}

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				TableModel model = doctorUserTable.getModel();
				tfId.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 0).toString());
				tfName.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 1).toString());
				tfUsername.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 2).toString());
				tfpassword.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 3).toString());
				tfPhone.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 4).toString());
				tfEmail.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 5).toString());
				tfEducation.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 6).toString());
				cmbxSpecialist.setSelectedItem(model.getValueAt(doctorUserTable.getSelectedRow(), 7).toString());
				tfExperience.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 8).toString());
				taChamber.setText(model.getValueAt(doctorUserTable.getSelectedRow(), 9).toString());
			}
		});
		full_panel.add(doctorList_panel);

		add(full_panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd)) {
			String name = tfName.getText().toString();
			String username = tfUsername.getText().toString();
			String password = tfpassword.getText().toString();
			String phone = tfPhone.getText().toString();
			String email = tfEmail.getText().toString();
			String education = tfEducation.getText().toString();
			String specialist = cmbxSpecialist.getSelectedItem().toString();
			String experience = tfExperience.getText().toString();
			String chamber = taChamber.getText().toString();

			if (username.equals("") && password.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Fillup blank field");
			} else {

				boolean isExist = dm.isUserExist(username);
				if (!isExist) {
					Doctor doctor = new Doctor(name, username, password, phone, email, education, specialist,
							experience, chamber);
					boolean isInserted = dm.insert(doctor);
					if (isInserted) {
						JOptionPane.showMessageDialog(this, "Doctor user is created");
						this.dispose();
						DoctorProfile frame = new DoctorProfile("Doctor - Profile");
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "Doctor user is not created");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Your username is already exist");
				}
			}
		} else if (e.getSource().equals(btnEdit)) {
			int id = Integer.parseInt(tfId.getText().toString());
			String name = tfName.getText().toString();
			String username = tfUsername.getText().toString();
			String password = tfpassword.getText().toString();
			String phone = tfPhone.getText().toString();
			String email = tfEmail.getText().toString();
			String education = tfEducation.getText().toString();
			String specialist = cmbxSpecialist.getSelectedItem().toString();
			String experience = tfExperience.getText().toString();
			String chamber = taChamber.getText().toString();

			Doctor doctor = new Doctor(id, name, username, password, phone, email, education, specialist, experience,
					chamber);
			boolean isUpdated = dm.update(doctor);
			if (isUpdated) {
				JOptionPane.showMessageDialog(this, "Doctor user is updated");
				this.dispose();
				DoctorProfile frame = new DoctorProfile("Doctor - Profile");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Admin user is not updated");
			}

		} else if (e.getSource().equals(btnDelete)) {
			int id = Integer.parseInt(tfId.getText().toString());
			String name = tfName.getText().toString();
			String username = tfUsername.getText().toString();
			String password = tfpassword.getText().toString();
			String phone = tfPhone.getText().toString();
			String email = tfEmail.getText().toString();
			String education = tfEducation.getText().toString();
			String specialist = cmbxSpecialist.getSelectedItem().toString();
			String experience = tfExperience.getText().toString();
			String chamber = taChamber.getText().toString();

			Doctor doctor = new Doctor(id, name, username, password, phone, email, education, specialist, experience,
					chamber);

			boolean isDeleted = dm.delete(doctor);
			if (isDeleted) {
				JOptionPane.showMessageDialog(this, "Doctor user is deleted");
				this.dispose();
				DoctorProfile frame = new DoctorProfile("Doctor - Profile");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Dcotor user is not deleted");
			}
		} else if (e.getSource().equals(btnSearch)) {
			int id = Integer.parseInt(tfSearch.getText().toString());
			Doctor doctor = dm.searchById(id);
			if (doctor != null) {
				tfId.setText("" + doctor.getId());
				tfName.setText(doctor.getName());
				tfUsername.setText(doctor.getUsername());
				tfpassword.setText(doctor.getPassword());
				tfPhone.setText(doctor.getPhone());
				tfEmail.setText(doctor.getEmail());
				tfEducation.setText(doctor.getEducation());
				cmbxSpecialist.setSelectedItem(doctor.getSpecialist());
				tfExperience.setText(doctor.getExperience());
				taChamber.setText(doctor.getChamber());
			} else {
				JOptionPane.showMessageDialog(this, "Dcotor user is not found");
			}
		}
	}

	public static void main(String[] args) {
		DoctorProfile frame = new DoctorProfile("Doctor - Profile");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
