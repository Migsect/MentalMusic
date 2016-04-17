
import oscP5.*;

public class MuseOscServer {

	static MuseOscServer museOscServer;
	
	OscP5 museServer;
	static int recvPort = 5000;

	
	
	/*public static void main(String [] args) {
		museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort);
			}*/
	
	public void connectToMuse(String museName) {
		//TODO: make this a bool that returns false if stuff breaks
		museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort, OscP5.TCP);
	}
	
	void oscEvent(OscMessage msg) {
		System.out.println("### got a message " + msg);
		if (msg.checkAddrPattern("/muse/eeg")==true) {  
			for(int i = 0; i < 4; i++) {
				System.out.print("EEG on channel " + i + ": " + msg.get(i).floatValue() + "\n"); 
			}
		} 
	}
}