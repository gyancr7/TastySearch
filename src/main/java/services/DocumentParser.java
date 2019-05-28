package services;

import entity.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentParser {

    private static final int documentsToParse = 50000;
    static List<Document> getDocumentsFromFile(String filePath) throws IOException {

        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream).useDelimiter("\n\n");
        ArrayList<Document> documents = new ArrayList<>();
        int countDocuments = 0;

        while (scanner.hasNext() &&  countDocuments < documentsToParse) {
            countDocuments++;
            String document = scanner.next();
            documents.add(DocumentProcessor.getDocumentInfo(document));
        }
        return documents;

    }
}
