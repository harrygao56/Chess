package chess;

public class King extends Piece{
	public King(boolean white)
	{
		super(white);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "K";
		}
		else
		{
			return "k";
		}
	}
}