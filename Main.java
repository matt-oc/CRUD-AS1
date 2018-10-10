/**
 * The main class of GUI CRUD database connection
 * 
 * 
 * @author Matthew O'Connor
 * @version 25/09/2018
 */

public class Main {
	private DBConnection db;
	private Gui gui;


	/**
	 * Create out instances
	 * 
	 * @return
	 */
	public void run() {
		db = new DBConnection();
		gui = new Gui(db);
	}


	/**
	 * In case the window was closed, show it again.
	 */
	public void show() {
		gui.setVisible(true);
	}


	public static void main(String[] args) {
		Main start = new Main();

		start.run();
		while (true)
			;
	}
}