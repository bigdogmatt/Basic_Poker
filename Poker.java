import java.util.Scanner;

public class Poker {

	public static String getName( int card ) 
	{
		String suit;
		String rank;
		int rankNum = (card % 13) + 1;
		int suitNum = (card / 13) + 1;
		
		if(suitNum == 1) 
		{
			suit = "Spades";
		}
		else if(suitNum == 2) 
		{
			suit = "Hearts";
		}
		else if(suitNum == 3) 
		{
			suit = "Diamonds";	
		}
		else 
		{
			suit = "Clubs";
		}
		
		
		if(rankNum == 1) 
		{
			rank = "Ace";
		}
		else if(rankNum == 11) 
		{
			rank = "Jack";
		}
		else if(rankNum == 12) 
		{
			rank = "Queen";
		}
		else if(rankNum == 13) 
		{
			rank = "King";
		}
		else
		{
			rank = ""+rankNum;
		}
		
		return(rank + " of " + suit);
		

	}

	public static boolean three( int card1, int card2, int card3 ) 
	{
		int rankNum1 = (card1 % 13) + 1;
		int rankNum2 = (card2 % 13) + 1;
		int rankNum3 = (card3 % 13) + 1;
		
		if(rankNum1 == rankNum2 && rankNum1 == rankNum3)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}


	public static boolean two( int card1, int card2, int card3 ) 
	{
		int rankNum1 = (card1 % 13) + 1;
		int rankNum2 = (card2 % 13) + 1;
		int rankNum3 = (card3 % 13) + 1;
		
		if(rankNum1 == rankNum2 || rankNum1 == rankNum3 || rankNum2 == rankNum3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean flush( int card1, int card2, int card3 ) 
	{
		int suitNum1 = (card1 / 13) + 1;
		int suitNum2 = (card2 / 13) + 1;
		int suitNum3 = (card3 / 13) + 1;
		
		if(suitNum1 == suitNum2 && suitNum1 == suitNum3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public static void main(String[] args) 
	{
		int[] cards = new int[3];

		cards[0] = (int)(Math.random() * 52);

		do 
		{
			cards[1] = (int)(Math.random() * 52);
		} while( cards[1] == cards[0] );

		do 
		{
			cards[2] = (int)(Math.random() * 52);
		} while( cards[2] == cards[1] || cards[2] == cards[0] );		

		System.out.println("Your three cards are:");
		for( int i = 0; i < cards.length; ++i )
			System.out.println( getName( cards[i] ) );

		if( three( cards[0], cards[1], cards[2] ) )
			System.out.println("Three of a kind!");
		else if( flush( cards[0], cards[1], cards[2] ) )
			System.out.println("Flush!");
		else if( two( cards[0], cards[1], cards[2] ) )
			System.out.println("Pair!");
		else
			System.out.println("High card!");
		
	}	
}