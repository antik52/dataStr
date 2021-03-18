package service;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Arrays;

import dataStr.MyListMerge;


public class MainServiceMerge {

        public static void main(String[] args) {
                MyListMerge listOfInts = new MyListMerge(3);
                listOfInts.add(1); // 1
                listOfInts.add(2); // 1, 2
                listOfInts.add(1, 100); //1, 100, 2
                System.out.println(listOfInts);
                listOfInts.add(0, 84);//84, 1, 100, 2
                System.out.println(listOfInts);
                try {
                        System.out.println(listOfInts.get(0));
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                listOfInts.add(37); //84, 1, 100, 2, 5
                listOfInts.add(2); //84, 1, 100, 2, 5, 2
                listOfInts.add(8); //84, 1, 100, 2, 5, 2, 8
                System.out.println("Vai ir 2:"+listOfInts.search(2));
                try {
                        System.out.println(Arrays.toString(listOfInts.getNexts(2)));
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                System.out.println("vai var izdzēst 1:" + listOfInts.remove(1));
                        
                System.out.println(listOfInts);

                listOfInts.sortMerge();
                System.out.println(listOfInts);
                
                listOfInts.makeEmpty();
                System.out.println("???"+listOfInts);
                
               
                /*
                System.out.println("---------------2. int saraksts-------------------");
                try {
                	MyList listOfInts2 = addElementsFromFile("resources/numbers.txt");
                	System.out.println(listOfInts2);
                	listOfInts2.sort();
                	System.out.println(listOfInts2);
                } catch (Exception e) {
                	e.printStackTrace();
                }
                
                System.out.println("----------------Students Saraksts----------------");
          MyTemplateList<Student> studentList = new MyTemplateList<>();
          studentList.add(new Student("Janis", "Berzins", new int[] {10,5,8}));
          studentList.add(new Student("Peteris", "Ciemins", new int[] {10,8,9}));
          studentList.add(new Student("Baiba", "Roze", new int[] {1,4,9}));
          studentList.add(new Student("Liga", "Jauka", new int[] {6,5,3}));
          System.out.println(studentList);
          System.out.println();
          studentList.sort();
          System.out.println(studentList);
          System.out.println();
          studentList.remove(1);
          System.out.println(studentList);
          System.out.println();
          
         
                
        }
        
        public static MyList addElementsFromFile(String filename) throws Exception
        {
        	MyList myList = new MyList();
        	FileInputStream fileStream = new FileInputStream(filename);
        	DataInputStream inStream = new DataInputStream(fileStream);
        	while(inStream.available()>0) 
        	{
        		String res = inStream.readLine();
        		int resInt = Integer.parseInt(res);
        		myList.add(resInt);
        		
        	}
        	return myList;
        } */

 }
}