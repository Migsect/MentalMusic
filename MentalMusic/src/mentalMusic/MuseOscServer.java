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
		System.out.println("### got a message " + msg);
		if (msg.checkAddrPattern("/muse/eeg")==true) {  
			for(int i = 0; i < 4; i++) {
				try{
					byte[] buf = new byte[ 1 ];
				    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
				    SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
				    sdl.open();
				    sdl.start();
				    for( int k = 0; k < 1000 * (float )44100 / 1000; k++ ) {
				        //double angle = k / ( (float )44100 / 440 ) * 2.0 * Math.PI;
				    	
				        buf[ 0 ] = (byte )( Math.sin( msg.get(i).floatValue() ) * 100 );
				        sdl.write( buf, 0, 1 );
				    }
				    sdl.drain();
				    sdl.stop();
				} catch (Exception e) {
					System.out.println("boo");
				}
				//System.out.print("EEG on channel " + i + ": " + msg.get(i).floatValue() + "\n"); 
			}
		} 
	}

	public void disconnectMuse(String string) {
		// TODO Auto-generated method stub
		
	}
}