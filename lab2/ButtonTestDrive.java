class Button {
	private String label;
	private String color;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void dePress() {
		System.out.println("Button"+this.getLabel()+ "depressed");
	}
	
	public void unDepress() {
		System.out.println("Button undepressed");
	}
}

public class ButtonTestDrive {

	public static void main(String[] args) {
		Button b = new Button();
		
		b.setColor("Red");
		b.setLabel("Nike");
		
		System.out.println("Color: " + b.getColor());
		System.out.println("Label: " + b.getLabel());

		b.dePress();
		b.unDepress();
	}

}
