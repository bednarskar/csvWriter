import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Milijon {
    private static final char DEFAULT_SEPARATOR = '\n';
	public static void main(String[] args) throws IOException {
		System.out.println("dupa");
		String csvFile = "/home/klusek/Pulpit/csv/def.csv";
//        FileWriter writer = new FileWriter(csvFile);
		List<String> idki = new ArrayList<>();
		for (int i=0; i<100; i++) {
			idki.add(i+ "dupnyidek");
		}
		writeLine(idki);
//		writer.close();
		
        File f = new File(csvFile);
		
        BufferedReader b = new BufferedReader(new FileReader(f));
        
        List<String> pincet = new ArrayList<>();
        String idek = "";
        
        for (int i=0; i<4; i++) {
        	
	        while ((pincet.size())<500 && (idek = b.readLine()) != null ) {
	        	pincet.add(idek);

	        }
	        
	        System.out.println("idki " +pincet);
	        pincet.clear();
        }
        b.close();
	}
	
    public static void writeLine(List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        
        File file = new File("/home/klusek/Pulpit/csv/def.csv");
        
        if(!file.exists()) {
          file.createNewFile();
        } else {
          System.out.println("File already exists");
        }
        
		Files.write(Paths.get("/home/klusek/Pulpit/csv/def.csv"), sb.toString().getBytes(), StandardOpenOption.APPEND);

       // w.append(sb.toString());

    }
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }
    public static void writeLine(List<String> values) throws IOException {
        writeLine(values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(List<String> values, char separators) throws IOException {
        writeLine(values, separators, ' ');
    }

    
}
