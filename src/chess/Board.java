package chess;

public class Board {
	public Square[][] board;
	
	//FEN: Position Notation
	//Definition at https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation
	//Starting FEN: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
	public Board(String fen)
	{
		//Set up the board using FEN
		board = new Square[8][8];
		for (int i = 0; i < 8; i++)
		{
			if (fen.charAt(0) == '/')
			{
				fen = fen.substring(1);
			}
			
			for (int j = 0; j < 8; j++)
			{
				Piece piece;
				if (fen.charAt(0) == 'K')
				{
					piece = new King(true);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'k')
				{
					piece = new King(false);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'Q')
				{
					piece = new Queen(true);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'q')
				{
					piece = new Queen(false);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'R')
				{
					piece = new Rook(true);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'r')
				{
					piece = new Rook(false);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'N')
				{
					piece = new Knight(true);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'n')
				{
					piece = new Knight(false);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'B')
				{
					piece = new Bishop(true);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'b')
				{
					piece = new Bishop(false);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'P')
				{
					piece = new Pawn(true);
					fen = fen.substring(1);
				}
				else if (fen.charAt(0) == 'p')
				{
					piece = new Pawn(false);
					fen = fen.substring(1);
				}
				else
				{
					int num = Character.getNumericValue(fen.charAt(0));
					for (int k = j; k < num; k++)
					{
						if ((i+k)%2 == 0)
						{
							board[i][k] = new Square(i, j, null, true);
						}
						else
						{
							board[i][k] = new Square(i, j, null, false);
						}
					}
					fen = fen.substring(1);
					j+=num;
					continue;
				}
				
				if ((i+j)%2 == 0)
				{
					board[i][j] = new Square(i, j, piece, true);
				}
				else
				{
					board[i][j] = new Square(i, j, piece, false);
				}
			}
		}
	}
	
	public String toString()
	{
		//Returns all pieces on the board as well as square colors
		String val = "";
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				val = val.concat(board[i][j] + " ");
			}
			val = val.concat("\n");
		}
		return val;
	}
}