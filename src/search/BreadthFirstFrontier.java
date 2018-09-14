package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {
    // data structure to store nodes
    private Queue<Node> queue = new LinkedList<Node>();
    // maximum number of nodes which were kept in frontier
    int maxSize = 0;

    @Override
    public void add(Node node) {
        this.queue.add(node);
        this.maxSize = Math.max(this.maxSize, this.queue.size());
    }

    @Override
    public void clear() {
        this.queue.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public Node remove() {
        return this.queue.poll();
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }
}
