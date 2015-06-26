
public class Player {
	public int value=0;
	public boolean move(boolean[][] game, int pos,boolean player)
	{
		return true;
	}
	public void add(int increment)
	{
		value=value+increment;
	}
	public int getValue()
	{
		return value;
	}
	public String getName()
	{
		return "Player";
	}
	public void zero()
	{
		value=0;
	}
}
