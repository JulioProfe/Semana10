import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Servidor extends PApplet implements Observer{

	private Comserver cs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Servidor");
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		cs = new Comserver();
		cs.addObserver(this);
		new Thread(cs).start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
