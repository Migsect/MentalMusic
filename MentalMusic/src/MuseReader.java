import java.net.SocketException;
import java.util.Date;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortIn;

/*Read data from a muse and output to a given */
public class MuseReader {
	public static final int MUSE_PORT = 5000;
	MuseReader(){
		//TODO: fill stub
	}
	
	public boolean connectToMuse(String museName) {
		try{
			OSCPortIn receiver = new OSCPortIn(MUSE_PORT);
			OSCListener listener = new OSCListener() {
				public void acceptMessage(java.util.Date time, OSCMessage message) {
					System.out.println(message.getCharset());
				}
			};
			receiver.addListener(museName, listener);
			receiver.startListening();
			//receiver.wait
			return true;
		} catch(Exception e) {
			//TODO: fix this
			return false;
		}
	}
	
	

}
