import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int fib(int n){
        return fib(n,0,1);
    }
    private static int fib(int n, int a, int b )
    {
        if (n == 0) return a;
        if (n == 1) return b;
        return fib(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        in.forEachRemaining(i-> list.add(fib(Integer.parseInt(i))));
        list.forEach(System.out::println);
        }
}