import java.util.*;

import GUI.Window;


public class MentalMusic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MuseReader mr = new MuseReader();
		//while (true) {
			//Muse-A168
			
		//mr.readAddress("/muse/eeg/quantization");
		MuseOscServer server = new MuseOscServer();
		server.connectToMuse("/muse/eeg/quantization");
		
		
		//System.out.print("bla");


	}

}
