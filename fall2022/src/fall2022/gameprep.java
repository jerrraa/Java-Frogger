package fall2022;
import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameprep extends JFrame implements KeyListener{
	
	//instances of our data classes (store position, etc here)
	private frog1 frog1; private Rectangle frog1rect;
	private vehicle car1; private Rectangle car1rect;
	private JLabel car1label; private ImageIcon car1image;
	//graphic elements
	private Container content;
	private JLabel frog1Label;
	private ImageIcon frog1Image;
	
	private JButton StartButton;
	
	public gameprep() {
		frog1 = new frog1();
		frog1.setX(400); frog1.setY(850);
		frog1.setWidth(100); frog1.setHeight(100);
		frog1.setImage("greenfrog.png");
		//set up screen
		setSize(gameproperties.SCREEN_HEIGHT, gameproperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.white);
		
		
		setLayout(null);
		// graphic element instantiation and add to screen
		frog1Label = new JLabel();
		frog1Image = new ImageIcon(getClass().getResource(frog1.getImage()));

		//populate
		
		//car section
		add(frog1Label);
		car1 = new vehicle();
		car1.setImage("car.png");
		car1.setX(400); car1.setY(700); car1.setHeight(74); car1.setWidth(132);
		car1label.setIcon(car1image);
		
		
		content.addKeyListener(this);
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		gameprep testgame = new gameprep();
		testgame.setVisible(true);

	}
	
	public void movecars() {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
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
		frog1rect.setLocation(frog1.getX(), frog1.getY());
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
