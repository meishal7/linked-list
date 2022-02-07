/** 
* TITLE: LinkedListDemo.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 
* PROJECT: Lab 15
* LAST MODIFIED: 11/19/2020
* DESCRIPTION: the program invokes methods from LinkedList.java
*
* ALGORITHM:
* 
*/
public class LinkedListDemo {
    public static <T> void main(String[] args) {
        
        LinkedList<String> list = new LinkedList<>();
        
        System.out.println("The list using addToStart(E data) method");
        
        list.addToStart("Beef Taco");
        list.addToStart("California Burrito");
        
        System.out.println("\n"+list.toString());

        System.out.println("\nThe list using addToEnd(E element) method");
        list.addToEnd("Cheese Cesadilia");
        System.out.println("\n" + list.toString());

        System.out.println("\nThe list using add(int index, E element) method. Adding two elements to index 0");
        
        list.add(0, "Chicken Taco");
        list.add(0, "Fish Taco");
        
        System.out.println("\n"+list.toString());

        // System.out.println("\nThe list using add(E element) method");
        // list.add("Chips");
        // System.out.println(list.toString());

        System.out.println("\nSetting item at index #1 to \"Gucomole\"");
        list.set(1, "Guacomole");
        System.out.println("\n"+list.toString());

        System.out.println("\nRemoving\"Gucomole\" from the list: ");
        list.remove("Guacomole");
        System.out.println("\n"+list.toString());

        System.out.println("\nRemoving item at index 1 from the list: ");
        list.remove(1);
        System.out.println("\n"+list.toString());

        System.out.println("\nClearing the list: ");
        list.clear();
        System.out.println("\n"+list.toString());

    
    }
    
}
