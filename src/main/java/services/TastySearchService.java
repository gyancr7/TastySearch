package services;

import entity.Document;
import entity.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TastySearchService {

    public List<String> topKdocuments(int k, List<String> queryTokens, String filePath) throws IOException {

        List<String> topKDocuments = new ArrayList<>();
        List<Document> documents = DocumentParser.getDocumentsFromFile(filePath);
        Query query = new Query(queryTokens);
        Double documentScoreForQuery;

        for (Document document : documents) {
            documentScoreForQuery = DocumentProcessor.getDocumentScoreForQuery(document, query);
            document.documentQueryScore = documentScoreForQuery;
            DocumentProcessor.documentScorePriorityQueue.add(document);
        }

        int documentCount = 0;
        while (!DocumentProcessor.documentScorePriorityQueue.isEmpty() && documentCount < k) {
            Document document = DocumentProcessor.documentScorePriorityQueue.poll();
            topKDocuments.add(document.rawDocumentText);
            documentCount++;
        }
        return topKDocuments;
    }
}
