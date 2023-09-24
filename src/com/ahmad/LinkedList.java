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

    public void print(){
        Node node = first;
        for (int i = 0; i < size; i++ ){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            return;
        }

        Node current = first;

        while(current != null){
            if (current.next == last){
                last = current;
                current.next = null;
            }
            current = current.next;
        }
        size--;
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node current = first;
        int i = 0;
        while(current != null){
            array[i] = current.value;
            current = current.next;
            i++;
        }
        return array;
    }

    public void reverse(){
        // [10,20,30,40]

        if (size == 0)
            return;

        Node previous = first;
        Node current = previous.next;
        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous ;
    }

    public int kthNode(int k){
        if (isEmpty())
            throw new IllegalStateException();

        Node current = first;
        Node second = current;
        for (int i = 1; i < k; i++){
            second = second.next;
            if (second == null)
                throw new IllegalArgumentException();
        }

        while (second.next != null){
            current = current.next;
            second = second.next;
        }

        return current.value;

    }


}
