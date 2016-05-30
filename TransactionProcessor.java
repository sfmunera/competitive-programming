import java.io.*;
import java.util.*;

public class TransactionProcessor {
	
	//private static final String TRANSACTION_PATH = "/home/sfmunera/Desktop/finances/";
	private static final String TRANSACTION_PATH = "/home/sfmunera/Desktop/omi-finances/";
	private static final String TRANSACTION_FILE = "transactions";
	private static final String TRANSACTION_FILE_EXT = ".csv";
	
	static List<String> genFile(List<String> transactions, String suffix, String[] keywords) throws IOException {
		String outfile = TRANSACTION_PATH + TRANSACTION_FILE + "_" + suffix + TRANSACTION_FILE_EXT;
		PrintWriter out = new PrintWriter(new File(outfile));
		
		List<String> transactionsLeft = new ArrayList<String>();
		
		for (int i = 0; i < transactions.size(); ++i) {
			String t = transactions.get(i);
			boolean processable = keywords.length == 0; // If empty, assume all are valid
			for (String k : keywords) {
				if (t.toLowerCase().contains(k.toLowerCase())) {
					processable = true;
					break;
				}
			}
			if (processable) {
				out.println(t);
			} else {
				transactionsLeft.add(t);
			}
		}
		out.close();
				
		return transactionsLeft;
	}
	
	static List<String> readTransactions() throws IOException {
		Scanner in = new Scanner(new File(TRANSACTION_PATH + TRANSACTION_FILE + TRANSACTION_FILE_EXT));
		List<String> transactions = new ArrayList<String>();
		while (in.hasNextLine()) {
			String t = in.nextLine();
			transactions.add(t);
		}
		in.close();
		
		return transactions;
	}
	
	public static void main(String[] args) throws IOException {
		List<String> transactions = readTransactions();
		
		/*transactions = genFile(transactions, "AlbertHeijn", new String[]{"Albert", "AH", "groce"});
		transactions = genFile(transactions, "ASMLFood", new String[]{"Sodexo"});
		transactions = genFile(transactions, "TMobile", new String[]{"T-Mobile"});
		transactions = genFile(transactions, "Housing", new String[]{"WOONBEDRIJF"});
		transactions = genFile(transactions, "Colfuturo", new String[]{"Wereldbetaling", "Futuro"});
		transactions = genFile(transactions, "Public transport", new String[]{"NS-Eindhoven"});
		transactions = genFile(transactions, "Lenses", new String[]{"Contactalook"});
		transactions = genFile(transactions, "Health", new String[]{"IAK", "AON"});
		transactions = genFile(transactions, "Scholarship", new String[]{"AMANDUS"});
		transactions = genFile(transactions, "BELASTINGDIENST", new String[]{"BELASTINGDIENST"});
		transactions = genFile(transactions, "Internship", new String[]{"ASML"});
		transactions = genFile(transactions, "Laptop", new String[]{"COOPERATIEVE"});*/
		transactions = genFile(transactions, "Kenya", new String[]{"Kenya", "nairobi", "KONINKLIJKE", "ANWB"});
		transactions = genFile(transactions, "Grocery", new String[]{"Albert", "AH", "groce", "diyar ", "SIVAMANI", "Lidl", "Jumbo", "KRUISSTRAAT", "ING "});
		transactions = genFile(transactions, "Housing", new String[]{"WOONBEDRIJF"});
		transactions = genFile(transactions, "Public transport", new String[]{"NS-Eindhoven"});
		transactions = genFile(transactions, "Health", new String[]{"FYSIO", "AON", "Apotheek"});
		transactions = genFile(transactions, "Scholarship", new String[]{"AMANDUS"});
		transactions = genFile(transactions, "Internship", new String[]{"Salary"});
		transactions = genFile(transactions, "Laptop", new String[]{"COOPERATIEVE"});
		transactions = genFile(transactions, "OfficeFood", new String[]{"HTC", "metaforum", "auditorium", "sport"});
		transactions = genFile(transactions, "Experiment", new String[]{"Experiment"});
		transactions = genFile(transactions, "Mama", new String[]{"Kusum"});
		transactions = genFile(transactions, "Trips", new String[]{"trip", "ticket", "amsterdam", "delft", "GROEP"});
		transactions = genFile(transactions, "Donationsgift", new String[]{"PayPal"});
		transactions = genFile(transactions, "Clothes", new String[]{"V&D", "C&A", "H & M", "Bersh", "vanHaren", "Scamm"});
		
		
		transactions = genFile(transactions, "Others", new String[]{});
	}
}
