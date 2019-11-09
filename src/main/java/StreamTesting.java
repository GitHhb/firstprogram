import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTesting {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 4)
        .forEach(System.out::println);

        Stream.generate(()-> {
             int x = 0; x++;
        return x;}).forEach(System.out::println);
    }
}
