public class Operation {

    Operation (String expr) {
        boolean isValid = validate(expr);
        if (isValid) {
            System.out.println(" : Validation complete");
            String transExp = translate(expr);
            System.out.println("Value after evaluating expression is " + evaluate(transExp) +"\n");
        }else
            System.out.println(" : Invalid parenthesis!"+ "\n");
    }

    public boolean validate(String ex) {
        boolean isGood = true;
        CharStack cStack = new CharStack();
        char c;

        for(int i = 0; i < ex.length(); i++) {
            c = ex.charAt(i);
            System.out.print(c);

            if(c == '(') {
                cStack.push(c);
            }
            else if(c == ')'){
                if(cStack.isStackEmpty())
                    isGood = false;
                else
                    cStack.pop();
            }
        }

        if(!cStack.isStackEmpty())
            isGood = false;

        return isGood;
    }

    public String translate(String ex) {
        CharStack post = new CharStack();
        CharStack op = new CharStack();
        char c, myOp;
        String transString ="";
        int postsize = ex.length();

        for(int i = 0; i < ex.length(); i++) {
            c = ex.charAt(i);

            if(c == '(') {
                while (ex.charAt(i+1) != ')') {
                    i++;
                    c = ex.charAt(i);
                    if (c >= '0' && c <= '9')
                        post.push(c);
                    else if (c == '+' || c == '-' || c == '*' || c == '/')
                        op.push(c);
                }
                i++;
                if (!op.isStackEmpty()) {
                    myOp = op.pop();
                    post.push(myOp);
                }
                c = ')';
            }

            if (c >= '0' && c <= '9')
                post.push(c);

            if (!op.isStackEmpty()) {
                myOp = op.pop();
                post.push(myOp);
            }

            if (c == '+' || c == '-' || c == '*' || c == '/')
                op.push(c);

            if (c == ')' && !op.isStackEmpty()) {
                myOp = op.pop();
                post.push(c);
            }
        }

        System.out.print("Translated expression is: ");
        for(int i = 0; i <= post.top; i++) {
            transString += post.s[i];
            System.out.print(post.s[i]);
        }
        System.out.println();
        return transString;
    }

    public double evaluate(String ex) {
        DoubleStack nStack = new DoubleStack();
        char c;
        double number, x, y, z = 0;
        double answer;

        for(int i = 0; i < ex.length(); i++) {
            c = ex.charAt(i);
            if(c >= '0' && c <= '9' ) {
                number = (int)c - 48.0;
                nStack.push(number);
            }
            else{
                y = nStack.pop();
                x = nStack.pop();
                if(c == '+') {
                    z = x + y;
                }
                else if(c == '-') {
                    z = x - y;
                }
                else if(c == '*') {
                    z = x * y;
                }
                else if(c == '/') {
                    z = x / y;
                }
                nStack.push(z);
            }
        }
        answer = nStack.pop();
        return answer;
    }
}