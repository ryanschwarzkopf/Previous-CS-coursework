package cs272program;
import java.lang.System;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.Double;

public class Welcome {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Java");
		System.out.println(System.getProperties());
		FileWriter fw = new FileWriter("eclipse_test.txt");
		fw.write("hello");
		fw.close();
		average();	
	} // end main
	
	public static void average() throws IOException{
		double  ave = 0;
		int total = 0;
		String line;
		System.out.println("Enter numbers followed by whitespace to be averaged");
		System.out.println("Enter 'end' on a new line to finish input.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((line = br.readLine()) != null) {
			if(line.equals("end")) {
				break;
			}
			String[] numbers = line.split(" ");
			int len = numbers.length;
			total += numbers.length;
			for(int i = 0; i < len; i++) {
				ave += Double.parseDouble(numbers[i]);
			}// end for
		} // end while
		br.close();
		ave = ave / (1.0 * total);
		System.out.printf("The average is %f", ave);
	} // average
	
	
} // end Welcome
