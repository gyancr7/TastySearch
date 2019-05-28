package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import entity.Document;
import entity.Query;
import org.json.JSONObject;

import java.io.DataInput;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class CustomComparator implements Comparator<Document> {
    public int compare(Document document1, Document document2) {
        if (document1.documentQueryScore > document2.documentQueryScore) {
            return -1;

        } else if (document1.documentQueryScore.equals(document2.documentQueryScore)) {

            if (document1.documentReviewScore < document2.documentReviewScore) {
                return 1;

            } else if (document1.documentReviewScore > document2.documentReviewScore) {
                return -1;

            }
            return 0;
        }
        return 1;
    }
}

public class DocumentProcessor {

    static PriorityQueue<Document> documentScorePriorityQueue = new PriorityQueue<>(new CustomComparator());

    static Document getDocumentInfo(String documentText) throws IOException {

        String rawDocumentText = documentText;
        String documentTokens[] = documentText.split("\n");
        String documentId = documentTokens[1];
        Double documentReviewScore = Double.valueOf(documentTokens[4].replace("review/score: ", ""));
        String wordsToBeRemoved[] = {"product/productId: ", "review/userId: ", "review/profileName: ", "review/helpfulness: ", "review/score: ", "review/time: ", "review/summary: ", "review/text: "};

        Set<String> documentTextTokens = new HashSet<>();

        for (String wordToBeRemoved : wordsToBeRemoved) {
            documentText = documentText.replace(wordToBeRemoved, "");
        }

        documentText = documentText.replaceAll("\n", " ");
        documentText = documentText.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        documentTextTokens.addAll(Lists.newArrayList(documentText.split("\\s+")));

        Document document = new Document(documentId, documentReviewScore, documentTextTokens, rawDocumentText);

        return document;
    }

    static Double getDocumentScoreForQuery(Document document, Query query) {

        Double documentQueryScore = (Double.valueOf(Sets.intersection(document.documentTokens, query.queryTokens).size()))
                / Double.valueOf(query.queryTokens.size());

        return documentQueryScore;
    }
}


