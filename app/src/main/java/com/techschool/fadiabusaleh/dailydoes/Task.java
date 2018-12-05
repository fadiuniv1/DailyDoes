package com.techschool.fadiabusaleh.dailydoes;

public class Task {
    String category;
    String sbjct;
    String txt;
    String timeStamp;// = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    int important;
    int stats;

    public Task(){}

    public Task(String category,
                String sbjct,
                String txt,
                String timeStamp,
                int important, int stats) {
        this.category = category;
        this.sbjct = sbjct;
        this.txt = txt;
        this.timeStamp = timeStamp;
        this.important = important;
        this.stats = stats;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int aStats) {
        this.stats = aStats;
    }

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
