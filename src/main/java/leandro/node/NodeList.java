//package leandro.node;
//
//import java.util.Iterator;
//import java.util.TreeSet;
//
//public class NodeList<T> implements Iterator<T> {
//    private final int TOP_LEVEL = 1;
//    private final int LEFT_START_ID = 1;
////    public TreeSet nodes = new TreeSet<NodeList<T>>(
////
////            public int compare
////    );
//
////    private class NodeList<T> implements Comparable<NodeList<T>>{
//        public T value;
//        public int lft;
//        public int rgt;
//        public int lvl;
//
//        public NodeList(T value, int lft, int rgt, int lvl) {
//            this.value = value;
//            this.lft = lft;
//            this.rgt = rgt;
//            this.lvl = lvl;
//        }
//
//        @Override
//        public int compareTo(NodeList<T> o) {
//            return this.lft - o.lft;
//        }
//    }
//
//    public boolean createRootNode(T value) {
//        if (nodes.size() != 0) {
//            return false;
//        }
//        nodes.add(new NodeList<>(value, LEFT_START_ID, LEFT_START_ID + 1, TOP_LEVEL));
//        return true;
//    }
//
//    // Get NodeList where left index equal lft
//    private NodeList<T> getNodeWithLeft(NodeList<T> node) {
//        return nodes.floor(node);
//    }
//    // Create NodeList with value T as child NodeList of NodeList which has left side value lft
//    public void addChildNode(T value, int lft) {
//        NodeList rootNodeList = getNodeWithLeft(lft);
//        NodeList node = new NodeList<T>(value, lft + 1, lft + 2, )
//        this.lft = node.lft + 1;
//        this.rgt = this.lft + 1;
//        node.rgt = this.rgt + 1;
//    }
//
//    public NodeList getRoot() {
//
//        return this;
//    }
//
//    public void printNodes() {
//
//    }
//
//    @Override
//    public boolean hasNext() {
//        return false;
//    }
//
//    @Override
//    public T next() {
//        int start = this.lft;
//        int end = this.rgt;
//        while
//        return null;
//    }
//}
