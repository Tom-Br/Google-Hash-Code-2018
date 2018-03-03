package ghc.bl;

public class Map {
	
	private int totalRows;
	private int totalCols;
	
	public Map(int rows, int cols) {
		totalRows = rows;
		totalCols = cols;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public int getTotalCols() {
		return totalCols;
	}

	@Override
	public String toString() {
		return "Map [totalRows=" + totalRows + ", totalCols=" + totalCols + "]";
	};	
	
	
	
}
