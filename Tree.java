
/**
 * Write a description of class Tree here.
 * 
 * @author (James Hamm 5.6) 
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.*;               // for Stack class


public class Tree implements Comparable<Tree>
   {
   public Node root;             // first node of tree
   public int frequency=0;


   public Tree()                  // constructor
      {   root = null; }            // no nodes in tree yet


  //the PriorityQueue needs to be able to somehow rank the objects in it
  //thus, the objects in the PriorityQueue must implement an interface called Comparable
  //the interface requires you to write a compareTo() method so here it is:

   public int compareTo(Tree object){ //
       if(frequency-object.frequency>0){ //compare the cumulative frequencies of the tree
           return 1;
        }else if(frequency-object.frequency<0){
           return -1;   //return 1 or -1 depending on whether these frequencies are bigger or smaller
        }else{
            return 0;   //return 0 if they're the same
        }
   }
    
   // -------------------------------------------------------------

   String path=""; //this variable will track the path to the letter we're looking for 
   int counter=0; //initialise a counte to con the number of bits used in the code
  public int getCode(char letter, Node localRoot, String path)
  {
      
      if(localRoot!=null)
      {
        if(localRoot.letter==letter)
        {
            counter=path.length();
            System.out.print(path + " ");
            
        }
        
        else
        {
          getCode(letter,localRoot.leftChild,path+"0");
          getCode(letter,localRoot.rightChild,path+"1");
        }
      }
      return counter;
  }
     
}  // end class Tree