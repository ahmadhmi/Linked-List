package com.ahmad;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

    }

    private Node first;
    private Node last;
    private int size;


    public void addLast(int item){
        Node node = new Node(item);
        if (first == null)
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item){
        Node node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isEmpty(){
        return (first == null);
    }

    public int indexOf(int value){
        Node node = first;
        int index = 0;

        while(node != null){
            if (node.value == value)
                return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public void removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last){
            first = last = null;
            return;
        }
        Node node = first.next;
        first.next = null;
        first = node;
        
    }
}
