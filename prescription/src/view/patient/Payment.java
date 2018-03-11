package view.patient;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Payment extends JFrame{

	private JLabel lblNameOnCard, lblCardNumber, lblExpriation, lblCardCode;
	private JTextField tfNameOnCard, tfCardNumber, tfExpriation, tfCardCode;
	private JButton btnCheckout, btnclr;
	private JPanel c;
	private GridLayout gridLayout;
	
	
	public Payment(String msg) {
		super(msg);
		initComponents();	
	}
	
	private void initComponents() {
		setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        lblNameOnCard = new JLabel("Name on card:");
        lblCardNumber = new JLabel("Card number:");
        lblExpriation = new JLabel("Expiration:");
        lblCardCode = new JLabel("Card Code:");
       
        
        tfNameOnCard = new JTextField(15);
        tfCardNumber = new JTextField(15);
        tfExpriation = new JTextField(15);
        tfCardCode = new JTextField(4);
        
        btnCheckout = new JButton("Checkout");
        btnclr = new JButton("Clear");
        
        c = new JPanel(new GridLayout(5,2,30,30));
        
        c.add(lblNameOnCard);
        c.add(tfNameOnCard);
        c.add(lblCardNumber);
        c.add(tfCardNumber);
        c.add(lblExpriation);
        c.add(tfExpriation);
        c.add(lblCardCode);
        c.add(tfCardCode);
        c.add(btnclr);
        c.add(btnCheckout);
        
        add(c);
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payment frame = new Payment("Payment Information");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
