package chess;

public class Queen extends Piece{
	public Queen(boolean white)
	{
		super(white);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "Q";
		}
		else
		{
			return "q";
		}
	}
}