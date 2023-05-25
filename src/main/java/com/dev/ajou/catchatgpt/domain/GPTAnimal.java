package com.dev.ajou.catchatgpt.domain;


public class GPTAnimal {
    private long id;
    private long vitality;
    private long satiety;
    private long mood;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVitality() {
        return vitality;
    }

    public void setVitality(long vitality) {
        this.vitality = vitality;
    }

    public long getSatiety() {
        return satiety;
    }

    public void setSatiety(long satiety) {
        this.satiety = satiety;
    }

    public long getMood() {
        return mood;
    }

    public void setMood(long mood) {
        this.mood = mood;
    }
}
