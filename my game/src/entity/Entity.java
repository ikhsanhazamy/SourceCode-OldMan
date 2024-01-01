package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity { // MENYATUKAN 
	public int petaX, petaY;
	public int kecepatan;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNumber = 1;
	public Rectangle solidArea;
	public boolean collisonOn = false;
	

}
