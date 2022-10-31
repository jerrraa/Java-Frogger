package fall2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vehicle extends sprite implements ActionListener {
	private Thread CarThread;
	private Boolean moving;
	private int x, y, updatemove;
	
	
	public vehicle(int x, int y, int updatemove) {
		super(50, 50, 74,132, "car.png");
		this.x = x; this.y = y; this.updatemove = updatemove;
	}

	public void StartVehicle( ) {
		if (!this.moving) {
			CarThread = new Thread("Car Thread");
			CarThread.start();
		}
	}
	public void run() {
		this.moving = true;
	}
	public boolean DetectPlayer(frog1 playerfrog) {
		int frogx = playerfrog.getX();
		int frogy = playerfrog.getY();
		
		return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
