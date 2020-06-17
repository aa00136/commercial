package com.lgh.commercial;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, LinkedNode> map = new HashMap<>();

    private int size;

    private int capacity;

    private LinkedNode head;

    private LinkedNode tail;

    class LinkedNode {
        private int key;

        private int value;

        private LinkedNode prev;

        private LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value, LinkedNode prev, LinkedNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public LinkedNode getPrev() {
            return prev;
        }

        public void setPrev(LinkedNode prev) {
            this.prev = prev;
        }

        public LinkedNode getNext() {
            return next;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        this.head.setNext(tail);
        this.tail.setPrev(head);
    }

    public int get(int key) {
        LinkedNode exist = map.get(key);
        if (exist == null) {
            return -1;
        } else {
            moveToHead(exist);
            return exist.getKey();
        }
    }

    public void put(int key, int value) {
        LinkedNode exist = map.get(key);
        if (exist == null) {
            LinkedNode node = new LinkedNode();
            node.setKey(key);
            node.setValue(value);
            addToHead(node);
            map.put(key, node);
            size++;
            if (size > capacity) {
                LinkedNode removeNode = removeTail();
                map.remove(removeNode.getKey());
                size--;
            }
        } else {
            exist.setValue(value);
            moveToHead(exist);
        }
    }

    private void addToHead(LinkedNode node) {
        node.setPrev(this.head);
        node.setNext(this.head.getNext());
        this.head.getNext().setPrev(node);
        this.head.setNext(node);
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(LinkedNode node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    private LinkedNode removeTail() {
        LinkedNode removeNode = this.tail.getPrev();
        removeNode(removeNode);
        return removeNode;
    }
}
