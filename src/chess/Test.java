package chess;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {
	int mouseX = 20;
	int mouseY = 20;
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	
	public Test()
	{
		Board b = new Board("r1b1kb1r/ppp2ppp/2n1pn2/q7/3P4/2N2N2/PPPB1PPP/R2QKB1R");
		System.out.println(b);
		
	}
	
	public static void main(String[] args)
	{
		Test test = new Test();
	}
}
