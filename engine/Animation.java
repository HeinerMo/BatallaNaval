package engine;
import util.Util;

abstract class Animation {
	
	private float speed;
	private float startingTime;
	
	public Animation(float speed) {
		this.speed = speed;
	}
	
	public void start() {
		startingTime = Util.getTime();
	}
	
	public void update() {
		if (Util.getTime() - startingTime >= speed) {
			startingTime += speed;
			onUpdate();
		}
	}
	
	/*
	 * Este método debe ser sobre escrito por las clases hijas para poder implementar
	 * la animación como tal. 
	 * */
	protected void onUpdate() {

	}

}
