public class Stack {
    int top;
    char[] chStack;
    double[] numStack;

    Stack(char c) {
        top = -1;
        chStack = new char[32];
    }

    Stack(int n) {
        top = -1;
        numStack = new double[32];
    }

    public void push(char c) {
        ++top;
        chStack[top] = c;
    }

    public void push(double n) {
        ++top;
        numStack[top] = n;
    }

    public char pop(char c) {
        c = chStack[top];
        --top;
        return c;
    }

    public double pop(double n) {
        n = numStack[top];
        --top;
        return n;
    }

    public boolean isStackEmpty() {
        boolean answer = false;
        if (top == -1)
            answer = true;
        return answer;
    }

    public void showStack(char c) {
        for(int i = 0; i <= top; i++) {
            System.out.print(chStack[i]);
        }
        System.out.println();
    }

    public void showStack(double n) {
        for(int i = 0; i <= top; i++) {
            System.out.print(numStack[i]);
        }
        System.out.println();
    }

}