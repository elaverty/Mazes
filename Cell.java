import java.util.ArrayList;
public class Cell
{
	private int x,y;
	public Cell north, south, east, west;
	private ArrayList<Cell> links; 

	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		links = new ArrayList<Cell>();
	
	}

	public void link (Cell c, boolean bidi)
	{
		links.add(c);
		if (bidi)
		c.link(this, false);
	}

	public void unlink (Cell c, boolean bidi)
	{
		links.remove(c);
		if (bidi)
		c.unlink(this, false);
	}

	public boolean isLinked(Cell c) {
		if(links.contains(c)) {
			return true; 
		} 
		return false; 
	}
	
	public ArrayList<Cell> neighbors() {
		ArrayList<Cell> list = new ArrayList<Cell>();
		
		if(north != null) {
			list.add(north);
		}
		if(south != null) {
			list.add(south);
		}
		if(east != null) {
			list.add(east);
		}
		if(west != null) {
			list.add(west);
		}
		
		return list; 
	}


	public Cell getNorth()
	{
		return north;
	}
	public Cell getSouth()
	{
		return south;
	}
	public Cell getEast()
	{
		return east;
	}
	public Cell getWest()
	{
		return west;
	}

}