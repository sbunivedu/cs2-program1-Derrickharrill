import java.util.Scanner;
class Converter
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
            System.out.println(i+" "+stack.toString()+" "+postfix);
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
               while( !stack.isEmpty() && !(stack.peek()=='(') && precedence(stack.peek()) >= precedence(current) ){
                   //if(precedence(stack.peek()) >= precedence(current))
                        postfix += stack.pop();
               }
               stack.push(current);
            }
        }
        while(!stack.isEmpty()) //gets every thing out of the stack
            postfix += stack.pop();
        
        System.out.println("The postfix expression is: " + postfix);
        
    }
    
    public static int precedence(char c){
        /*
        * and / = 1
        + and - = 0
        */
        
        if(c == '*' || c == '/')
            return 1;
        else
            return 0;
        
        
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