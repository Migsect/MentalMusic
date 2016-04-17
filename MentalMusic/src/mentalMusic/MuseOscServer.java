package mentalMusic;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

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
		//System.out.println("### got a message " + msg);
		if (msg.checkAddrPattern("/muse/eeg")==true) {  
			try{
				byte[] buf = new byte[ 1 ];
			    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
			    SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
			    sdl.open();
			    sdl.start();
			    int i = 0;
			    
		        double angle = 500 / ( (float )44100 / msg.get(i).floatValue()/*440*/ ) * 2.0 * Math.PI;
		        buf[ 0 ] = (byte )( Math.sin( angle ) * 1000 );
		        sdl.write( buf, 0, 1 );
		        System.out.print("EEG on channel " + 0 + ": " + msg.get(0).floatValue() + "\n"); 

			    sdl.drain();
			    sdl.stop();
			} catch (Exception e) {
				System.out.println("boo");
			}
		} 
	}

	public void disconnectMuse(String string) {
		// TODO Auto-generated method stub
		
	}
}