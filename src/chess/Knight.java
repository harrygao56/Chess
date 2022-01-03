package chess;

public class Knight extends Piece{
	public Knight(boolean white)
	{
		super(white);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "N";
		}
		else
		{
			return "n";
		}
	}
}