package ru.fedinskiy.chain;

/**
 * Created by fedinskiy on 09.03.17.
 */
public abstract class Rumors {
	protected Rumors rumors;
	public boolean isTrue;
	
	public Rumors setNext(Rumors rumors){
		this.rumors=rumors;
		return rumors;
	}
	
	abstract void  writeRumors(String message);
	
	public void chain(String message){
		if(isTrue){
			writeRumors(message);
			return;
		}
		if(this.rumors!=null){
			this.rumors.chain(message);
		}
	}
}
