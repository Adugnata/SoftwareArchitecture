import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

@FunctionalInterface
interface MyInterface{
    void print();
    default void dprint(){
        System.out.println("Hi");
    }
    static void sprint(){
        System.out.println("Hey");
    }
}
interface Validate<T>{
    boolean test(T t);
}

public class Driver {
    public static<T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }
    public static void main(String[] args) {
        MyInterface m = ()-> System.out.println("Hey everyone");
        Predicate<Integer> ne = i-> i<0;
        System.out.println(ne.test(1));
       m.print();
       m.dprint();
       Validate<Integer> v = i->i>0;
        System.out.println(v.test(5));
        System.out.println(check(7, n->n>0));
        System.out.println(check("Tesfa",n->n.startsWith("T")));
        Predicate<String> p = s->s.contains("Tesfa");
        System.out.println(p.test("michael"));
        System.out.println(p.test("Tesfamichael"));
        BiPredicate<String,Integer> b = (s,l)->s.length()==l;
        System.out.println(b.test("Tesfamichael",12));
        Supplier<StringBuilder> sb = StringBuilder::new;
        System.out.println(sb.get().append("Tesfamichael"));
        Supplier<LocalTime> lt = LocalTime::now;
        System.out.println(lt.get());
        Supplier<Double> r = Math::random;
        System.out.println(r.get());
        Consumer<String> print = System.out::println;
        print.accept("Tesfamichael");
        List<String> s = new ArrayList<>(); s.add("Tesfamichael");s.add("Adugna");
        s.forEach(print);
        var city = new HashMap<>();
        BiConsumer<String,String> c = city::put;
        c.accept("Ethiopia","Addis Ababa");
        System.out.println(city);
        Function<String,Integer> f = String::length;
        System.out.println(f.apply("Tesfamichael"));
        BiFunction<String,String,Integer> bf = (s1,s2)->s1.length() + s2.length();
        Consumer<Integer> printi = System.out::println;
        printi.accept(bf.apply("Tesfamichael","Adugna"));
    }
}
