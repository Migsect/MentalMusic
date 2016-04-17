import java.net.SocketException;
import java.util.Date;
import oscP5.*;

/*Read data from a muse and output to a given */
public class MuseReader {
	
	
	
	static int recvPort = 5000;

	class MuseOscServer {
		OscP5 museServer;
		MuseOscServer museOscServer;
		void oscEvent(OscMessage msg) {
			System.out.println("### got a message " + msg);
			if (msg.checkAddrPattern("/muse/eeg")==true) {  
				for(int i = 0; i < 4; i++) {
					System.out.print("EEG on channel " + i + ": " + msg.get(i).floatValue() + "\n"); 
				}
			} 
		}
	}

	MuseReader(){
		//TODO: fill stub
	}
	
	public boolean connectToMuse(String museName) {
		MuseOscServer museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort);
		
		museOscServer.oscEvent(museOscServer.museServer.newMsg(museName));
		
		return false;
	}

}
