import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica implements Observer {
	private Comclient cc;
	private Comserver cs;
	private PApplet app;
	private int x, y;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		cc = new Comclient();
		cc.addObserver(this);
		new Thread(cc).start();

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		y = (int) arg;
	}

	public void pintar() {
		app.fill(155, 0, 100);
		app.noStroke();
		app.ellipse(x, y, 50, 50);
	}

}
