package codeforces;

import java.io.*;
import org.apache.commons.net.ftp.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// File separator: "/" for UNIX, "\" for Windows
		String fileSep = System.getProperty("file.separator");  
		
		if (args.length == 0) {
			System.out.println("Ingrese el directorio de destino!");
			System.exit(1);
		}
		String root = args[0];
		
		BufferedReader in = new BufferedReader(new FileReader("ListAllImage.txt"));
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("168.176.124.168");
			ftp.login("HORUS_CARTAGENA", "1r1barren");
			System.out.println("FTP Reply: " + ftp.getReplyCode());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		int failures = 0;
		int i = 1;
		
		String line = null;
		
		try {
			while ((line = in.readLine()) != null) {
				String[] parts = line.split("[ \t]+");
				String pathImage = parts[0];
				String filename = parts[1];
				String pathImageRemote = "/" + pathImage.replace('\\', '/');
				
				boolean path = ftp.changeWorkingDirectory(pathImageRemote);
				if (!path) {
					++failures;
					System.out.println("Remote directory does not exist: " + pathImageRemote);
				} else {
					boolean ok = true;
					
					if (fileSep.equals("/"))
						pathImage = pathImage.replace("\\", fileSep);
					else
						pathImage = pathImage.replace("/", fileSep);
					String pathImageLocal = root + (root.endsWith(fileSep) ? "" : fileSep) + pathImage;
					if (!(new File(pathImageLocal)).exists())
						ok = (new File(pathImageLocal)).mkdirs();
					
					if (ok) {
						FileOutputStream local = new FileOutputStream(pathImageLocal + fileSep + filename);
						ftp.setFileType(FTP.BINARY_FILE_TYPE);
						
						boolean status = ftp.retrieveFile(filename, local);
						if (status) {
							System.out.println(filename + " image transferred!");
							++i;
							failures = 0;
							
						} else {
							System.out.println("Could not transfer image: " + filename);
							++failures;
						}
					} else {
						System.out.println("Could not create local path: " + pathImageLocal);
						++failures;
					}
				}
				
				if (failures == 10) {
					System.out.println(failures + " failures! Ending transfer...");
					break;
				}
			}
			
			ftp.logout();
			ftp.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		in.close();
		System.exit(0);
	}
}
