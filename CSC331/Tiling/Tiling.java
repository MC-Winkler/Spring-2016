/**
 *  @author   J. Hollingsworth and YOUR NAME HERE
 *  
 *  Divide-and-Conquer approach to placing tromino
 *  tiles on a 2^k x 2^k board.
 */
import java.util.Scanner;
import java.awt.Color;

public class Tiling {
	
	private static Color randColor() {
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		
		return new Color(r, g, b);
	}
	
	public static void tile(DeficientBoard db, int row, int col, int n) {
		if (n >1){
			int rDef = db.getDeficientRow(row, col, n);
			int cDef = db.getDeficientCol(row, col, n);
			Color theColor = randColor();
			if (rDef < row +n/2 && cDef < col +n/2){
				db.placeTromino((row+(n/2))-1, (col +(n/2))-1, db.LR, theColor);
			}
			if (rDef < row + n/2 && cDef >= col +n/2){
				db.placeTromino((row+(n/2))-1, (col +(n/2))-1, db.LL, theColor);
			}
			if (rDef >= row + n/2 && cDef >= col + n/2){
				db.placeTromino((row+(n/2))-1, (col +(n/2))-1, db.UL, theColor);
			}
			if (rDef >= row + n/2 && cDef < col + n/2){
				db.placeTromino((row+(n/2))-1, (col +(n/2))-1, db.UR, theColor);
			}
			tile(db, row, col, n/2);
			tile(db, row, col + (n/2) , n/2);
			tile(db, row + (n/2), col, n/2);
			tile(db, row + (n/2), col + (n/2) , n/2);
		}
		
	}

	public static void main(String[] args) {
		
		DeficientBoard db = new DeficientBoard(3);
		System.out.println(db);
		
		tile(db, 0, 0, db.getSize());
		
		BoardViewer bv = new BoardViewer(db);
		bv.setVisible(true);

	}

}
