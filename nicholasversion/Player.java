package nicholasversion;

import java.util.ArrayList;


public class Player {
	
	private int playerType;
	private int score;
	private int round;
	public ArrayList<boolean[]> recordKeeper;
	
	private final int THISPLAYER=0,OPPONENT=1;
	
	private final String[] TYPENAMES={"Angel","Devil","TTCoop","TTDefect"};
	
	public Player(int playerType){
		this.playerType=playerType;
		score=0;
		recordKeeper=new ArrayList<boolean[]>();
	}

	public String getTYPENAME(){
		return TYPENAMES[playerType];
	}
	
	public boolean play(){
		boolean retBool=false;
		
		if(playerType==0){
			retBool=true;
		}
		
		if(playerType==1){
			retBool=false;
		}
		
		if(playerType==2){
			
			if(round==0){
				retBool=true;
			}
			
			else{
				retBool=recordKeeper.get(round-1)[OPPONENT];
			}
		}
		
		if(playerType==3){
			
			if(round==0){
				retBool=false;
			}
			
			else{
				retBool=recordKeeper.get(round-1)[OPPONENT];
			}
		}
		
		return retBool;
	}
	
	public void addRecord(boolean[] record){
		recordKeeper.add(record);
	}
	public void addScore(int addition){
		score+=addition;
	}
	public void incrementRound(){
		round++;
	}
	
	public void updateInfo(boolean[] record, int addition){
		addRecord(record);
		addScore(addition);
		incrementRound();
	}
	
	public void printScore(){
		System.out.printf("Player type %s Score: %d\n",getTYPENAME(), score);
	}
	
}

