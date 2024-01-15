package z4;

import z3.LinkedList;
import z3.ListElem;

import java.util.Random;

public class SortedLinkedList {
    private ListElem first;

    public SortedLinkedList() {
        first=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(int value){
        ListElem newElem=new ListElem(value);
        if (isEmpty()) newElem.next=first;
        first=newElem;
    }

    public void insert(int value){
        ListElem newElem=new ListElem(value);
        ListElem current=first;
        ListElem previous=null;

        while (current!=null && newElem.iData>current.iData){
            previous=current;
            current=current.next;
        }

        if (previous==null) first=newElem;
        else previous.next=newElem;
        newElem.next=current;
    }

    public boolean find(int searchElem){
        if (isEmpty()) return false;
        ListElem current=first;
        while (current.iData!=searchElem){
            if (current.next==null) return false;
            else
                current=current.next;
        }
        return true;
    }

    public ListElem deleteFirst(){
        if (isEmpty()) return null;
        ListElem temp=first;
        first=first.next;
        return temp;
    }

    public ListElem delete(int value){
        if (isEmpty()) return null;
        ListElem current=first;
        ListElem previous=null;
        while (current.iData!=value){
            if (current.next==null) return null;
            else
                previous=current;
            current=current.next;
        }

        if (previous==null) first=first.next;
        else previous.next=current.next;
        return current;
    }

    public void print(){
        System.out.println("lista");
        ListElem current=first;
        while (current!=null){
            System.out.print(current.toString()+" ");
            current=current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedLinkedList list=new SortedLinkedList();

        Random random=new Random();

        for (int i=0;i<10;i++){
            int liczba= random.nextInt(100);
            list.insert(liczba);
        }

        list.print();
    }

}
