import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BinarySearch{

    static class Node {
        int value;
        Node left, right;

        // constructor
        Node(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;

    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.value + " ");
        inorder(temp.right);
    }

    /*function to insert element in binary tree */
    static void insert(Node temp, int value)
    {

        if (temp == null) {
            root = new Node(value);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(value);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(value);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    static void deleteDeepest(Node root,
                              Node delNode)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp == delNode)
            {
                temp = null;
                return;

            }
            if (temp.right!=null)
            {
                if (temp.right == delNode)
                {
                    temp.right = null;
                    return;
                }
                else
                    q.add(temp.right);
            }

            if (temp.left != null)
            {
                if (temp.left == delNode)
                {
                    temp.left = null;
                    return;
                }
                else
                    q.add(temp.left);
            }
        }
    }

    static void delete(Node root, int value)
    {
        if (root == null)
            return;

        if (root.left == null &&
                root.right == null)
        {
            if (root.value == value)
                return;
            else
                return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, valueNode = null;


        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp.value == value)
                valueNode= temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (valueNode != null)
        {
            int x = temp.value;
            deleteDeepest(root, temp);
            valueNode.value = x;
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter root node to add more nodes:");
        int r=sc.nextInt();
        root = new Node(r);
        while(true)
        {
            System.out.println("\n_______________________________");
            System.out.println("****BINARY SEARCH TREE MENU****");
            System.out.println("_______________________________");
            System.out.println("1. Add new node\n2. Delete a node\n3. Print\n0. Exit");
            System.out.println("_______________________________");
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.println("Please enter a value");
                int value=sc.nextInt();
                insert(root, value);
                System.out.println("I will add the following: "+ value);
            }
            if(choice==2)
            {
                System.out.println("Please enter a value");
                int value=sc.nextInt();
                delete(root, value);
                System.out.println("I will delete the following: "+ value);
            }
            if(choice==3) {

                System.out.println("I will the print the tree: " );
                inorder(root);
            }
            if(choice==4)
                System.exit(0);
        }

    }
}
