package fall2022;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gameprep extends JFrame implements KeyListener, ActionListener{
	private static final long serialVersionUID = 1L;
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
	private ReverseVehicle vehiclelane1[];
	private Vehicle vehiclelane2[];
	
	private JLabel LOGlabel, LOGlabel2, LOGlabel3;
	private Log LogLane[];
	private Log LogLane1[];
	private Log LogLane2[];
	private ImageIcon logicon = new ImageIcon(getClass().getResource("log.png"));
	
	private int offset = 300;
	private int heightveh = 90;
	private int widthveh = 127;
	private JLabel LifeText, ScoreText;
	int lifes = 3;
	int score;
	int xreset = 400; int yreset = 912;
	public Gameprep() {
		InsertVehicleRows();
		InsertVehicleRows1();
		InsertVehicleRows2();
		System.out.println(lifes);
		InsertLogRows();
		DisplayContents();
	}
	public void Resetfrogger() {
		//if frog intersects with vehicle or log, we reset.
		lifes--;
		frog1.SetLives(lifes);
		DataScore.INSTANCE.addScore(score-=50);
		LifeText.setText("Lifes: " + frog1.GetLives());
		ScoreText.setText("Score: " + DataScore.INSTANCE.GetScore());
		frog1.setX(xreset); frog1.setY(yreset);
		frog1Label.setLocation(frog1.getX(), frog1.getY());
		
		Resetgame();
	}
	public void AddToScore() {
		score += 50;
		ScoreText.setText("Score: " + DataScore.INSTANCE.GetScore());
		frog1.setX(xreset); frog1.setY(yreset);
		frog1Label.setLocation(frog1.getX(), frog1.getY());
		
	}
	public void Resetgame() {
		System.out.println(frog1.GetLives());
		if (frog1.GetLives() <= 0) {
			Gameprep.this.setVisible(false);
			Gameprep.this.dispose();
			new Gameprep();
			Gameprep.main(null);
		}
	}
	public static void main(String[] args) {
		Gameprep testgame = new Gameprep();
		testgame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == StartButton) {
			
			for(ReverseVehicle one : vehiclelane1) {
				one.GrabFrog1(frog1);
				one.GrabGame(this);
				one.StartMoving();
			}
			for(Vehicle two : vehiclelane) {
				two.GrabFrog1(frog1);
				two.GrabGame(this);
				two.StartMoving();
			}
			for(Vehicle three : vehiclelane2) {
				three.GrabFrog1(frog1);
				three.GrabGame(this);
				three.StartMoving();
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
		System.out.println(x+" "+y);
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
		frog1.setX(400); frog1.setY(912);
		frog1.setWidth(67); frog1.setHeight(60);
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
		LifeText = new JLabel("");
		LifeText.setFont(new Font("Calibri", Font.BOLD, 30));
		LifeText.setText("Lifes: " + lifes);
		LifeText.setForeground(Color.WHITE);
		LifeText.setSize(200, 200);
		LifeText.setLocation(10, -56);
		
		ScoreText = new JLabel("");
		ScoreText.setFont(new Font("Calibri", Font.BOLD, 30));
		ScoreText.setText("Score: " + DataScore.INSTANCE.GetScore());
		
		ScoreText.setForeground(Color.WHITE);
		ScoreText.setSize(200, 200);
		ScoreText.setLocation(10, -27);
		//background of panel
		JLabel Backgroundlab = new JLabel();
		ImageIcon Backgroundimg = new ImageIcon(getClass().getResource("background.png"));
		Backgroundlab.setIcon(Backgroundimg);
		Backgroundlab.setSize(Gameproperties.SCREEN_WIDTH, Gameproperties.SCREEN_HEIGHT);
		Backgroundlab.setLocation(0,5);
		//insert labels 
		add(LifeText);
		add(ScoreText);
		add(StartButton);
		add(frog1Label);
		add(StartButton);
		add(Backgroundlab);
		
		content.addKeyListener(this);
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//start button 
		StartButton.setFocusable(false);
		StartButton.addActionListener(this);
		
	}
	//this belongs to middle row
	public void InsertVehicleRows() {
		vehiclelane = new Vehicle[4];
		int Xoffset = 0;
		for (int i = 0; i<4; i++ ) {
			vehiclelane[i] = new Vehicle();
			VEHICLElabel = new JLabel(); 
			VEHICLElabel.setIcon(vehicleicon);
			VEHICLElabel.setSize(widthveh, heightveh);
			
			vehiclelane[i].SetVehicleLabel(VEHICLElabel);
			vehiclelane[i].setHeight(heightveh); vehiclelane[i].setWidth(widthveh);
			vehiclelane[i].setX(vehiclelane[i].getX() + Xoffset);
			vehiclelane[i].setY(710);
			vehiclelane[i].SetSpeed(Gameproperties.CHARACTER_STEP-60);
			VEHICLElabel.setLocation(vehiclelane[i].getX(), vehiclelane[i].getY());
			
			add(VEHICLElabel);
			Xoffset += offset-20;
		}
	}
	//this belongs to top row
	public void InsertVehicleRows1(){
		vehiclelane1 = new ReverseVehicle[4];
		int Xoffset = 0;
		for (int i = 0; i<4; i++ ) {
			vehiclelane1[i] = new ReverseVehicle();
			VEHICLElabel2 = new JLabel(); 
			VEHICLElabel2.setIcon(vehicleicon);
			VEHICLElabel2.setSize(widthveh, heightveh);
			vehiclelane1[i].SetVehicleLabel(VEHICLElabel2);
			vehiclelane1[i].setHeight(heightveh); vehiclelane1[i].setWidth(widthveh);
			vehiclelane1[i].setX(vehiclelane1[i].getX() + Xoffset);
			vehiclelane1[i].setY(620);
			vehiclelane1[i].SetSpeed(Gameproperties.CHARACTER_STEP-80);
			VEHICLElabel2.setLocation(vehiclelane1[i].getX(), vehiclelane1[i].getY());
			add(VEHICLElabel2);
			Xoffset += offset+20;
		}
	}
	//this belongs to bottom row
	public void InsertVehicleRows2(){
		vehiclelane2 = new Vehicle[4];
		int Xoffset = 0;
		for (int i = 0; i<4; i++ ) {
			vehiclelane2[i] = new Vehicle();
			VEHICLElabel3 = new JLabel(); 
			VEHICLElabel3.setIcon(vehicleicon);
			VEHICLElabel3.setSize(widthveh, heightveh);
			vehiclelane2[i].SetVehicleLabel(VEHICLElabel3);
			vehiclelane2[i].setHeight(heightveh); vehiclelane1[i].setWidth(widthveh);
			vehiclelane2[i].setX(vehiclelane2[i].getX() + Xoffset);
			vehiclelane2[i].setY(800);
			vehiclelane2[i].SetSpeed(Gameproperties.CHARACTER_STEP-40);
			VEHICLElabel3.setLocation(vehiclelane2[i].getX(), vehiclelane2[i].getY());
			add(VEHICLElabel3);
			Xoffset += offset+50;
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

