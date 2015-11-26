package edt.core;
import java.io.*;


public class Command {

	/**
	* Loads new document
	* @param filename : file name
	* @return return loaded document
	*/
	public Document loadDocument(String filename) throws IOException, ClassNotFoundException {


			FileInputStream fileStream = new FileInputStream(filename);
			ObjectInputStream obj = new ObjectInputStream(fileStream);
			Document doc = (Document) obj.readObject();
			return doc;

	}

	/**
	* Saves the document
	* @param doc: document to be saved
	*/
	public void saveDocument(Document doc) {
		try {
			FileOutputStream fileStream = new FileOutputStream(doc.getFilename());
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(doc);
			os.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
