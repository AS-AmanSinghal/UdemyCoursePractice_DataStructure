package Tree;

public class BinarySearchTree {
    Node root;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
    }

    public BinarySearchTree insert(BinarySearchTree tree, int value) {
        Node newNode = new Node(value);
        if (tree.root == null) {
            tree.root = newNode;
        } else {
            Node currentNode = tree.root;
            while (true) {
                if (value < currentNode.value) {
                    //Left
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        break;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        break;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
        return tree;
    }

    public void lookup(BinarySearchTree tree, int value) {

        Node currentNode = tree.root;
        if (currentNode == null) {
            System.out.println("No Tree Found");
        } else {
            while (currentNode != null) {
                if (value < currentNode.value)
                    currentNode = currentNode.left;
                else {
                    if (value > currentNode.value)
                        currentNode = currentNode.right;
                    else {
                        System.out.println("Value Found");
                        break;
                    }
                }
            }
            if (currentNode == null)
                System.out.println("Value Not Found");
        }
    }

    public void delete(BinarySearchTree tree, int value) {
        Node currentNode = tree.root;
        if (currentNode == null) {
            System.out.println("No Tree Found");
        }
        Node parentNode = null;
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (value == currentNode.value) {

                        //OPTION1: No Right Child
                        if (currentNode.right == null) {
                            if (parentNode == null)
                                tree.root = currentNode.left;
                            else {
                                //if parent>current value,make current
                                //left child a child of parent
                                if (currentNode.value < parentNode.value)
                                    parentNode.left = currentNode.left;
                                else {
                                    //if parent<current value,make current
                                    //right child a child of parent
                                    if (currentNode.value > parentNode.value)
                                        parentNode.right = currentNode.left;
                                }
                            }
                            //Option 2: Right Child which doesn't have a left child
                        } else {
                            if (currentNode.right.left == null) {
                                if (parentNode == null)
                                    tree.root = currentNode.left;
                                else {
                                    currentNode.right.left = currentNode.left;

                                    //if parent>current,make right child of the
                                    //left the parent
                                    if (currentNode.value < parentNode.value)
                                        parentNode.left = currentNode.right;

                                        //if parent<current,make right child of the
                                        //right the parent
                                    else {
                                        if (currentNode.value > parentNode.value) {
                                            parentNode.right = currentNode.right;
                                        }
                                    }
                                }
                            } else {
                                //find the right child's left most child

                                Node leftMost = currentNode.right.left;
                                Node leftMostParent = currentNode.right;
                                while (leftMost.left != null) {
                                    leftMostParent = leftMost;
                                    leftMost = leftMost.left;
                                }

                                //Parent's left subtree is now leftmsot's right
                                //subtree
                                leftMostParent.left = leftMost.right;
                                leftMost.left = currentNode.left;
                                leftMost.right = currentNode.right;
                                if (parentNode == null) {
                                    tree.root = leftMost;
                                } else {
                                    if (currentNode.value < parentNode.value)
                                        parentNode.left = leftMost;
                                    else {
                                        if (currentNode.value > parentNode.value) {
                                            parentNode.right = leftMost;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }
}