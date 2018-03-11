package view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
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

import controller.PharmacyManager;
import model.Doctor;
import model.Pharmacy;

public class PharmacyProfile extends JFrame implements ActionListener {

	private JLabel lblSearch, lblId, lblName, lblUsername, lblPassword, lblPhone, lblAddress;
	private JPanel crud_panel, view_panel, phamacyUserList_pannel, full_panel, search_panel, crudView_Panel;
	private JTextField tfSearch, tfId, tfName, tfUsername, tfPhone;
	private JTextArea taAddress;
	private JPasswordField tfpassword;
	private JButton btnAdd, btnEdit, btnDelete, btnSearch;
	private JTable pharmacyUserTable;

	private PharmacyManager pm;

	public PharmacyProfile(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());

		pm = new PharmacyManager();

		crud_panel = new JPanel(new GridLayout(10, 1, 10, 10));
		view_panel = new JPanel(new GridLayout(10, 2, 10, 10));
		phamacyUserList_pannel = new JPanel();
		full_panel = new JPanel(new GridLayout(2, 1, 10, 10));
		search_panel = new JPanel(new GridLayout(1, 2, 20, 10));
		crudView_Panel = new JPanel(new GridLayout(1, 2, 20, 10));

		lblSearch = new JLabel("Search User:");
		lblId = new JLabel("Id:");
		lblName = new JLabel("Name:");
		lblUsername = new JLabel("Username:");
		lblPassword = new JLabel("Password:");
		lblPhone = new JLabel("Phone:");
		lblAddress = new JLabel("Address:");

		tfSearch = new JTextField();
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfName = new JTextField(15);
		tfUsername = new JTextField();
		tfpassword = new JPasswordField();
		tfPhone = new JTextField();
		taAddress = new JTextArea();

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
		view_panel.add(lblAddress);
		view_panel.add(taAddress);
		view_panel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "User Information"));

		crudView_Panel.add(crud_panel);
		crudView_Panel.add(view_panel);
		full_panel.add(crudView_Panel);

		phamacyUserList_pannel.setLayout(new BorderLayout());
		phamacyUserList_pannel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "User List"));
		String[] columns = { "Id", "Name", "Username", "Password", "Phone", "Address" };
		Object[][] data = pm.getPharmacyUserList();
		pharmacyUserTable = new JTable(data, columns);
		phamacyUserList_pannel.add(pharmacyUserTable.getTableHeader(), BorderLayout.NORTH);
		phamacyUserList_pannel.add(pharmacyUserTable, BorderLayout.CENTER);
		pharmacyUserTable.addMouseListener(new MouseListener() {
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
				TableModel model = pharmacyUserTable.getModel();
				tfId.setText(model.getValueAt(pharmacyUserTable.getSelectedRow(), 0).toString());
				tfName.setText(model.getValueAt(pharmacyUserTable.getSelectedRow(), 1).toString());
				tfUsername.setText(model.getValueAt(pharmacyUserTable.getSelectedRow(), 2).toString());
				tfpassword.setText(model.getValueAt(pharmacyUserTable.getSelectedRow(), 3).toString());
				tfPhone.setText(model.getValueAt(pharmacyUserTable.getSelectedRow(), 4).toString());
				taAddress.setText(model.getValueAt(pharmacyUserTable.getSelectedRow(), 5).toString());
			}
		});
		full_panel.add(phamacyUserList_pannel);

		add(full_panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd)) {
			String name = tfName.getText().toString();
			String username = tfUsername.getText().toString();
			String password = tfpassword.getText().toString();
			String phone = tfPhone.getText().toString();
			String address = taAddress.getText().toString();

			if (username.equals("") && password.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Fillup blank field");
			} else {

				boolean isExist = pm.isUserExist(username);
				if (!isExist) {
					Pharmacy pharmacy = new Pharmacy(name, username, password, phone, address);
					boolean isInserted = pm.insert(pharmacy);
					if (isInserted) {
						JOptionPane.showMessageDialog(this, "Pharmacy user is created");
						this.dispose();
						PharmacyProfile frame = new PharmacyProfile("Pharmacy - Profile");
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "Pharmacy user is not created");
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
			String address = taAddress.getText().toString();

			Pharmacy pharmacy = new Pharmacy(id, name, username, password, phone, address);
			boolean isUpdated = pm.update(pharmacy);
			if (isUpdated) {
				JOptionPane.showMessageDialog(this, "Pharmacy user is updated");
				this.dispose();
				PharmacyProfile frame = new PharmacyProfile("Pharmacy - Profile");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Pharmacy user is not updated");
			}

		} else if (e.getSource().equals(btnDelete)) {
			int id = Integer.parseInt(tfId.getText().toString());
			String name = tfName.getText().toString();
			String username = tfUsername.getText().toString();
			String password = tfpassword.getText().toString();
			String phone = tfPhone.getText().toString();
			String address = taAddress.getText().toString();

			Pharmacy pharmacy = new Pharmacy(id, name, username, password, phone, address);

			boolean isDeleted = pm.delete(pharmacy);
			if (isDeleted) {
				JOptionPane.showMessageDialog(this, "Pharmacy user is deleted");
				this.dispose();
				PharmacyProfile frame = new PharmacyProfile("Pharmacy - Profile");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Pharmacy user is not deleted");
			}
		} else if (e.getSource().equals(btnSearch)) {
			int id = Integer.parseInt(tfSearch.getText().toString());
			Pharmacy pharmacy = pm.searchById(id);
			if (pharmacy != null) {
				tfId.setText("" + pharmacy.getId());
				tfName.setText(pharmacy.getName());
				tfUsername.setText(pharmacy.getUsername());
				tfpassword.setText(pharmacy.getPassword());
				tfPhone.setText(pharmacy.getPhone());
				taAddress.setText(pharmacy.getAddress());

			} else {
				JOptionPane.showMessageDialog(this, "Pharmacy user is not found");
			}
		}
	}

	public static void main(String[] args) {
		PharmacyProfile frame = new PharmacyProfile("Pharmacy - Profile");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
