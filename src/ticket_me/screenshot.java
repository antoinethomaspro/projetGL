
import java.sql.*;  
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;  
import javax.swing.filechooser.FileSystemView;  
import java.io.*;  
import java.net.URL;  
import javax.swing.filechooser.FileNameExtensionFilter;  

/** 
 * 
 * @author Huma ZUHAIR
 */  
public class screenshot extends JFrame implements ActionListener {  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtPath;  
	JLabel lblPath;  
	JButton btnSave, btnBrowse;  
	JFileChooser fileChooser;  
	JPanel pobj, innerPanel;  
	GridBagConstraints gc = new GridBagConstraints();  


	public screenshot() {  


		lblPath = new JLabel("Select Photo:");   
		txtPath = new JTextField(15);  
		txtPath.setText("No File Uploaded");  

		btnSave = new JButton("Save");  
		btnSave.addActionListener(this);  
		btnBrowse = new JButton("Browse");  
		btnBrowse.addActionListener(this);  

		pobj = new JPanel();        
		pobj.setLayout(new GridBagLayout());  


		gc.fill = GridBagConstraints.HORIZONTAL;  
		gc.gridx = 0;  
		gc.gridy = 3;  
		gc.weighty = gc.weightx = 0.5;  
		pobj.add(lblPath, gc);  

		gc.fill = GridBagConstraints.HORIZONTAL;  
		gc.gridx = 1;  
		gc.gridy = 3;  
		gc.weighty = gc.weightx = 0.5;  
		pobj.add(txtPath, gc);  

		gc.fill = GridBagConstraints.HORIZONTAL;  
		gc.gridx = 2;  
		gc.gridy = 3;  
		gc.weighty = gc.weightx = 1;  
		pobj.add(btnBrowse, gc);  

		gc.fill = GridBagConstraints.REMAINDER;  
		gc.gridx = 1;  
		gc.gridy = 4;  
		gc.weighty = gc.weightx = 0.5;  
		pobj.add(btnSave, gc);  

		getContentPane().add(pobj);  
		setSize(400, 180);  
		setVisible(true);  
		setResizable(false);  
		setLocation(new Point(320, 240));  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	}  

	/** 
	 * This function is used for inserting image into Ticket Table 
	 * 
	 * @param imagePath that needs to be saved 
	 * @throws ClassNotFoundException 
	 */  
	private void SaveImage(String imagePath) throws ClassNotFoundException {  
		try {  
			byte[] rawBytes = null;  
			FileInputStream fis = null;  

			//if (imagePath.equals("No File Uploaded")) {  
			//ClassLoader cl = this.getClass().getClassLoader();  
			//URL resouces = cl.getResource("resources/blank-image.png");  
			//imagePath = resouces.getFile();  
			//}  

			File fileObj = new File(imagePath);  
			fis = new FileInputStream(fileObj);  

			//loading the Jdbc driver for Sql Operations  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_me", "root", "");  
			PreparedStatement st = con.prepareStatement("INSERT INTO ticket (screenshot) VALUES (?)");  
			//st.setBinaryStream(4, fis);  
			int imageLength = Integer.parseInt(String.valueOf(fileObj.length()));  
			rawBytes = new byte[imageLength];  
			fis.read(rawBytes, 0, imageLength);  
			st.setBinaryStream(1, (InputStream) fis, imageLength);  
			st.setBytes(1, rawBytes);  
			int count = st.executeUpdate();  
			if (count > 0) {  
				JOptionPane.showMessageDialog(this, "Data Saved Successfully");  
			} else {  
				JOptionPane.showMessageDialog(this, "Error Saving Data");  
			}
		} catch (HeadlessException | IOException  | NumberFormatException | SQLException | ClassNotFoundException ex) {  
			JOptionPane.showMessageDialog(this, ex.getMessage());  
		}  
	}  

	/** 
	 * ActionPerformed Event used for handling button Click Event 
	 * 
	 * @param e ActionEvent Object 
	 */  
	@Override  
	public void actionPerformed(ActionEvent e) {  

		JButton btn = (JButton) e.getSource();  

		if (btn.equals(btnBrowse)) {  

			fileChooser = new JFileChooser("C:\\", FileSystemView.getFileSystemView());  
			fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif", "gif", "bmp"));  
			int returnVal = fileChooser.showOpenDialog(pobj);  
			if (returnVal == JFileChooser.APPROVE_OPTION) {  
				String fileName = fileChooser.getSelectedFile().getName();  
				String extension = fileName.substring(fileName.lastIndexOf("."));  
				if (extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".png")  
						|| extension.equalsIgnoreCase(".bmp") || extension.equalsIgnoreCase(".tif")  
						|| extension.equalsIgnoreCase(".gif")) {  
					txtPath.setText(fileChooser.getSelectedFile().getPath());  
				} else {  
					JOptionPane.showMessageDialog(this, "Kindly Select Image File Only",  
							"Error", JOptionPane.ERROR_MESSAGE);  
				}  
			} else {  
				txtPath.setText("No File Uploaded");  
			}  
		}  
		else if (btn.equals(btnSave)) {  
			try {
				SaveImage(txtPath.getText());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		}  
	}  
	/** 
	 * @param args the command line arguments 
	 */  
	public static void main(String[] args) {  
		new screenshot();  
	}  
}  
