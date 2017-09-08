import java.util.Scanner;
class Converer
{
    
    public static void main(String [] args){
        
        CharStack stack = new CharStack();
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please input your infix expression:  ");
        String infix = scan.nextLine();
        boolean error = false;
        String postfix ="";
        
        for(int i = 0; i<infix.length(); i++){
            
            char current = infix.charAt(i);
        
            if(isOperand(current)){
                postfix += current;
            }else if(current=='('){
                stack.push(current);
            }else if (current==')'){
                if(!stack.isEmpty()){
                    while(stack.peek()!='('){ // makes sure that it doesn't add '(' to my postfix string
                        postfix+=stack.pop();
                    }
                    stack.pop();
                }else
                    error = true;
            }else if (isOperator(current)){
                if(!stack.isEmpty() && (current==stack.peek() || ((current=='-'|| current=='+') && (stack.peek()=='*' || stack.peek()=='/'))))
                    postfix+=stack.pop();
                stack.push(current);
            }
        }
        while(!stack.isEmpty()) //gets every thing out of the stack
            postfix += stack.pop();
        
        System.out.println("The postfix expression is: " + postfix);
        
    }
    
    public static boolean isOperand(char c){
        
        if( (c>='a'&&c<='z') || (c>='A'&&c<='Z') || (c>='0'&&c<='9') )
            return true;
        else
            return false;
        
    }
    public static boolean isOperator(char c){
        
        if( (c=='+') || (c=='-') || (c=='*') || (c=='/') )
            return true;
        else
            return false;
        
    }
    
}