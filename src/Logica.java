import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica implements Observer {
	private Comclient cc;
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
		System.out.println(y);
	}

	public void pintar() {
		app.fill(155, 0, 100);
		app.noStroke();
		app.ellipse(x, y, 50, 50);
	}
	public void mover(){
		x ++;
		if (x >= app.width) {
			try {
				cc.enviarLlego();
				setY(y);
				x = 20;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

}
