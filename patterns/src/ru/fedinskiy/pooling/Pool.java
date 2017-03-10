package ru.fedinskiy.pooling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fedinskiy on 07.03.17.
 */
public class Pool {
	private static final LinkedList<HeavyObject> store = new LinkedList<HeavyObject>();
	private static final HashSet<HeavyObject> inUse = new HashSet<HeavyObject>();
	private final HeavyObjectFactory factory;
	
	public Pool(HeavyObjectFactory factory) {
		this.factory = factory;
	}
	
	public HeavyObject borrow(){
			HeavyObject freeObject=getOrCreateFreeObject();
			inUse.add(freeObject);
			return freeObject;
	}
	
	public void free(HeavyObject toFree){
		if(	inUse.remove(toFree)){
			store.add(toFree);
		}
	}
	
	private HeavyObject getOrCreateFreeObject() {
		HeavyObject freeObject=null;
		
		if (store.size() == 0) {
			freeObject = createObject();
		} else {
			synchronized (store){
				while(null==freeObject) {
					try {
						store.wait();
						int i = store.size();
						freeObject = store.get(i);
						store.remove(i);
						store.notifyAll();
					} catch (InterruptedException e) {
						System.out.println("не удалось залочить");
					}
				}
			}
			
		}
		return freeObject;
	}
	
	private HeavyObject createObject() {
		return factory.createObject();
	}
}
