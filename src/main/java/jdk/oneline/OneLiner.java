package jdk.oneline;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingBy;

public class OneLiner {
    public static void main(String[] args) {
         List<Integer> result = IntStream.rangeClosed(1, 10).mapToObj(i -> IntStream.rangeClosed(1, i).boxed().collect(Collectors.toList())).flatMap(id -> id.stream()).collect(Collectors.toList());
        result.stream().forEach(System.out::print);
        System.out.println("");
        Map<Integer, List<Integer>> mapedResult = result.stream().collect(groupingBy(Function.identity()));
        Map<Integer, Set<Integer>> mapedResultV2 = result.stream().collect(groupingBy(Function.identity(), toSet()));
        mapedResult.entrySet().stream().forEach(System.out::println);
        mapedResultV2.entrySet().stream().forEach(System.out::println);
    }
}
