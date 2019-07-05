package OOP.WorkingWithAbstraction.JediGalaxy;

public class Galactic {


    private int row;
    private int col;
    private int[][] galactic;

    public Galactic(int row,int col) {
        this.row = row;
        this.col = col;
        this.galactic = new int[row][col];
        fillGalactic();

    }
    private void fillGalactic() {
        int value = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.galactic[i][j] = value++;
            }
        }
    }

    public int[][] getGalactic() {
        return galactic;
    }

    public void moveEvil(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < this.galactic.length && evilCol < this.galactic[0].length) {
                this.galactic[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
}
