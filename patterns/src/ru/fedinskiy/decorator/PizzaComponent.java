package ru.fedinskiy.decorator;

/**
 * Created by fedinskiy on 08.03.17.
 */
public class PizzaComponent implements ComponentInterface {
	protected ComponentInterface component;
	
	public PizzaComponent(ComponentInterface component) {
		this.component = component;
	}
	
	@Override
	public void showComponent() {
		component.showComponent();
	}
}
