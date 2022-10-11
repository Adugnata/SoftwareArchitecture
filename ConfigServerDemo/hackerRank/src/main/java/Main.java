import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static BigInteger f(int n){
        BigInteger r=BigInteger.valueOf(1);
        for(int i=2;i<=n;i++) r = r.multiply(BigInteger.valueOf(i));
        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Consumer<BigInteger> print = System.out::println;
        print.accept(f(in.nextInt()));
    }
}
