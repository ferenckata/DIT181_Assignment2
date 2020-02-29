package Assignment_2;
import java.util.Stack;
import java.util.Scanner;

class RPN {
    private Stack<String> evaluationStack = new Stack<String>();

    // Main input loop
    public void loop() {
        Scanner reader = new Scanner(System.in);

        final String prompt = "> ";
        System.out.print(prompt);

        while (reader.hasNext()) {
            String input = reader.next();
            if (input.equals("quit") || input.equals("q")) {
                System.out.println("Quitting");
                break;
            }
            System.out.println("Got a string: " + input);
            System.out.print(prompt);
        }
        reader.close();
    }

    // Evaluate the stack and push the result back in the same stack
    public void evaluate() {
        System.out.println("Tokens: ");
        System.out.println(this.toString());
        // ToDo: Implement this method (you may use auxiliary methods)
    }

    // To visualise the token stack
    public String toString() {
        StringBuilder result = new StringBuilder();
        // ToDo: Implement this method
        return result.toString();
    }

    // For unit test purposes
    public void addToken(String token) {
        evaluationStack.add(token);
    }

    // For unit test purposes
    public Stack<String> getEvaluationStack() {
        Stack<String> copy = new Stack<String>();
        copy.addAll(evaluationStack);
        return copy;
    }


    public static void main(String[] args) {
        RPN calc = new RPN();
        calc.loop();
    }
}

