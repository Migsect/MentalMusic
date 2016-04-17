package mentalMusic;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

import oscP5.*;

public class MuseOscServer {

	static MuseOscServer museOscServer;
	
	OscP5 museServer;
	static int recvPort = 5000;
	private boolean eventRunning = false;

	
	
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
		if (eventRunning){
			return;
		}
		eventRunning = true;
		
			if (msg.checkAddrPattern("/muse/eeg")==true) {  
				try{
					
					byte[] buf = new byte[ 1 ];
				    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
				    SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
				    sdl.open();
				    sdl.start();
				    
				    float rawFreq = msg.get(0).floatValue();
				    float tunedFreq = MuseReader.findNearestNote(rawFreq);
					for( int i = 0; i < 10000 * (float )44100 / 1000; i++ ) {	    
				        double angle = i / ( (float )44100 / tunedFreq/*440*/ ) * 2.0 * Math.PI;
				        buf[ 0 ] = (byte )( Math.sin( angle ) * 500);
				        sdl.write( buf, 0, 1 );
				        System.out.print("EEG on channel " + 0 + ": " + tunedFreq + "\n"); 
					}
				    sdl.drain();
				    sdl.stop();
				} catch (Exception e) {
					System.out.println("Exception thrown when playing sound.");
				}
			
		}
		eventRunning = false;
	}

	public void disconnectMuse(String string) {
		// TODO Auto-generated method stub
		
	}
}