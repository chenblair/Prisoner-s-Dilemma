
public class Random extends Player {

	/*
	 * random yo
	 */
	public boolean move(boolean[][] game, int pos, boolean player) {
		int a=(int)(Math.random()*2);
		if (a==0)
			return true;
		return false;
	}

	@Override
	public String getName() {
		return "Random";
	}

}
