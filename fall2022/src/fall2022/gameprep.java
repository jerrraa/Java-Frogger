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

public class gameprep extends JFrame implements KeyListener, ActionListener{
	
	//instances of our data classes (store position, etc here)
	private frog1 frog1; private Rectangle frog1rect;
	//graphic elements
	private Container content;
	private JLabel frog1Label;
	private ImageIcon frog1Image;
	private JButton StartButton;
	
	private vehicle vehicle;
	
	private vehicle VehicleRow[];
	private vehicle VehicleRow1[];
	
	private Log LogRow[];
	private Log LogRow1[];
	
	private int death_count = 0;
	private int score = 0;
	
	public gameprep() {
		//insert 
		VehicleRow = new vehicle[2];
		VehicleRow1 = new vehicle[2];
		LogRow = new Log[2];
		LogRow1 = new Log[2];
		
		
		DisplayContents();
	}
	public static void main(String[] args) {
		gameprep testgame = new gameprep();
		testgame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		vehicle.NewThread();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int x = frog1.getX(); int y = frog1.getY();
		
		//modify position
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y -= gameproperties.CHARACTER_STEP;
			frog1.display();

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += gameproperties.CHARACTER_STEP;
			frog1.display();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= gameproperties.CHARACTER_STEP;
			frog1.display();
			
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += gameproperties.CHARACTER_STEP;
			frog1.display();
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
		
		frog1 = new frog1();
		frog1.setX(400); frog1.setY(850);
		frog1.setWidth(100); frog1.setHeight(100);
		frog1.setImage("greenfrog.png");
		
		//set up screen
		setSize(gameproperties.SCREEN_WIDTH, gameproperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.white);
		setLayout(null);
		
		// graphic element instantiation and add to screen
		
		frog1Label = new JLabel();
		frog1Image = new ImageIcon(getClass().getResource("greenfrog.png"));
		frog1Label.setIcon(frog1Image);
		frog1Label.setSize(frog1.getWidth(), frog1.getHeight());
		frog1Label.setLocation(frog1.getX(), frog1.getY());
		
		JLabel Backgroundlab = new JLabel();
		ImageIcon Backgroundimg = new ImageIcon(getClass().getResource("background.png"));
		Backgroundlab.setIcon(Backgroundimg);
		Backgroundlab.setSize(gameproperties.SCREEN_WIDTH-16, 990);
		Backgroundlab.setLocation(0, 0);
		add(frog1Label);
		add(Backgroundlab);
		content.addKeyListener(this);
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//start button 
		StartButton.addActionListener(this);
		
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}

