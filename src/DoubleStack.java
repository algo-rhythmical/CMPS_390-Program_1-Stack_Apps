public class DoubleStack {
    int top;
    double[] nStk;

    DoubleStack() {
        top = -1;
        nStk = new double[32];
    }

    public void push(double n) {
        ++top;
        nStk[top] = n;
    }

    public double pop() {
        double n;
        n = nStk[top];
        --top;
        return n;
    }

    public boolean isStackEmpty() {
        boolean answer = false;
        if (top == -1)
            answer = true;
        return answer;
    }

    public void showStack () {
        for(int i = 0; i <= top; i++) {
            System.out.print(nStk[i]);
        }
        System.out.println();
    }

}