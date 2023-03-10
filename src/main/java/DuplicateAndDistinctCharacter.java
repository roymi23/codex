import java.util.Arrays;
import java.util.Scanner;

public class DuplicateAndDistinctCharacter {

    public static void main(String[] args) {

        Scanner sC = new Scanner(System.in);
        String givenString = sC.nextLine();

        String[] distinctChars = findDistinctChars(givenString);
        System.out.println("Distinct chars found in given string: " + Arrays.toString(distinctChars));

        String[] duplicateChars = findDuplicateChars(givenString);
        System.out.println("Duplicated chars found in given string: " + Arrays.toString(duplicateChars));

    }

    private static String[] findDuplicateChars(String givenString) {

        return null;
    }

    private static String[] findDistinctChars(String givenString) {
        return null;
    }
}
