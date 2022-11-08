package fall2022;

import javax.swing.JLabel;

public class Vehicle extends Sprite implements Runnable {
	private Boolean moving;
	private int x, y;
	private Boolean visible, running;
	private Thread newt;
	private JLabel vehicleLabel;
	private Frog1 frog1;
	public Vehicle() {
		super(0,0,135,145,"car.png");
		this.running = false;
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
	public void StartMoving() {
		this.moving = false;
		this.ThreadMove(this.moving);
	}
	public void SetVehicleLabel(JLabel temp) {
		this.vehicleLabel = temp;
	}
	public void ThreadMove(Boolean move) {
		if (!move) {
			newt = new Thread(this, "Vehicle1");
			newt.start();
		}
	}
	@Override
	public void run() {
		this.moving = true;
		System.out.println("running");
		int offset = 0;
		while (this.moving) {
			int xqw = this.getX();
			int yqw = this.getY();
			xqw += Gameproperties.CHARACTER_STEP-60;
			if (xqw >= Gameproperties.SCREEN_WIDTH) {
				xqw = -1 * this.width;
			}
			this.setX(xqw);
			this.setY(yqw);
			this.detectCollision();
			//System.out.println(xqw + " " + yqw);
			this.vehicleLabel.setLocation(xqw, yqw);
			
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				
			}
		}
		this.moving = false;
	}
	public void detectCollision() {
	}
}
