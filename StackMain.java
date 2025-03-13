import java.util.ArrayList;

public class StackMain {

     public static void main(String[] args){

        StackLinkedList myStack = new StackLinkedList(10);
        myStack.push(5);
        myStack.printStack();
        myStack.pop(); 
        myStack.printStack();


        ArrayList<String> arrayList=new ArrayList<String>(); 
        arrayList.add("Test ArrayList" ); 

        StackArrayList myStackList = new StackArrayList(10); 

        myStackList.printList();
       


    
     }
   
     }
 
 
 