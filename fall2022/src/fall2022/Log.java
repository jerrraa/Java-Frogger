package fall2022;

public class Log extends Sprite implements Runnable {
	private Boolean moving;
	private int x, y;
	private Boolean visible;
	public Log () {
		super(0,0,135,145,"log.png");
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
