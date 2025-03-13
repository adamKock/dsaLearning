import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableMain {
    public static void main(String[] args) {
        
        HashTableConstructor myHashTable =new HashTableConstructor(); 


        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = myHashTable.findDuplicates(nums);
        System.out.println(duplicates); 
        
    }

    public static List<List<String>> groupAnagrams(String []str){
       Map<String,List<String>> groupAnagrams=new HashMap<>(); 

       groupAnagrams.put(null, null); 
    }

   
}
