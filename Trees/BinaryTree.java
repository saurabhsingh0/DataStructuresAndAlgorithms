class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class BinarySearchTree {
    Node root;
    BinarySearchTree(){
        root=null;
    }
    //method to insert into the tree
    void insertNode(Node rootNode, int data){
        if(root==null){
            Node newNode=new Node(data);
            root=newNode;
        }
        //move to left child
        else if(data<rootNode.data){
            if(rootNode.left==null) {
                Node newNode= new Node(data);
                rootNode.left=newNode;
            }
            else {
                insertNode(rootNode.left,data);
            }
        }
        //move to right child
        else if(data>rootNode.data){
            if(rootNode.right==null){
                Node newNode=new Node(data);
                rootNode.right=newNode;
            }
            else{
                insertNode(rootNode.right,data);
            }
        }
    }

    //method for inorder traversal
    void inorder(Node currentNode){
        if(currentNode!=null){
            inorder(currentNode.left);
            System.out.print(currentNode.data+"->");
            inorder(currentNode.right);
        }
    }

    //method for preorder traversal
    void preorder(Node currentNode){
        if(currentNode!=null){
            System.out.print(currentNode.data+"->");
            preorder(currentNode.left);
            preorder(currentNode.right);
        }
    }

    //method for postorder traversal
    void postorder(Node currentNode){
        if(currentNode!=null){
            postorder(currentNode.right);
            System.out.print(currentNode.data+"->");
            postorder(currentNode.right);
        }
    }
}

class Main{
    public static void main(String[] args) {
        int array[]={45,39,56,12,34,78,32,10,89,54,67,81};
        BinarySearchTree bst= new BinarySearchTree();
        for(int i=0;i<array.length;i++){
            bst.insertNode(bst.root,array[i]);
        }
        //inorder traversal
        System.out.println("Inorder Traversal");
        bst.inorder(bst.root);
        //preorder traversal
        System.out.println("\nPreorder traversal");
        bst.preorder(bst.root);
        //postorder traversal
        System.out.println("\nPostorder Traversal");
        bst.postorder(bst.root);

    }
}
