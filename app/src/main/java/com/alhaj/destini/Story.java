package com.alhaj.destini;

public class Story {

    private int story;
    private int aboveStringButtion;
    private int belowStringButtion;

    public Story(int story, int aboveStringButtion, int belowStringButtion) {
        this.story = story;
        this.aboveStringButtion = aboveStringButtion;
        this.belowStringButtion = belowStringButtion;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int  getAboveStringButtion() {
        return aboveStringButtion;
    }

    public void setAboveStringButtion(int aboveStringButtion) {
        this.aboveStringButtion = aboveStringButtion;
    }

    public int getBelowStringButtion() {
        return belowStringButtion;
    }

    public void setBelowStringButtion(int belowStringButtion) {
        this.belowStringButtion = belowStringButtion;
    }
}
