package models;

public class CrackInfo {
	//wrapper class for info returned by a crack attempt
	protected boolean cracked;
	protected long time;
	protected int attempts;
	
	public CrackInfo(boolean cracked, long time, int attempts){
		this.cracked = cracked;
		this.time = time;
		this.attempts = attempts;
	}
	
	public boolean getCracked(){
		return cracked;
	}
	
	public long getTime(){
		return time;
	}
	
	public int getAttempts(){
		return attempts;
	}
}
