package mentalMusic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

import oscP5.*;

public class MuseOscServer {

	static MuseOscServer museOscServer;
	
	OscP5 museServer;
	static int recvPort = 5000;
	ExecutorService fixedPool;
	
	
	/*public static void main(String [] args) {
		museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort);
			}*/
	
	public void connectToMuse(String museName) {
		//TODO: make this a bool that returns false if stuff breaks
		museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort, OscP5.TCP);
		
		//thread pool
		fixedPool = Executors.newFixedThreadPool(4);
		
	}
	
	void oscEvent(OscMessage msg) {
		System.out.println("### got a message " + msg);
		if (msg.checkAddrPattern("/muse/eeg")==true) {  
			//for(int i = 0; i < 4; i++) {
				try{
				    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
				    SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
				    fixedPool.submit(new SoundPlayer(msg, sdl));
				} catch (Exception e) {
					System.out.println("boo");
				}
				//System.out.print("EEG on channel " + i + ": " + msg.get(i).floatValue() + "\n"); 
			//}
		} 
	}

	public void disconnectMuse(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}