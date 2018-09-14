package search;
import java.util.EmptyStackException;
import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
    // data structure to store nodes
    private Stack<Node> stack = new Stack<>();
    // maximum number of nodes which were kept in frontier
    int maxSize = 0;

    @Override
    public void add(Node node) {
        this.stack.push(node);
        this.maxSize = Math.max(this.maxSize, this.stack.size());
    }

    @Override
    public void clear() {
        this.stack.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public Node remove() {
        try {
            return this.stack.pop();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

}
