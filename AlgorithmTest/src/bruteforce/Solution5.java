/*
 *  스택 구현
 */
package bruteforce;

public class Solution5 {
    static int top;
    static int[] stack;
    static int size;

    public Solution5(int size) {
        top = -1;
        stack = new int[size];
        this.size = size;
    }

    public void size() {
        System.out.println(size);
    }

    public void empty() {
        if (stack.length != 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    public void top() {
        if (top == -1) {
            System.out.println(top);
        } else {
            System.out.println(top);
        }
    }

    public int peek() {
        return stack[top];
    }

    public void push(int value) {
        System.out.println("top : " + top);
        stack[++top] = value;
        System.out.println("stack index : stack[" + top + "]");
        System.out.println(stack[top] + " PUSH ! ");
    }

    public int pop() {
        System.out.println(stack[top] + " POP ! ");
        return stack[top--];
    }

    public void printStack() {
        System.out.println(" Stack List ");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
        System.out.println(" -- END OF LIST --s");
    }

    public static void main(String[] args) {
        Solution5 st = new Solution5(100);
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        st.printStack();
        st.pop();
        st.pop();
        st.push(15);
        st.printStack();
    }
}
