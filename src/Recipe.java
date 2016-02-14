import java.util.ArrayList;

/**
 * Created by User on 11/02/16.
 */
public class Recipe {

    private int count = 0;
    private ArrayList<int[][]> recipes = new ArrayList<int[][]>();
    private int[][] grid;
    private String total = "End Test";
    private int[][] bonus;
    private int[][] bonusAdd;


    public Recipe(int[][] grid) {
        setRecipe();
        this.grid = grid;
        bonus = new int[grid.length][grid[0].length];
        bonusAdd = new int[grid.length][grid[0].length];

    }

    public void setRecipe() {
        int[][] recipe0 = {{1, 0},
                {1, 0}};
        int[][] recipe1 = {{1, 1},
                {0, 0}};
        int[][] recipe2 = {{1, 2},
                {3, 0}};
        int[][] recipe3 = {{2, 1},
                {0, 3}};
        int[][] recipe4 = {{0, 2},
                {2, 3}};
        int[][] recipe5 = {{3, 1},
                {0, 0}};
        int[][] recipe6 = {{1, 0, 0, 0},
                {0, 3, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},};
        int[][] recipe7 = {{0, 0, 0, 2},
                {0, 0, 2, 0},
                {0, 2, 0, 0},
                {2, 0, 0, 0},};
        int[][] recipe8 = {{4, 3},
                {2, 0}};
        int[][] recipe9 = {{1, 2},
                {0, 3}};
        int[][] recipe10 = {{1, 4},
                {0, 2},
                {4, 0},
                {2, 2}};
        recipes.add(recipe0);
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);
        recipes.add(recipe5);
        recipes.add(recipe6);
        recipes.add(recipe7);
        recipes.add(recipe8);
        recipes.add(recipe9);
        recipes.add(recipe10);
    }

    public int[][] getRecipe(int index) {
        return recipes.get(index);
    }

    public void useGems2() {
        for (int i = 0; i < grid.length; i++) { //row i
            for (int j = 0; j < grid[0].length; j++) { //column j
                if (grid[i][j] != 0) { // change from null to 0
                    //iterate through all known grid recipe
                    for (int z = 0; z < recipes.size(); z++) {
                        for (int w = 0; w < recipes.get(z)[0].length; w++) { // iterate through the first row of a recipe
                            if (recipes.get(z)[0][w] != 0) {
                                if (grid[i][j] == recipes.get(z)[0][w]) { //check if the first row's non-null value matches with the grid
                                    //start to specifically check one recipe
                                    compareRecipe(z, i, j, w);
                                    break;
                                } else {
                                    break;
                                }
                            }//end checking for one specific recipe
                        }
                    }
                }
            }
        }

        for (int a = 0; a < bonus.length; a++) {
            for (int b = 0; b < bonus[0].length; b++) {
                System.out.print(bonus[a][b]);
            }
            System.out.println("");
        }
    }

    public void compareRecipe(int z, int i, int j, int w) {
        int[][] check = recipes.get(z); // param @check just to shorten the path
        boolean match = true;
        for (int a = 0; a < bonus.length; a++) {
            for (int b = 0; b < bonus[0].length; b++) {
                bonusAdd[a][b] = 0;
            }
        }
        checkMatch:
        {
            for (int a = 0; a < check.length; a++) { // the length of recipe-row
                for (int b = 0; b < check[0].length; b++) { // the width of recipe-column
                    if (check[a][b] != 0) { // for every non-void value of recipe. TODO Change !=0 to != null for real grid
                        if ((i + a) > 3 || (j + b - w) > 3 || (j + b - w) < 0) {
                            //System.out.println("Out of index:check at grid:" + i + j + "and recipe at" + z);
                            match = false;
                            break checkMatch;

                        } else if (grid[i + a][j + b - w] != check[a][b]) {
                            //System.out.println("Does not match at grid " + i + j + " and recipe " + z + " at " + a + b);
                            match = false;
                            break checkMatch;
                        } else {//if the position passes these conditions, it means that only that position matches the grid
                            bonusAdd[i + a][j + b - w]++;
                        }
                    }
                }
            }
        }
        if (match) {
            for (int c = 0; c < bonus.length; c++) { // add bonus position to bonus
                for (int d = 0; d < bonus[0].length; d++) {
                    if (bonusAdd[c][d] != 0) {
                        bonus[c][d] += bonusAdd[c][d];
                    }
                }
            }
            System.out.println("Match at grid " + i + j + " with recipe # " + z);//changed by adding effects to array
        }
    }

    public String getString() {
        return total;
    }


}
