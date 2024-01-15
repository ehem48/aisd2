package z3;

public class LinkedList {
    private ListElem first;

    public LinkedList() {
        first=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public ListElem getFirst(){
        return first;
    }

    public void insertFirst(int value){
        ListElem newElem=new ListElem(value);
        if (!isEmpty()) newElem.next=first;
        first=newElem;
    }

    public boolean find(int elem){
        if (isEmpty()) return false;
        ListElem current=first;
        while (current.iData!=elem){
            if (current.next==null) return false;
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
            if(current.next==null) return null;
            else previous=current;
            current=current.next;
        }

        if (previous==null) first=first.next;
        previous.next=current.next;
        return current;
    }

    public void print2(){
        System.out.println("Lista");
        ListElem elem=first;
        while (elem!=null){
            System.out.print(elem.toString()+" ");
            elem=elem.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);
        list.insertFirst(88);

        list.print2();

        int licza=44;
        boolean wynik= list.find(licza);
        if (wynik) System.out.println("Znaleziono");
        else System.out.println("nieznaleziono");

        ListElem dElem=list.delete(66);
        list.print2();

        list.deleteFirst();
        list.print2();

    }
}
