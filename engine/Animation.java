package engine;

import util.Util;

public class Animation {
	
	private float speed;
	private float startingTime;
	private boolean finished;
	
	public Animation(float speed) {
		this.speed = speed;
		finished = false;
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

	public boolean isFinished() {
		return finished;
	}
}
