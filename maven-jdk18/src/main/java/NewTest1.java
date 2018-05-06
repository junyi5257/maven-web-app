import java.util.Arrays;

/**
 * lambda 表达式
 * Created by goujy on 8/22/17.
 */
public class NewTest1 {
    public static void main(String[] args) {
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
        Arrays.asList("d", "e", "f").forEach((String e) -> System.out.println(e));
        Arrays.asList("g", "h", "i").forEach(e -> {
            System.out.println(e);
            System.out.println(e);
        });

        String str = ",";
        Arrays.asList("j", "k", "l").forEach(e -> System.out.println(e + "=" + str));
        Arrays.asList("m","n","o").sort((e1,e2) -> e1.compareTo(e2));
    }
}
