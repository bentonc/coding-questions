package org.bentonc.codingquestions.miscellaneous;

public class FindHighestCostTeam {

    class Node {
        int wage;
        int teamWage;
        int teamCount;

        Node left;
        Node right;

        public Node(int value) {
            this.wage = value;
            this.teamWage = wage;
            this.teamCount = 0;
        }

        @Override
        public String toString() {
            return String.format(
                    "wage: %s, teamWage: %s, teamCount: %s",
                    wage, teamWage, teamCount);
        }
    }

    private int calculateTotalWages(Node root) {
        if (root == null) {
            return 0;
        }

        int left = calculateTotalWages(root.left);
        int right = calculateTotalWages(root.right);
        root.teamWage = left + right;

        return root.wage + root.teamWage;
    }

    private void printWages(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.toString());

        printWages(root.left);
        printWages(root.right);
    }

    public void run() {
        Node root = new Node(1);
        root.left = new Node(6);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        root.right.right = new Node(2);

        calculateTotalWages(root);
        printWages(root);
    }
}
