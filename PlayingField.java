import java.util.*;
public class PlayingField {

	private static final int reps=100;
	private static final int reps2=100;
	private static final int s3=3;
	private static final int s2=2;
	private static final int s1=1;
	private static final int s0=0;
	private static final int[][][] scoreboard=new int[][][]{
			{{s1,s1},{s3,s0}},
			{{s0,s3},{s2,s2}}
	};
	private static boolean[][] record=new boolean[2][100];
	public static void main(String[] args){
		Player[] playersE={new Angel(),new Demon(),new TiTa(),new TiTa2(),new MassRet()};
		ArrayList<Player> players=new ArrayList<Player>();
		for (Player p:playersE)
		{
			players.add(p);
		}
		for (int i=0;i<reps2;i++)
		{
			for(Player a:players)
			{
				for(Player b:players)
				{
					interaction(a,b);
				}
			}
			for (Player p:players)
			{
				System.out.println(p.getName()+" : "+count(p,players));
			}
		}
		
	}
	public static void interaction(Player a,Player b)
	{
		for (int i=0;i<reps;i++)
		{
			record[0][i]=a.move(record,i,false);
			record[1][i]=b.move(record,i,true);
			a.add(scoreboard[(record[0][i])?1:0][(record[1][i])?1:0][0]);
			b.add(scoreboard[(record[0][i])?1:0][(record[1][i])?1:0][1]);
		}
	}
	public static int count(Player p,ArrayList<Player> players)
	{
		int ttl=0;
		for (Player a:players)
		{
			if (a.getName().equals(p.getName()))
			{
				ttl++;
			}
		}
		return ttl;
	}

}
