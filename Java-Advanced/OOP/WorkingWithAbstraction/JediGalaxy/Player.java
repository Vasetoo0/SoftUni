package OOP.WorkingWithAbstraction.JediGalaxy;

public class Player {

    private long starSum = 0;

    public void collectStars(Galactic galactic, int ivoRow, int ivoCol) {

        while (ivoRow >= 0 && ivoCol < galactic.getGalactic()[1].length) {
            if (ivoRow < galactic.getGalactic().length && ivoCol >= 0 && ivoCol < galactic.getGalactic()[0].length) {
                this.starSum += galactic.getGalactic()[ivoRow][ivoCol];
            }

            ivoCol++;
            ivoRow--;
        }
    }

    public long getStarSum() {
        return starSum;
    }
}
