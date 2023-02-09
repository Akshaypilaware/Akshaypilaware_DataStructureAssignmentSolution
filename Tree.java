import java.util.ArrayList;
import java.util.List;

class Node {
  int value;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class BST {
  Node root;

  public BST() {
    this.root = null;
  }

  public void insert(int value) {
    if (root == null) {
      root = new Node(value);
      return;
    }

    Node current = root;
    while (true) {
      if (value < current.value) {
        if (current.left == null) {
          current.left = new Node(value);
          break;
        } else {
          current = current.left;
        }
      } else {
        if (current.right == null) {
          current.right = new Node(value);
          break;
        } else {
          current = current.right;
        }
      }
    }
  }

  public List<Integer> inOrderTraversal() {
    List<Integer> values = new ArrayList<>();
    inOrderTraversal(root, values);
    return values;
  }

  private void inOrderTraversal(Node node, List<Integer> values) {
    if (node == null) {
      return;
    }

    inOrderTraversal(node.left, values);
    values.add(node.value);
    inOrderTraversal(node.right, values);
  }

  public Node convertToSkewedTree() {
    List<Integer> values = inOrderTraversal();
    Node newRoot = new Node(values.get(0));
    Node current = newRoot;

    for (int i = 1; i < values.size(); i++) {
      current.right = new Node(values.get(i));
      current = current.right;
    }

    return newRoot;
  }
}

public class Tree{
  public static void main(String[] args) {
    BST bst = new BST();
    bst.insert(50);
    bst.insert(30);
    bst.insert(60);
    bst.insert(10);
    bst.insert(55);

    Node newRoot = bst.convertToSkewedTree();

    List<Integer> values = new ArrayList<>();
    inOrderTraversal(newRoot, values);

    System.out.println(values);
  }

  private static void inOrderTraversal(Node node, List<Integer> values) {
    if (node == null) {
      return;
    }

    inOrderTraversal(node.left, values);
    values.add(node.value);
    }
}
