import java.util.HashSet;
import java.util.Iterator;


public class HashSetTest {
    public static void main(String[] args){
        // creating
        HashSet<Integer> set = new HashSet<>();

        // insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // duplicate not allowed

        // search - contains
        if (set.contains(1)){
            System.out.println(true);
        }

        // delete
        set.remove(1);

        System.out.println(set.contains(1));

        System.out.println("size: "+ set.size());

        System.out.println("set: "+ set);

        //Iterator
        for (int s: set){
            System.out.println(s);
        }

        Iterator<Integer> it = set.iterator();
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());

    }
}
