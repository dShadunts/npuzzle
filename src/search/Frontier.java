package search;

import java.math.BigInteger;

public interface Frontier {
    /**
    * add a node to frontier
    */
    void add(Node node);

    /**
    * remove all nodes from frontier
    */
    void clear();

    /**
    * check if there are no nodes in frontier
    */
    boolean isEmpty();

    /**
    * remove a node from frontier, if empty -> return null
    */
    Node remove();

    /**
    * get the maximum number of nodes which were kept in frontier simultaniously
    */
    int getMaxSize();
}
