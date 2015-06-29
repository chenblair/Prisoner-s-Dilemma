import java.util.*;
public abstract class Player
{
	public int value=0;
	public int ttlValue=0;
	public abstract boolean move(boolean[][] game, int pos,boolean player);
	public void add(int increment)
	{
		value=value+increment;
	}
	public int getValue()
	{
		return value;
	}
	public int getTtlValue()
	{
		return ttlValue;
	}
	public void empty(int m)
	{
		ttlValue+=m*value;
		zero();
	}
	public abstract String getName();
	public void zero()
	{
		value=0;
	}
	public void zeroTtl()
	{
		ttlValue=0;
	}
}
