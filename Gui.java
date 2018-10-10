
/**
 * The Gui class of GUI CRUD database connection
 * 
 * 
 * @author Matthew O'Connor
 * @version 25/09/2018
 */

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Gui implements ActionListener {

	private JFrame frame;
	private JTextField ssnField;
	private JTextField dobField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField salaryField;
	private JTextField genderField;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnPrevious;
	private JButton btnClear;
	private JButton btnNext;
	private JButton btnAdd;
	private JButton btnFirst;
	private JButton btnLast;
	private DBConnection dbc;
	private ResultSet rs;
	private Statement st;
	private String ssnTemp;
	private String nameTemp;


	/**
	 * Create the application.
	 * 
	 * @param dbc
	 */

	public Gui(DBConnection db) {
		dbc = db;
		initialize();
		frame.setVisible(true);
		dbc.connect();
		update();

		// Connect and load intitial data to GUI
		try {
			if (rs.next()) {
				ssnField.setText(rs.getString("ssn"));
				dobField.setText(rs.getString("dob"));
				nameField.setText(rs.getString("name"));
				addressField.setText(rs.getString("address"));
				salaryField.setText(rs.getString("salary"));
				genderField.setText(rs.getString("gender"));
				ssnTemp = ssnField.getText();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Make this interface visible again. (Has no effect if it is already visible.)
	 */
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.text);
		frame.getContentPane().setBackground(new Color(216, 191, 216));
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ssnField = new JTextField();
		ssnField.setBounds(185, 95, 297, 26);
		frame.getContentPane().add(ssnField);
		ssnField.setColumns(10);

		JLabel headingLbl = new JLabel("Employee Details");
		headingLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		headingLbl.setBounds(266, 21, 184, 51);
		frame.getContentPane().add(headingLbl);

		dobField = new JTextField();
		dobField.setBounds(185, 123, 297, 26);
		frame.getContentPane().add(dobField);
		dobField.setColumns(10);

		nameField = new JTextField();
		nameField.setBounds(185, 178, 297, 26);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);

		addressField = new JTextField();
		addressField.setBounds(185, 206, 297, 26);
		frame.getContentPane().add(addressField);
		addressField.setColumns(10);

		salaryField = new JTextField();
		salaryField.setBounds(185, 265, 297, 26);
		frame.getContentPane().add(salaryField);
		salaryField.setColumns(10);

		genderField = new JTextField();
		genderField.setBounds(185, 292, 297, 26);
		frame.getContentPane().add(genderField);
		genderField.setColumns(10);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(298, 397, 117, 41);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(this);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(140, 397, 117, 41);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(462, 397, 117, 41);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(this);

		btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(577, 98, 117, 51);
		frame.getContentPane().add(btnPrevious);
		btnPrevious.addActionListener(this);

		btnNext = new JButton("Next");
		btnNext.setBounds(577, 191, 87, 41);
		frame.getContentPane().add(btnNext);
		btnNext.addActionListener(this);

		btnClear = new JButton("Clear");
		btnClear.setBounds(577, 277, 87, 41);
		frame.getContentPane().add(btnClear);
		btnClear.addActionListener(this);

		btnFirst = new JButton("First Entry");
		btnFirst.setForeground(Color.ORANGE);
		btnFirst.setBackground(Color.GRAY);
		btnFirst.setBounds(185, 330, 90, 41);
		frame.getContentPane().add(btnFirst);
		btnFirst.addActionListener(this);

		btnLast = new JButton("Last Entry");
		btnLast.setForeground(Color.ORANGE);
		btnLast.setBounds(395, 330, 87, 41);
		frame.getContentPane().add(btnLast);
		btnLast.addActionListener(this);

		JLabel lblSsn = new JLabel("SSn");
		lblSsn.setBounds(95, 100, 61, 16);
		frame.getContentPane().add(lblSsn);

		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(95, 128, 61, 16);
		frame.getContentPane().add(lblDob);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(95, 183, 61, 16);
		frame.getContentPane().add(lblName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(95, 211, 61, 16);
		frame.getContentPane().add(lblAddress);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(95, 270, 61, 16);
		frame.getContentPane().add(lblSalary);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(95, 297, 61, 16);
		frame.getContentPane().add(lblGender);
	}


	/**
	 * Event listener action
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			System.out.println("You pressed NEXT");

			try {
				if (rs.isLast()) {
					// Do nothing, stop running into after last area
				}
				else if (rs.next()) {

					// Update Text fields
					ssnField.setText(rs.getString("ssn"));
					dobField.setText(rs.getString("dob"));
					nameField.setText(rs.getString("name"));
					addressField.setText(rs.getString("address"));
					salaryField.setText(rs.getString("salary"));
					genderField.setText(rs.getString("gender"));
					ssnTemp = ssnField.getText();
				}
			}
			catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
		else if (e.getSource() == btnPrevious) {
			System.out.println("You pressed PREVIOUS");

			try {
				if (rs.isFirst()) {
					// Do nothing, stop running into before first area
				}
				else if (rs.previous()) {

					// Update Text fields
					ssnField.setText(rs.getString("ssn"));
					dobField.setText(rs.getString("dob"));
					nameField.setText(rs.getString("name"));
					addressField.setText(rs.getString("address"));
					salaryField.setText(rs.getString("salary"));
					genderField.setText(rs.getString("gender"));
					ssnTemp = ssnField.getText();
				}
			}
			catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

		else if (e.getSource() == btnClear) {
			System.out.println("You pressed Clear");

			// Update Text fields
			ssnField.setText("");
			dobField.setText("");
			nameField.setText("");
			addressField.setText("");
			salaryField.setText("");
			genderField.setText("");
			dbc.connect();
			update();

		}

		else if (e.getSource() == btnAdd) {
			System.out.println("You pressed ADD");

			// Validate inputs to ensure they are allowed
			if (ValidateInput()) {

				try {
					nameTemp = nameField.getText();
					st.executeUpdate("INSERT INTO Employee VALUES(" + ssnField.getText() + "," + "'" + dobField.getText().toString() + "'"
							+ "," + "'" + nameField.getText().toString() + "'" + "," + "'" + addressField.getText().toString() + "'" + ","
							+ salaryField.getText() + "," + "'" + genderField.getText().toString() + "'" + ")");
					dbc.connect(); // reconnect to allow user to continue
					update();
					if (rs.next()) {
						// Update Text fields
						ssnField.setText(rs.getString("ssn"));
						dobField.setText(rs.getString("dob"));
						nameField.setText(rs.getString("name"));
						addressField.setText(rs.getString("address"));
						salaryField.setText(rs.getString("salary"));
						genderField.setText(rs.getString("gender"));
					}
					JOptionPane.showMessageDialog(frame, nameTemp + " has been added to the database"); // confirmation
																										// dialogue
				}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "error: " + e1.getMessage()); // show error and allow user to
																						// continue
					dbc.connect();
					update();

				}
			}

		}

		else if (e.getSource() == btnUpdate) {

			System.out.println("You pressed Update");
			// Validate inputs to ensure they are allowed
			if (ValidateInput()) {
				try {

					st.executeUpdate(
							"UPDATE Employee SET name = " + "'" + nameField.getText() + "'" + " WHERE ssn = " + "'" + ssnTemp + "'");
					st.executeUpdate("UPDATE Employee SET dob = " + "'" + dobField.getText() + "'" + " WHERE ssn = " + "'" + ssnTemp + "'");
					st.executeUpdate(
							"UPDATE Employee SET address = " + "'" + addressField.getText() + "'" + " WHERE ssn = " + "'" + ssnTemp + "'");
					st.executeUpdate(
							"UPDATE Employee SET salary = " + "'" + salaryField.getText() + "'" + " WHERE ssn = " + "'" + ssnTemp + "'");
					st.executeUpdate(
							"UPDATE Employee SET gender = " + "'" + genderField.getText() + "'" + " WHERE ssn = " + "'" + ssnTemp + "'");
					System.out.println(
							"UPDATE Employee SET ssn = " + ssnField.getText() + " WHERE ssn = " + "'" + ssnField.getText() + "'" + ssnTemp);
					st.executeUpdate("UPDATE Employee SET ssn = " + "'" + ssnField.getText() + "'" + " WHERE ssn = " + "'" + ssnTemp + "'");
					ssnTemp = ssnField.getText();
					dbc.connect();// reconnect to allow user to continue
					update();
					if (rs.next()) {
						// Update Text fields
						ssnField.setText(rs.getString("ssn"));
						dobField.setText(rs.getString("dob"));
						nameField.setText(rs.getString("name"));
						addressField.setText(rs.getString("address"));
						salaryField.setText(rs.getString("salary"));
						genderField.setText(rs.getString("gender"));
					}

					JOptionPane.showMessageDialog(frame, "The SSn: " + ssnTemp + " has been successfully updated");
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "error: " + e1.getMessage());
					dbc.connect();
					update();

				}

			}
		}

		else if (e.getSource() == btnDelete) {
			System.out.println("You pressed Delete");
			try {
				nameTemp = nameField.getText();
				st.executeUpdate("DELETE FROM Employee " + "WHERE ssn = " + ssnField.getText());
				ssnField.setText("");
				dobField.setText("");
				nameField.setText("");
				addressField.setText("");
				salaryField.setText("");
				genderField.setText("");
				dbc.connect(); // reconnect to allow user to continue
				update();
				if (rs.next()) {
					// Update Text fields
					ssnField.setText(rs.getString("ssn"));
					dobField.setText(rs.getString("dob"));
					nameField.setText(rs.getString("name"));
					addressField.setText(rs.getString("address"));
					salaryField.setText(rs.getString("salary"));
					genderField.setText(rs.getString("gender"));
				}

				JOptionPane.showMessageDialog(frame, nameTemp + " has been successfully deleted");
			}
			catch (SQLException e1) {
				JOptionPane.showMessageDialog(frame, "error: " + e1.getMessage());
				dbc.connect();
				update();

			}

		}

		else if (e.getSource() == btnLast) {
			System.out.println("You pressed Last");

			try {

				if (rs.last()) {
					// Update Text fields
					ssnField.setText(rs.getString("ssn"));
					dobField.setText(rs.getString("dob"));
					nameField.setText(rs.getString("name"));
					addressField.setText(rs.getString("address"));
					salaryField.setText(rs.getString("salary"));
					genderField.setText(rs.getString("gender"));
					ssnTemp = ssnField.getText();
				}
			}
			catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

		else if (e.getSource() == btnFirst) {
			System.out.println("You pressed Last");

			try {

				if (rs.first()) {
					// Update Text fields
					ssnField.setText(rs.getString("ssn"));
					dobField.setText(rs.getString("dob"));
					nameField.setText(rs.getString("name"));
					addressField.setText(rs.getString("address"));
					salaryField.setText(rs.getString("salary"));
					genderField.setText(rs.getString("gender"));
					ssnTemp = ssnField.getText();
				}
			}
			catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

	}


	/**
	 * Update function to prevent repeated code
	 */
	public void update() {
		rs = dbc.getRs();
		st = dbc.getmyStmt();
	}


	/**
	 * Validate input to help prevent errors
	 */

	public boolean ValidateInput() {

		System.out.println("Validating" + ssnField.getText().length());
		if (ssnField.getText().length() > 30 || ssnField.getText().length() <= 0 || !ssnField.getText().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(frame, "Invalid SSn entry, try again");
			return false;
		}
		if (dobField.getText().length() > 12 || dobField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(frame, "Invalid DOB entry, try again");
			return false;
		}
		if (nameField.getText().length() > 30 || nameField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(frame, "Invalid Name entry, try again");
			return false;
		}
		if (addressField.getText().length() > 50 || addressField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(frame, "Invalid address entry, try again");
			return false;
		}
		if (salaryField.getText().length() > 10 || salaryField.getText().length() <= 0 || !salaryField.getText().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(frame, "Invalid Salary entry, try again");
			return false;
		}
		if (genderField.getText().length() > 10 || genderField.getText().length() <= 0) {
			JOptionPane.showMessageDialog(frame, "Invalid gender entry, try again");
			return false;
		}

		return true;
	}

}
