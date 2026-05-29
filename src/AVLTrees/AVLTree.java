package AVLTrees;

public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    private class Node {

        Person value;
        int height;
        Node left;
        Node right;

        Node(Person value) {
            this.value = value;
            this.height = 1;
        }

        private int height(Node n) {
            return n == null ? 0 : n.height;
        }

        private int getBalance() {
            return height(left) - height(right);
        }

        private void updateHeight() {
            this.height = 1 + Math.max(height(left), height(right));
        }

        private Node insert(Node node) {

            if (node.value.getId() < this.value.getId()) {
                if (this.left == null)
                    this.left = node;
                else
                    this.left = this.left.insert(node);

            } else if (node.value.getId() > this.value.getId()) {
                if (this.right == null)
                    this.right = node;
                else
                    this.right = this.right.insert(node);

            } else {
                return this;
            }

            updateHeight();
            return balance();
        }

        private Node balance() {
            int balance = getBalance();

            if (balance > 1) {
                if (left.getBalance() < 0)
                    left = left.rotateLeft();

                return rotateRight();
            }

            if (balance < -1) {
                if (right.getBalance() > 0)
                    right = right.rotateRight();

                return rotateLeft();
            }

            return this;
        }

        private Node rotateLeft() {
            Node newRoot = right;
            Node temp = newRoot.left;

            newRoot.left = this;
            this.right = temp;

            this.updateHeight();
            newRoot.updateHeight();

            return newRoot;
        }

        private Node rotateRight() {
            Node newRoot = left;
            Node temp = newRoot.right;

            newRoot.right = this;
            this.left = temp;

            this.updateHeight();
            newRoot.updateHeight();

            return newRoot;
        }

        private void print(String prefix, boolean isTail) {

            String nodeInfo = value.getClass().getSimpleName()
                    + "(id=" + value.getId() + ")"
                    + " [h=" + height + ", b=" + getBalance() + "]";

            System.out.println(prefix + (isTail ? "└── " : "├── ") + nodeInfo);

            String newPrefix = prefix + (isTail ? "    " : "│   ");

            if (left != null || right != null) {

                if (right != null) {
                    if (left != null) {
                        right.print(newPrefix, false);
                    } else {
                        right.print(newPrefix, true);
                    }
                }

                if (left != null) {
                    left.print(newPrefix, true);
                }
            }
        }
    }

    public void insert(Person value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
        } else {
            root = root.insert(node);
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.print("", true);
        }
    }
}