package chess;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame implements MouseMotionListener {
	int mouseX = 20;
	int mouseY = 20;
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	
	public Test()
	{
		Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
		System.out.println(b);
		
		panel.setBounds(15,40,400,400);
		panel.setBackground(Color.cyan);
		panel.setLayout(null);
		panel.addMouseMotionListener(this);
		this.add(panel);
		
		label.setBounds(mouseX, mouseY, 50, 50);
		label.setIcon(b.board[7][4].getPiece().getIcon());
		panel.add(label);
	}
	
	public void mouseDragged(MouseEvent e) {
	    mouseX = e.getX();
	    mouseY = e.getY();
	    label.setBounds(mouseX, mouseY, 50, 50);
	}
	
	public void mouseMoved(MouseEvent e) {}
	
	public static void main(String[] args) {
		Test frame = new Test();
	    frame.setVisible(true);
	    frame.setSize(600, 600);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
