package fall2022;
import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gameprep extends JFrame implements KeyListener, ActionListener{
	
	//instances of our data classes (store position, etc here)
	private Frog1 frog1;
	//graphic elements
	private Container content;
	private JLabel frog1Label;
	private ImageIcon frog1Image;
	private ImageIcon vehicle1Image;
	private JButton StartButton;
	
	private Vehicle vehicle1;
	private JLabel vehicle1Label;

	
	public int lifes = 3;
	public int score = 0;
	
	public Gameprep() {
		InsertVehicleRows();
		InsertLogRows();
		DisplayContents();
	}
	public void resetfrogger() {
		//if frog intersects with vehicle or log, we reset.
		lifes--;
		score -= 50;
		frog1.SetLives(lifes);
		frog1Label.setLocation(0, 890);
	}
	public void AddToScore() {
		score += 50;
	}
	public void resetgame() {
		if (frog1.GetLives() <= 0) {
			Gameprep.this.setVisible(false);
			Gameprep.this.dispose();
			new Gameprep();
		}
	}
	public static void main(String[] args) {
		Gameprep testgame = new Gameprep();
		testgame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == StartButton) {
			//empty for now
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int x = frog1.getX(); int y = frog1.getY();
		
		//modify position
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y -= Gameproperties.CHARACTER_STEP;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += Gameproperties.CHARACTER_STEP;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= Gameproperties.CHARACTER_STEP-40;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += Gameproperties.CHARACTER_STEP-40;
		} else {
			System.out.println("invalid operation");
		}
		frog1.setX(x);
		frog1.setY(y);
		//update graphic
		frog1Label.setLocation(frog1.getX(), frog1.getY());
		//frog1rect.setLocation(frog1.getX(), frog1.getY());
	}

	public void DisplayContents() {
		//implement start button
		StartButton = new JButton("Start");
		StartButton.setSize(100, 100);
		StartButton.setLocation(853, 700);
		//declare player 1 frog
		frog1 = new Frog1();
		frog1.setX(400); frog1.setY(890);
		frog1.setWidth(100); frog1.setHeight(100);
		frog1.setImage("greenfrog.png");
		//declare vehicle to be used in a row
		
		vehicle1 = new Vehicle();
		vehicle1.setX(0);
		vehicle1.setY(800);
		vehicle1.setWidth(127); vehicle1.setHeight(90);
		vehicle1.setImage("car.png");
		
		//set up screen
		setSize(Gameproperties.SCREEN_WIDTH, Gameproperties.SCREEN_HEIGHT+45);
		content = getContentPane();
		content.setBackground(Color.white);
		setLayout(null);
		
		//insert previous classes into labels and images
		
		vehicle1Label = new JLabel();
		vehicle1Image = new ImageIcon(getClass().getResource("car.png"));
		vehicle1Label.setIcon(vehicle1Image);
		vehicle1Label.setSize(vehicle1.getWidth(), vehicle1.getHeight());
		vehicle1Label.setLocation(vehicle1.getX(),vehicle1.getY());
		
		frog1Label = new JLabel();
		frog1Image = new ImageIcon(getClass().getResource("greenfrog.png"));
		frog1Label.setIcon(frog1Image);
		frog1Label.setSize(frog1.getWidth(), frog1.getHeight());
		frog1Label.setLocation(frog1.getX(), frog1.getY());
		
		//background of panel
		JLabel Backgroundlab = new JLabel();
		ImageIcon Backgroundimg = new ImageIcon(getClass().getResource("background.png"));
		Backgroundlab.setIcon(Backgroundimg);
		Backgroundlab.setSize(Gameproperties.SCREEN_WIDTH, Gameproperties.SCREEN_HEIGHT);
		Backgroundlab.setLocation(0,5);
		//insert labels 
		add(frog1Label);

		add(vehicle1Label);
		vehicle1.SetVehicleLabel(vehicle1Label);
		add(StartButton);
		add(Backgroundlab);
		
		content.addKeyListener(this);
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//start button 
		StartButton.addActionListener(this);
		StartButton.setFocusable(false);
		
	}
	
	public void InsertVehicleRows() {
		Vehicle[] vehiclelane;
		ImageIcon vehicleicon = new ImageIcon(getClass().getResource("car.png"));
		//use a for loop to input objects into a array
		//creates 4 cars
		int offset = 300;
		int Xoffset = 0;
		int height = 90;
		int width = 127;
		vehiclelane = new Vehicle[4];
		
		for (int i = 0; i<=2; i++ ) {
			vehiclelane[i] = new Vehicle();
		}
		
		for (Vehicle vehicle : vehiclelane) {
			vehicle = new Vehicle();
			JLabel VEHICLElabel = new JLabel(); 
			VEHICLElabel.setIcon(vehicleicon);
			VEHICLElabel.setSize(width, height);
			
			vehicle.SetVehicleLabel(VEHICLElabel);
			vehicle.setX(vehicle.getX() + Xoffset);
			vehicle.setY(710);
			VEHICLElabel.setLocation(vehicle.getX(), vehicle.getY());
			add(VEHICLElabel);
			Xoffset += offset;
		}
		for (Vehicle vehicle2 : vehiclelane) {
			vehicle2 = new Vehicle();
			JLabel VEHICLElabel2 = new JLabel(); 
			VEHICLElabel2.setIcon(vehicleicon);
			VEHICLElabel2.setSize(width, height);
			vehicle2.setX(vehicle2.getX() + Xoffset);
			vehicle2.setY(620);
			VEHICLElabel2.setLocation(vehicle2.getX()-1200, vehicle2.getY());
			vehicle2.SetVehicleLabel(VEHICLElabel2);
			add(VEHICLElabel2);
			Xoffset += offset;
		}
		for (Vehicle vehicle3 : vehiclelane) {
			vehicle3 = new Vehicle();
			JLabel VEHICLElabel3 = new JLabel(); 
			VEHICLElabel3.setIcon(vehicleicon);
			VEHICLElabel3.setSize(width, height);
			vehicle3.setX(vehicle3.getX() + Xoffset);
			vehicle3.setY(800);
			VEHICLElabel3.setLocation(vehicle3.getX()-2400, vehicle3.getY());
			vehicle3.SetVehicleLabel(VEHICLElabel3);
			
			add(VEHICLElabel3);
			Xoffset += offset;
		}
	}
	
	public void InsertLogRows() {
		Log[] LogLane;
		//repeated code instead it's LOGS
		LogLane = new Log[3];
		for (int i = 0; i<3; i++) {
			LogLane[i] = new Log();
		}
		for (Log log1 : LogLane) {
			log1 = new Log();
		}
		for (Log log2 : LogLane) {
			log2 = new Log();
		}
		for (Log log3 : LogLane) {
			log3 = new Log();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}

