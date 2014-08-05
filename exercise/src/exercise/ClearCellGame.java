package model;

import java.util.Random;


/* This class must extend Game */
/*This class extends GameModel and implements the logic of the clear cell game. 
 * We define an empty cell as BoardCell.-EMPTY. 
 * An empty row is defined as one where every cell corresponds to BoardCell.EMPTY.
 */
public class ClearCellGame extends Game {
	/*Defines a board with empty cells. It relies on the super class constructor to define the board. 
	 * The random parameter is used for the generation of random cells. 
The strategy parameter defines which clearing cell strategy to use (for this
project it will be 1).
	 */
	//Game board;
	Random random;
	int strategy;
	int score=0;

	public  ClearCellGame (int maxRows, int maxCols, Random random, int strategy){
		super(maxRows, maxCols);
		this.random=random;
		this.strategy=strategy;


	}
	public boolean isGameOver (){

		return(!isEmpty(getMaxRows()));
	}

	//check if the row is empty
	private boolean isEmpty(int row){
		for(int col=0;col<getMaxCols();col++ ){
			if(getBoardCell(row-1, col)!=BoardCell.EMPTY) return false;
		}
		return true;
	}

	public int getScore(){
		return score;

	}
	public void nextAnimationStep (){
		if(!isGameOver()){

			for(int row=getMaxRows()-1;row>0;row--){
				for(int col=0;col<getMaxCols();col++){
					setBoardCell(row,col,getBoardCell(row-1,col));
				}
			}
			for(int col=0;col<getMaxCols();col++){
				setBoardCell(0,col,BoardCell.getNonEmptyRandomBoardCell(random));
			}
		}

	}

	public String toString(){
		for(int row=0;row<getMaxRows();row++){
			for(int col=0;col<getMaxCols();col++){
				System.out.print(getBoardCell(row,col).getName()+" ");
			}System.out.println();
		}
		return"";
	}



	public void processCell (int rowIndex, int colIndex){

		int maxR=getMaxRows();
		int maxC=getMaxCols();
		int lowR=rowIndex;
		int upper=rowIndex;

		BoardCell color=this.getBoardCell(rowIndex, colIndex);	
		//check down
		boolean down=true;
		for(int row =rowIndex+1;row<maxR;row++){
			if(!getBoardCell(row,colIndex).equals(color)){
				down=false;
			}else if(down){
				setBoardCell(row,colIndex,BoardCell.EMPTY);
				score++;
				upper=row;
			}
		}

		//check up
		boolean up=true;
		for(int row =rowIndex-1;row>=0;row--){
			if(!getBoardCell(row,colIndex).equals(color)){
				up=false;
			}else if(up){
				setBoardCell(row,colIndex,BoardCell.EMPTY);
				score++;
				lowR=row;
			}
		}

		//right
		boolean right=true;
		for(int col =colIndex+1;col<maxC;col++){
			if(!getBoardCell(rowIndex,col).equals(color)){
				right=false;
			}else if(right){
				setBoardCell(rowIndex,col,BoardCell.EMPTY);
				score++;
			}
		}

		//left
		boolean left=true;
		for(int col =colIndex-1;col>=0;col--){
			if(!getBoardCell(rowIndex,col).equals(color)){
				left=false;
			}else if(left){
				setBoardCell(rowIndex,col,BoardCell.EMPTY);
				score++;
			}
		}

		//up right
		boolean upR=true;
		int col4=colIndex;
		for(int row=rowIndex-1;row>=0;row--){
			if(col4!=maxC-1)    col4++;
			if(!getBoardCell(row,col4).equals(color)){
				upR=false;
			}else if(upR){
				setBoardCell(row,col4,BoardCell.EMPTY);
				score++;
			}
		}

		//up left
		boolean upL=true;
		int col3=colIndex;
		for(int row=rowIndex-1;row>=0;row--){
			if(col3!=0)col3--;
			if(!getBoardCell(row,col3).equals(color)){
				upL=false;
			}else if(upL){
				setBoardCell(row,col3,BoardCell.EMPTY);
				score++;
			}

		}

		//down right
		boolean downR=true;
		int col=colIndex;
		for(int row=rowIndex+1;row<maxR;row++){
			if(col!=maxC-1)col++;
			if(!getBoardCell(row,col).equals(color)){
				downR=false;
			}else if(downR){
				setBoardCell(row,col,BoardCell.EMPTY);
				score++;
			}
		}

		//down left
		boolean downL=true;
		int col2=colIndex;
		for(int row=rowIndex+1;row<maxR;row++){
			if(col2!=0)col2--;
			if(!getBoardCell(row,col2).equals(color)){
				downL=false;
			}else if(downL){
				setBoardCell(row,col2,BoardCell.EMPTY);
				score++;
			}
		}


		setBoardCell(rowIndex,colIndex,BoardCell.EMPTY);
		score++;

		for(int row=lowR;row<=upper;row++){
			if(isEmpty(row+1)){
				for(int row2=row;row2<maxR-1;row2++){
					for(int col5=0;col5<maxC;col5++){
						setBoardCell(row2,col5, getBoardCell(row2+1,col5));

					}
				}
			}
		}
	}
}