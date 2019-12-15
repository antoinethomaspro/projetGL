

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

public class DisplayImage extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlRead;
	JTextField tfIDRead;   // To read image of this ID from database
	JLabel image;
	JButton btnRead;       // Read image file
	Connection conn = null;    // Database Connection
	BufferedImage img = null;  // Image to be displayed
	int id_ticket;
	/** Constructor: Setup Connection and GUI
	 * @param id_ticket takes the id ticket to show its image
	 * @throws ClassNotFoundException  shows exception
	 *  
	 *  */
	public DisplayImage(int id_ticket) throws ClassNotFoundException {
		this.id_ticket = id_ticket;
		// Setup database connection
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_me","root","root");
		} catch(SQLException ex) {
			ex.printStackTrace();
		}

		pnlRead = new JPanel();
		this.add(pnlRead, BorderLayout.CENTER);   // Top panel for read image
		image = new JLabel();
		pnlRead.add(image);
		JFrame frame = new JFrame("Display Screenshot");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.getContentPane().add(this);
		frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);		
		frame.setVisible(true);
		img = readImage(""+id_ticket);
		repaint();
	}


	/** Read image from the database for the given ID 
	 * @param id is the id of the ticket
	 * @return img the buffered image
	 */ 
	public BufferedImage readImage(String id) {

		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT screenshot FROM ticket WHERE id_ticket = ?");
			pstmt.setString(1, id);
			System.out.println(pstmt);  // for debugging
			ResultSet rset = pstmt.executeQuery();

			rset.next();
			img = ImageIO.read(rset.getBinaryStream("screenshot"));
			try {
				image.setIcon(new ImageIcon(img));
			} catch (NullPointerException e) {
				image.setText("No file");
			}
		} catch(Exception ex) {
		}
		return img;
	}
	public static void main(String[] args) throws ClassNotFoundException {
		new DisplayImage(6);
	}
}
