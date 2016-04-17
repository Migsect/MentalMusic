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

public class SoundPlayer {
	
	Queue<byte[]> sounds;

	public SoundPlayer(){
		sounds = new LinkedList<>();
	}
	
	public SoundPlayer(byte[] sound){
		sounds = new LinkedList<>();
		this.add(sound);
	}
	
	public SoundPlayer(Queue<byte[]> sounds){
		this.sounds = sounds;
	}
	
	public void add(byte[] sound){
		sounds.add(sound);
	}
	
	private void playAll(){
		while (!sounds.isEmpty()){
			play(sounds.remove());
		}
	}
	
	private void play(byte[] sound){
		InputStream byteArrayInputStream = new ByteArrayInputStream(
                sound);
		AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
		InputStream soundInputStream = new ByteArrayInputStream(sound);
		DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, format);
        SourceDataLine sourceDataLine = null;
		try {
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
		} catch (LineUnavailableException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
			sourceDataLine.open(format);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
        sourceDataLine.start();
        AudioInputStream audioInputStream  = new AudioInputStream(byteArrayInputStream,format, sound.length / format.getFrameSize());
        int cnt = 0;
        byte tempBuffer[] = new byte[10000];
		  try {
              while ((cnt = audioInputStream.read(tempBuffer, 0,tempBuffer.length)) != -1) {
                  if (cnt > 0) {
                      // Write data to the internal buffer of
                      // the data line where it will be
                      // delivered to the speaker.
                      sourceDataLine.write(tempBuffer, 0, cnt);
                  }// end if
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
		//AudioDataStream audStream = new AudioDataStream(new AudioData(sound));
	}
}
