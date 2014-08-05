package model;

/**
 * This class represents the logic of a game where a board is updated on each
 * step of the game animation. The board can also be updated by selecting a
 * board cell.
 * 
 * @author Dept of Computer Science, UMCP
 */

public abstract class Game {
	protected BoardCell[][] board;

	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * 
	 * @param maxRows
	 * @param maxCols
	 */
	/*This class represents the logic of a game where a board is updated on each step of the game animation. 
	 * The board can also be updated by selecting a board cell.
	 */

	public Game(int maxRows, int maxCols) {
		if(maxRows<0||maxCols<0) throw new IndexOutOfBoundsException();
		board= new BoardCell[maxRows][maxCols];
		for(int row=0;row<maxRows;row++){
			for(int col=0;col<maxCols;col++){
				board[row][col]=BoardCell.EMPTY;
			}
		}
	}

	//int the maximum number of rows on the Board.
	public int getMaxRows() {
		return board.length;
	}

	//int the maximum number of columns on the Board.
	public int getMaxCols() {
		return board[0].length;
	}

	//set boardcell in rowIndex and colIndex with the specific boardCell
	public void setBoardCell(int rowIndex, int colIndex, BoardCell boardCell) {
		if(rowIndex<0||rowIndex>=getMaxRows()||colIndex<0||colIndex>=getMaxCols()){
			throw new IndexOutOfBoundsException();
		}
		if(boardCell==null) throw new NullPointerException();

		board[rowIndex][colIndex]=boardCell;
	}

	// get boardcell, index values must be within range

	public BoardCell getBoardCell(int rowIndex, int colIndex) {
		if(rowIndex<0||rowIndex>=getMaxRows()||colIndex<0||colIndex>=getMaxCols()){
			throw new IndexOutOfBoundsException();
		}
		return board[rowIndex][colIndex];
	}

	/**
	 * Initializes row with the specified color.
	 * @param rowIndex
	 * @param cell
	 */
	public void setRowWithColor(int rowIndex, BoardCell cell) {
		if(rowIndex<0||rowIndex>=getMaxRows()){
			throw new IndexOutOfBoundsException();
		}
		if(cell==null) throw new NullPointerException();
		for(int col=0;col<getMaxCols();col++){
			board[rowIndex][col]=cell;
		}

	}

	/**
	 * Initializes column with the specified color.
	 * @param colIndex
	 * @param cell
	 */
	public void setColWithColor(int colIndex, BoardCell cell) {
		if(colIndex<0||colIndex>=getMaxRows()){
			throw new IndexOutOfBoundsException();
		}
		if(cell==null) throw new NullPointerException();
		for(int row=0;row<getMaxRows();row++){
			board[row][colIndex]=cell;
		}

	}

	/**
	 * Initializes the board with the specified color.
	 * @param cell
	 */
	public void setBoardWithColor(BoardCell cell) {
		if(cell==null) throw new NullPointerException();
		for(int row=0;row<getMaxRows();row++){
			for(int col=0;col<getMaxCols();col++){
				board[row][col]=cell;
			}
		}

	}	

	public abstract boolean isGameOver();

	public abstract int getScore();

	/**
	 * Advances the animation one step.
	 */
	public abstract void nextAnimationStep();

	/**
	 * Adjust the board state according to the current board state and the
	 * selected cell.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 */
	public abstract void processCell(int rowIndex, int colIndex);
}