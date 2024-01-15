package z1;

public class DynArrayDouble {
    private Double [] table;
    private  int nElems;

    public DynArrayDouble(int maxSize) {
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
        table[nElems]=value;
        nElems++;
    }

    public Double get(int index){
        return table[index];
    }

    public int size(){
        return nElems;
    }

    public boolean remove(int index){
        if (nElems==0 || index>=nElems || index<0)
            return false;
        for (int i=index;i<nElems-1;i++){
            table[i]=table[i+1];
        }
        nElems--;
        return true;
    }

    public int find(Double searchElem){
        for (int j=0;j<nElems;j++){
            if (table[j].doubleValue()==searchElem.doubleValue()) {
                return j;
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
        DynArrayDouble array=new DynArrayDouble(maxSize);

        array.add(Double.valueOf(22));
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
