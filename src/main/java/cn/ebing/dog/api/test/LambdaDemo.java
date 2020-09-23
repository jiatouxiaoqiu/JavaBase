package cn.ebing.dog.api.test;

import java.util.Optional;
import java.util.stream.Stream;

public class LambdaDemo {
    public static void main(String[] args) {
        Optional<Integer> result = Stream.of("a", "be", "hello")
                .map(s -> s.length())
                .filter(l -> l <= 3)
                .max((o1, o2) -> o1-o2);
        System.out.println(result.get()); // 输出2
    }
}
