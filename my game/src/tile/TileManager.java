package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.PanelGame;

public class TileManager {
	
	PanelGame gp;
	Tile[] tile;
	int mapTileNumber[][];
	
	public TileManager(PanelGame gp) { 
		
		this.gp = gp;
		tile = new Tile[10];
		mapTileNumber = new int[gp.maxKolomPeta][gp.maxBarisPeta];
		
		getTileImage();
		loadMap("/maps/world01.txt"); // MAPS YANG AKAN DITAMPILKAN
		
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile(); 
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
			// GAMBAR MENAMPILKAN RUMPUT
			
			tile[1] = new Tile(); 
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			// GAMBAR MENAMPILKAN TEMBOK

			tile[2] = new Tile(); 
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
			tile[2].collision = true;
			// GAMBAR MENAMPILKAN AIR
			
			tile[3] = new Tile(); 
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			tile[3].collision = true;
			// GAMBAR MENAMPILKAN TANAH
			
			tile[4] = new Tile(); 
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[4].collision = true;
			// GAMBAR MENAMPILKAN POHON
			
			tile[5] = new Tile(); 
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			// GAMBAR MENAMPILKAN PASIR
			
			tile[6] = new Tile(); 
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/hut.png"));
			// GAMBAR MENAMPILKAN RUMAH
			
			// DIBERIKAN NOMOR PADA SETIAP PNG AGAR MUDAH UNTUK MENGEDITNYA LEWAT NOTEPAD
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
		public void loadMap(String filePath) {
			try {
				InputStream is = getClass().getResourceAsStream(filePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				 
				int col = 0;
				int row = 0;
				
				while (col < gp.maxKolomPeta && row < gp.maxBarisPeta) {
							
					String line = br.readLine();
					
					while (col < gp.maxKolomPeta) {
						String numbers[] = line.split(" ");
						
						int number = Integer.parseInt(numbers[col]);
						
						mapTileNumber[col][row] = number;
						col++;
					}
					if(col == gp.maxKolomPeta) {
						col = 0;
						row++;
					}				
				}
				br.close();
				
				}catch(Exception e) {				
			}
		}
	
	
	public void draw(Graphics2D a2) { 
		
		
		int kolomPeta = 0;
		int barisPeta = 0;
		
		while(kolomPeta < gp.maxKolomPeta && barisPeta < gp.maxBarisPeta) {
			int tileNumber = mapTileNumber[kolomPeta][barisPeta];
			
			int worldX = kolomPeta * gp.ukuranUbin;
			int worldY = barisPeta * gp.ukuranUbin;
			int screenX = worldX - gp.character.petaX + gp.character.layarX;
			int screenY = worldY - gp.character.petaY + gp.character.layarY;
			
				
				a2.drawImage(tile[tileNumber].image, screenX, screenY, gp.ukuranUbin, gp.ukuranUbin, null);				
			
		
		kolomPeta++;
		
		if(kolomPeta == gp.maxKolomPeta) {
			kolomPeta = 0;
			barisPeta++;

			}
		}
	}
}




















