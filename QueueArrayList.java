import java.util.ArrayList;

public class QueueArrayList {


    private ArrayList<String> queueArray; 

    public QueueArrayList(String value){
        queueArray=new ArrayList<>(); 
    }



    

    public void enqueue(String value){
        queueArray.add(value); 
    }

    public boolean peek(){
        return queueArray.isEmpty(); 
    }

    public void printArrayQueue(){
        System.out.println(queueArray);
    }
} 
    