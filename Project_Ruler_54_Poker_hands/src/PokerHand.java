
public class PokerHand {
	enum SUIT {
		SPADE, HEART, CLUB, DIAMOND
	}

	enum VALUE {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	enum HANDTYPE {
		HIGHCARD, ONEPAIR, TWOPAIRS, THREEOFAKIND, STRAIGHT, FLUSH, FULLHOUSE, FOUROFAKIND, STRAIGHTFLUSH
	}

	int[] suits, values;
	HANDTYPE handtype;
	int[] cardSortedFrequency;

	public PokerHand(String hand) {
		suits = new int[4];
		values = new int[13];
		cardSortedFrequency = new int[5];
		String[] cards = hand.split(" ");
		loadCards(cards);		
		evalHandType();
	}

	public void loadCards(String[] cards) {
		char tempSuit, tempValue;
		for (int i = 0; i < cards.length; i++) {
			tempSuit = cards[i].charAt(1);
			switch (tempSuit) {
			case 'S':
				suits[SUIT.SPADE.ordinal()]++;
				break;
			case 'H':
				suits[SUIT.HEART.ordinal()]++;
			case 'C':
				suits[SUIT.CLUB.ordinal()]++;
			case 'D':
				suits[SUIT.DIAMOND.ordinal()]++;
			}
		}
		for (int i = 0; i < cards.length; i++) {
			tempValue = cards[i].charAt(0);
			switch (tempValue) {
			case '2':
				values[VALUE.TWO.ordinal()]++;
				break;
			case '3':
				values[VALUE.THREE.ordinal()]++;
				break;
			case '4':
				values[VALUE.FOUR.ordinal()]++;
				break;
			case '5':
				values[VALUE.FIVE.ordinal()]++;
				break;
			case '6':
				values[VALUE.SIX.ordinal()]++;
				break;
			case '7':
				values[VALUE.SEVEN.ordinal()]++;
				break;
			case '8':
				values[VALUE.EIGHT.ordinal()]++;
				break;
			case '9':
				values[VALUE.NINE.ordinal()]++;
				break;
			case 'T':
				values[VALUE.TEN.ordinal()]++;
				break;
			case 'J':
				values[VALUE.JACK.ordinal()]++;
				break;
			case 'Q':
				values[VALUE.QUEEN.ordinal()]++;
				break;
			case 'K':
				values[VALUE.KING.ordinal()]++;
				break;
			case 'A':
				values[VALUE.ACE.ordinal()]++;
				break;
			}
		}
	}

	public void evalHandType() {
		// check Flush
		boolean isFlush = false, isStraight = false;
		for (int suit : suits) {
			if (suit == 5) {
				isFlush = true;
				break;
			}
		}
		// check straight
		int check = 0;
		for (int value : values) {
			if (value == 1) {
				check++;
				if (check == 5) {
					isStraight = true;
					break;
				}
			}
			check = 0;
		}
		if (isFlush == true && isStraight == true) {
			handtype = HANDTYPE.STRAIGHTFLUSH;
		} else if (isFlush == true && isStraight != true) {
			handtype = HANDTYPE.FLUSH;
		} else if (isFlush != true && isStraight == true) {
			handtype = HANDTYPE.STRAIGHT;
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
				handtype = HANDTYPE.FOUROFAKIND;
			} else if (cardRepeats[1] == 1) {
				if (cardRepeats[0] == 1) {
					handtype = HANDTYPE.FULLHOUSE;
				} else {
					handtype = HANDTYPE.THREEOFAKIND;
				}
			} else if (cardRepeats[0] == 2) {
				handtype = HANDTYPE.TWOPAIRS;
			} else if (cardRepeats[0] == 1) {
				handtype = HANDTYPE.ONEPAIR;
			} else {
				handtype = HANDTYPE.HIGHCARD;
			}
		}
		cardFrequency();
	}

	// 改变卡牌在数组中的存储方式，简化， 大牌且频率高的牌在数组前面
	public void cardFrequency() {
		int count = 0;
		for (int i = 12; i >= 0; i--) {
			if (values[i] == 4) {
				cardSortedFrequency[count] = i;
				count++;
			}
		}
		for (int i = 12; i >= 0; i--) {
			if (values[i] == 3) {
				cardSortedFrequency[count] = i;
				count++;
			}
		}
		for (int i = 12; i >= 0; i--) {
			if (values[i] == 2) {
				cardSortedFrequency[count] = i;
				count++;
			}
		}
		for (int i = 12; i >= 0; i--) {
			if (values[i] == 1) {
				cardSortedFrequency[count] = i;
				count++;
			}
		}
	}

	public HANDTYPE getHandType() {
		return handtype;
	}

	public int[] cardComparable() {
		return cardSortedFrequency;
	}

	public int compareTo(PokerHand hand) {
		if (this.handtype.ordinal() == hand.getHandType().ordinal()) {
			int[] otherHand = hand.cardComparable();
			for (int i = 0, len = otherHand.length; i < len; ++i) {
				if (cardSortedFrequency[i] > otherHand[i]) {
					return 1;
				} else if (cardSortedFrequency[i] < otherHand[i]) {
					return -1;
				}
			}
			return 0;
		} else {
			return this.handtype.ordinal() > hand.getHandType().ordinal() ? 1 : -1;
		}
	}

}
