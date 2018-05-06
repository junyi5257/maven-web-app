import java.util.Optional;

/**
 * Created by goujy on 8/22/17.
 */
public interface Inf2 {
    default void getMethod(){
        System.out.println("--Inf2");
    }
}


class A implements Inf1, Inf2{

    @Override
    public void getMethod() {

    }

    public static void main(String[] args) {
        Optional<String> op = Optional.ofNullable(null);


    }
}