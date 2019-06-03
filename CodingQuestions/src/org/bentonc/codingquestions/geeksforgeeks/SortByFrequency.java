package org.bentonc.codingquestions.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/sort-elements-by-frequency/
 * https://www.geeksforgeeks.org/sort-elements-by-frequency-set-2/
 * https://www.geeksforgeeks.org/sort-elements-frequency-set-4-efficient-approach-using-hash/
 *
 * Note: This question is probably better for "Logical and Maintainable" type questions.
 */
public class SortByFrequency {

    class Element {
        private int value;
        private int count;

        Element(int value, int count) {
            this.value = value;
            this.count = count;
        }

        int getValue() {
            return value;
        }

        int getCount() {
            return count;
        }

        void setCount(int count) {
            this.count = count;
        }
    }

    class Node {
        private Element element;
        private Node left;
        private Node right;

        Node(Element element) {
            this.element = element;
        }

        Element getElement() {
            return element;
        }

        Node getLeft() {
            return left;
        }

        Node getRight() {
            return right;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        void setRight(Node right) {
            this.right = right;
        }
    }

    void bySorting(List<Integer> integers) {
        List<Element> elements = new ArrayList<>();

        for (int i = 0; i < integers.size(); i++) {
            elements.add(new Element(integers.get(i), 0));
        }

        elements.sort(Comparator.comparing(Element::getValue));

        elements.get(0).setCount(1);

        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i).getValue() == elements.get(i - 1).getValue()) {
                elements.get(i).setCount(
                        elements.get(i).getCount() + elements.get(i - 1).getCount() + 1);

                elements.get(i - 1).setCount(-1);
            } else {
                elements.get(i).setCount(1);
            }
        }

        elements.sort(Comparator.comparing(Element::getCount));

        List<Integer> result = new ArrayList<>();
        for (int i = elements.size() - 1; i >= 0; i--) {
            if (elements.get(i).getCount() != -1) {
                for (int j = 0; j < elements.get(i).getCount(); j++) {
                    result.add(elements.get(i).getValue());
                }
            }
        }

        // System.out.println("result: " + result);
    }

    void byMap(List<Integer> integers) {
        Map<Integer, Element> map = new HashMap<>();

        for (int i = 0; i < integers.size(); i++) {
            Integer value = integers.get(i);
            Element defaultElement = new Element(value, 0);
            map.putIfAbsent(value, defaultElement);
            map.get(value).setCount(map.get(value).getCount() + 1);
        }

        List<Element> elements = new ArrayList<>(map.values());

        elements.sort(Comparator.comparing(Element::getCount));

        List<Integer> result = new ArrayList<>();
        for (int i = elements.size() - 1; i >= 0; i--) {
            if (elements.get(i).getCount() != -1) {
                for (int j = 0; j < elements.get(i).getCount(); j++) {
                    result.add(elements.get(i).getValue());
                }
            }
        }

        // System.out.println("result: " + result);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(new Element(value, 1));
        }

        if (value == root.getElement().getValue()) {
            root.getElement().setCount(root.getElement().getCount() + 1);
        } else if (value < root.getElement().getValue()) {
            root.setLeft(insert(root.getLeft(), value));
        } else {
            root.setRight(insert(root.getRight(), value));
        }

        return root;
    }

    private void store(Node root, List<Element> list) {
        if (root == null) {
            return;
        }

        store(root.getLeft(), list);
        list.add(root.getElement());
        store(root.getRight(), list);
    }

    void byBst(List<Integer> integers) {
        Node root = null;

        for (int i = 0; i < integers.size(); i++) {
            root = insert(root, integers.get(i));
        }

        List<Element> elements = new ArrayList<>();
        store(root, elements);

        elements.sort(Comparator.comparing(Element::getCount));

        List<Integer> result = new ArrayList<>();
        for (int i = elements.size() - 1; i >= 0; i--) {
            if (elements.get(i).getCount() != -1) {
                for (int j = 0; j < elements.get(i).getCount(); j++) {
                    result.add(elements.get(i).getValue());
                }
            }
        }

        // System.out.println("result: " + result);
    }
}
