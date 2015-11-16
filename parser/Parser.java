package edt.parser;

import edt.core.Author;
import edt.core.Section;
import edt.core.Document;
import edt.core.Paragraph;

import java.io.*;

public class Parser {

    private Document _document;
    private Section _curSection;

    public Parser() {
    }

    public static void main(String[] args) throws Exception {
        String fileName = System.getProperty("import");

        Parser parser = new Parser();

        Document doc = parser.parse(fileName);

        System.out.println(doc.getContent());
    }

    public Document parse(String filename)throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            _document = new Document();
            _curSection = _document;

            parseTitle(reader.readLine());
            parseAuthors(reader.readLine());

            String line;

            while ((line = reader.readLine()) != null)
                parseLineContent(line);

            return _document;


        } finally {
            if (reader != null)
                reader.close();
        }
        
    }

    private void parseTitle(String title) {
        _document.setTitle(title);
    }

    private void parseAuthors(String authors) {
        for(String author : authors.split("\\|")) {
                String[] str = author.split("\\/");
                _document.addAuthor(new Author(str[0], str[1]));
            }
    }

    private void parseLineContent(String line) {
        String[] content = line.split("\\|");

        switch(content[0]) {
        case "SECTION":  // create new section
            _curSection = new Section(content[2]);
            _document.addSection(-1, _curSection);
            if (content[1].length() > 0)
                _document.indexElement(content[1], _curSection);
            break;

        case "PARAGRAPH":  // create new paragraph
            Paragraph par = new Paragraph(content[1]);
            _curSection.addParagraph(-1, par);
            break;

        default:
            System.err.println("Error in parsing content. Invalid Token " + line);
        }
    }
}
