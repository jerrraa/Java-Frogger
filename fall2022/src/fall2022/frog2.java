package fall2022;

public class frog2 extends sprite {

	private Boolean visible, moving;
	
	public frog2() {
		super(0, 0, 100, 100, "redfrog.png");
		this.visible = true;
		this.moving = false;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getMoving() {
		return moving;
	}

	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public void show() {
		this.visible = true;
	}
	public void hide() {
		this.visible = false;
	}
	
	public void display() {
		System.out.println("x, y: "+ this.x + "," + this.y);
		System.out.println("height, width: "+ this.height + "," + this.width);
		System.out.println("image: " + this.image);
		//super.Display();
		System.out.println("visible: " + this.visible);
		System.out.println("moving: " + this.moving);
	}
}
