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

	
	public int death_count = 0;
	public int score = 0;
	
	public Gameprep() {
		
		InsertVehicleRows();
		InsertLogRows();
		DisplayContents();
	}
	public void reset() {
		//if frog intersects with vehicle or log, we reset.
		death_count++;
		score -= 50;
		frog1Label.setLocation(0, 0);
	}
	public void goalscore() {
		score += 50;
	}
	public static void main(String[] args) {
		Gameprep testgame = new Gameprep();
		testgame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == StartButton) {
			vehicle1.StartMoving(true);
			StartButton.setText("Stop");
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
			x -= Gameproperties.CHARACTER_STEP;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += Gameproperties.CHARACTER_STEP;
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
		add(StartButton);
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
		//insert the car onto panel and use thread
		add(vehicle1Label);
		vehicle1.updateVehicleLabel(vehicle1Label);
		add(Backgroundlab);
		
		content.addKeyListener(this);
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//start button 
		StartButton.addActionListener(this);
		StartButton.setFocusable(false);
		
	}
	
	public void InsertVehicleRows() {
		Vehicle[] vehiclerow1;
		//use a for loop to input objects into a array
		vehiclerow1 = new Vehicle[3];
		for (int i = 0; i<3; i++) {
			vehiclerow1[i] = new Vehicle();
		}
		
	}
	
	public void InsertLogRows() {
		Log[] LogsRow;
		//repeated code instead it's LOGS
		LogsRow = new Log[3];
		for (int i = 0; i<3; i++) {
			LogsRow[i] = new Log();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}

