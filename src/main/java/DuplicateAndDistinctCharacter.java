import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateAndDistinctCharacter {

    public static void main(String[] args) {

        Scanner sC = new Scanner(System.in);
        System.out.println("Please enter your string...");
        String givenString = sC.nextLine();

        Object[] distinctChars = findDistinctChars(givenString);
        System.out.println("Distinct chars found in given string: " + Arrays.toString(distinctChars));

        Object[] duplicateChars = findDuplicateChars(givenString);
        System.out.println("Duplicated chars found in given string: " + Arrays.toString(duplicateChars));

        System.out.println("First non duplicated character: " + findFirstNonDuplicatedCharacter(givenString));

    }

    private static String findFirstNonDuplicatedCharacter(String givenString) {

        return Arrays.stream(givenString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(i->i.getValue() == 1).findFirst().get().getKey();
    }

    private static Object[] findDuplicateChars(String givenString) {

        //print the map that displays each character and it's occurrences
        final Map<String, List<String>> duplicateMap = Arrays.stream(givenString.split("")).collect(Collectors.groupingBy(c -> c));
        System.out.println("Map of characters and their occurrences" + duplicateMap);

        return Arrays.stream(givenString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i->i.getValue() > 1).map(i->i.getKey()).toArray();
    }

    private static Object[] findDistinctChars(String givenString) {

        Object[] objects = givenString.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c-> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().map(e->e.getKey()).toArray();
        System.out.println("Distinct characters Result when using grouping by: " + Arrays.toString(objects));

        return Arrays.stream(givenString.split("")).distinct().toArray();
    }
}
