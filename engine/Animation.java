package engine;

public class Animation {
	
	private double duration;
	private double startingTime;
	
	public Animation(int duration) {
		this.duration = duration;
	}
	
	public void start() {
		startingTime = System.currentTimeMillis();
	}
	
	public void update() {
		if (System.currentTimeMillis() - startingTime <= duration) {
			onUpdate();
		}
	}
	
	/*
	 * Este m�todo debe ser sobre escrito por las clases hijas para poder implementar
	 * la animaci�n como tal. 
	 * */
	protected void onUpdate() {
		
	}
}
