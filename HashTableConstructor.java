import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableConstructor {

    private int size=7; 
    private Node[] dataMap; 

    class Node{
        String key; 
        int value; 
        Node next; 

        Node(String key, int value){
            this.key=key; 
            this.value=value; 
            
        }
    }
    public HashTableConstructor(){
        dataMap=new Node [size]; 
    }




    private int hash (String key){
        int hash=0; 
        char[] keyChars=key.toCharArray();
        for(int i=0; i<keyChars.length; i++){
            int assciiValue=keyChars[i];
            hash=(hash +assciiValue*23 )%dataMap.length; 
        }
        return hash; 
    }

    public void set(String key, int value){
        int index=hash(key);
        Node newNode = new Node(key, value); 
        if(dataMap[index]==null){
            dataMap[index]=newNode; 
        }else{
            Node temp=dataMap[index]; 
            while(temp.next!=null){
                temp=temp.next; 
            }
            temp.next=newNode; 
        }
    }

    public int get(String key){
        int index=hash(key);
        Node temp=dataMap[index]; 
        while(temp!=null){
            if(temp.key==key){
                return temp.value; 
            }
            temp=temp.next; 
        }
            return 0; 

    }

    public ArrayList keys(){
        ArrayList<String> allKeys=new ArrayList<>(); 
        for(int i=0; i<dataMap.length; i++){
            Node temp=dataMap[i]; 
            while(temp!=null){
                allKeys.add(temp.key); 
                temp=temp.next; 
            }
          
        }
        return allKeys; 
    }


    public static boolean compare(int[] arr1, int[]arr2){
        HashMap <Integer, Boolean> hash =new HashMap<>(); 

        for(int i=0; i<arr1.length; i++){
            hash.put(arr1[i], true); 
        }
        for(int j=0; j<arr2.length; j++){
            if(hash.get(arr2[j])!=null){
                return true; 
            }
        }
        return false; 
    }


    public static boolean compareE(int[] arr1, int[]arr2){
        HashMap <Integer, Boolean> hash =new HashMap<>(); 

      for(int i: arr1){
        hash.put(i, true);
      }
      for(int j: arr2){
        if(hash.get(j)!=null){
            return true;
        }
      }

return false;
    
}

public static List<Integer> findDuplicates(int[] nums) {
        // Initialize a HashMap to track occurrences of each number
        Map<Integer, Integer> numCounts = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        // Iterate through the array
        for (int num : nums) {
            // If the number is already in the HashMap, it's a duplicate
            if (numCounts.containsKey(num)) {
                if (numCounts.get(num) == 1) { // Only add the duplicate once
                    duplicates.add(num);
                }
                // Increment the count
                numCounts.put(num, numCounts.get(num) + 1);
            } else {
                // If not in the HashMap, add it with count 1
                numCounts.put(num, 1);
            }
        }

        return duplicates;
    }


    public static Character firstNonRepeatingChar(String string){
     Map<Character,Integer> charCount=new HashMap<>(); 
     
        for(int i=0; i<string.length(); i++){
            char c =string.charAt(i);
            charCount.put(c, charCount.getOrDefault(c,0)+1);    
     }
     for(int i=0; i<string.length(); i++){
        char c= string.charAt(i); 
        if(charCount.get(c)==1){
            return c; 
        }

     }
       
     return null; 
     }

   

      
    

    }

      

