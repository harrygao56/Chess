package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardGUI extends JLayeredPane {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    private static final int GRID_ROWS = 8;
    private static final int GRID_COLS = 8;
    private static final Dimension LAYERED_PANE_SIZE = new Dimension(WIDTH, HEIGHT);
    private GridLayout gridlayout = new GridLayout(GRID_ROWS, GRID_COLS);
    private JPanel backingPanel = new JPanel(gridlayout);
    private JPanel[][] squares = new JPanel[GRID_ROWS][GRID_COLS];
    Board board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");

    public BoardGUI() {
        backingPanel.setSize(LAYERED_PANE_SIZE);
        backingPanel.setLocation(0, 0);
        backingPanel.setBackground(Color.white);
        
        for (int i = 0; i < squares.length; i++)
		{
			for (int j = 0; j < squares.length; j++)
			{
				squares[i][j] = new JPanel(new GridBagLayout());
				squares[i][j].setSize(new Dimension(50,50));
				if (board.board[i][j].isWhite())
				{
					squares[i][j].setBackground(Color.white);
				}
				else 
				{
					squares[i][j].setBackground(Color.gray);
				}
				if (board.getBoard()[i][j].getPiece() != null)
				{
					squares[i][j].add(board.getBoard()[i][j].getPiece());
				}
				backingPanel.add(squares[i][j]);
			}
		}

        setPreferredSize(LAYERED_PANE_SIZE);
        add(backingPanel, JLayeredPane.DEFAULT_LAYER);
        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
    }

    private class MyMouseAdapter extends MouseAdapter {
        private JLabel dragLabel = null;
        private int dragLabelWidthDiv2;
        private int dragLabelHeightDiv2;
        private JPanel clickedPanel = null;

        @Override
        public void mousePressed(MouseEvent me) {
            clickedPanel = (JPanel) backingPanel.getComponentAt(me.getPoint());
            Component[] components = clickedPanel.getComponents();
            if (components.length == 0) {
                return;
            }
            // if we click on jpanel that holds a jlabel
            if (components[0] instanceof JLabel) {

                // remove label from panel
                dragLabel = (JLabel) components[0];
                clickedPanel.remove(dragLabel);
                clickedPanel.revalidate();
                clickedPanel.repaint();

                dragLabelWidthDiv2 = dragLabel.getWidth() / 2;
                dragLabelHeightDiv2 = dragLabel.getHeight() / 2;

                int x = me.getPoint().x - dragLabelWidthDiv2;
                int y = me.getPoint().y - dragLabelHeightDiv2;
                dragLabel.setLocation(x, y);
                add(dragLabel, JLayeredPane.DRAG_LAYER);
                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            if (dragLabel == null) {
                return;
            }
            int x = me.getPoint().x - dragLabelWidthDiv2;
            int y = me.getPoint().y - dragLabelHeightDiv2;
            dragLabel.setLocation(x, y);
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (dragLabel == null) {
                return;
            }
            remove(dragLabel); // remove dragLabel for drag layer of JLayeredPane
            JPanel droppedPanel = (JPanel) backingPanel.getComponentAt(me.getPoint());
            if (droppedPanel == null) {
                // if off the grid, return label to home
                clickedPanel.add(dragLabel);
                clickedPanel.revalidate();
            } else {
                int r = -1;
                int c = -1;
                searchPanelGrid: for (int row = 0; row < squares.length; row++) {
                    for (int col = 0; col < squares[row].length; col++) {
                        if (squares[row][col] == droppedPanel) {
                            r = row;
                            c = col;
                            break searchPanelGrid;
                        }
                    }
                }

                if (r == -1 || c == -1) {
                    // if off the grid, return label to home
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                } else {
                    droppedPanel.add(dragLabel);
                    droppedPanel.revalidate();
                }
            }

            repaint();
            dragLabel = null;
        }
    }
}