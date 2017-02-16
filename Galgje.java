/**
 * Created by kjell on 13-2-2017.
 */
public class Galgje {
    public static Letters[] letters;
    public static String alphabetString;
    public static char[] alphabet;

    /**
     * set's up the application
     * starts a class which isn't static containing all of the functions of this program
     * and also sets up every letter
     * then check's which letters are part of the word and then starts the guessing process
     */
    public static void main(String[] args){
        alphabetString = "abcdefghijklmnopqrstuvwxyz";
        alphabet = alphabetString.toCharArray();

        int i = 0;
        letters = new Letters[26];
        while (i < 26) {
            letters[i] = new Letters(alphabet[i], false, false);
            i++;
        }

        GalgjeNonStaticMain galgjeNonStaticMain = new GalgjeNonStaticMain(letters);
        galgjeNonStaticMain.setIsDeelVanWoord();
        galgjeNonStaticMain.raden();
    }
}
