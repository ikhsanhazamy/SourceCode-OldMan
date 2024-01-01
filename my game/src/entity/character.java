package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyHandler;
import main.PanelGame;

// CLASS UNTUK KARAKTER DI EXTENDS DENGAN ENTITY
public class character extends Entity{
	 
	PanelGame gp; // IMPORTAN DARI GAME PANEL
	KeyHandler KeyH; // IMPORTAN DARI KEYHENDLER
	/* SUPAYA SI KARAKTER BISA MASUK KE PANEL GAME JUGA BISA MENERIMA PERINTAH 
	   SESUAI DENGAN KEY YANG TELAH KITA SETTING SEBELUMNYA*/
	
	public int layarX; //
	public int layarY; //
	
	
	public character(PanelGame gp, KeyHandler KeyH) {
		
		this.gp = gp; 
		this.KeyH = KeyH;
		// SUPAYA KARAKTER BISA MASUK KE PANEL GAME JUGA BISA MEMBACA TOMBOL YANG KITA TEKAN
		
		
		/* INI ADALAH SETTING KARAKTER SUPAYA BISA BERADA DI TENGAH LAYAR LAPTOP 
		   YAITU DENGAN LEBAR LAYAR DIBAGI DUA DIKURANG DENGAN UKURANUBIN DIBAGI DUA
		   TINGGI LAYAR DIBAGI DUA DIKURANG UKURANUBIN DIBAGI DUA*/
		layarX = gp.lebarLayar/2 - (gp.ukuranUbin/2);
		layarY = gp.tinggiLayar/2 - (gp.ukuranUbin/2);
		
		solidArea = new Rectangle();
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getcharacterImage();
		
	}
	
	public void setDefaultValues() {
		
		petaX = gp.ukuranUbin * 23;
		petaY = gp.ukuranUbin * 21;
		kecepatan = 5;
		direction = "down";
	}
	
	
	
	/*MENGIMPORT FILE GAMBAR KARAKTER YANG KITA PUNYA KEDALAM KODINGAN INI SUPAYA BISA KIKTA EDIT UNTUK BISA MELAKUKAN GERAK*/
	public void getcharacterImage() {
		try  {
			
			up1 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_up_1.png"));
			up2 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_up_2.png"));
			down1 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_down_1.png"));
			down2 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_down_2.png"));
			left1 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_left_1.png"));
			left2 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_left_2.png"));
			right1 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_right_1.png"));
			right2 = ImageIO.read (getClass().getResourceAsStream("/character/oldman_right_2.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if (KeyH.upPressed == true || KeyH.downPressed == true ||
				KeyH.leftPressed == true || KeyH.rightPressed == true) {
			
			if (KeyH.upPressed == true) {
				direction = "up";
				petaY -= kecepatan;
			}
			else if(KeyH.downPressed == true) {
				direction = "down";
				petaY += kecepatan;
			}
			else if(KeyH.leftPressed == true) {
				direction = "left";
				petaX -= kecepatan;
			}
			else if(KeyH.rightPressed == true) {
				direction = "right";
				petaX += kecepatan;
			}
			
			collisonOn = false;
			gp.ccheck.checkTile(this);
			
			spriteCounter++;
			if (spriteCounter > 12) {
				if(spriteNumber == 1) {
					spriteNumber =2;
				}
				else if(spriteNumber == 2) {
					spriteNumber = 1;
				}
				spriteCounter = 0;
			}
		}
		
		
	}
	
	public void draw(Graphics2D a2) {
//		a2.setColor(Color.white);
//		a2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if (spriteNumber == 1) {
				image = up1;
			}
			if (spriteNumber == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNumber == 1) {
				image = down1;
			}
			if (spriteNumber == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNumber ==1) {
				image = left1;
			}
			if (spriteNumber == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNumber == 1) {
				image = right1;
			}
			if (spriteNumber == 2) {
				image = right2;
			}
			break;
		}
		
		a2.drawImage(image, layarX, layarY, gp.ukuranUbin, gp.ukuranUbin, null);
	}
}









