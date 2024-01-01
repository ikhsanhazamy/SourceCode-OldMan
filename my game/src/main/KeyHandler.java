package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{ // UNTUK MEMBACA PENEKANAN PADA TOMBOL "W A S D"
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed; // MENGGUNAKAN TIPE BOOLEAN UNTUK TRUE ATAU FALSE
 PanelGame gp;

 
	public KeyHandler(PanelGame gp) { // GP ADALAH GAME PANEL
		this.gp = gp;
	}// SUPAYA KEY BISA DI BACA MAKA KITA MASUKAN GAME PANEL KEDALAM CLASS KEYHENDLER INI

	@Override
	public void keyTyped(KeyEvent e) {
		 
	}
	
    //SETTING JALAN PLAYER
	@Override
	public void keyPressed(KeyEvent e) { // METHOD DARI KEYLISTENER
		int code = e.getKeyCode(); // MEMBACA TOMBOL YANG DITEKAN 
		
		// JUDUL GAME
		if(gp.judulGame == gp.tampilanAwal) {
			
		}
		
		if(code == KeyEvent.VK_ENTER) {
			if(gp.ui.perintahNomor == 0) {
				gp.judulGame = gp.mulaiGame;
			}
			// TAMPILAN AWAL GAME SEBELUM MEMUALAI GAME
			if(gp.ui.perintahNomor == 1) {
				
			}
			// ENTER ADALAH TOMBOL YANG DITEKAN KETIKA INGINJ MEMULAI GAME BARU
			
		}
		
		if(gp.judulGame == gp.mulaiGame) {
		
		if (code == KeyEvent.VK_W) { // keyEvent MENJELASKAN SESUATU YANG TERJADI JIKA TOMBOL YANG DIMAKSUD DITEKAN
			upPressed = true; // TOMBOL W UMTUK MAJU
	}						  
		if (code == KeyEvent.VK_S) {
			downPressed = true; // TOMBOL S UNTUK MUNDUR
	}
		if (code == KeyEvent.VK_A) {
			leftPressed = true; // TOMBOL A UNTUK KE KIRI
	}
		if (code == KeyEvent.VK_D) { 
			rightPressed = true; // TOMBOL D UNTUK KR KANAN
	}
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		} // KONSFIRMASI UNTUK MEMULAI GAME
		
		
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { // METHOD DARI KEYLISTENER
										  // keyReleased FUNGSI KETIKA MELEPASKAN TOMBOL YANG DI MAKSUD
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
	}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
	}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
	}
		if (code == KeyEvent.VK_D) { 
			rightPressed = false;
		}
		
		if (code == KeyEvent.VK_ENTER) {
			enterPressed = false;

		}	// DIKETIK FALSE KARENA JIKA TRUE KARAKTER AKAN TERUS BERGERAK TIDAK BISA DI HENTIKAN
	}
}
		
	


