import java.util.*;


public class MentalMusic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MuseReader mr = new MuseReader();
		while (true) {
			//Muse-A168
			mr.connectToMuse("/muse/eeg/quantization");
			System.out.println("stuff");
		}
		//System.out.print("bla");
	}

}
