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
		//dbl = dbl/2; //divide by 2 for regular notes
		
		Integer low_num = 550*3;
		Integer high_num = 1150*3;
		Integer diff = high_num - low_num;
		Integer poss_val = 21*3;
		
		Integer num_div = 0;
		Integer num_mult = 0;
		
		while(dbl < low_num){
			dbl = dbl*2;
			num_div++;
		}
		while(dbl > high_num){
			dbl = dbl/2;
			num_mult++;
		}
		
		dbl = ((dbl-low_num)/diff*poss_val);
		
		if (num_div != 0){
			if (num_div > 2){
				num_div = 2;
			}
			dbl = dbl/num_div;
		}
		
		if (num_mult != 0){
			if (num_mult > 2){
				num_mult = 2;
			}
			dbl = dbl*num_mult;
		}
		
		Integer integer = new Integer((new Long(Math.round(dbl)).intValue()));
		
		switch(integer){
			case 1:
				return 130.82f;
			case 2:
				return 146.83f;
			case 3:
				return 164.81f;
			case 4:
				return 174.61f;
			case 5:
				return 196.00f;
			case 6:
				return 220.00f;
			case 7:
				return 261.63f;
			case 8:
				return 293.66f;
			case 9:
				return 329.63f;
			case 10:
				return 349.23f;
			case 11:
				return 392.00f;
			case 12:
				return 440.00f;
			case 13:
				return 493.88f;
			case 14:
				return 523.25f;
			case 15:
				return 587.33f;
			case 16:
				return 659.26f;
			case 17:
				return 698.46f;
			case 18:
				return 783.99f;
			case 19:
				return 880.00f;
			case 20:
				return 987.77f;
			case 21:
				return 1046.50f;
			default:
				return 1174.66f;						
		}
		
		/*if(dbl < 0){
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
		
		return dbl*num_div;*/
	}

	private Integer valueOf(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
