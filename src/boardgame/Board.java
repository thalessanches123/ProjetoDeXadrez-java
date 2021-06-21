package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("erro aao criar o tabuleiro:é necessario que haja pelo menos uma linha e coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece pieces(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("posicao nao esta no tabuleiro!!!");
		}
		return pieces[row][column];
	}
	
	public Piece pieces(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("posicao nao esta no tabuleiro!!!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("ja tem uma peça nessa posicao!!" + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("posicao nao esta no tabuleiro!!!");
		}
		if( pieces(position) == null) {
			return null;
		}
		Piece aux = pieces(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("posicao nao esta no tabuleiro!!!");
		}
		return pieces(position) != null; 
	}
	
}
