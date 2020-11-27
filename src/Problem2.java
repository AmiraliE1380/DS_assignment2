import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Problem2 {
    private Stack<String> stack;
    private ArrayList<String> operators;

    public static void main(String[] args) {
        new Problem2().run();
    }

    private void run() {
        stack = new Stack<String>();
        operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        System.out.println("Recursive function : " + prefixToPostfixRecursive("*+AB-CD"));
        System.out.println("Non recursive function : " + prefixToPostfix("*+AB-CD"));
        //Infix: (A+B)*(C-D)
    }

    private String prefixToPostfixRecursive(String prefix) {
        if(prefix.length() == 0) {
            return print();
        }

        if(operators.contains(prefix.substring(prefix.length() - 1))) {
            String newString = stack.pop() + stack.pop() + prefix.substring(prefix.length() - 1);
            stack.push(newString);
        } else {
            stack.push(prefix.substring(prefix.length() - 1));
        }
        return prefixToPostfixRecursive(prefix.substring(0, prefix.length() - 1));
    }

    private String prefixToPostfix(String prefix) {
        int size = prefix.length();
        for(int i = size - 1; i >=0; i--) {
            if(operators.contains(String.valueOf(prefix.charAt(i)))) {
                String newString = stack.pop() + stack.pop() + prefix.charAt(i);
                stack.push(newString);
            } else {
                stack.push(String.valueOf(prefix.charAt(i)));
            }
        }
        return print();
    }

    private String print() {
        StringBuilder postfix = new StringBuilder();
        Iterator iterator = stack.iterator();
        while(iterator.hasNext()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
}
