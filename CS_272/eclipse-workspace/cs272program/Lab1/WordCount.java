package cs272program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class WordCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		read();
		write("best");
	}
	
	public static void read() throws IOException {
		// prints number of words in "pg100_small.txt"
		int total = 0;
		String line;
		
		BufferedReader br = new BufferedReader(new FileReader("pg100_small.txt"));
		while((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			total += words.length;
		}// end while
		
		br.close();
		System.out.printf("The total number of words is %d", total);
	}
	
	public static void write(String input) throws IOException {
		// prints the word after input value any time it is found in file "pg100_small.txt"
		String line;
		boolean printWordZero = false;
		FileWriter fw = new FileWriter("output.txt"); 
		BufferedReader br = new BufferedReader(new FileReader("pg100_small.txt"));
		while((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			int length = words.length;
			if(printWordZero) { 
				fw.write(words[0]);
				printWordZero = false;
			} // end if			
			for(int i = 0; i < length; i++) {
				// check if 
				if(i == (length - 1) && words[i].equalsIgnoreCase(input)) {
					printWordZero = true;
					break;
				} // end if 
				else if(words[i].equalsIgnoreCase(input)) { // if input is found
					fw.write(words[i + 1]);
					fw.write("\n");
				} // end else if
			}// end for
		}// end while
		br.close();
		fw.close();
	}
		
}
