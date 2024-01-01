package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.character;
import tile.TileManager;

import javax.swing.JPanel;

public class PanelGame extends JPanel implements Runnable{ // EXTENDS MEMPERLUAS JPenel DAN IMPLEMENT RUNNABLE UNTUK MENJALANKAN THREAD
														   // PANELGAME MERUPAKAN SUBKELAS DARI JPANEL
	//SETINGAN LAYAR
	final int ukuranUbinAsli = 16; //16x16 UBIN MENJADI UKURAN DEFAULT KARAKTER DAN UBIN PETA
	final int skala = 3; // MEMPERBESAR MENJADI SEPERTI 48 PIXELS KARENA 16X3
	
	public final int ukuranUbin = ukuranUbinAsli * skala;//48x48 UKURAN UBIN 
	public final int maxLayarKolom = 16; // LAYAR SAMPING PADA LAYAR
	public final int maxLayarBaris = 12; // LAYAR KEBAWAH PADA LAYAR
	public final int lebarLayar = ukuranUbin * maxLayarKolom; // 768 pixels TOTAL LEBAR LAYAR
	public final int tinggiLayar = ukuranUbin * maxLayarBaris; // 576 pixels TOTAL TINGGI LAYAR
	
	//SETINGAN MAPS
	public int maxKolomPeta = 50; // TOTAL KOLOM PETA
	public int maxBarisPeta = 50; // TOTAL GARIS PETA
	public int lebarPeta = ukuranUbin * maxKolomPeta; // 2.400 TOTLAS LEBAR PETA YANGB AKAN DITAMPILKAN DI LAYAR
	public int tinggiPeta = ukuranUbin * maxBarisPeta; // 2.400 TOTAL TINGGI PETA  YANGB AKAN DITAMPILKAN DI LAYAR
	
	
	//FPS
	int FPS = 60; // REFRESH LAYAR DENGAN FPS 60/DETIK
	
	TileManager tileManager = new TileManager(this);	
	KeyHandler KeyH = new KeyHandler (this); // INSTANCE DARI KEYHENDLER
	
	Thread gameThread; // UNTUK MEMULAI DAN MENGHENTIKAN GAME DAN UNTUK MENGAKTIFKANNYA KITA IMPELEMNTASIKAN RUNNABLE PADA CLASS PANEL GAME DIATAS
	public collisioncheck ccheck = new collisioncheck(this);
	public character character = new character(this,KeyH);
	public UI ui = new UI (this);
	
	// SETINGAN PLAYES POSISI DEFAULT
	public int judulGame;
	public final int tampilanAwal = 0;
	int playerX = 100; // POSISI AWAL KARAKTER
	int playerY = 100; // POSISI AWAL KARAKTER
	int kecepatan = 5; // KECEPATAN JALAN KARAKTER
	
	// JUDUL GAME
	public int judulGme; // JUDUL GAME YANG AKAN DITAMPILKAN KETIKA KITA BARU MEMBUKA GAME NYA
	public final int mulaiGame = 1; // UNUTK AWALAN GAME SEBELUM MASUK KE GAMENYA
	
	
	
	
	public PanelGame () {
		this.setPreferredSize(new Dimension(lebarLayar,tinggiLayar)); // MENGATUR DIMENSI UKURAN PANEL PADA PANELGAME
		this.setBackground(Color.black); // LATAR AWAL SEBELUM PETA DIEDIT
		this.setDoubleBuffered(true); // FUNGSI BURRERING SEBAGAI DEFAULT MEMBUAT RENDERING GAMBAR MENJADI LEBIH BAIK
		this.addKeyListener(KeyH); // MEMBACA KEY YANG DI TERAPKAN
		this.setFocusable(true); // SUPAYA GAME PANEL FOKUS UNTUK MENGINPUT
		
	}
	
	public void pengaturanGame() {
		
		judulGame = tampilanAwal; // JUDUL GAME AKAN MUNCUL DI TAMPILAN AWAL GAME
		
	}
	
	
	public void startGameThread() { // MEMULAI GAMETHREAD
		
		gameThread = new Thread(this); // MEMBUAT INSTANCE ATAU WUJUD DARI GAMETHREADNYA (THIS) BERARTI KELAS GAMETHREAD YANG DITUJU
		gameThread.start(); // MENAJALANKANN GAMETHRAD, INI AKAN OTOTMATIS MEMANGGIL METHOD RUN
	}

	
	public void run() { // METHOD DARI RUNNABLE UNTUK MENGAKTIFKAN GAMETHREAD
		double drawInterval = 1000000000/FPS; // REFRESH FPS PER DETIK
		double delta = 0;
		long lastTime = System.nanoTime(); // WAKTUNYA TIDAK DITENTUKAN
		long currentTime;
		long timer = 0; 
		int drawCount = 0;
		
		while (gameThread !=null) { // WHILE LOOP(BERULANG ULANG) INTI DARI GAME INI 
									// SELAMA GAMETHRAD ADA MAKA YANG AKAN TERUS MEBGULANGI YANG TERTULIS DALAM KURUNG 
			 						// LOOP INI JUGA MENGULANG UPDATE DAN DAN PAINT COMPONENT   
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			lastTime = currentTime;
			
			if (delta >= 1) {
				update(); // MEMANGGIL METHODE UPDATE 
				repaint(); // MEMANGGIL METHOD PAINTCOMPONENT
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS:"+drawCount); // MEEFRES FPS PERSEKIAN DETIKNYA
				drawCount = 0;
				timer = 0;
			}
			
		}
		
	}
	public void update() {
		 
		character.update(); // MEREFRESH KARAKTER DI SETIAP DETI8KNYA DENGAN 60FPS
	}
	
	public void paintComponent(Graphics a) { // MENAMBAHKAN GRAPHICS SEBAGAI A
		super.paintComponent(a); // SUPER MERUPAKAN INDUK CLASS YAITU JPANEL
		
		Graphics2D a2 = (Graphics2D)a; // UNTUK MEMPERLUAS CLASS DARI GRAFIK UNTUK MEMBERIKAN KONTROL MENEJEMEN WARNA KORDINAT DAN LAINNYA
		
		// TAMPILAN LAYAR AWAL
		if(judulGame == tampilanAwal) {
			ui.draw(a2); // TAMPILAN SPALSHSCREEN ATAU UI SEBELUM MASUK KE GAME NYA
		}
		// lain lain
		else {
			tileManager.draw(a2);
			
			
			
			character.draw(a2);
			
			
			ui.draw(a2);
		}
		
		a2.dispose(); // MEMBUANG KONTEKS GRAFIS DAN MELEPASKAN SUMBERDAYA SISTEM YANG DIGUNAKAN	
	}
}














