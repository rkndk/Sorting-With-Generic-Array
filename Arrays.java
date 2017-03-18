@SuppressWarnings("unchecked")
public class Arrays<T extends Comparable> {
    //instace variables - replace the example below with your own
    private T[] a; //ref to array a
    private int nElems; //number of data items

    //constructor for objects of class Data
    public Arrays(int max){
        //initialize instance variables
        a = (T[])(new Comparable[max]); // create the array
        nElems = 0; //no items yet
    }

    //mengembalikan jumlah data yang ada dalam array
    public int size(){
        return nElems;
    }

    //menampilkan semua data dalam array
    public void display(){
		for(int i=0; i<nElems; i++){
			System.out.println(a[i]);
		}
    }

    //sequential seraching. Mencari data dengan mencari data satu per satu
    public int sequentSearch(T searchKey){
        int n = nElems;
        int i = 0;

        while(i < n){            
            if((a[i].compareTo(searchKey))>0){
                return i;
            }
            i++;
        }

        return n;
    }

    public void insert(T value){
        a[nElems] = value;
        nElems++;
    }
    
    public void delete(T value){
        int posisiIndeks = this.sequentSearch(value);

        if(posisiIndeks == nElems){
            System.out.println("Posisi data yang dihapus tidak ditemukan");
        }
        else{
            //hapus data dengan menurun semua data
            for(int i = posisiIndeks; i<nElems; i++){
                a[i] = a[i+1];
                nElems--;
            }
        }
    }

    public void bubbleSort(){
        int out,in;

        for(out=nElems-1; out>1; out--) // outer loop (backward)
            for(in=0; in<out; in++) // inner loop (forward)
                if( (a[in].compareTo(a[in+1])) > 0 ) // out of order?
                    swap(in, in+1); // swap them
    } // end bubbleSort()
    
    private void swap(int one, int two)
    {
        T temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
