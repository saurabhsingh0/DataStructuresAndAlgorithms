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
public class BinaryTree {
    Node root;
    BinaryTree(){
        root=null;
    }
    //method to insert into tree;
    Node insertNode(Node root,int value){
        if(root==null){
            root= new Node(value);
        }
        else if(value<root.data){
            root.left=insertNode(root.left,value);
        }
        else if(value>root.data){
            root.right=insertNode(root.right,value);
        }
        return root;
    }

    //inorder traversal
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.data+"->");
            inorder(root.right);
        }
    }
}

class main{
    public static void main(String[] args) {
        int array[]={45,39,56,12,34,78,32,10,89,54,67,81};
        BinaryTree bt= new BinaryTree();
        for(int i=0;i<10;i++){
            bt.insertNode(bt.root,array[i]);
        }
        bt.inorder(bt.root);
    }
}
