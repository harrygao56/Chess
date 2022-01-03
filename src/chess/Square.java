package chess;

public class Square {
	private int X;
	private int Y;
	private Piece piece;
	private boolean white;
	
	public Square(int X, int Y, Piece piece, boolean white)
	{
		this.X = X;
		this.Y = Y;
		this.piece = piece;
		this.white = white;
	}
	
	public int getX()
	{
		return X;
	}
	
	public int getY()
	{
		return Y;
	}
	
	public boolean isWhite()
	{
		return white;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}
}
