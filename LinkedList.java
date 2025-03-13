public class LinkedList {
    private Node head; 
    private Node tail; 
    private int length; 

    public class Node {

        int value; 
        Node next; 
        
        Node(int value){
            this.value=value; 
        }
        
    }
    
    public LinkedList(int value){
        Node newNode= new Node(value);
        head=newNode; 
        tail=newNode; 
        length=1; 
    }

    public void printList(){
        Node temp=head; 

        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next; 
        }
    }

    public Node getHead(){
        return head; 
    }

    public Node getTail(){

        return tail; 
    }

    public void getLength(){

        System.out.println("Length " + length);
    }

    public void append(int value){
        Node newNode= new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        } else{
            tail.next =newNode; 
            tail=newNode; 
        }length++; 

    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prePend(int value){
        Node newNode=new Node(value); 
        if (length == 0){
            head=newNode; 
            tail=newNode; 
        }else {
            newNode.next=head; 
            head=newNode; 
        }length++; 

    }

    public Node removeFirst() {
        if(length == 0) return null; 
        Node temp=head;
           head=head.next;
           temp.next=null; 
           length--; 
           if(length==0)tail=null; 
        
        return temp; 
        
    }

    public Node get(int index){
        if(index<0 || index >= length){
            return null; 
        }
        Node temp=head; 
        for(int i=0; i<index; i++){
            temp= temp.next;
            
        }return temp; 
        

        
    }

    public boolean set(int index, int value){
        Node temp=get(index); 
        if(temp!=null){
            temp.value=value; 
            return true; 
        }
        return false; 

    }

    public boolean insert(int index, int value){
        if(index<0 || index >= length){
            return false; 
        }else if(index==0){
            prePend(value);
            return true; 
        }else if(index==length){
            append(value);
            return true; 
        }else{
            Node newNode =new Node(value); 
            Node temp=get(index -1); 
            newNode.next=temp.next; 
            temp.next=newNode; 
            length++; 
            return true; 
        }

    }

    public Node remove(int index){
        if(index<0 || index >= length) return null; 
        if(index==0)return removeFirst(); 
        if(index==length-1) return removeLast(); 
        Node prev=get(index-1); 
        Node temp = prev.next; 
        prev.next=temp.next; 
        temp.next=null;
        length--; 
        return temp; 
    }

    public void reverse(){
        Node temp=head; 
        head=tail; 
        tail=temp; 
        Node after =temp.next; 
        Node before =null; 
        for(int i=0; i<length; i++){
            after =temp.next;
            temp.next=before; 
            before=temp;
            temp=after;  
        }

    }

    public Node findMiddleNode(){
	    if(head==null) return null; 
        Node slow=head; 
        Node fast=head; 
        while(fast!=null &fast.next!=null){
           slow=slow.next; 
           fast=fast.next.next; 
        }
        return slow; 
 
	}

    public boolean hasLoop(){
        if(head==null) return false; 
        Node slow=head; 
        Node fast=head; 
        Boolean hasLoop=false; 
        while(fast!=null &&fast.next!=null){
            slow=slow.next; 
            fast=fast.next.next; 
            if(fast==slow){
                hasLoop= true;
                break;  
            }else{
                hasLoop= false; 
            }
    }
        return hasLoop;
   
}

public Node findKthFromEnd(int k){
    Node pre= head; 
    Node temp=head;  

    for(int i=0; i<k; i++){
        if(temp==null){
            return null; 
        }temp=temp.next; 
    }

    while(temp!=null){
        pre=pre.next; 
        temp=temp.next; 
    }return pre; 

}

public void removeDuplicates(){
    Node temp=head; 
    while(temp!=null && temp.next!=null){
        if(temp.value==temp.next.value){
            temp.next=temp.next.next; 
        }else{
            temp=temp.next; 
        }
            
        }
        
    }


   public int binaryToDecimal(){
    int num =0; 
    while(head.next!=null){
        num = num + head.value*2; 
        head=head.next; 
    }
    return num; 
   } 

   public void partitionList(int x){
    Node lessThanX=new Node(0); 
    Node less= lessThanX; 
    Node moreThanX=new Node(0); 
    Node more = moreThanX; 
    while(head!=null){
        if(head.value<x){
            less.next=head;  
            less=less.next;  
        }else{
            more.next=head; 
            more=more.next; 
        }
        head=head.next; 
    }
    less=moreThanX.next; 
    more=null; 
   }


   public void reverseBetween(int startIndex, int endIndex) {
    if (head == null) return;
    Node dummyNode = new Node(0);
    dummyNode.next = head;
    Node previousNode = dummyNode;
    for (int i = 0; i < startIndex; i++) {
        previousNode = previousNode.next;
    }
    Node currentNode = previousNode.next;
    for (int i = 0; i < endIndex - startIndex; i++) {
        Node nodeToMove = currentNode.next;
        currentNode.next = nodeToMove.next;
        nodeToMove.next = previousNode.next;
        previousNode.next = nodeToMove;
    }
    head = dummyNode.next;
}


public void reverseBetweenSecondGo(int startIndex, int endIndex){
    if(head==null || startIndex==endIndex) return; 
    // first we need to get a variable and point it to the node before the start index
    Node dummyNode=new Node(0); 
    dummyNode.next=head; 
    Node pre=dummyNode; 
    for(int i=0; i<startIndex; i++){
        pre=pre.next; 
    }
    Node current = pre.next; 

    for (int i=0; i<endIndex-startIndex; i++){
        Node nodeToMove=current.next; 
        current.next=nodeToMove.next; 
        nodeToMove.next=pre.next; 
        pre.next=nodeToMove; 

    }
    head=dummyNode.next; 
}




public void reverseBetweenThirdGo(int startIndex, int endIndex){
    if(head==null || startIndex==endIndex)return; // returns if LL is empty 
    Node dummy=new Node(0); 
    dummy.next=head; 
    Node pre= dummy; 
    for(int i=0; i<startIndex; i++){
        pre=pre.next; 
    }
    Node current=pre.next; 

    for(int i=0; i<endIndex-startIndex; i++){
        Node nodeToMove=current.next; 
        current.next=nodeToMove.next; 
        nodeToMove.next=pre.next; 
        pre.next=nodeToMove; 
        

    }

    head=dummy.next; 


}


public void reverseFullList(){
    Node previousNode=null; 
    Node current=head; 


    while(current!=null){
        Node nextNode=current.next; 
        current.next=previousNode; 
        previousNode=current; 
        current=nextNode; 

    }
    tail=head; 
    head=previousNode; 
}

public void reverseSublist(int left, int right){
    Node dummyNode=new Node(0); 
    dummyNode.next=head; 
    Node beforeStartIndex=dummyNode; 

    for(int i=0; i<left-1; i++){
        beforeStartIndex=beforeStartIndex.next; 
    }
    Node currentNode=beforeStartIndex.next; 

    for(int j=0; j<right-left; j++){
        Node nodeToMove=currentNode.next; 
        currentNode.next=nodeToMove.next; 
        nodeToMove.next=beforeStartIndex.next; 
        beforeStartIndex.next=nodeToMove; 
        
    }

    head=dummyNode.next; 


}













}

