package dataStr;
import java.util.Arrays;

public class MyListMerge {
	

    private int[] elements;
    private int elementCounter = 0;
    private final int DEFAULT_ARRAY_SIZE = 6;
    private int arraySize = DEFAULT_ARRAY_SIZE;

    
    public MyListMerge()
    {
            elements = new int[arraySize];
    }
    //Izveidot konstruktoru, kas izveido masīvu elementu glabāšanai un skaitītāju, kas glabā informāciju par pievienoto elementu skaitu. Kā konstruktora parametrs tiek padots saraksta lielums;
    public MyListMerge(int myArraySize)
    {
            if(myArraySize>0 && myArraySize<=100)
                    arraySize = myArraySize;
            
            
            elements = new int[arraySize];
    }
    //Izveidot funkciju, kas pārbauda, vai saraksts nav jau pilns;
    public boolean isFull()
    {
            if(elementCounter==arraySize)
                    return true;
            else
                    return false;
            
            //return (elementCounter==arraySize)? true: false;
            //return (elementCounter==arraySize);
    }
    //Izveidot funkciju, kas pārbauda, vai saraksts ir tukšs;
    public boolean isEmpty()
    {
            return (elementCounter==0);
    }
    
    //Izveidot funkciju, kas atgriež, cik elementu ir ievietoti sarakstā;
    public int size()
    {
            return elementCounter;
    }
    //Izveidot funkciju, kura palielina izveido jaunu masīvu ar izmēru 2 reizes lielāku kā esošā masīva izmēru, pie nosacījuma - ja elementu skaits nav lielāks par 100, pretēja gadījumā izmēru palielina 1.5 reizes. Neaizmirstam pārkopēt visus elementus jaunizveidotajā masīvā;
    private void resize()
    {
            int newSizeOfArray = (elementCounter<=100)? (arraySize * 2) : (int) (arraySize*1.5);
            int[] newArray = new int[newSizeOfArray];
            
            for(int i = 0; i < elementCounter;i++ )
            {
                    newArray[i] = elements[i];
            }
            
            elements = newArray;
            arraySize = newSizeOfArray;
    }
    //Izveidot funkciju, kas veic elementu pievienošanu pēdējam saraksta elementam (veikt nepieciešamās pārbaudes);
    public void add(int newElement)
    {
            if(isFull())
                    resize();
            
            elements[elementCounter] = newElement;
            elementCounter++;
                            
    }
    
    //Izveidot funkciju, kas veic elementu pievienošanu pēc indeksa (veikt nepieciešamās pārbaudes);
    public boolean add(int index, int newElement)
    {
            if(index>=0 && index<=elementCounter)
            {
                    if(isFull())
                            resize();
                    
                    for(int i = elementCounter-1; i >=index ; i--)
                    {
                            elements[i+1] = elements[i];
                    }
                    
                    elements[index] = newElement;
                    elementCounter++;
                    
                    return true;
            }
            else
                    return false;
    }
    
    //Izveidot funkciju, kas veic elementa dzēšanu pēc indeksa (veikt nepieciešamās pārbaudes);
    public boolean remove(int index)
    {
            if(isEmpty())
                    return false;
            
            if(index>=0 && index<elementCounter)
            {
                    
                    for(int i = index; i < elementCounter; i++)
                    {
                            elements[i]= elements[i+1];
                    }
                    elementCounter--;
                    return true;
            }
            else
                    return false;
    }
    
    //Izveidot funkciju, kas veic elementa izgūšanu pēc indeksa (veikt nepieciešamās pārbaudes);
    public int get(int index) throws Exception 
    {
            if(isEmpty())
                    throw (new Exception("Nevar izgūt elementu, jo saraksts ir tukšs")); 
            
            if(index>=0 && index < elementCounter)
            {
                    return elements[index];
            }
            else
            {
                    
                    throw (new Exception("Nevar izgūt elementu, jo nav pareizs indeks")); 
            }
    }
    
    //Izveidot funkciju, kas veic elementa meklēšanu;
    public boolean search(int searchElement)
    {
            if(isEmpty())
                    return false;
            
            
            for(int i = 0; i < elementCounter;i++)
            {
                    if(elements[i] == searchElement)
                    {
                            return true;
                    }
            }
            return false;
    }
    
    //Izveidot funkciju, kas kā argumentu saņem elementu un atgriež nākamo elementu (veikt nepieciešamās pārbaudes);
    public int[] getNexts(int searchElement) throws Exception 
    {
            if(search(searchElement))
            {
                    int[] allNextElements = new int[elementCounter-1];
                    int nextArrayIndex = 0;
                    for(int i = 0; i < elementCounter-1;i++)
                    {
                            if(elements[i] == searchElement)
                            {
                                    allNextElements[nextArrayIndex] = elements[i+1];
                                    nextArrayIndex++;
                            }
                    }
                    return allNextElements;
            }
            else
            {
                    throw (new Exception("Padotais elements neatrodās sarakstā, tāpēc nevar atrast nākamo elementu"));
            }
    }
    
    //Izveidot funkciju, kas veic elementu kārtošanu;
   /* public void sort()
    {
            for(int i = 0; i < elementCounter; i++)
            {
                    for(int j = 0; j < elementCounter; j++)
                    {
                            if(elements[i] > elements[j])
                            {
                                    int temp = elements[i];
                                    elements[i] = elements[j];
                                    elements[j] = temp;
                            }
                    }
            }
    } */
    
    
  //рекурсивная функция сортировки частей массива
  	public static int[] sort(int[] arr){
  		if(arr.length < 2) return arr;
  		int m = arr.length / 2;
  		int[] arr1 = Arrays.copyOfRange(arr, 0, m);
  		int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
  		return merge(sort(arr1), sort(arr2));
  	}
  	//слияние двух массивов в один отсортированный
  	public static int[] merge(int[] arr1,int arr2[]){
  		int n = arr1.length + arr2.length;
  		int[] arr = new int[n];
  		int i1=0;
  		int i2=0;
  		for(int i=0;i<n;i++){
  			if(i1 == arr1.length){
  				arr[i] = arr2[i2++];				
  			}else if(i2 == arr2.length){
  				arr[i] = arr1[i1++];
  			}else{
  				if(arr1[i1] < arr2[i2]){
  					arr[i] = arr1[i1++];
  				}else{
  					arr[i] = arr2[i2++];
  				}
  			}
  		}
  		return arr;
  	}	
	
  	
  	
    //Izveidot funkciju, kas veic saraksta izvadi;
    public String toString()
    {
            String res = "";
            for(int i = 0; i < elementCounter; i++)
            {
                    res+=elements[i]+ ",";
            }
            return res;
    }
    
    //Izveidot funkciju, kas veic saraksta iztukšošanu;
    public void makeEmpty()
    {
            elementCounter = 0;
    }
    
    
    

}
