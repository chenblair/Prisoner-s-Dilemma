
public class TiTa extends Player {

	public boolean move(boolean[][] game, int pos,boolean player)
	{
		if (pos==0)
			return true;
		return game[(!player)?1:0][pos-1];
	}
	public String getName()
	{
		return "TitTat";
	}
}
