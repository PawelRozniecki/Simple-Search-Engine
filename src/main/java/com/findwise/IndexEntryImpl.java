package com.findwise;

public class IndexEntryImpl implements IndexEntry {

    private final String docId;
    private double td_idf;

    public IndexEntryImpl(String docId, double td_idf) {
        this.docId = docId;
        this.td_idf = td_idf;
    }

    public IndexEntryImpl(IndexEntry indexEntry) {
        this.docId = indexEntry.getId();
        this.td_idf = indexEntry.getScore();
    }

    @Override
    public String getId() {
        return docId;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public double getScore() {

        return td_idf;
    }

    @Override
    public void setScore(double td_idf) {
        this.td_idf = td_idf;


    }
}
