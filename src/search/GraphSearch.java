package search;
import java.util.HashSet;

public class GraphSearch implements Search {
    private Frontier frontier;
    // number of nodes generated
    private int graphSize = 0;

    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    @Override
    public Node search(Node rootNode, GoalTest goalTest) {
        this.frontier.clear(); // empty frontier as there may be some old data
        HashSet<State> explored = new HashSet<>(); // data structure to keep track of explored states
        this.frontier.add(rootNode);
        this.graphSize++; // rootNode
        while(!this.frontier.isEmpty()) {
            Node node = this.frontier.remove();
            // found solution
            if (goalTest.isGoal(node.state)) { return node; }
            // if state is not explored -> expand it
            if (!explored.contains(node.state)){
                explored.add(node.state);
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    // if new state is not explored -> add it to frontier to explore later
                    if (!explored.contains(newState)) {
                        this.graphSize++;
                        this.frontier.add(new Node(node, action, newState));
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int numOfNodesGenerated() {
        return this.graphSize;
    }
}
