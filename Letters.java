/**
 * Created by kjell on 13-2-2017.
 */
public class Letters {
    private char letter;
    private boolean alGeraden, deelVanWoord;

    /**
     * constructor of this class, It sets up everything needed for the main loop of galgje
     * @param letter the letter this class is
     * @param alGeraden if this letter has already been tried to guess
     * @param deelVanWoord if this letter is part of the word to guess
     */
    public Letters(char letter, boolean alGeraden, boolean deelVanWoord){
        this.letter = letter;
        this.alGeraden = alGeraden;
        this.deelVanWoord = deelVanWoord;
    }

    /**
     * returns the letter
     * @return the letter this class is
     */
    public char getLetter(){
        return letter;
    }

    /**
     * Sets the letter
     * @param letter this class should be
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Returns if this letter has already been guessed whether it is part of the word or not
     * @return true or false depending if this letter has already been guessed whether is it part of the word or not
     */
    public boolean getAlGeraden() {
        return alGeraden;
    }

    /**
     * Sets whether this letter has already been guessed whether it is part of the word or noet
     * @param alGeraden which is true or false depending on whether this letter has already been guessed whether it is part of the word or not
     */
    public void setAlGeraden(boolean alGeraden) {
        this.alGeraden = alGeraden;
    }

    /**
     * Returns whether this letter is part of the word or not
     * @return whether this letter is part of the word or not
     */
    public boolean isDeelVanWoord() {
        return deelVanWoord;
    }

    /**
     * Sets whether letter is part of the word or not
     * @param true or false depending on whether this letter is part of the word or not
     */
    public void setDeelVanWoord(boolean deelVanWoord) {
        this.deelVanWoord = deelVanWoord;
    }
}
