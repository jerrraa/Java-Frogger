package fall2022;

import javax.swing.JLabel;

public class Vehicle extends Sprite implements Runnable {
	private Boolean moving;
	private int x, y;
	private Boolean visible, running;
	private Thread newt;
	private JLabel vehicleLabel;
	public Vehicle() {
		super(0,0,135,145,"car.png");
		this.running = false;
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
	public void StartMoving(Boolean tf) {
		this.ThreadMove();
	}
	public void updateVehicleLabel(JLabel temp) {
		this.vehicleLabel = temp;
	}
	public void ThreadMove() {
		if (!this.running) {
			this.running = true;
			newt = new Thread(this, "Vehicle1");
			newt.start();
		}
	}
	@Override
	public void run() {
		this.moving = true;
		System.out.println("running");
		
		while (this.moving) {
			int x = this.x;
			int y = this.y;
			x += Gameproperties.CHARACTER_STEP-20;
			if (x >= Gameproperties.SCREEN_WIDTH) {
				x = -1 * this.width;
			}
			this.x = x;
			System.out.println("x, y: "+ this.x + "," + this.y);
			this.vehicleLabel.setLocation(this.x, 800);
			
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				
			}
		}
	}
	
}
