package org.bentonc.codingquestions.geeksforgeeks;

/**
 * https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/
 */
public class FindLargestSubtreeSum {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private int answer = 0;

    int findLargestSubtreeSum(final Node root) {
        if (root == null) {
            return 0;
        }

        int left = findLargestSubtreeSum(root.left);
        int right = findLargestSubtreeSum(root.right);
        int currentSum = root.value + left + right;

        answer = Math.max(currentSum, answer);

        return currentSum;
    }

    public void run() {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);

        System.out.println(findLargestSubtreeSum(root));
    }
}
