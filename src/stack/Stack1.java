package stack;

import java.util.Stack;

public class Stack1 {

    /*check if brackets are balanced*/
    public static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char check = ' ';
            switch (c) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    }
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[') {
                        return false;
                    }
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{') {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    /*Reverse stack using 2 stacks*/
    public static void reverseStackUsing2Stacks() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        // transfer all elements from source to A
        while (!stack.empty()) {
            A.push(stack.pop());
        }

        // transfer all elements from A to B
        while (!A.empty()) {
            B.push(A.pop());
        }

        // transfer all elements from B to source
        while (!B.empty()) {
            stack.push(B.pop());
        }

        while (!stack.empty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Are brackets balanced: " + areBracketsBalanced("([{}])"));
        System.out.println("####################################");
        System.out.println("Reverse stack using 2 stacks");
        reverseStackUsing2Stacks();
        System.out.println("####################################");
    }
}
