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
        boolean isValid = true;
        Stack cStack = new Stack('c');
        char c;
        for(int i = 0; i < ex.length(); i++) {
            c = ex.charAt(i);
            System.out.print(c);
            if(c == '(') {
                cStack.push(c);
            }
            else if(c == ')'){
                if(cStack.isStackEmpty())
                    isValid = false;
                else
                    cStack.pop('c');
            }
        }
        if(!cStack.isStackEmpty())
            isValid = false;
        return isValid;
    }

    public String translate(String ex) {
        Stack post = new Stack('c');
        Stack op = new Stack('c');
        char c, myOp;
        String transString ="";

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
                    myOp = op.pop('c');
                    post.push(myOp);
                }
                c = ')';
            }

            if (c >= '0' && c <= '9')
                post.push(c);

            if (!op.isStackEmpty()) {
                myOp = op.pop('c');
                post.push(myOp);
            }

            if (c == '+' || c == '-' || c == '*' || c == '/')
                op.push(c);

            if (c == ')' && !op.isStackEmpty()) {
                myOp = op.pop('c');
                post.push(c);
            }
        }
        System.out.print("Translated expression is: ");
        for(int i = 0; i <= post.top; i++) {
            transString += post.chStack[i];
            System.out.print(post.chStack[i]);
        }
        System.out.println();
        return transString;
    }

    public double evaluate(String ex) {
        Stack nStack = new Stack(1);
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
                y = nStack.pop(1);
                x = nStack.pop(1);
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
        answer = nStack.pop(1);
        return answer;
    }
}