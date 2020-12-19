package com.company;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
	int[] numArray = {1, 1, 2, 3, 1, 2, 5, 9, 12, 13, 55, 121, 0, 1};
	char[] charArray = {'a', 'b', 'b', 'c', 'a', 's', 't', 'g', 'f', 'q'};
	int[] numArray2 = {2,1};
	int[] numArray22 = {2,1};

		System.out.println("Order The Following : " + Arrays.toString(numArray));
		System.out.println("Order The Following : " + Arrays.toString(charArray));
		System.out.println("Order The Following : " + Arrays.toString(numArray2));

		System.out.println("\n______________________________________________________\n");
        System.out.print(Arrays.toString(numArray));
        System.out.println("\nTo order the first structure I will use: Collection Sort\n" +
                "From library: Java 8\n" +
                "Why: Time complexity is okay and it takes only a few lines of code " +
                "for the int array to be sorted.\n It is very simple to use, but the time " +
                "complexity may be slower than other methods. \n"+
                "____________________________________________________________________");


        System.out.print(Arrays.toString(charArray));
        System.out.println("\nTo order the second structure I will use:TreeSet\n" +
                "From library: SortedSet in Java Platform SE 7\n" +
                "Why: It is not faster than HashSet but it helps apply the natural order" +
                "of the elements. TreeSet is\n useful in that it orders the elements" +
                "automatically, and can even rid of duplicates. In terms of\n adding " +
                "elements, TreeSet is much better than HashSet\n"+
                "____________________________________________________________________");



        System.out.print(Arrays.toString(numArray2));
        System.out.println("\nTo order the third structure I will use: Insertion Sort\n" +
                "From library: N/A. Just using an algorithm\n"+
                "Why: The most efficient and fastest way too order this would not use a " +
                "separate library but to swap\n the two numbers as it takes less time" +
                "and memory to do the action. The time complexity would be quite short.\nWe can also " +
                "use the Insertion Sort algorithm because it is recommended for arrays with " +
                "fewer elements\n"+
                "____________________________________________________________________");


        Collection<String> characterList =
                new TreeSet<String>(Collator.getInstance());
        characterList.add("a");
        characterList.add("b");
        characterList.add("b");
        characterList.add("c");
        characterList.add("a");
        characterList.add("s");
        characterList.add("t");
        characterList.add("g");
        characterList.add("f");
        characterList.add("q");



		Arrays.sort(numArray);
		Arrays.sort(charArray);
		Arrays.sort(numArray22);
		insertionSort(numArray2);

		/////
		System.out.println("\n\nOrdered Array using Collection Sort from Java 8: \n" + Arrays.toString(numArray)+
                "\n________________________________________________________");
		System.out.println("Ordered Array using Sorting Map by Values from HashMap of Java SE 7 with no duplicates: \n" + characterList);

                System.out.println("Ordered Array using Collection Sort from Java 8 with duplicates: \n" + Arrays.toString(charArray)+
                "\n________________________________________________________");

         //////
        System.out.println("Ordered Array using Insertion Sort from Java 8: \n" + Arrays.toString(numArray22));
		System.out.println("Ordered Array using Collection Sort from Java 8: \n" + Arrays.toString(numArray2)+
                "\n________________________________________________________");


    }

    public static void swap(final int[] arr, final int pos1, final int pos2){
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }



}

