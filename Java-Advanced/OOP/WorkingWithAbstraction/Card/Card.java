package OOP.WorkingWithAbstraction.Card;

public class Card {

    private CardSuits cardSuits;
    private CardRank cardRank;

    public Card(CardSuits cardSuits, CardRank cardRank) {
        this.cardSuits = cardSuits;
        this.cardRank = cardRank;
    }

    public void getPower(){

        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                cardRank,
                cardSuits,
                this.cardSuits.getSuitPower() + this.cardRank.getRankPower()));

    }

}
