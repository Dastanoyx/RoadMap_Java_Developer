package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminal {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Yassin", "Danza", "Touchka");
        Stream<String> namesStream = names.stream();

        // foreach, performs an action for every element in the stream
        namesStream.forEach(System.out::println);

        // count: returns the number of elements in the stream
        long nrOfItems = names.stream().count();
        System.out.println(nrOfItems);

        // min, max: return the minimum and maximum elements in the stream
        Optional<String> min = names.stream().min((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(min.get());

        // allmatch: check if all of the elements in the stream match a given predicate
        Boolean allBiggerThan5 = names.stream().allMatch(s -> s.length() > 5);
        System.out.println("All bigger than 5: " + allBiggerThan5);

        // anymatch: check if any, of the elements in the stream match a given predicate
        Boolean anyBiggerThan5 = names.stream().anyMatch(s -> s.length() > 5);
        System.out.println("Any bigger than 5: " + anyBiggerThan5);

        // nonematch: check if none of the elements in the stream match a given predicate
        Boolean noneBiggerThan5 = names.stream().noneMatch(s -> s.length() > 5);
        System.out.println("None bigger than 5: " + noneBiggerThan5);

        // collect: transforms the stream into a different data structure, such as a List, set, or Map.
        List<String> namesList = names.stream().collect(Collectors.toList());
        // Java 16+
        List<String> nameList2 = names.stream().toList();

        // reduce: applies a binary operator to the elements in the stream, reducing them to a single value.
        Optional<String> totalString = names.stream().reduce(String::concat);
        System.out.println(totalString.get());
    }
}