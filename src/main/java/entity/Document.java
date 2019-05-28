package entity;

import java.util.Set;

public class Document {

    public String documentId;
    public Double documentReviewScore;
    public Double documentQueryScore;
    public Set<String> documentTokens;
    public String rawDocumentText;

    public Document(String documentId, Double documentReviewScore, Set<String> documentTokens, String documentText) {
        this.documentId = documentId;
        this.documentReviewScore = documentReviewScore;
        this.documentTokens = documentTokens;
        this.rawDocumentText = documentText;
    }
}
