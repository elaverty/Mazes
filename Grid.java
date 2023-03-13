public class Grid
{
	int rows, columns;
	Cell[][] grid;

	public Grid(int r, int c)
	{
		rows = r;
		columns = c;

		grid = new Cell[rows][columns];

		prepareGrid();

		configureCells();
		
	}



	public void prepareGrid() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				grid[i][j] = new Cell(i, j); 
			}
		}
	}

	public void configureCells() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(!(i - 1 < 0)) {
					grid[i][j].north = grid[i - 1][j]; 
				}
				if(!(i + 1 >= rows)) {
					grid[i][j].south = grid[i + 1][j]; 
				}
				if(!(j - 1 < 0)) {
					grid[i][j].west = grid[i][j - 1]; 
				}
				if(!(j + 1 >= columns)) {
					grid[i][j].east = grid[i][j + 1]; 
				}
			}
		}
	}


public Cell randomCell() { 
		int row = (int) Math.random() * rows; 
		int column = (int) Math.random() * columns; 
		
		return grid[row][column]; 
	}

	public int size() {
		return this.rows * this.columns; 
	}

	public String toString() {
		String ret = ""; 

		
		ret += "+"; 
		for(int i = 0; i < this.columns; i++) {
			ret += "---+"; 
		}
		ret += "\n"; 
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				Cell c = this.grid[i][j]; 
				
				if(c.isLinked(c.west)) {
					ret += " ";
				} else {
					ret += "|"; 
				}
				
				ret += "   "; 
			}
			
			ret += "|\n+"; 
			
			for(int j = 0; j < this.columns; j++) {
				Cell c = this.grid[i][j];
				if(c.isLinked(c.south)) {
					ret += "   ";
				} else {
					ret += "---";
				}
				ret += "+";
			}
			
			ret += "\n"; 
		}
		
		
		return ret; 
	}
}