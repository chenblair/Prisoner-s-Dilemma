
public class MassRet extends Player {
	/*
	 * keeps cooperating until opponent defects, then keeps defecting
	 */
	public boolean move(boolean[][] game, int pos,boolean player)
	{
		if (pos==0)
			return true;
		if (!game[(player)?1:0][pos-1])
			return false;
		if (game[(!player)?1:0][pos-1])
			return false;
		return true;
	}
	public String getName()
	{
		return "MassRet";
	}
}
