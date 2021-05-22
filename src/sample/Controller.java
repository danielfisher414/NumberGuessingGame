//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private String difficulty = null;
    private int inputCount;
    private ArrayList<Integer> guessesList = new ArrayList();
    private StringBuilder str = new StringBuilder();
    private int randomNum;
    private int numCount;
    private int inputNum;

    public Controller() {
    }

    public boolean isItSelected() {
        return true;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String diff) {
        this.difficulty = diff;
    }

    public int getHighScore(int highScore) {
        if (highScore == 0) {
            highScore = this.inputCount;
        } else if (this.inputCount < highScore) {
            highScore = this.inputCount;
        }

        if (this.equalRandomNum()) {
            this.inputCount = 0;
        }

        return highScore;
    }

    public void setHighScore() {
        ++this.inputCount;
    }

    public String getGuesses() {
        String guess = "";

        for(int i = 0; i < this.guessesList.size(); ++i) {
            if (this.guessesList.size() >= 5) {
                this.guessesList.remove(i);
            }

            guess = guess + this.guessesList.get(i) + ", ";
        }

        return guess;
    }

    public void setGuesses(int input) {
        this.inputNum = input;
        this.guessesList.add(input);
    }

    public void deleteGuesses() {
        this.str.setLength(0);
        this.guessesList.removeAll(this.guessesList);
    }

    public void setRandomNum(int min, int max) {
        Random random = new Random();
        this.randomNum = random.nextInt(max + min) + min;
    }

    public int getRandomNum() {
        return this.randomNum;
    }

    public boolean equalRandomNum() {
        if (this.inputNum == this.randomNum) {
            this.numCount = 0;
            return true;
        } else {
            return false;
        }
    }

    public String higherOrLower(int num) {
        if (num < this.getRandomNum()) {
            return "Higher";
        } else {
            return num > this.getRandomNum() ? "Lower" : "That's the right number";
        }
    }
}
