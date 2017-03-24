import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Observable;

public class Comclient extends Observable implements Runnable {

	private Socket s;
	private final int Puerto = 6000;
	private boolean online;

	public Comclient() {
		// TODO Auto-generated constructor stub

		online = true;
		try {
			s = new Socket(InetAddress.getByName("192.168.108.15"), Puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void recibir() {
		try {
			DataInputStream entrada = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			entrada.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void enviar() throws IOException {
		DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
		salida.writeUTF("llego");
		salida.flush();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (online) {
			recibir();
		}
	}
}
