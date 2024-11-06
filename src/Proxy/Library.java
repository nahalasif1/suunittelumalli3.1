package Proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, DocumentInterface> documents = new HashMap<>();

    public void addUnprotectedDocument(String identifier, String creationDate, String content) {
        Document document = new Document(identifier, creationDate, content);
        documents.put(identifier, document);
    }

    public void addProtectedDocument(String identifier, String creationDate, String content) {
        Document document = new Document(identifier, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(document);
        documents.put(identifier, proxy);
    }

    public DocumentInterface getDocument(String identifier) {
        return documents.get(identifier);
    }
}
