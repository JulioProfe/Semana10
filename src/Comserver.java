import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Comserver extends Observable implements Runnable {

	private static final int Puerto = 6000;
	private ServerSocket ss;
	private Socket s;
	private boolean online;
	private String llego;

	public Comserver() {
		// TODO Auto-generated constructor stubç
		try {
			ss = new ServerSocket(Puerto);
			s = null;
			online = true;
			System.out.println("server pro" + online);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (online) {
			try {
				if (s == null) {
					s = ss.accept();
					enviar();
					System.out.println("Corriendo");
				}
				recibir();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void enviar() throws IOException{
		DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
		salida.writeInt((int) (Math.random()*10));
		salida.flush();
	}
	
	private void recibir(){
		try {
			DataInputStream entrada = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			llego = (String) entrada.readUTF();
			if (llego instanceof String) {
				llego.contains("llego");
				enviar();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
