package engine;

import java.awt.Graphics2D;

import util.Util;

public class Animation {
	
	protected float duration;
	protected float startingTime;
	protected boolean finished;
	
	public Animation(float duration) {
		this.duration = duration;
	}
	
	public void start() {
		startingTime = Util.getTime();
		finished = false;
	}
	
	public void update() {
		if (Util.getTime() - startingTime <= duration) {
			onUpdate();
		} else {
			finished = true;
		}
	}
	
	public void render(Graphics2D g) {
		
	}
	
	/*
	 * Este m�todo debe ser sobre escrito por las clases hijas para poder implementar
	 * la animaci�n como tal. 
	 * */
	protected void onUpdate() {
		
	}

	public boolean isFinished() {
		return finished;
	}
}
