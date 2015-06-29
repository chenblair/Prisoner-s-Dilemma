
public class HungerGames {
	private static final int reps=100;
	private static final int reps2=100;
	private static final int S3=3;
	private static final int S2=2;
	private static final int S1=1;
	private static final int S0=0;
	private static final int[][][] scoreboard=new int[][][]{
			{{S1,S1},{S3,S0}},
			{{S0,S3},{S2,S2}}
	};
	private static boolean[][] record=new boolean[2][100];
	private static Player[] playerE={new Angel(), new  Demon(),new TiTa(),new TiTa2(),
				new MassRet(), new Pavlov(), new Random()};
	private static int[] playerS=new int[playerE.length];

	public static void main(String[] args) {
		for (int i=0;i<playerS.length;i++)
			playerS[i]=1;
		for (int k=0;k<reps2;k++)
		{
			adjust();
			for(int i=0;i<playerE.length;i++)
			{
				for(int j=0;j<playerE.length;j++)
				{
					interaction(playerE[i],playerE[j]);
					playerE[i].empty(playerS[i]*playerS[j]);
					playerE[j].empty(playerS[i]*playerS[j]);
				}
			}
			for (int i=0;i<playerE.length;i++)
			{
				playerS[i]=playerE[i].getTtlValue();
				playerE[i].zeroTtl();
			}
		}
	}
	public static void adjust()
	{
		int ttl=0;
		for (int i=0;i<playerS.length;i++)
			ttl+=playerS[i];
		for (int i=0;i<playerS.length;i++)
			playerS[i]=(playerS[i]*100)/ttl;
		for (int i=0;i<playerS.length;i++)
			System.out.print(playerS[i]+" ");
		System.out.println();
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
}
