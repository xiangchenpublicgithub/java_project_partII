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
	Random rand;
	int strategy;
	int totalScore=0;

	public  ClearCellGame (int maxRows, int maxCols, Random random, int strategy){
		super(maxRows, maxCols);
		this.rand=random;
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
		return totalScore;

	}
	public void nextAnimationStep (){
		if(!isGameOver()){

			for(int row=getMaxRows()-1;row>0;row--){
				for(int col=0;col<getMaxCols();col++){
					setBoardCell(row,col,getBoardCell(row-1,col));
				}
			}
			for(int col=0;col<getMaxCols();col++){
				setBoardCell(0,col,BoardCell.getNonEmptyRandomBoardCell(rand));
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
		int rLow=rowIndex;
		int upper=rowIndex;

		BoardCell color=this.getBoardCell(rowIndex, colIndex);	
		//check down
		boolean down=true;
		for(int row =rowIndex+1;row<maxR;row++){
			if(!getBoardCell(row,colIndex).equals(color)){
				down=false;
			}else if(down){
				setBoardCell(row,colIndex,BoardCell.EMPTY);
				totalScore++;
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
				totalScore++;
				rLow=row;
			}
		}

		//right
		boolean rightSide=true;
		for(int col =colIndex+1;col<maxC;col++){
			if(!getBoardCell(rowIndex,col).equals(color)){
				rightSide=false;
			}else if(rightSide){
				setBoardCell(rowIndex,col,BoardCell.EMPTY);
				totalScore++;
			}
		}

		//left
		boolean leftSide=true;
		for(int col =colIndex-1;col>=0;col--){
			if(!getBoardCell(rowIndex,col).equals(color)){
				leftSide=false;
			}else if(leftSide){
				setBoardCell(rowIndex,col,BoardCell.EMPTY);
				totalScore++;
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
				totalScore++;
			}
		}

		//up left
		boolean high=true;
		int col3=colIndex;
		for(int row=rowIndex-1;row>=0;row--){
			if(col3!=0)col3--;
			if(!getBoardCell(row,col3).equals(color)){
				high=false;
			}else if(high){
				setBoardCell(row,col3,BoardCell.EMPTY);
				totalScore++;
			}

		}

		//down right
		boolean low=true;
		int col=colIndex;
		for(int row=rowIndex+1;row<maxR;row++){
			if(col!=maxC-1)col++;
			if(!getBoardCell(row,col).equals(color)){
				low=false;
			}else if(low){
				setBoardCell(row,col,BoardCell.EMPTY);
				totalScore++;
			}
		}

		//down left
		boolean downL=true;
		int col2=colIndex;
		for(int firstRow=rowIndex+1;firstRow<maxR;firstRow++){
			if(col2!=0)col2--;
			if(!getBoardCell(firstRow,col2).equals(color)){
				downL=false;
			}else if(downL){
				setBoardCell(firstRow,col2,BoardCell.EMPTY);
				totalScore++;
			}
		}


		setBoardCell(rowIndex,colIndex,BoardCell.EMPTY);
		totalScore++;

		for(int row=rLow;row<=rLow;row++){
			if(isEmpty(row+1)){
				for(int anotherRow=row;anotherRow<maxR-1;anotherRow++){
					for(int col5=0;col5<maxC;col5++){
						setBoardCell(anotherRow,col5, getBoardCell(anotherRow+1,col5));

					}
				}
			}
		}
	}
}