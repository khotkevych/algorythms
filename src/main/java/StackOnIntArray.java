
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Design a stack. We want to push, pop, and also, retrieve the minimum element in constant time.
public class StackOnIntArray {
// we have two approaches: more space ot more time for pop operation
    private int[] items;
    private int top;
    private int size;
    private int min;

    StackOnIntArray(int size) {
        min = Integer.MAX_VALUE;
        top = -1;
        this.size = size;
        items = new int[size];
    }

    public void push(int item) {
        if (top == size - 1) {
            throw new StackOverflowError();
        }
        top++;
        items[top] = item;
        if (min > item) {
            min = item;
        }
    }

    public int pop() {
        if (top < 0) {
            throw new RuntimeException();
        }
        int item = items[top];
        items[top] = 0;
        top--;
        if (item == min) {
            if (top < 0) {
                min = Integer.MAX_VALUE;
            } else {
                min = items[top];
                for (int i = top - 1; i >= 0; i--) {
                    if (min > items[i]) {
                        min = items[i];
                    }
                }
            }
        }
        return item;
    }

    public int min() {
        if (top < 0) {
            throw new RuntimeException();
        }
        return min;
    }

    public int top() {
        return top;
    }


    public static void main(String[] args) {
        StackOnIntArray array = new StackOnIntArray(5);
        array.push(4);
        array.push(10);
        array.push(10);
        array.push(-5);
        array.push(4);
        System.out.println(array.min());
        array.pop();
        array.pop();
        System.out.println(array.min());
    }
}
