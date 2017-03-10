package ru.fedinskiy.decorator;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class Tomato extends PizzaComponent {
	
	public Tomato(ComponentInterface component) {
		super(component);
	}
	
	@Override
	public void showComponent() {
		super.showComponent();
		System.out.println("tomato");
	}
}

