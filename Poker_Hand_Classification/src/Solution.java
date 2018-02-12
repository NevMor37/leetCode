import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	// test case :2h, 3h, 4h, 5h, 6h
	public static void main(String args[]) throws Exception {
		// Take inputs
		Scanner scan = new Scanner(System.in);
		String tempS = scan.nextLine();
		// String tempS = "Ah, 6h, 2h, 9h, Th";
		// Eliminate white space
		tempS = tempS.replaceAll(" ", "");
		PokerHand obj = new PokerHand(tempS);
	}

}

class PokerHand {
	String[] handType = new String[] { "high card", "one pair", "two pairs", "three of a kind", "straight", "flush",
			"full house", "four of a kind", "straight flush" };
	int[] suits, values;

	public PokerHand(String hand) {
		suits = new int[4];
		values = new int[13];
		// Sparse the string
		String[] cards = hand.split(",");
		// Check duplicate cards
		HashMap<String, String> map = new HashMap<String, String>();
		for (String s : cards) {
			if (map.containsKey(s)) {
				System.out.println("invalid input");
				System.exit(0);
			}
			map.put(s, s);
		}
		// Put suits and values in the array
		loadCards(cards);
		// check the poker hands type
		evalHandType();
	}

	public void loadCards(String[] cards) {
		char tempSuit, tempValue;
		for (int i = 0; i < cards.length; i++) {
			tempSuit = cards[i].charAt(1);
			// System.out.println(tempSuit);
			switch (tempSuit) {
			case 's':
				suits[0]++;
				break;
			case 'h':
				suits[1]++;
				break;
			case 'c':
				suits[2]++;
				break;
			case 'd':
				suits[3]++;
				break;
			}
		}
		/*
		 * for(int i = 0; i<4; i++){ System.out.println(suits[i]); }
		 */
		for (int i = 0; i < cards.length; i++) {
			tempValue = cards[i].charAt(0);
			switch (tempValue) {
			case '2':
				values[0]++;
				break;
			case '3':
				values[1]++;
				break;
			case '4':
				values[2]++;
				break;
			case '5':
				values[3]++;
				break;
			case '6':
				values[4]++;
				break;
			case '7':
				values[5]++;
				break;
			case '8':
				values[6]++;
				break;
			case '9':
				values[7]++;
				break;
			case 'T':
				values[8]++;
				break;
			case 'J':
				values[9]++;
				break;
			case 'Q':
				values[10]++;
				break;
			case 'K':
				values[11]++;
				break;
			case 'A':
				values[12]++;
				break;
			}
		}
		/*
		 * for(int value : values){ System.out.println(value); }
		 */
	}

	public void evalHandType() {
		// check Flush
		boolean isFlush = false, isStraight = false;
		for (int suit : suits) {
			// System.out.println(suit);
			if (suit == 5) {
				isFlush = true;
				break;
			}
		}
		// check straight
		int check = 0;
		for (int value : values) {
			if (value == 1) {
				++check;
				if (check == 5) {
					isStraight = true;
					break;
				}
			} else {
				check = 0;
			}

		}
		if (isFlush == true && isStraight == true) {

			System.out.println(handType[8]);
			return;
		} else if (isFlush == true && isStraight != true) {

			System.out.println(handType[5]);
			return;
			// System.out.println(isFlush);
		} else if (isFlush != true && isStraight == true) {

			System.out.println(handType[4]);
			return;
		} // 先判断出三种类型 接着判断 HIGHCARD, ONEPAIR, TWOPAIRS, THREEOFAKIND, FULLHOUSE,
			// FOUROFAKIND
		else {
			int[] cardRepeats = new int[3];
			for (int value : values) {
				if (value == 4) {
					cardRepeats[2]++;
				}
				if (value == 3) {
					cardRepeats[1]++;
				}
				if (value == 2) {
					cardRepeats[0]++;
				}
			}
			if (cardRepeats[2] == 1) {

				System.out.println(handType[7]);
				return;
			} else if (cardRepeats[1] == 1) {
				if (cardRepeats[0] == 1) {

					System.out.println(handType[6]);
					return;
				} else {

					System.out.println(handType[3]);
					return;
				}
			} else if (cardRepeats[0] == 2) {

				System.out.println(handType[2]);
				return;
			} else if (cardRepeats[0] == 1) {

				System.out.println(handType[1]);
				return;
			} else {

				System.out.println(handType[0]);
				return;
			}
		}
	}

}
