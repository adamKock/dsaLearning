public class QueueMain {

    public static void main(String[] args) {
        
        QueueLinkedList myQueue=new QueueLinkedList(7); 

        myQueue.printQueue();

        QueueArrayList qAL =new QueueArrayList("John"); 
        qAL.enqueue("Cock");
        System.out.println(qAL.peek()); 
        
    }
    
}
