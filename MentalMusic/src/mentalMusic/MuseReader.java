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
	
	
	public static Double findNearestNote(Double dbl){
		//dbl = dbl/2; //divide by 2 for regular notes
		
		Integer low_num = 550;
		Integer high_num = 1150;
		Integer diff = high_num - low_num;
		Integer poss_val = 7;
		
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
				return 130.82;
			case 2:
				return 146.83;
			case 3:
				return 164.81;
			case 4:
				return 174.61;
			case 5:
				return 196.00;
			case 6:
				return 220.00;
			default:
				return 246.94;
							
		}
		
		/*if(dbl < 0){
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
		
		return dbl*num_div;*/
	}

	private Integer valueOf(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
