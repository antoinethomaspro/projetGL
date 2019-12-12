package ticket_me;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * @author Huma ZUHAIR Clemence MILLORD
 * Read image form MySQL database as BLOB type
 */

public class DisplayImage extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlRead;
	JPanel pnlWrite;
	JTextField tfIDRead;   // To read image of this ID from database
	JLabel image;
	JButton btnRead;       // Read image file
	Connection conn = null;    // Database Connection
	BufferedImage img = null;  // Image to be displayed

	/** Constructor: Setup Connection and GUI
	 * @throws ClassNotFoundException */
	public DisplayImage() throws ClassNotFoundException {
		// Setup database connection
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_me","root","");
		} catch(SQLException ex) {
			ex.printStackTrace();
		}

		// Setup GUI
		this.setLayout(new BorderLayout());
		pnlRead = new JPanel();
		this.add(pnlRead, BorderLayout.NORTH);   // Top panel for read image
		pnlWrite = new JPanel();
		this.add(pnlWrite, BorderLayout.SOUTH);  // Bottom panel for write image


		image = new JLabel("image label");
		pnlRead.add(image);
		pnlRead.add(new JLabel("add id ticket: "));
		tfIDRead = new JTextField("0", 10);
		pnlRead.add(tfIDRead);
		btnRead = new JButton("Read Image");
		pnlRead.add(btnRead);
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Read image from database for the selected ID
				img = readImage(tfIDRead.getText());
				repaint();
			}
		});
	}


	/** Read image from the database for the given ID 
	 * @param id is the id of the ticket
	 */ 
	public BufferedImage readImage(String id) {

		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT screenshot FROM ticket WHERE id_ticket = ?");
			pstmt.setString(1, id);
			System.out.println(pstmt);  // for debugging
			ResultSet rset = pstmt.executeQuery();

			rset.next();
			img = ImageIO.read(rset.getBinaryStream("screenshot"));
			image.setIcon(new ImageIcon(img));

			// Only one result expected

			// Read image via InputStream
			//			InputStream in = rset.getBinaryStream("screenshot");
			// Decode the inputstream as BufferedImage

		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return img;
	}


	/** Entry main method */
	public static void main(String[] args) {
		// Run the GUI codes on the Event-Dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Read Image BLOB Demo");
				DisplayImage imgPanel = null;
				try {
					imgPanel = new DisplayImage();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(imgPanel);
				frame.setSize(600, 400);
				frame.setVisible(true);
			}
		});
	}
}
