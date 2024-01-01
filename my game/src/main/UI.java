package main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
	PanelGame gp;
	Graphics2D a2;
	public int perintahNomor = 0;
	
	public UI(PanelGame gp) {
		this.gp = gp;
		// UNTUK MEMBUAT TAMPILAN AWAL SEBELUM MEMUALI GAME
		
	}

	public void draw(Graphics2D a2) {
		this.a2 = a2;
		
		
		if(gp.judulGame == gp.tampilanAwal) {
			drawTitleScreen();
		}
		
		if(gp.judulGame == gp.mulaiGame) {
			
		}
		
	}
	public void drawTitleScreen() { // METHOD UNTUK MEMBENTUK TAMPILAN AWAL
		
		a2.setColor(new Color(0,0,0)); // MENAMPILKAN WARNA LAYAR UTAMA SESUAI YANG DIINGINKAN
		a2.fillRect(0, 0, gp.lebarLayar, gp.tinggiLayar);
		
		// NAMA GAME
		a2.setFont(a2.getFont().deriveFont(Font.BOLD,96F)); // FONT YANG DIGUNAKAN PADA TAMPILAN AWAL
		String text = "OldMan"; // JUDUL GAME PADA TAMPILAN AWAL GAME
		int x = getXforcenteredText(text);
		int y = gp.ukuranUbin*3;
		
		a2.setColor(Color.red);// WARNA DALAM TAMPILAN AWAL GAME
		a2.drawString(text, x+5, y+5);
		
		a2.setColor(Color.white); // WARNA PADA TITLE
		a2.drawString(text, x, y);
		
		a2.setFont(a2.getFont().deriveFont(Font.BOLD,40F));
		text = "NEW GAME"; // PILIHAN UNTUK MEMILIH NEW GAME ATAU LOAD GAME
		x = getXforcenteredText(text);
		y += gp.ukuranUbin*3.5;
		a2.drawString(text, x, y);
		 if(perintahNomor == 0) {
			 a2.drawString(">", x-gp.ukuranUbin, y);
		 }

	} 
	
	public int getXforcenteredText(String text) {
		int panjang = (int)a2.getFontMetrics().getStringBounds(text, a2).getWidth();
		int x = gp.lebarLayar/2 - panjang/2;
		return x;// UNTUK MENJALANKAN TAMPILAN
	}
}

