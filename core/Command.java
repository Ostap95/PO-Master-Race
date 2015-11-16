package edt.core;
import java.io.*;


public class Command {
	
	public Document loadDocument(String filename) {
		try {
			FileInputStream fileStream = new FileInputStream(filename);
			ObjectInputStream obj = new ObjectInputStream(fileStream);

			Document doc = (Document) obj.readObject();
			return doc; 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;   
		} catch (IOException ex) {
			ex.printStackTrace();
			return null; 
		}
	}
	
	public void saveDocument(Document doc) {
		try {
			FileOutputStream fileStream = new FileOutputStream(doc.getFilename());
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(doc);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}