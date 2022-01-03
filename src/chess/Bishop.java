package chess;

public class Bishop extends Piece{
	public Bishop(boolean white)
	{
		super(white);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "B";
		}
		else
		{
			return "b";
		}
	}
}