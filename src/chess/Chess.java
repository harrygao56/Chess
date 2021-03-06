package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Chess extends JFrame {
	private JPanel menu;
	private JLabel startButton;
	private JLabel chessLabel;
	
	public Chess()
	{
		setTitle("Chess");
		
		menu = new JPanel();
		menu.setBackground(Color.white);
		
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		menu.setLayout(grid);
		
		//Creating and configuring "Start" button
		startButton = new JLabel("Start", SwingConstants.CENTER);
		startButton.setFont(new Font("Serif", Font.PLAIN, 20));
		startButton.setOpaque(true);
		startButton.setBackground(Color.black);
		startButton.setPreferredSize(new Dimension(100,40));
		startButton.setForeground(Color.white);
		//Creating border
		Border border = BorderFactory.createLineBorder(Color.black);
		startButton.setBorder(border);
		startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent mevt) {
                startGame();
            }
            
            public void mouseEntered(MouseEvent e) {
                startButton.setBackground(Color.white);
                startButton.setForeground(Color.black);
             }

             public void mouseExited(MouseEvent e) {
            	 startButton.setBackground(Color.black);
                 startButton.setForeground(Color.white);
             }
        });
		
		chessLabel = new JLabel("Chess.", SwingConstants.CENTER);
		chessLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		chessLabel.setOpaque(true);
		chessLabel.setBackground(Color.white);
		chessLabel.setPreferredSize(new Dimension(200,80));

		gbc.gridx = 1;
		gbc.gridy=1;
        menu.add(chessLabel,gbc);
		
		gbc.gridx = 1;
		gbc.gridy=3;
        menu.add(startButton,gbc);
        
        add(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,600);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	public void startGame()
	{
		remove(menu);
		
		getContentPane().add(new BoardGUI());
		revalidate();
		repaint();
		pack();
	}
	
	public static void main(String[] args)
	{
		Chess chess = new Chess();
	}
}