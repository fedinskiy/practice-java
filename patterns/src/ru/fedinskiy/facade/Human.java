package ru.fedinskiy.facade;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Human {
	private Brain brain;
	private Heart heart;
	private Hands hands;
	
	public Human(Brain brain, Heart heart, Hands hands) {
		this.brain = brain;
		this.heart = heart;
		this.hands = hands;
	}
	
	public void Life() {
		brain.stayCool(15);
		brain.think("8  march");
		hands.doWork();
		heart.stayHot(37);
		heart.takeRhytm();
	}
}
