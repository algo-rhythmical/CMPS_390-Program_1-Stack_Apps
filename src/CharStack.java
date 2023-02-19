public class    CharStack {
    int top;
    char[] s;

    CharStack() {
        top = -1;
        s = new char [100];
    }

    CharStack(int n) {
        top = -1;
        s = new char[n];
    }

    public void push(char c) {
        ++top;
        s[top] = c;
    }

    public char pop() {
        char c;
        c = s[top];
        --top;
        return c;
    }

    public boolean isStackEmpty () {
        boolean answer = false;
        if(top == -1) {
            answer = true;
        }
        return answer;
    }

    public void showStack() {
        for(int i = 0; i <= top; ++i) {
            System.out.print(s[i]);
        }
        System.out.println();
    }

    public void TestStackIO (String test) {
        for(int i = 0; i < test.length(); ++i) {
            push(test.charAt(i));
        }
        showStack();
        while (!isStackEmpty()) {
            System.out.print(pop());
        }
    }

}