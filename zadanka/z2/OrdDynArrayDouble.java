package z2;

public class OrdDynArrayDouble {
    private Double [] table;
    private int nElems;

    public OrdDynArrayDouble(int maxSize) {
        table=new Double[maxSize];
        nElems=0;
    }

    public void add(Double value){
        if (nElems>=table.length){
            Double [] locTable=new Double[table.length*2];
            for (int i=0;i<table.length;i++)
                locTable[i]=table[i];
            locTable=table;
        }

        int j;
        for (j=0;j<nElems;j++){
            if (table[j].compareTo(value)>0)
                break;
        }

        for (int k=nElems;k>j;k--){
            table[k]=table[k-1];
        }

        table[j]=value;
        nElems++;
    }

    public Double get(int index){
        return table[index];
    }

    public int size(){
        return  nElems;
    }

    public boolean remove(int index){
        if (nElems==0 || index>=nElems || index<0) return false;

        for (int i=0; i<nElems;i++){
            table[i]=table[i+1];
        }
        nElems--;
        return true;
    }

    public int find(Double index){
        for (int i=0;i<nElems;i++){
            if (table[i].doubleValue()==index.doubleValue()){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for (int i=0;i<nElems;i++){
            System.out.print(table[i].doubleValue()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize=5;
        OrdDynArrayDouble array=new OrdDynArrayDouble(maxSize);

        array.add(Double.valueOf(123));
        array.add(Double.valueOf(123.432));
        array.add(Double.valueOf(123.321));
        array.print();

        array.remove(1);
        array.print();

        array.add(Double.valueOf(555.55));
        array.print();
        System.out.println(array.find(Double.valueOf(555.55)));
    }
}
