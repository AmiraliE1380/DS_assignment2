import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Problem2 {
    private Stack<String> stack;
    private ArrayList<String> operators;

    public static void main(String[] args) {
        new Problem2().run();
    }

    private void run() {
        stack = new Stack<>();
        operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("%");
        operators.add("*");
        System.out.println(prefixToPostfix("+AB"));
    }

    private String prefixToPostfix(String prefix) {
        if(prefix.length() == 0) {
            return print();
        }

        if(operators.contains(prefix.indent(prefix.length()))) {
            String newString = stack.pop() + stack.pop() + prefix.substring(prefix.length() - 1);
            stack.push(newString);
        } else {
            stack.push(prefix.substring(prefix.length() - 1));
        }
        return prefixToPostfix(prefix.substring(0, prefix.length() - 2));
    }

    private String print() {
        int size = stack.size();
        String postfix = "";
        for(int i = 0; i < size; i++) {
            postfix.concat(stack.pop());
        }
        return postfix;
    }
}
