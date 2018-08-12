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
    //method to delete a node in tree
    void deleteNode(Node current,int value){
        if(current==null){
            return;
        }
        else if(value<current.data) {
            deleteNode(current.left,value);
        }
        else if(value>current.data){
            deleteNode(current.right,value);
        }
        //we are the node we want to delete
        else {
            //case 1 no child nodes
            if(current.left==null && current.right==null){
                current=null;
            }
            // case 2 1 child
            else if(current.left==null){
                current=current.right;
            }
            else if(current.right==null){
                current=current.left
            }
            //node has 2 children
            //swap it with max node in left sub tree or min node in right sub tree
            else {
                Node minNode=findMinimum(current.right);
                current.data=minNode.data;
                deleteNode(current.right,minNode.data);
            }
        }
    }


    //method to find minimum node in tree
    Node findMinimum(Node current){
        while(current.left!=null){
            current=current.left;
        }
        System.out.println("\n Minimum is " + current.data);
        return current;
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
        bst.findMinimum(bst.root);
        
    }
}
