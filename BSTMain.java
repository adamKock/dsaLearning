public class BSTMain {

    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree(); 
        System.out.println(bst.root);

        bst.insert(10); 

        System.out.println(bst.contains(10)); 
        System.out.println(bst.contains(11)); 
    }
    
}
