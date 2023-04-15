package Lab10;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.lang.String;

/*****************************************************************************************************************
 * Dictionary stores a file into a HashMap using key value pairs.
 * A dictionary object may take one file with one word and one definition per line. The word must be separated from the
 * definition by a tab.
 * 
 * 
 * @author Ryan Schwarzkopf
 * @version Nov 16, 2022
 * @see HashMap
****************************************************************************************************************/
public class Dictionary {
	
	private HashMap<String, String> hmap;

	private void read(String fname) {
		String line = "";
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fname);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				String[] stringSplit = line.split("	");	
				hmap.put(stringSplit[0], stringSplit[1]);
			}
			bufferedReader.close(); // Always close files.
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fname + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fname + "'");
		}
	}
	
	/**
	 * Constructor sets initial capacity to 16 and initial load factor of 0.75
	 * and reads from file filename
	 * @param filename: File to be read from
	 */
	public Dictionary(String filename) {
		hmap = new HashMap<String, String>();
		read(filename);
	}
	
	/**
	 * Constructor sets initial capacity. Initial load factor is 0.75
	 * and reads from file filename
	 * 
	 * @param initialCapacity: Initial size of hmap
	 * @param filename: File to be read from
	 */
	public Dictionary(int initialCapacity, String filename) {
		hmap = new HashMap<String, String>(initialCapacity);
		read(filename);
	}
	
	/**
	 * Get definition for a word
	 * @param s: key
	 * @return definition
	 */
	public String get(String s) {
		return hmap.get(s);
	}
	
	/**
	 * Test this class
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary d = new Dictionary(100, "example_words.txt");
		System.out.println("This set is: " + d.hmap.keySet());
		System.out.println(d.get("Aback"));
		System.out.println(d.get("Abacist"));
	}
}
