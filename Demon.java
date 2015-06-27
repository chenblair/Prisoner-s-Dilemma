
public class Demon extends Player {
	
	/**
	 * always defects
	 */
	public boolean move(boolean[][] game, int pos,boolean player)
	{
		return false;
	}
	public String getName()
	{
		return "Demon";
	}

}
