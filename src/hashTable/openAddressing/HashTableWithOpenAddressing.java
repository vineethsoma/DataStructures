package part1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashTableWithOpenAddressing<K> {

	private Entry<K> table[];
	private int table_size = 25;
	private int entries = 0;

	public HashTableWithOpenAddressing() {
		table = new Entry[table_size];
	}

	private class Entry<K> {

		private K key;
		private boolean exists;

		public Entry(K inKey) {
			key = inKey;
			exists = true;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public boolean isExists() {
			return exists;
		}

		public void setExists(boolean exists) {
			this.exists = exists;
		}

		public void prepDelete() {
			exists = false;
		}

	}

	public void insert(K key) throws Exception {

		if (key == null) { // key cannot be null
			throw new Exception("Key cannot be null");
		}

		int index = locate(key, true);
		table[index] = new Entry(key);
		entries++;

		if (entries == table_size / 2) { // rehash if half full
			rehash();
		}

	}

	public int hash(K key) {
		int code = key.hashCode();
		return code % table_size;
	}

	private int locate(K key, boolean empty) throws Exception {
		int initialPoint = hash(key);
		int index = initialPoint;

		while (true) {
			try {
				if (table[index].key == key && empty == false) {
					return index;
				}
			} catch (Exception e) {
				if (empty) {
					return index;
				}
			}

			index = (index + 1) % table_size;

			if (index == initialPoint) {
				throw new Exception("Value not found");
			}
		}
	}

	public boolean delete(K key) throws Exception {

		if (key == null) { // key cannot be null
			throw new Exception("Key cannot be null");
		}

		try {
			int index = locate(key, false);
			table[index].prepDelete(); // marks entry for deletion
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	private void finalDelete() {

		for (int i = 0; i < table.length; i++) {

			try {
				if (table[i].exists == false) {
					table[i] = null;
				}
			} catch (Exception e) {

			}
		}
	}

	private void rehash() throws Exception {

		finalDelete();

		Entry<K> temp[];
		temp = new Entry[table_size];

		for (int i = 0; i < table_size; i++) { // copy all entries to temp
			if (table[i] != null) {
				temp[i] = table[i];
			}
		}

		table_size = table_size * 2;
		entries = 0;

		table = new Entry[table_size];
		for (int i = 0; i < table_size / 2; i++) {
			Entry<K> entry = temp[i];
			if (entry != null) {
				insert(entry.key);
			}
		}
	}

	public void print() {
		System.out.println(); // new line
		System.out.println("HashTableWithOpenAddressing");
		System.out.println("Size : " + table_size);
		for (int i = 0; i < table_size; i++) {
			Entry<K> e = table[i];
			if (e == null) {
				System.out.println(i + " empty");
			} else {
				String status;
				if (e.isExists() == true) {
					status = "Exists";
				} else {
					status = "Marked for deletion";
				}
				System.out.println(i + " " + e.key
						+ " | Status: " + status);
			}
		}
	}
	
	static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

        public  void menuSystem() //need to put in specific functions call for the menu options 
        {
		
		
		
		boolean notDone = true  ; 
		Scanner in = new Scanner(System.in) ; 
		
		while(notDone) { //reads commands 
                System.out.println ( "") ;    
                System.out.println ( "\t \t Hash Mapping with Open Addressing ") ;
		System.out.println ( "\t\t Please select from the following option: ") ;
		System.out.println ( "\t\t (d) display hash table ") ; 
		System.out.println ( "\t\t (r) rehash  ") ; 
		System.out.println ( "\t\t (!) To exit  ") ; 
		System.out.print( "Enter your option: ") ;
			String command = in.next() ; 
			char com = command.charAt(0) ; 
			switch(com){
			
			
			case 'd':{
				
			print() ; 	
				
				
				
				break ; 
			}
			
			case 'r':{
				
				
                            try {	
                                rehash();
                            } catch (Exception ex) {
                                Logger.getLogger(HashTableWithOpenAddressing.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
				
				break ; 
			}

			case '!':{
				
				
				
				notDone = false ; 
				
				break ; 
			}
			default :{
				
			System.out.println ("Command not recognized please try again")	;
				
			}
			
			
			
                    }
			
                }
        }
        public static void main(String[] args) throws IOException {

		
		HashTableWithOpenAddressing<String> table = new HashTableWithOpenAddressing<>();
		
		String fileName = "src/patients.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String input = br.readLine();
	        
	        
	        while (input != null) {
	            String[] splited = input.split(","); 
	            String lastName = splited[0];
	            
	            try{
	            	table.insert(lastName);
	            }catch (Exception e){
	            	
	            }
	            input = br.readLine();
	        }
	      
	    } finally {
	        br.close();
	    }
	    
	    table.menuSystem(); 
		
	
	}
}