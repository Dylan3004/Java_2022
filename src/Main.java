import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer>tablica = new ArrayList<>();
        ArrayList<Integer> tablica1;
        ArrayList<Integer> tablica2;
        ArrayList<Integer>tablica3;
        ArrayList<Integer>tablica4;
        ArrayList<Integer>tablica5;
        int rozmiar = 5000;
        System.out.println(" Tablica");
        for(int i = 0;i<rozmiar;i++) {
            Random random = new Random();
            int a = random.nextInt(rozmiar);
            tablica.add(a);
            System.out.print(" "+tablica.get(i));
        }
        tablica1= (ArrayList<Integer>) tablica.clone();
        tablica2= (ArrayList<Integer>) tablica.clone();
        tablica3= (ArrayList<Integer>) tablica.clone();
        tablica4= (ArrayList<Integer>) tablica.clone();
        tablica5= (ArrayList<Integer>) tablica.clone();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("QuickSort :");
        long start =System.currentTimeMillis();
        Quicksort(tablica3,0, tablica.size()-1);
        long end= System.currentTimeMillis();
        for (Integer integer : tablica3) {
            //System.out.print(" " +integer) ;
        }
        System.out.println(" ");
        System.out.println("This function takes"+(start-end)+"ms");
        System.out.println("Bubble Sort :");
        long start1 =System.currentTimeMillis();
        BubbleSort(tablica);
        long end1= System.currentTimeMillis();
        for (Integer integer : tablica) {
            //System.out.print(" " +integer) ;
        }
        System.out.println(" ");
        System.out.println("This function takes"+(start1-end1)+"ms");
        System.out.println("InsertSort :");
        long start2 =System.currentTimeMillis();
        InsertSort(tablica1);
        long end2= System.currentTimeMillis();
        for (Integer integer : tablica1) {
            //System.out.print(" " +integer) ;
        }

        System.out.println(" ");
        System.out.println("This function takes"+(start2-end2)+"ms");
        System.out.println("SelectionSort :");
        long start3 =System.currentTimeMillis();
        SelectionSort(tablica2);
        long end3= System.currentTimeMillis();
        for (Integer integer : tablica2) {
            //System.out.print(" " +integer) ;
        }
        System.out.println(" ");
        System.out.println("This function takes"+(start3-end3)+"ms");
        System.out.println("MeargeSort:");
        long start4 =System.currentTimeMillis();
        Mergeort(tablica4);
        long end4= System.currentTimeMillis();
        for (Integer integer : tablica4) {
            //System.out.print(" " +integer) ;
        }
        System.out.println();
        System.out.println("This function takes"+(start4-end4)+"ms");
        System.out.println("HeapSort:");
        long start5 = System.currentTimeMillis();
        HeapSort(tablica5);
        long end5 = System.currentTimeMillis();
        for (Integer integer : tablica5) {
            //System.out.print(" " +integer) ;
        }
        System.out.println();
        System.out.println("This function takes"+(start5-end5)+"ms");

    }
    static int  BeginSort(ArrayList<Integer>tablica,int poczatek,int koniec)
    {
        Integer pivot = tablica.get(koniec);
        while (poczatek<koniec)
        {

            while(tablica.get(poczatek)<=pivot && poczatek<koniec)
            {
                poczatek++;

            }
            while (tablica.get(koniec)>pivot && poczatek<koniec)
            {

                koniec--;
            }
            Collections.swap(tablica,poczatek,koniec);
        }
        return poczatek;
    }
    static void Quicksort(ArrayList<Integer> tablica, int poczatek, int koniec)
    {
        if(poczatek<koniec)
        {

            int c = BeginSort(tablica,poczatek,koniec);
            Quicksort(tablica,poczatek,c-1);
            Quicksort(tablica,c,koniec);

        }

    }
    static void BubbleSort(ArrayList<Integer> tablica)
    {
        for(int j =0;j<tablica.size()-1;j++)
            for(int i = 0;i<tablica.size()-1-j;i++)
            {
                if(tablica.get(i)>tablica.get(i+1))
                {
                    Collections.swap(tablica,i,i+1);
                }
            }
    }
    static void InsertSort(ArrayList<Integer> tablica)
    {
        for(int i =1;i< tablica.size();i++)
        {
            int z = tablica.get(i);
            int j = i;
            while(j>0 && tablica.get(j-1) > z)
            {
                tablica.set(j,tablica.get(j-1));
                j=j-1;
            }
            tablica.set(j,z);
        }

    }
    static void SelectionSort(ArrayList<Integer>tablica)
    {
        for(int i = 0;i<tablica.size()-1;i++)
        {
            int indeks = i;
            for(int j= i;j<tablica.size()-1;j++)
            {
                if(tablica.get(j)<tablica.get(indeks))
                {
                    indeks=j;
                }
            }
            Collections.swap(tablica,indeks,i);


        }
    }
    static void Mergeort(ArrayList<Integer>tablica)
    {
        if(tablica.size()==1)
        {
            return;
        }
        ArrayList<Integer> firsthalf = new ArrayList<>();
        ArrayList<Integer> secondhalf = new ArrayList<>();
        int mid = tablica.size()/2;
        for(int i =0;i<mid;i++)
        {
            firsthalf.add(tablica.get(i));
        }
        for(int j =0;j< tablica.size()-mid;j++)
        {
            secondhalf.add(tablica.get(j+mid));
        }
        Mergeort(firsthalf);
        Mergeort(secondhalf);

        welder(tablica,firsthalf,secondhalf);
    }
    static void welder(ArrayList<Integer>tablica,ArrayList<Integer>firsthalf,ArrayList<Integer>secondhalf)
    {
        //int size1 = firsthalf.size();
        //int size2 = secondhalf.size();
        int i=0 ,j=0, k=0 ;
        while (i< firsthalf.size() && j< secondhalf.size())
        {
            if(firsthalf.get(i) <= secondhalf.get(j))
            {
                tablica.set(k,firsthalf.get(i));
                i++;
            }
            else
            {
                tablica.set(k,secondhalf.get(j));
                j++;
            }
            k++;
        }
        while (i<firsthalf.size())
        {
            tablica.set(k,firsthalf.get(i));
            i++;
            k++;
        }
        while (j<secondhalf.size())
        {
            tablica.set(k,secondhalf.get(j));
            j++;
            k++;
        }
    }
    static void Heap(ArrayList<Integer>tablica,int rozmiar,int iterator)
    {
        int naj = iterator;
        int leftson = iterator *2+1;
        int rightson = iterator *2+2;

        if(rightson<rozmiar && tablica.get(rightson)>tablica.get(naj))
        {
            naj=rightson;
        }
        if(leftson<rozmiar && tablica.get(leftson)> tablica.get(naj))
        {
            naj=leftson;
        }
        if(naj!=iterator)
        {
            Collections.swap(tablica,iterator,naj);
            Heap(tablica,rozmiar,naj);
        }

    }
    static void HeapSort(ArrayList<Integer>tablica)
    {
        int n = tablica.size();
        int koniec = tablica.size()-1;
        int level = n/2-1;
        for(int i =level;i>0;i--)
        {
            Heap(tablica,n,i);
        }
        for(int i =koniec;i>0;i--)
        {
            Collections.swap(tablica,i,0);
            Heap(tablica,i,0);
        }

    }


}
