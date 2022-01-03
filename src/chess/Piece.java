package chess;

public abstract class Piece {
	private boolean alive;
	private boolean white;
	
	public Piece(boolean white)
	{
		this.white = white;
		alive = true;
	}
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public boolean isWhite()
	{
		return white;
	}
	
	public void die()
	{
		alive = false;
	}
	
	public abstract void moves();
}
