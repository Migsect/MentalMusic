package mentalMusic;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import oscP5.OscMessage;

public class SoundPlayer implements Runnable{

	
	public SoundPlayer(OscMessage msg, SourceDataLine sdl){
		this.msg = msg;
		this.sdl = sdl;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			byte[] buf = new byte[ 1 ];
			sdl.open();
		    sdl.start();
		    for( int i = 0; i < 1000 * (float )220 / 1000; i++ ) {
		        double angle = i / ( (float )44100 / msg.get(i).floatValue()/*440*/ ) * 2.0 * Math.PI;
		        buf[ 0 ] = (byte )( Math.sin( angle ) * 1000 );
		        sdl.write( buf, 0, 1 );
		    }
		    sdl.drain();
		    sdl.stop();
		} catch (Exception e) {
			System.out.println("~~~~Issue with SoundPlayer thread~~~~");
		}
	}
	
	private OscMessage msg;
	private SourceDataLine sdl;
	
}
