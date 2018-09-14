package search;

import java.math.BigInteger;

public class TreeSearch implements Search {
    private Frontier frontier;
    // number of nodes generated
    private int treeSize = 0;

    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    @Override
    public Node search(Node rootNode, GoalTest goalTest) {
        this.frontier.clear(); // empty frontier as there may be some old data
        this.frontier.add(rootNode);
        this.treeSize++; // rootNode
        while(!this.frontier.isEmpty()) {
            Node node = this.frontier.remove();
            if (goalTest.isGoal(node.state)) { return node; }
            for (Action action : node.state.getApplicableActions()) {
                this.treeSize++;
                State newState = node.state.getActionResult(action);
                this.frontier.add(new Node(node, action, newState));
            }
        }
        return null;
    }

    @Override
    public int numOfNodesGenerated() {
        return this.treeSize;
    }
}
