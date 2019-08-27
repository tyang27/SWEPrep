import java.util.*;

class BinaryNode {
  int val;
  BinaryNode left, right;
  BinaryNode(int val) { this.val=val; }
  static void traverse(BinaryNode root) {
    // Preorder
    if (root.left != null)
      traverse(root.left);
    // Inorder
    System.out.println(root.val);
    if (root.right != null)
      traverse(root.right);
    // Postorder
  }
}

class Tree {

  public static void main(String[] args) {
    BinaryNode root = new BinaryNode(2);
    root.left = new BinaryNode(1);
    root.right = new BinaryNode(3);
    BinaryNode.traverse(root);
  }
}
