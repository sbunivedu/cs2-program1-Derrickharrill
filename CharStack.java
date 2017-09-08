public class CharStack
{
  private final int MAX_CAP = 100;
  private int top; //location of top item on the stack
  private char [] s; //The stack

  public CharStack(){
    //PRE:
    //POS:
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;
  }

  public void push(char element){
    //PRE: stack cannot be full
    //POS:
    //TAS: Add a new item to the stack
    top ++;
    s[top] = element;
  
  }

  public char pop (){
    //PRE: the stack cannot be empty to pop something
    //POS:
    //TAS: remove and return the item on the top of the stack
    top--;
    return s[top+1];
  }
  
  public boolean isEmpty(){
    //PRE:
    //POS:
    //TAS: Return whether or not the stack is empty. HINT: look
    //     at the constructor.
    return top<=-1;
  }

  public boolean isFull(){

    //TAS: return whether or not the stack is full
    return top == MAX_CAP-1;
  }
  
  public char peek(){
    //PRE: Stack sould not be empty
    //POS:
    //TAS: looks at the top of the stack
    return s[top];
  }
  
  public String toString(){
    String stackString = "";
    for(int i = top; i>-1; i--){
        if(i==0){
          stackString = stackString + s[i];
        }
        else{
          stackString = stackString + s[i] + ", ";
        }
      }
    return stackString;
  }
  
}
