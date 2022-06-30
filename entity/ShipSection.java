package entity;

import java.awt.Graphics2D;

import util.Util;

public class ShipSection extends Entity {

	private boolean isDamaged;
	private int frame;
	private float time;
	private float frametime;

	public ShipSection(int x, int y) {
		super(x, y);
		isDamaged = false;
		frame = 1;
		time = Util.getTime();
		frametime = 0.1f;
	}

	@Override
	public void update() {
		if (Util.getTime() - time > frametime) {
			frame += 1;
			if (frame > 4) {
				frame = 1;
			}
			time += frametime;
		}
	}

	@Override
	public void render(Graphics2D g) {
		if (isDamaged) {
			switch (frame) {
			case 1:
				g.drawImage(Util.images.get("flame1"), (x * Util.tileSize) + Util.tileSize / 4, (y * Util.tileSize) + Util.tileSize / 4, Util.tileSize / 2, Util.tileSize / 2, null);
				break;
			case 2:
				g.drawImage(Util.images.get("flame2"), (x * Util.tileSize) + Util.tileSize / 4, (y * Util.tileSize) + Util.tileSize / 4, Util.tileSize / 2, Util.tileSize / 2, null);
				break;
			case 3:
				g.drawImage(Util.images.get("flame3"), (x * Util.tileSize) + Util.tileSize / 4, (y * Util.tileSize) + Util.tileSize / 4, Util.tileSize / 2, Util.tileSize / 2, null);
				break;
			case 4:
				g.drawImage(Util.images.get("flame4"), (x * Util.tileSize) + Util.tileSize / 4, (y * Util.tileSize) + Util.tileSize / 4, Util.tileSize / 2, Util.tileSize / 2, null);
				break;
			}
		}
	}
	public void setDamaged(boolean b) {
		isDamaged = b;
	}

	public boolean isDamaged() {
		return isDamaged;
	}
	
	public void updatePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isColliding(ShipSection s) {
		if (s.getX() == x && s.getY() == y) {
			return true;
		}
		return false;
	}

	public boolean inBounds() {
		if (x > 9 || y > 9) {
			return false;
		}
		return true;
	}

	public boolean checkBullet(int x, int y){
		if(x==this.x && y==this.y){
			isDamaged=true;
			return true;
		}
		return false;
	}
}
