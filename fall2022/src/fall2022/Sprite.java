package fall2022;

import java.awt.Rectangle;

/*
 	1. Create the new class skeleton
 	2. identify all class attributes (data members)
 	3. getters and setters (accessors, mutators)
 	4. default constructor
 	5. secondary constructors
 	6. print/display function
 	7. any other code required for objects
 	8. run in an application
 */

public class Sprite {
	protected int x, y; // upper left, top position
	protected int height, width; 
	protected String image;
	protected Rectangle r;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Sprite() {
		super();
		this.x = -1;
		this.y = -1;
		this.width = -1;
		this.height = -1;
		this.image = "";
	}
	public Sprite(int x, int y, int height, int width, String image) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.image = image;
	}
	public void display() {
		System.out.println("x, y: "+ this.x + "," + this.y);
		System.out.println("height, width: "+ this.height + "," + this.width);
		System.out.println("image: " + this.image);
	}
	
}
