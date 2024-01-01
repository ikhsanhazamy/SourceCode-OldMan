package main;

import javax.swing.JFrame; // JENDELA UTAMA GAME

public class Main { // CLASS DARI MAIN

	public static void main(String[] args) {
		
		JFrame jendela = new JFrame (); // MEMBUAT JENDELA
		jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // MENUTUP JENDELA DENGAN BENAR 
		jendela.setResizable(false); // TIDAK DAPAT MERUBAH UKURAN JENDELA
		jendela.setTitle("Gantle Game"); // NAMA GAME
		
		PanelGame gamePanel = new PanelGame();
		jendela.add(gamePanel); // MENAMBAH GAMEP PANEL
		
		jendela.pack(); // UNTUK MENGEMAS PANEL GAME, JUGA UNTUK MENYESUAIKAN UKURAN DAN TATALETAK YANG KITA INGINKAN
		
		jendela.setLocationRelativeTo(null); // JENDELA AKAN DITAMPILKAN DITENGAH LAYAR
		jendela.setVisible(true); // MENAMPILKAN JENDELA TERLIHAT	
		
		gamePanel.startGameThread(); // UNTUK MEMANGGIL THREAD
		
	}
}
