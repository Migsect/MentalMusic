package mentalMusic;
import java.net.SocketException;
import java.util.Date;
import oscP5.*;

/*Read data from a muse and output to a given */
public class MuseReader {
	
	static int recvPort = 5000;
	public MuseReader(){
		
	}
	
	public void readAddress(String address){
		//TODO: fill stubz
		//MuseOscServer.museOscServer.connectToMuse(address);
		
	}
	
	
	public static float findNearestNote(float dbl){
		dbl = dbl/2; //divide by 2 for regular notes
		
		Integer num_div = 0;
		while (dbl > 246.94 || dbl < -246.94){
			dbl = dbl/2;
			num_div++;
		}
		
		if(dbl < 0){
			num_div *= (-1);
		}
		
		if(dbl < 138.59){
			dbl = 130.82f;
		}
		else if(dbl < 155.56){
			dbl = 146.83f;
		}
		else if(dbl < 169.71){
			dbl = 164.81f;
		}
		else if(dbl < 185.00){
			dbl = 174.61f;
		}
		else if(dbl < 207.65){
			dbl = 196.00f;
		}
		else if(dbl < 233.08){
			dbl = 220.00f;
		}
		else{
			dbl = 246.94f;
		}
		
		return dbl*num_div;
	}

	private Integer valueOf(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
