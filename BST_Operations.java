import java.util.*;
class Node
{
    // The Node
    int data;
    Node left;
    Node right;
}
class Main
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
    public static Node delete(int value,Node rootNode)
    {
        if (rootNode==null)
            return null;

        if (value<rootNode.data)
        {
            rootNode.left=delete(value,rootNode.left);
        }
        else if (value>rootNode.data)
        {
            rootNode.right=delete(value,rootNode.right);
        }
        else {

            // Deleting time

            // Case 1: No Children
            if (rootNode.left== null && rootNode.right==null)
            {
                // this is a leaf node ( no child )
                return null;
            }
            // Case 2 : Left Child is null
            else if (rootNode.left==null)
            {
                return rootNode.right;
            }
            // Case 3 : Right Child is null
            else if (rootNode.right==null)
            {
                return rootNode.left;
            }
            // Case 4: Both Child are present
            else {
                // We will be finding minimum in the right subtree
                Node temp=rootNode.right;
                int newValue=FindMin(temp);
                rootNode.data=newValue;
                rootNode.right=delete(newValue,rootNode.right);
            }

        }
        return rootNode;
    }
    public static int FindMin(Node currentNode)
    {

        while (currentNode.left!=null)
        {
            currentNode=currentNode.left;
        }
        return currentNode.data;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Node root=null;
        System.out.println("Enter values");
        int n=sc.nextInt();
        int[] values=new int[n];
        for (int i = 0; i <n ; i++) {
            values[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++)
        {
            root=insert(root,values[i]); // Inserting values to the tree
        }
        System.out.println("The Tree : ");
        displayBST(root);
        System.out.println();
        System.out.println("Enter the element to be deleted from Tree : ");
        int value=sc.nextInt();
        root=delete(value,root);
        displayBST(root);
    }
}
