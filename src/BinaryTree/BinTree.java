/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

/**
 *
 * @author zakkizuboys
 */
public class BinTree {

    private Node root;

    private boolean isEmpty() {
        return (root == null);
    }

    public void insert(int input) {
        Node temp = new Node(input);
        if (isEmpty()) {
            root = temp;
        } else {
            Node cursor = root,
                    parent = null;
            while (cursor != null) {
                parent = cursor;
                if (input < cursor.data) {
                    cursor = cursor.left;
                } else {
                    cursor = cursor.right;
                }
            }

            if (input < parent.data) {
                parent.left = temp;
                return;
            } else {
                parent.right = temp;
                return;
            }
        }
    }

    public Node find(int key) {
        Node cursor = root;
        while (cursor != null) {
            System.out.println(cursor.data);
            if (cursor.data == key) {
                return cursor;
            } else if (key < cursor.data) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //minimum elemen
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private Node getSuccessor(Node localNode) {
        Node parent = null,
                successor = localNode,
                cursor = localNode.left;
        while (cursor != null) {
            parent = successor;
            successor = cursor;
            cursor = cursor.right;
        }
        if (successor != localNode.left) {
            parent.right = successor.left;
            successor.left = localNode.left;
        }
        return successor;
    }

    public void traverse(int tipe) {
        switch (tipe) {
            case 1:
                System.out.print("\nPreorder :\n");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder :\n");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder :\n");
                postOrder(root);
                break;
        }
        System.out.println('\n');
    }

    private void preOrder(Node localRoot) {
        if (localRoot == null) {
            return;
        }
        System.out.print(localRoot.data + " ");
        preOrder(localRoot.left);
        preOrder(localRoot.right);
    }

    private void inOrder(Node localRoot) {
        if (localRoot == null) {
            return;
        }
        inOrder(localRoot.left);
        System.out.print(localRoot.data + " ");
        inOrder(localRoot.right);
    }

    private void postOrder(Node localRoot) {
        if (localRoot == null) {
            return;
        }
        postOrder(localRoot.left);
        postOrder(localRoot.right);
        System.out.print(localRoot.data + " ");
    }

    public int getLeafCount() {
        return ii(root);
    }

    private int ii(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return ii(node.left) + ii(node.right);

        }
    }

    public void searchPaths(int x) {
        searchgetPaths(root, x);
    }

    void searchgetPaths(Node root, int x) {
        if (root.data < x) {
            System.out.print(root.data + " ");
            searchgetPaths(root.right, x);
        } else if (root.data > x) {
            System.out.print(root.data + " ");
            searchgetPaths(root.left, x);
        } else if (root.data == x) {
            System.out.print(root.data + " ");
        }
        
    }
    

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    void remove(int b){
        System.out.println(remove(b, root).data);
        remove(b, root);
    }
    
    private Node remove(int k, Node t){
        Node p, p2, n;
        if (root.data == k){
            Node lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null){
                return null;
            }
            else if (lt == null){
                p = rt;
                return p;
            }
            else if (rt == null){
                p = lt;
                return p;
            }
            else{
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                 p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.data){
            n = remove(k, root.getLeft());
            root.setLeft(n);
        }
        else{
            n = remove(k, root.getRight());
            root.setRight(n);             
        }
        return root;
    }

}
