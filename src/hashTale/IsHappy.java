package hashTale;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = 0;
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            while (n > 0) {
                int num = n % 10;
                n /= 10;
                temp += num * num;
            }
            n = temp;
            temp = 0;
        }
        return n == 1;
    }

    @Test
    public void test() {
        System.out.println(isHappy(2));
    }
}
