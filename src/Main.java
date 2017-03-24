import java.net.InetAddress;

import processing.core.PApplet;

public class Main extends PApplet{

	
	private Logica log;
	private Comclient cc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		size(500, 300);
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		log = new Logica(this);
		cc = new Comclient();
		try {
			System.out.println(InetAddress.getLocalHost());
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		background(255);
		log.pintar();
	}
	
}
