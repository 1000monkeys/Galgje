import java.util.Random;
import java.util.Scanner;


/**
 * Created by kjell on 13-2-2017.
 */
public class GalgjeNonStaticMain {
    private char[] watJeProbeertTeRaden;
    private String woordOmTeRaden;
    private int fout, aantalGoedGeraden, maxAantalFout;
    private boolean geraden, teVeelFout;
    private Letters[] letters;

    /**
     * Constructor van de classe, pakt een random woord uit de lijst en maakt daar een char array van,
     * Maakt dan van het alphabet een char array en maakt dan de classe voor elke letter aan en begint dan het raden.
     */
    public GalgjeNonStaticMain(Letters[] letters){
        this.letters = letters;

        woordOmTeRaden = getRandomWoord();
        watJeProbeertTeRaden = woordOmTeRaden.toCharArray();
    }

    /**
     * Sets whether the character is part of the word to guess
     */
    public void setIsDeelVanWoord() {
        int i = 0;
        while (i < watJeProbeertTeRaden.length) {
            int i2 = 0;
            while (i2 < 26) {
                if (letters[i2].getLetter() == watJeProbeertTeRaden[i]) {
                    letters[i2].setDeelVanWoord(true);
                }
                i2++;
            }
            i++;
        }
    }

    /**
     * Gets the alphabet char array
     * @return the alphabet char array
     */
    public char[] getAlphabet() {
        return Galgje.alphabet;
    }


    /**
     * Haalt de positie van een letter op in het alphabet
     * @param letter the letter to get the alphabetical index of
     * @return the index of the passed letter
     */
    public int getAlphabetPosition(char letter){
        return Galgje.alphabetString.indexOf(letter);
    }

    /**
     * checks if every word of the word to guess is guessed
     * @return true if it is already guessed false if it isn't
     */
    public boolean allesGeradenCheck() {
        int i = 0;
        int aantalGoedGeraden = 0;
        while (i < watJeProbeertTeRaden.length) {
            if (letters[getAlphabetPosition(watJeProbeertTeRaden[i])].getAlGeraden()) {
                aantalGoedGeraden++;
            }
            i++;
        }
        if (aantalGoedGeraden == watJeProbeertTeRaden.length) {
            System.out.println("Je hebt het complete woord geraden!");
            return true;
        }
        return false;
    }


    /**
     * Checks how many times a given char is in a in the word to guess
     * @param Char to check
     * @return the amount the given char is in the the word to guess
     */
    public int countCharsInString(char charOmTeChecken){
        int i = 0;
        int count = 0;
        while(i < watJeProbeertTeRaden.length){
            char ch = woordOmTeRaden.charAt(i);
            if (ch == charOmTeChecken) {
                count++;
            }
            i++;
        }
        return count;
    }

    /**
     * Creates a word to output and only shows the guessed letters making the others a dot
     * @return the word with only the guessed letters shown
     */
    public String createWoord(){
        int i = 0;
        String woord = "";
        while (i < watJeProbeertTeRaden.length) {
            if (letters[getAlphabetPosition(watJeProbeertTeRaden[i])].isDeelVanWoord() && letters[getAlphabetPosition(watJeProbeertTeRaden[i])].getAlGeraden()) {
                woord += watJeProbeertTeRaden[i];
            }else{
                woord += ".";
            }
            i++;
        }
        return woord;
    }

    /**
     * Creates a string consisting of the alphabet showing only the already tried letters and replacing the others with a dot
     * @return the alphabet with only the guessed letters shown
     */
    public String createAlphabet(){
        int i = 0;
        String woord = "";
        while (i < alphabet.length) {
            if (letters[i].getAlGeraden()) {
                woord += letters[i].getLetter();
            }else{
                woord += ".";
            }
            i++;
        }
        return woord;
    }


    /**
     * This is the main loop which goes through almost or every function to create the illusion a game is being played.
     */
    public void raden(){
        Scanner scanner = new Scanner(System.in);
        fout = 0;
        maxAantalFout = 6;
        geraden = false;
        teVeelFout = false;
        System.out.println("Probeer het woord te raden!");
        while (allesGeradenCheck() != true && teVeelFout != true) {
            System.out.println("Geprobeerd: " + createAlphabet());
            String letter = scanner.next();
            char[] watJeProbeertTeRaden = letter.toCharArray();
            int positieInAlphabet = Galgje.alphabetString.indexOf(watJeProbeertTeRaden[0]);
            if (letters[positieInAlphabet].getAlGeraden()) {
                System.out.println("Deze heb je al geprobeerd!");
            }else{
                if (letters[positieInAlphabet].isDeelVanWoord()) {
                    System.out.println("Goed geraden! Deze kwam " + countCharsInString(watJeProbeertTeRaden[0]) + " keer voor !");
                    letters[positieInAlphabet].setAlGeraden(true);
                }else{
                    System.out.println("Dit is fout! Je mag nog " + (maxAantalFout - fout) +  " keren fout raden!");
                    System.out.println("je Mag nog " + (maxAantalFout - fout) + " fout hebben!");
                    letters[positieInAlphabet].setAlGeraden(true);
                    fout++;
                }
            }
            System.out.println("Woord: " + createWoord());
            if (fout > maxAantalFout) {
                teVeelFout = true;
                System.out.println("Sorry je hebt teveel fout!");
                System.out.println("Het woord was " + woordOmTeRaden + "!");
            }
        }
    }

    /**
     * Makes an array consisting of words and then creates a number consisting of a number between 0 and the number of itmes in the array -1
     * @return the word to guess
     */
    public String getRandomWoord(){
        String[] woorden = new String[50];
        woorden[0] = "grafeem";
        woorden[1] = "tjiftjaf";
        woorden[2] = "maquette";
        woorden[3] = "kitsch";
        woorden[4] = "pochet";
        woorden[5] = "convocaat";
        woorden[6] = "jakkeren";
        woorden[7] = "collaps";
        woorden[8] = "zuivel";
        woorden[9] = "cesium";
        woorden[10] = "voyant";
        woorden[11] = "spitten";
        woorden[12] = "pancake";
        woorden[13] = "gietlepel";
        woorden[14] = "karwats";
        woorden[15] = "dehydreren";
        woorden[16] = "viswijf";
        woorden[17] = "flater";
        woorden[18] = "cretonne";
        woorden[19] = "sennhut";
        woorden[20] = "tichel";
        woorden[21] = "wijten";
        woorden[22] = "cadeau";
        woorden[23] = "trotyl";
        woorden[24] = "chopper";
        woorden[25] = "pielen";
        woorden[26] = "vigeren";
        woorden[27] = "vrijuit";
        woorden[28] = "dimorf";
        woorden[29] = "kolchoz";
        woorden[30] = "janhen";
        woorden[31] = "plexus";
        woorden[32] = "borium";
        woorden[33] = "ontweien";
        woorden[34] = "quiche";
        woorden[35] = "ijverig";
        woorden[36] = "mecenaat";
        woorden[37] = "falset";
        woorden[38] = "telexen";
        woorden[39] = "hieruit";
        woorden[40] = "femelaar";
        woorden[41] = "cohesie";
        woorden[42] = "exogeen";
        woorden[43] = "plebejer";
        woorden[44] = "opbouw";
        woorden[45] = "zodiak";
        woorden[46] = "volder";
        woorden[47] = "vrezen";
        woorden[48] = "convex";
        woorden[49] = "verzenden";

        Random random = new Random();
        return woorden[random.nextInt(50) + 1];
    }
}
