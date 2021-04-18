package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;



import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Pal extends JFrame {

	private JPanel contentPane;
	Button run;
	Label path;
	Label dist;
	JPanel panel;
	JComboBox source;
	JComboBox target;
	JPanel panel_1 ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pal frame = new Pal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Pal() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Source:");
		label.setFont(new Font("Ebrima", Font.PLAIN, 16));
		label.setForeground(Color.BLACK);
		label.setBounds(560, 29, 72, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Target:");
		label_1.setFont(new Font("Ebrima", Font.PLAIN, 16));
		label_1.setBounds(560, 74, 72, 22);
		contentPane.add(label_1);
		
	    run = new Button("Run");
	  
		run.setBackground(Color.GRAY);
		run.setBounds(707, 118, 70, 22);
		contentPane.add(run);
		
		Label label_2 = new Label("Path:");
		label_2.setFont(new Font("Ebrima", Font.PLAIN, 16));
		label_2.setBounds(560, 167, 72, 22);
		contentPane.add(label_2);
		
		 path = new Label("");
		path.setBackground(Color.WHITE);
		path.setForeground(Color.BLACK);
		path.setBounds(638, 167, 140, 63);
		contentPane.add(path);
		
		Label label_4 = new Label("Distence:");
		label_4.setFont(new Font("Ebrima", Font.PLAIN, 16));
		label_4.setBounds(560, 261, 70, 22);
		contentPane.add(label_4);
		
		 dist = new Label("");
		dist.setBackground(Color.WHITE);
		dist.setBounds(638, 261, 140, 22);
		contentPane.add(dist);
		
		 source = new JComboBox();
		source.setBounds(638, 29, 123, 30);
		contentPane.add(source);
		
		 target = new JComboBox();
		target.setBounds(638, 70, 123, 30);
		contentPane.add(target);
		
		 panel_1 = new JPanel();
		//JLabel back;
		panel_1.setBounds(34, 29, 459, 415);
		contentPane.add(panel_1);
		ImageIcon img = new ImageIcon("roomBookingIcon.png");
		panel_1.setLayout(new BorderLayout(0, 0));
		//back = new JLabel("",img,JLabel.CENTER) ;
		//panel_1.add (back);
	}
}
