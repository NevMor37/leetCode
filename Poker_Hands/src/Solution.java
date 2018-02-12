import java.util.*;

import PokerHand.VALUE;

import java.io.*;
/*
 * SPADE, HEART, CLUB, DIAMOND
 * TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
 * HIGHCARD, ONEPAIR, TWOPAIRS, THREEOFAKIND, STRAIGHT, FLUSH, FULLHOUSE, FOUROFAKIND, STRAIGHTFLUSH
*/
public class Solution {
	  public void pokerHands(String p1, String p2){
		    int[] suits1 = new int[5];
		    int [] suits2 = new int[5];
		    int [] values1 = new int[13];
		    int [] values2 = new int[13];
		    int [] cardsFormat1 = new int[13];
		    int [] cardsFormat2 = new int[13];
		    
		    String [] cards1 = p1.split(" ");
		    String [] cards2 = p2.split(" ");
		    
		    for(int i=0;i<cards1.length;i++){
		    	 switch(cards1[i].charAt(0)){
		    	 case '2':
						values1[0]++;
						break;
					case '3':
						values1[1]++;
						break;
					case '4':
						values1[2]++;
						break;
					case '5':
						values1[3]++;
						break;
					case '6':
						values1[4]++;
						break;
					case '7':
						values1[5]++;
						break;
					case '8':
						values1[6]++;
						break;
					case '9':
						values1[7]++;
						break;
					case 'T':
						values1[8]++;
						break;
					case 'J':
						values1[9]++;
						break;
					case 'Q':
						values1[10]++;
						break;
					case 'K':
						values1[11]++;
						break;
					case 'A':
						values1[12]++;
						break;
		    	 }
		    }
		    
		    for(int i=0;i<cards2.length;i++){
		    	 switch(cards2[i].charAt(0)){
		    	 case '2':
						values2[0]++;
						break;
					case '3':
						values2[1]++;
						break;
					case '4':
						values2[2]++;
						break;
					case '5':
						values2[3]++;
						break;
					case '6':
						values2[4]++;
						break;
					case '7':
						values2[5]++;
						break;
					case '8':
						values2[6]++;
						break;
					case '9':
						values2[7]++;
						break;
					case 'T':
						values2[8]++;
						break;
					case 'J':
						values2[9]++;
						break;
					case 'Q':
						values2[10]++;
						break;
					case 'K':
						values2[11]++;
						break;
					case 'A':
						values2
						[12]++;
						break;
		    	 }
		    }
	  }
      public static void main(String [] args){
    	    Scanner scan = new Scanner(System.in);
    	    int n = scan.nextInt();
    	    scan.nextLine();
    	    String tempS = "",
    	    	   temp1 = "",
    	    	   temp2 = "";
    	    Solution obj = new Solution();
    	    for(int i=0;i<n;i++){
    	    	tempS = scan.nextLine();
    	    	temp1 = tempS.substring(0,14);
    	    	temp2 = tempS.substring(15);
    	    	obj.pokerHands(temp1, temp2);
    	    }
      }
}
