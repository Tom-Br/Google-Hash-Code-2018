package ghc.bl;

public class Position implements Comparable<Position> {
	
	private int row;
	private int col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	@Override
	public int compareTo(Position o) {
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "Position [row=" + row + ", col=" + col + "]";
	}


	
	
}
