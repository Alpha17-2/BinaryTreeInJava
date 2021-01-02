import java.util.*;
class Node
{
    // The Node
    int data;
    Node left;
    Node right;
}
public class insertionsanddisplay
{
    public static void displayBST(Node rootNode)
    {
        // We are using Pre-order Traversal technique to display the tree
        if (rootNode==null) // Base case
            return;
        System.out.print(rootNode.data+" ");
        displayBST(rootNode.left);
        displayBST(rootNode.right);
    }
    public static Node CreateNewNode(int value)
    {
        Node newNode=new Node(); // creating a new new node using the new function
        newNode.data=value;
        newNode.left=null;
        newNode.right=null;
        return newNode;
    }
    public static Node insert(Node rootNode,int val)
    {
        if (rootNode==null) // Will run only once when the tree is empty
        {
            rootNode=CreateNewNode(val);
            return rootNode;
        }
        if (val<=rootNode.data)
        {
            rootNode.left=insert(rootNode.left,val);
        }
        else
        {
            rootNode.right=insert(rootNode.right,val);
        }
        return rootNode;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int[] values=new int[7]; // {6,4,3,5,7,2,8 }
        Node root=null;
        System.out.println("Enter values");
        for (int i = 0; i <7 ; i++) {
            values[i]=sc.nextInt();
        }
        for (int i=0;i<7;i++)
        {
            root=insert(root,values[i]); // Inserting values to the tree
        }
        System.out.println("The Tree : ");
        displayBST(root);
    }
}