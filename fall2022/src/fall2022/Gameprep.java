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
	//private ImageIcon vehicle1Image;
	private JButton StartButton;
	
	private JLabel VEHICLElabel, VEHICLElabel2, VEHICLElabel3;
	private ImageIcon vehicleicon = new ImageIcon(getClass().getResource("car.png"));
	//private Vehicle vehicle1;
	//private JLabel vehicle1Label;
	private Vehicle vehiclelane[];
	private Vehicle vehiclelane1[];
	private Vehicle vehiclelane2[];
	
	private JLabel LOGlabel, LOGlabel2, LOGlabel3;
	private Log LogLane[];
	private Log LogLane1[];
	private Log LogLane2[];
	private ImageIcon logicon = new ImageIcon(getClass().getResource("log.png"));
	
	
	private int offset = 300;
	private int heightveh = 90;
	private int widthveh = 127;
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
			for(Vehicle two : vehiclelane) {
				two.StartMoving();
			}
			for(Vehicle one : vehiclelane1) {
				//one.StartMoving();
			}
			for(Vehicle three : vehiclelane2) {
				//three.StartMoving();
			}
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
			x -= Gameproperties.CHARACTER_STEP-45;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += Gameproperties.CHARACTER_STEP-45;
		} else {
			System.out.println("invalid operation");
		}
		frog1.setX(x);
		frog1.setY(y);
		//update graphic
		System.out.println(y);
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
		frog1.SetLives(lifes);

		//set up screen
		setSize(Gameproperties.SCREEN_WIDTH, Gameproperties.SCREEN_HEIGHT+45);
		content = getContentPane();
		content.setBackground(Color.white);
		setLayout(null);
		
		//insert previous classes into labels and images
		frog1Label = new JLabel();
		frog1Image = new ImageIcon(getClass().getResource("greenfrog.png"));
		frog1Label.setIcon(frog1Image);
		frog1Label.setSize(frog1.getWidth(), frog1.getHeight());
		frog1Label.setLocation(frog1.getX(), frog1.getY());
		// grass
		
		
		//background of panel
		JLabel Backgroundlab = new JLabel();
		ImageIcon Backgroundimg = new ImageIcon(getClass().getResource("background.png"));
		Backgroundlab.setIcon(Backgroundimg);
		Backgroundlab.setSize(Gameproperties.SCREEN_WIDTH, Gameproperties.SCREEN_HEIGHT);
		Backgroundlab.setLocation(0,5);
		//insert labels 
		add(frog1Label);

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
		vehiclelane = new Vehicle[4];
		int Xoffset = 0;
		for (int i = 0; i<4; i++ ) {
			vehiclelane[i] = new Vehicle();
			VEHICLElabel = new JLabel(); 
			VEHICLElabel.setIcon(vehicleicon);
			VEHICLElabel.setSize(widthveh, heightveh);
			vehiclelane[i].SetVehicleLabel(VEHICLElabel);
			vehiclelane[i].setX(vehiclelane[i].getX() + Xoffset);
			vehiclelane[i].setY(710);
			VEHICLElabel.setLocation(vehiclelane[i].getX(), vehiclelane[i].getY());
			add(VEHICLElabel);
			Xoffset += offset;
		}
	}
	public void InsertLogRows() {
		LogLane = new Log[4];
		for (int i = 0; i<4; i++) {
			LogLane[i] = new Log();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}

