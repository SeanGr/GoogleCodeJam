

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  
		codeJam();
	}

	public static void codeJam() throws IOException{
		
		// Read input file, then write answer to output file.
		
		File file = new File("C:\\CodeJam\\B-small-attempt0.in");
	    File outFile = new File("C:\\CodeJam\\answer.out");
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
	    int testCases = Integer.parseInt(br.readLine());
	   
	    int answer; 
	    
	    for(int t=1;t<=testCases;t++){
	
	    //for problem 1 Standing Ovation	
	    //answer = standingOvation(br.readLine());

	    //for problem 2 IHOP
	    String input1 = br.readLine();
	    String input2 = br.readLine();
	    
	    //answer = iHOP(Integer.parseInt(br.readLine()),br.readLine());
	    answer = iHOP(Integer.parseInt(input1), input2);
	    
	    	bw.write(input2+"\n");
	        bw.write("Case #" + t +": " + answer + "\n");
	    }
	    br.close();
	    bw.close();
	}
	
	public static int iHOP(int numDiners, String diners){
	
		/*Each number has a value which is the number of special minutes it .
		would take to break that stack down to 2 pancakes. Adding all 
		these then + 2 should yield the result */
		
		//Getting input ready. Place everything into an array of ints.
		String[] dinersSplit = diners.split("\\s");
		
	
		
		ArrayList<Integer> dinerPancakes = new ArrayList<Integer>();
		
		for (String s : dinersSplit){
			dinerPancakes.add(Integer.parseInt(s));
		}
		
		int pancakeStack = 0;
		int totalMinutes = 0;
		int timeSaved;
		int mostTimeSaved = Collections.max(dinerPancakes)/2; 
		boolean solved = false;
		//This problem is way harder than it looks. have to find some way to evaluate if splits are worth it

		if (numDiners > mostTimeSaved){
			return Collections.max(dinerPancakes);
		}
	}
	
	public static int standingOvation(String audience){
		
		int sMAX = Character.getNumericValue(audience.charAt(0));
		int minInvites = 0;
		int standing = 0;
		
		// Go through input, i is also the shyness level of audience members at the time.
		for (int i = 0; i <= sMAX; i++){
			
			//crude large input handler, didn't realize input size changed. Low on time.
			int spacer = 0;
			
			if(sMAX<10){
				spacer=2;
			}
			
			else if (sMAX <100&&sMAX>=10){
				spacer = 3;
			}
			else if (sMAX<1000&&sMAX>=100){
				spacer = 4;
			}
			else{
				spacer=5;
			}
			
			//swap that char to a string.
			int sInt = Character.getNumericValue(audience.charAt(i+spacer));
		
			// if not enough standing members to get these to stand, invite more.
			if (i - standing>0){
				minInvites+=(i-standing);
				standing += i-standing;
			}
			// stand up the people in this position.
			
			standing +=sInt;
			
			
		}
		
		return minInvites;
		
	}
}
