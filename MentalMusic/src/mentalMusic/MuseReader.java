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
	
	
	public Double findNearestNote(Double dbl){
		dbl = dbl/2; //divide by 2 for regular notes
		
		Integer num_div = 0;
		while (dbl > 246.94 || dbl < 246.94){
			dbl = dbl/2;
			num_div++;
		}
		
		if(dbl < 0){
			num_div *= (-1);
		}
		
		if(dbl < 138.59){
			dbl = 130.82;
		}
		else if(dbl < 155.56){
			dbl = 146.83;
		}
		else if(dbl < 169.71){
			dbl = 164.81;
		}
		else if(dbl < 185.00){
			dbl = 174.61;
		}
		else if(dbl < 207.65){
			dbl = 196.00;
		}
		else if(dbl < 233.08){
			dbl = 220.00;
		}
		else{
			dbl = 246.94;
		}
		
		return dbl*num_div;
	}

	private Integer valueOf(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
