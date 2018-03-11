package view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import controller.AdminManager;
import model.Admin;

public class AdminProfile extends JFrame implements ActionListener {

	private JLabel lblSearch, lblId, lblName, lblPassword, lblStatus;
	private JPanel crud_panel, view_panel, adminList_panel, full_panel, search_panel;
	private JTextField tfSearch, tfId, tfName;
	private JComboBox cmbxStatus;
	private JPasswordField tfpassword;
	private JButton btnAdd, btnEdit, btnDelete, btnSearch;
	JTable adminUserTable;

	private AdminManager am;

	public AdminProfile(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());

		am = new AdminManager();

		crud_panel = new JPanel(new GridLayout(15, 1, 10, 10));
		view_panel = new JPanel(new GridLayout(15, 1, 10, 10));
		adminList_panel = new JPanel();
		full_panel = new JPanel(new GridLayout(1, 3, 10, 10));
		search_panel = new JPanel(new GridLayout(1, 2, 20, 10));

		lblSearch = new JLabel("Search User:");
		lblId = new JLabel("Id:");
		lblName = new JLabel("Username:");
		lblPassword = new JLabel("Password:");
		lblStatus = new JLabel("Status:");

		tfSearch = new JTextField(15);

		tfId = new JTextField();
		tfId.setEnabled(false);
		tfName = new JTextField();
		tfpassword = new JPasswordField();
		cmbxStatus = new JComboBox();
		cmbxStatus.addItem("Active");
		cmbxStatus.addItem("Inactive");

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
		view_panel.add(lblPassword);
		view_panel.add(tfpassword);
		view_panel.add(lblStatus);
		view_panel.add(cmbxStatus);
		view_panel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "User Information"));

		full_panel.add(crud_panel);
		full_panel.add(view_panel);

		adminList_panel.setLayout(new BorderLayout());
		adminList_panel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "User List"));
		String[] columns = { "Id", "Name", "Password", "Status" };
		Object[][] data = am.getAdminUserList();
		adminUserTable = new JTable(data, columns);
		adminList_panel.add(adminUserTable.getTableHeader(), BorderLayout.NORTH);
		adminList_panel.add(adminUserTable, BorderLayout.CENTER);
		adminUserTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {}
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				TableModel model = adminUserTable.getModel();
				tfId.setText(model.getValueAt(adminUserTable.getSelectedRow(), 0).toString());
				tfName.setText(model.getValueAt(adminUserTable.getSelectedRow(), 1).toString());
				tfpassword.setText(model.getValueAt(adminUserTable.getSelectedRow(), 2).toString());
				cmbxStatus.setSelectedItem(model.getValueAt(adminUserTable.getSelectedRow(), 3).toString());
			}
		});
		full_panel.add(adminList_panel);
		
		add(full_panel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd)) {
			String txt_username = tfName.getText().toString();
			String txt_password = tfpassword.getText().toString();
			String txt_status = cmbxStatus.getSelectedItem().toString();

			if (txt_username.equals("") && txt_password.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Fillup blank field");
			} else {

				boolean isExist = am.isUserExist(txt_username);
				if (!isExist) {
					Admin txt_admin = new Admin(txt_username, txt_password, txt_status);
					boolean isInserted = am.insertAdminUser(txt_admin);
					if (isInserted) {
						JOptionPane.showMessageDialog(this, "Admin user is created");
						this.dispose();
						DoctorProfile frame = new DoctorProfile("Admin - Profile");
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "Admin user is not created");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Your username is already exist");
				}
			}
		} else if (e.getSource().equals(btnEdit)) {
			int id = Integer.parseInt(tfId.getText().toString());
			String txt_username = tfName.getText().toString();
			String txt_password = tfpassword.getText().toString();
			String txt_status = cmbxStatus.getSelectedItem().toString();
			Admin admin = new Admin(id, txt_username, txt_password, txt_status);
			boolean isUpdated = am.update(admin);
			if (isUpdated) {
				JOptionPane.showMessageDialog(this, "Admin user is updated");
				this.dispose();
				DoctorProfile frame = new DoctorProfile("Admin - Profile");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Admin user is not updated");
			}
		} else if (e.getSource().equals(btnDelete)) {
			int id = Integer.parseInt(tfId.getText().toString());
			String txt_username = tfName.getText().toString();
			String txt_password = tfpassword.getText().toString();
			String txt_status = cmbxStatus.getSelectedItem().toString();
			Admin admin = new Admin(id, txt_username, txt_password, txt_status);
			boolean isDeleted = am.delete(admin);
			if (isDeleted) {
				JOptionPane.showMessageDialog(this, "Admin user is deleted");
				this.dispose();
				DoctorProfile frame = new DoctorProfile("Admin - Profile");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Admin user is not deleted");
			}
		} else if (e.getSource().equals(btnSearch)) {
			int id = Integer.parseInt(tfSearch.getText().toString());
			Admin admin = am.searchById(id);
			if (admin != null) {
				tfId.setText("" + admin.getId());
				tfName.setText(admin.getName());
				tfpassword.setText(admin.getPassword());
				cmbxStatus.setSelectedItem(admin.getStatus());
			} else {
				JOptionPane.showMessageDialog(this, "Admin user is not found");
			}
		}
	}

	public static void main(String[] args) {
		AdminProfile frame = new AdminProfile("Admin - Profile");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
