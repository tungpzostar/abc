package gd;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class o extends JFrame {
	JLabel image;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					o frame = new o();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public o() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.setBounds(259, 302, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 268, 179, 23);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(222, 234, 180, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblHideMessage = new JLabel("Hide message:");
		lblHideMessage.setBounds(102, 238, 110, 23);
		contentPane.add(lblHideMessage);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(102, 272, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblInputImage = new JLabel("Input image");
		lblInputImage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblInputImage.setBounds(24, 11, 207, 212);
		contentPane.add(lblInputImage);
		
		JLabel lblOutputImage = new JLabel("Output image");
		lblOutputImage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOutputImage.setBounds(381, 11, 207, 212);
		contentPane.add(lblOutputImage);
		
		JButton btnChooseImage = new JButton("Choose Image ");
		btnChooseImage.setBounds(241, 200, 130, 23);
		btnChooseImage.addActionListener(new ActionListener() {
			private Container jpanel;

			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
	            fc.showOpenDialog(null);
	            File f = fc.getSelectedFile();
	            String filename = f.getAbsolutePath();
	            ImageIcon icon = new ImageIcon(filename);
	            Image newImg = icon.getImage();
	            Image img = newImg.getScaledInstance(lblInputImage.getWidth(), lblInputImage.getHeight(), Image.SCALE_SMOOTH);
	            ImageIcon image = new ImageIcon(img);
	            lblInputImage.setIcon(image);
			}
		});
		contentPane.add(btnChooseImage);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
