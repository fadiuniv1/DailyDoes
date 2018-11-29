package com.techschool.fadiabusaleh.dailydoes;

public class Task {
    String category;
    String sbjct;
    String txt;
    String timeStamp;// = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    int important;

    public int getStats() {
        return stats;
    }

    public void setStats(int aStats) {
        this.stats = aStats;
    }

    int stats;


    public String getCategory() {
        return category;
    }

    public void setCategory(String aCategory) {
        this.category = aCategory;
    }

    public String getSbjct() {
        return sbjct;
    }

    public void setSbjct(String aSbjct) {
        this.sbjct = aSbjct;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String aTxt) {
        this.txt = aTxt;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String aTimeStamp) {
        this.timeStamp = aTimeStamp;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int aImportant) {
        this.important = aImportant;
    }


}
