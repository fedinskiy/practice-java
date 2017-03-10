package ru.fedinskiy.decorator;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Mushrooms extends PizzaComponent {
	
	public Mushrooms(ComponentInterface component) {
		super(component);
	}
	
	@Override
	public void showComponent() {
		super.showComponent();
		System.out.println("mushrooms");
	}
}
