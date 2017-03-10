package ru.fedinskiy.observer;

/**
 * Created by fedinskiy on 09.03.17.
 */
public interface IObservable {
	void addObserver(IObserver observer);
	void removeObserver(IObserver observer);
	void notifyAllObservers();
}
