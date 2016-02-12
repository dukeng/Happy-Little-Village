import java.util.ArrayList;

/**
 * Created by User on 11/02/16.
 */
public class testRitual {


    public static void main(String[] args) {
        String total = "A";
        int[][] ritual = {
                {1, 4, 4, 2},
                {0, 2, 2, 2},
                {4, 2, 1, 2},
                {2, 2, 3, 0}
        };
        Recipe recipe = new Recipe(ritual);
        recipe.useGems2();
        System.out.print(recipe.getString());
    }


}
