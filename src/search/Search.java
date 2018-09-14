package search;

import java.math.BigInteger;

public interface Search {
    /**
    * search for the node which meets the goalTest
    * @return no solution found -> null, else node containing goal state 
    */
    Node search(Node rootNode, GoalTest goalTest);

    /**
    * number of nodes generated during last search
    * @return int
    */
    int numOfNodesGenerated();
}
