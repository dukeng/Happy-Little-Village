import java.util.ArrayList;

/**
 * Created by User on 11/02/16.
 */
public class Recipe {

    public int count = 0;
    public ArrayList<int[][]> recipes = new ArrayList<int[][]>();
    public int[][] grid;
    public String total = "End Test";

    public Recipe(int[][] grid) {
        setRecipe();
        this.grid = grid;

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
                {0, 2, 0, 0},
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
        for (int i = 0; i < grid[0].length; i++) { //row i
            for (int j = 0; j < grid.length; j++) { //column j
                if (grid[i][j] != 0) { // change from null to 0
                    //iterate through all known grid recipe
                    for (int z = 0; z < recipes.size(); z++) {
                        for (int w = 0; w < recipes.get(z)[0].length; w++) { // iterate through the first row of a recipe
                            if (recipes.get(z)[0][w] != 0) {
                                if (grid[i][j] == recipes.get(z)[0][w]) { //check if any of the first row's value matches with the grid
                                    //start to specifically check one recipe
                                    compareRecipe(z, i, j, w);
                                    break;
                                }//end checking for one specific recipe
                                else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void compareRecipe(int z, int i, int j, int w) {
        int[][] check = recipes.get(z); // param @check just to shorten the path
        boolean match = true;
        checkMatch:
        {
            for (int a = 0; a < check.length; a++) { // the length of recipe-row
                for (int b = 0; b < check[0].length; b++) { // the width of recipe-column
                    if (check[a][b] != 0) { // for every non-void value of recipe. TODO Change !=0 to != null for real grid
                        if ((i + a) > 3 || (j + b - w) > 3 || (j + b - w) < 0) {
                            //System.out.println("Out of index:check at grid:" + i + j + "and recipe at" + z);
                            match = false;
                            break checkMatch;

                        }
                        else if (grid[i + a][j + b - w] != check[a][b]) {
                            //System.out.println("Does not match at grid " + i + j + " and recipe " + z + " at " + a + b);
                            match = false;
                            break checkMatch;
                        }
                    }
                }
            }
        }
        if (match) {
            System.out.println("Match at grid " + i + j + " with recipe # " + z);
        }

    }

    public String getString() {
        return total;
    }


}
