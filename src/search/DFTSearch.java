package search;

import npuzzle.NPuzzlePrinting;
import npuzzle.Tiles;
import npuzzle.TilesGoalTest;

/**
 * Test of  Tree Search using DFS
 */
public class DFTSearch {
    public static void main(String[] args) {
        Frontier frontier = new DepthFirstFrontier();
        TreeSearch search = new TreeSearch(frontier);
        Tiles initial = new Tiles(new int[][] {
                { 7, 4, 2 },
                { 8, 1, 3 },
                { 5, 0, 6 }
        });

        GoalTest goalTest = new TilesGoalTest();
        Node solution = search.search(new Node(null, null, initial), goalTest);
        new NPuzzlePrinting().printSolution(solution);
        System.out.println("Generated nodes: " + search.numOfNodesGenerated());
        System.out.println("Maximum number of nodes in frontier: " + frontier.getMaxSize());

    }

}
