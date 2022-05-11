import java.util.*;

/**
 * @author Hppppppf
 * @date 2022/3/29 21:41
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);stack.push(2);stack.push(3);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);deque.push(2);deque.push(3);
        ArrayList<Integer> arrayList1 = new ArrayList<>(stack);
        ArrayList<Integer> arrayList2 = new ArrayList<>(deque);
        System.out.println(arrayList1);
        System.out.println(arrayList2);
    }
}
