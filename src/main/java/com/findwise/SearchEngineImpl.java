package com.findwise;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngineImpl implements SearchEngine {

    private final HashMap<String, String> docs = new HashMap<>();
    private final HashMap<String, List<IndexEntry>> indexEntriesMap = new HashMap<>();


    @Override
    public void indexDocument(String id, String content) {

        docs.put(id, content);
        String[] tokens = getTokens(content);

        Map<String, Integer> wordFrequencyMap = getWordFrequency(tokens);

        for (String entryWord : wordFrequencyMap.keySet()) {

            // documents an entry. Saves an ID and thecal

            // TF formula: Number of times entryWord appears in a document/ word count in the document
            IndexEntry entry = new IndexEntryImpl(id, (double) wordFrequencyMap.get(entryWord) / tokens.length);

            if (indexEntriesMap.containsKey(entryWord)) {
                indexEntriesMap.get(entryWord).add(entry);
            } else {
                indexEntriesMap.put(entryWord, new ArrayList<>(List.of(entry)));
            }
        }
    }

    @Override
    public List<IndexEntry> search(String term) {

        // search for a single term
        // remove any spaces and normalize to lower case
        String rawTerm = term.replace(" ", "").toLowerCase();
        // get the map of the found term entry, if it doesn't exist then return an empty list
        List<IndexEntry> indexEntries = this.indexEntriesMap.getOrDefault(rawTerm, Collections.emptyList());

        // returns a list of index entries matching the rawTerm, sets the correct tf-idf scores and sorts them by score
        // in largest to smallest order

        return indexEntries
                .stream()
                .map(IndexEntryImpl::new)
                .peek(entry -> entry.setScore(entry.getScore() * getIDF(term)))
                .sorted(Comparator.comparing(IndexEntry::getScore).reversed())
                .collect(Collectors.toList());

    }

    public String[] getTokens(String content) {
        return content.toLowerCase().split("\\s+");
    }


    public Map<String, Integer> getWordFrequency(String[] words) {

        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String w : words) {

            if (!wordFrequency.containsKey(w)) {
                wordFrequency.put(w, 1);
            } else {
                wordFrequency.put(w, wordFrequency.get(w) + 1);
            }
        }

        return wordFrequency;

    }

    public HashMap<String, String> getDocs() {
        return docs;
    }

    public HashMap<String, List<IndexEntry>> getIndexEntriesMap() {
        return indexEntriesMap;
    }

    public double getIDF(String term) {
        // get the number of occurrences of the term throughout out all the documents

        int documentTermCount = getIndexEntriesMap().getOrDefault(term, Collections.emptyList()).size();


        // adding +1 to avoid division by zero problems

        return Math.log((double) getDocs().size() / documentTermCount + 1);
    }

}
