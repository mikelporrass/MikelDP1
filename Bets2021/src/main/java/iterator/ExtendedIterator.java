package iterator;

import java.util.Iterator;

import domain.Event;

public interface ExtendedIterator<Event>  extends Iterator {
	//uneko elementua itzultzen du eta aurrekora pasatzen da
	public Event previous();
	//true aurreko elementua existitzen bada.
	public boolean hasPrevious();
	//Lehendabiziko elementuan kokatzen da.
	public void goFirst();
	//Azkeneko elementuan kokatzen da.
	public void goLast();
	public Event next();
	public boolean hasNext();
	public int size();
	public Boolean isEmpty();
	}
