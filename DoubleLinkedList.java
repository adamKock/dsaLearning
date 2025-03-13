public class DoubleLinkedList {

    public Node head; 
    private Node tail; 
    private int length; 

    public class Node {

        int value; 
        Node next; 
        Node prev; 
        
        Node(int value){
            this.value=value;  
        }  
    }

    public DoubleLinkedList(int value){
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

    public void getHead(){
        
        System.out.println("Head " + head.value);
    }

    public void getTail(){
       
        System.out.println("Tail " + tail.value);
    }

    public void getLength(){

        System.out.println("Length " + length);
    }

    public void appendDLL(int value){
        Node newNode =new Node(value); 
        if(length==0){
            head=newNode; 
            tail=newNode;
        }else{
            tail.next=newNode; 
            newNode.prev=tail; 
            tail=newNode; 
        }
        length++; 
    }

    public Node removeLast(){
        if (length == 0) return null;
        Node temp=tail; 

        if(length == 1) {
            head=null; 
            tail=null; 
        }else{
            tail=tail.prev; 
            tail.next=null;
            temp.prev=null;
        }
         
        length--; 
        
        return temp; 
    }

    public void prePendDLL(int value){
        Node newNode=new Node(value); 

        if(length==0){
           head=newNode; 
           tail=newNode; 

        }else{
            newNode.next=head; 
            head.prev=newNode; 
            head=newNode; 

        }
        length++; 

    }

    public Node removeFirstDLL(){
        if(length == 0) return null; 
        Node temp=head; 
        head=head.next; 
        temp.next=null; 
        head.prev=null; 
        length--; 

        if(length==0){
            head=null; 
            tail=null; 
        }
        return temp; 


    }

    public Node getDLL(int index){
        if(length==0 || index >=length )return null; 

        Node temp=head; 
        for(int i=0; i<index; i++){
            temp=temp.next; 
        }
        return temp; 
    }

    public boolean setDLL(int index, int value){
        Node temp=getDLL(index); 
        if(temp!=null){
            temp.value=value; 
            return true; 
        }else 
        return false;

    }

    public boolean insertDLL(int value, int index){
        if(index<0 || index>length){
            return false; 
        }else if(index==0){
            prePendDLL(value);
            return true; 
        }else if(index==length){
            appendDLL(value);
            return true; 
        }else{
            Node newNode= new Node(value); 
            Node temp=getDLL(index-1); 
            Node after=temp.next; 
            temp.next=newNode; 
            newNode.next=after; 
            after.prev=newNode; 
            newNode.prev=temp; 
            length++; 
            return true; 
        }

    }

    public Node removeDLL (int index){
        if(index<0 || index>length) return null;
        if(index==0) return removeFirstDLL(); 
        if(index==length-1)return removeLast();
        else{
            Node temp=getDLL(index); 
            Node previous=temp.prev; 
            Node after=temp.next; 
            previous.next=after; 
            after.prev=previous; 
            temp.prev=null; 
            temp.next=null; 
            length--; 

            return temp; 

        } 
            
        } 



        public void reverse(){
            Node temp=head;
            Node current=head; 
            Node previous=null; 
            Node after=null; 
            
            while(current!=null){
                after=current.next; 
                current.next=previous; 
                previous=current; 
                current=after; 
            }

            head=previous; 
            tail=temp; 


        }

        public void reverseOne(){
            Node current=head; 
            Node previous =null; 
            Node temp=head; 

            while(current!=null){
                Node after=current.next;
                current.next=previous; 
                previous=current; 
                current=after; 
            }

            head=previous; 
            tail=temp; 

        }

        public void reverseTwo(){
            Node current=head; 
            Node temp=head; 
            Node previous=null; 

            while(current!=null){
                Node after= current.next; 
                current.next=previous; 
                previous=current; 
                current=after; 
            }
            head=previous; 
            tail=temp;

        }

        public void swapFirstLast(){
            if(length<2) return; 
            else{
                int valueOfHead=head.value; 
                head.value =tail.value; 
                tail.value=valueOfHead; 
            }
        }

        public void reverseDoubleLinkedList(){
            if(length<2)return; 
        else{
            Node temp =null; 
            Node currentNode=head; 
            while(currentNode!=null){
                temp=currentNode.prev; 
                currentNode.prev=currentNode.next; 
                currentNode.next=temp; 
                currentNode=currentNode.prev; 
            }
            tail=head; 
            head=currentNode; 

            }
        }


        public Boolean isPallindrome(){
            
            Node tempHead=head; 
            Node tempTail=tail; 

            for(int i=0; i<length/2; i++){
                if(tempHead.value!=tempTail.value){
                    return false;
                }
                tempHead=tempHead.next; 
                tempTail=tempTail.prev;
            }
            
        return true; 

        }


        public void swapPairs(){
            Node dummyNode =new Node(0);
            dummyNode.next=head; 
            Node previousNode=dummyNode; 

            while(head!=null && head.next!=null){
                Node firstNode=head; 
                Node secondNode=head.next; 

                previousNode.next=secondNode; 
                firstNode.next=secondNode.next;
                secondNode.next=firstNode; 

                secondNode.prev=previousNode; 
                firstNode.prev=secondNode; 

                if(firstNode.next!=null){
                    firstNode.next.prev=firstNode;
                }
                
                head=firstNode.next; 
                previousNode=firstNode; 

            }
            head=dummyNode.next;
            if(head!=null) head.prev=null;

           
        }

    }
    
