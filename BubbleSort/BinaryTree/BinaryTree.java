import java.util.Vector;

public class BinaryTree{
    Node root;

    private Node addRecursive(Node current, int value){
        if(current == null){
            return new Node(value);
        }

        if(value < current.value){
            current.left = addRecursive(current.left, value);
        }else if(value > current.value){
            current.right = addRecursive(current.right, value);
        }else{
            return current;
        }

        return current;
    }
    public void add(int value){
        root = addRecursive(root, value);
    }

    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            right = null;
            left = null;
        }
    }

    private static BinaryTree createBinaryTree(){
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        return bt;
    }   

    private boolean containsNodeRecursive(Node current, int value){
        if(current == null){
            return false;
        }
        if(value == current.value){
            return true;
        }
        if(value < current.value){
            return containsNodeRecursive(current.left, value);
        }else{
        return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
        }
    }  
    private boolean containsNode(int value){
        return containsNodeRecursive(root, value);
    }
    

    private Node deleteRecursive(Node current, int value){
        if(current == null){
            return null;
        }
        if(value == current.value){
            if(current.left == null && current.right == null){
                return null;
            }
            if(current.right == null){
                return current.left;
            }
            if(current.left == null){
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if(value < current.value){
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root){
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value){
        root = deleteRecursive(root, value);
    }

    public static void traverseInOrder(Node node){
        if(node != null){
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public static void traversePreOrder(Node node){
        if(node != null){
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public static void traversePostOrder(Node node){
        if(node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public static void traverseLevelOrder(Node root){
        if(root == null){
            return;
        }
        Vector<Node> nodes = new Vector<Node>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node node = nodes.remove(0);
            System.out.print(" " + node.value);
            if(node.left != null){
                nodes.add(node.left);
            }
            if(node.right != null){
                nodes.add(node.right);
            }
        }
    }

    public static void printTreeBFS(Node root){
        if(root == null){
            return;
        }
        Vector<Node> nodes = new Vector<Node>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node node = nodes.remove(0);
            System.out.print(" " + node.value);
            if(node.left != null){
                nodes.add(node.left);
            }
            if(node.right != null){
                nodes.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = createBinaryTree();
        System.out.println(bt.containsNode(6));
        System.out.println(bt.containsNode(4));
        System.out.println(bt.containsNode(1));
        System.out.println(bt.containsNode(9));

        bt.delete(9);

        System.out.println(bt.containsNode(9));
        traverseInOrder(bt.root);
        System.out.println();

        traversePreOrder(bt.root);
        System.out.println();

        traversePostOrder(bt.root);
        System.out.println();

        traverseLevelOrder(bt.root);
        System.out.println();

        printTreeBFS(bt.root);
        

    }
    
}
