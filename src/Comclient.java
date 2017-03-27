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
			s = new Socket(InetAddress.getByName("192.168.112.7"), Puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int recibir() {
		try {
			DataInputStream entrada = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			int recibidito = entrada.readInt();
			System.out.println("RECIBIDITO: " + recibidito);
			return recibidito;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public void enviarLlego() throws IOException {
		DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
		String yupi = "llego";
		salida.writeUTF(yupi);
		salida.flush();
		System.out.println("ENVIANDITO: " + yupi);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (online) {
			try {
				int recibido = recibir();
				setChanged();
				notifyObservers(recibido);
				clearChanged();
				System.out.println("RECIBIENDO: " + recibido);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
}
