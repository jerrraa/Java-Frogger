package fall2022;


public class vehicle extends sprite implements Runnable {
	private Boolean moving;
	private int x, y;
	private Boolean visible;
	
	public vehicle(int x, int y) {
		super(50, 50, 74,132, "car.png");
		this.x = x; this.y = y;
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
	public void NewThread() {
		vehicle Vehicle1 = new vehicle(0,0);
		Thread t = new Thread(Vehicle1, "Vehicle1");
		t.start();
		System.out.println("test");
	}
	@Override
	public void run() {
		System.out.println("running");
		this.moving = true;
		
		
	}
	
}
