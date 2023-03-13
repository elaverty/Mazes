public class BinaryTree{
	Grid grid;

	public BinaryTree(int x, int y)
	{
		grid = new Grid(x, y);
		on(grid);
		
	}
	public void on(Grid g) {
		
		for(int i = 0; i < g.rows; i++) {
			for(int j = 0; j < g.columns; j++) {
				Cell c = g.grid[i][j];
				
				if(c.north != null && c.east != null) {
					if(Math.random()  < 0.5) {
						c.link(c.north, true);
					} else {
						c.link(c.east, true);
					}
				}
				
				else if (c.north == null && c.east == null) {
					continue; 
				}
				
				else if(c.north == null) {
					c.link(c.east, true);
				} 
				
				else {
					c.link(c.north, true);
				}
			}
		}
	}

	public String toString()
	{
		return grid.toString();
	}
}