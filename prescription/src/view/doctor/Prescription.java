package view.doctor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Prescription extends JFrame implements ActionListener{

	private JLabel[] lblMedicineName, lblCategory,lblDay, lblMeasure, lblTime, lblComments, lblAdvice;
	private JTextField[] tfMedicineName, tfComments;
	private JRadioButton[] rbtab, rbcap;
	private JComboBox[] mg_combo;
	private JComboBox[] day_combo;
	private JCheckBox[] chkbm, chkbd, chkbn;
	private JTextArea[] taAdvice, tacomments;
	private ButtonGroup bg;
	private JButton btnPres;

	private JPanel[] common, category_panel, time_panel;
	private Container c;

	public Prescription(String msg) {
		super(msg);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		c = this.getContentPane();
		setLayout(new FlowLayout());
		lblMedicineName = new JLabel[5];
		lblAdvice = new JLabel[5];
		lblCategory = new JLabel[5];
		lblDay = new JLabel[5];
		lblMeasure = new JLabel[5];
		lblTime = new JLabel[5];
		lblComments = new JLabel[5];
		lblAdvice = new JLabel[5];
		
		btnPres = new JButton("Prescriped");
		
		btnPres.addActionListener(this);
		tfMedicineName = new JTextField[5];
		tfComments = new JTextField[5];

		rbtab = new JRadioButton[5];
		rbcap = new JRadioButton[5];

		mg_combo = new JComboBox[5];
		day_combo = new JComboBox[5];
		
		chkbm = new JCheckBox[5];
		chkbd = new JCheckBox[5];
		chkbn = new JCheckBox[5];

		taAdvice = new JTextArea[5];
		tacomments = new JTextArea[5];
		
		common = new JPanel[5];
		category_panel = new JPanel[5];
		time_panel = new JPanel[5];
		
		for (int i = 0; i < 5; i++) {
			lblMedicineName[i] = new JLabel("Medicine Name: " + (i + 1));
			common[i] = new JPanel(new GridLayout(7,2,5,5));
			common[i].add(lblMedicineName[i]);

			tfMedicineName[i] = new JTextField(15);
			common[i].add(tfMedicineName[i]);

			lblCategory[i] = new JLabel("Medicine Category:");
			common[i].add(lblCategory[i]);
			
			bg = new ButtonGroup();
			rbtab[i] = new JRadioButton("Tablet");
			rbcap[i] = new JRadioButton("Capsule");
			bg.add(rbtab[i]);
			bg.add(rbcap[i]);

			category_panel[i] = new JPanel(new FlowLayout());
			category_panel[i].add(rbtab[i]);
			category_panel[i].add(rbcap[i]);

			common[i].add(category_panel[i]);
			
			lblMeasure[i] = new JLabel("Measure");
			common[i].add(lblMeasure[i]);
			mg_combo[i] = new JComboBox();
			
			for(int j=10; j<1000; j+=10) {
				mg_combo[i].addItem(j+" mg");
				common[i].add(mg_combo[i]);
			}
			
			lblDay[i] = new JLabel("Day");
			
			common[i].add(lblDay[i]);
			
			day_combo[i] = new JComboBox();
			
			for(int k = 3; k<90; k+=2) {
				day_combo[i].addItem(k+" days");
				common[i].add(day_combo[i]);
			}
			
			lblTime[i] = new JLabel("Time");
			common[i].add(lblTime[i]);
			
			time_panel[i] = new JPanel(new FlowLayout());
			chkbm[i] = new JCheckBox("Morning");
			chkbd[i] = new JCheckBox("Day");
			chkbn[i] = new JCheckBox("Night");
			
			time_panel[i].add(chkbm[i]);
			time_panel[i].add(chkbd[i]);
			time_panel[i].add(chkbn[i]);
			
			common[i].add(time_panel[i]);
			
			
			lblComments[i] = new JLabel("Comments");
			common[i].add(lblComments[i]);
			
			tacomments[i] = new JTextArea();
			JScrollPane scrollPane = new JScrollPane(tacomments[i]);
			common[i].add(scrollPane);
			
			lblAdvice[i] = new JLabel("Advice");
			common[i].add(lblAdvice[i]);
			
			
			taAdvice[i] = new JTextArea();
			JScrollPane spAdvice = new JScrollPane(taAdvice[i]);
			common[i].add(spAdvice);
			
			common[i].setBorder(new BevelBorder(BevelBorder.RAISED));
			add(common[i]);
		}
		BorderLayout b = new BorderLayout();
		c.add(btnPres, b.WEST);
	}

	public static void main(String[] args) {
		Prescription frame = new Prescription("Prescription");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		//frame.setBounds(300, 200, 500, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnPres)) {
			this.dispose();
			DoctorPatientQueue frame = new DoctorPatientQueue("Patient Queue");
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int height = screenSize.height;
			int width = screenSize.width;
			frame.setSize(width/2, height/2);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
	}

}
