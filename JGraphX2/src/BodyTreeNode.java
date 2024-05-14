import java.util.*;

public class BodyTreeNode<T> {
    private T data = null;
    private List<BodyTreeNode<T>> children = new ArrayList<>();
    private BodyTreeNode<T> parent = null;

    public BodyTreeNode(T data) {
        this.data = data;
    }

    public void addChild(BodyTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        BodyTreeNode<T> newChild = new BodyTreeNode<>(data);
        this.addChild(newChild);
    }

    public void addChildren(List<BodyTreeNode<T>> children) {
        for (BodyTreeNode<T> child : children) {
            child.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<BodyTreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(BodyTreeNode<T> parent) {
        this.parent = parent;
    }

    public BodyTreeNode<T> getParent() {
        return parent;
    }

    public String getParents(BodyTreeNode<T> node) {
        Deque<BodyTreeNode<T>> stack = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        BodyTreeNode<T> parentNode = node.getParent();
        while (parentNode != null) {
            stack.push(parentNode);
            parentNode = parentNode.getParent();
        }
        Iterator<BodyTreeNode<T>> itr = stack.iterator();
        while (itr.hasNext()) {
            path.append(itr.next().getData()).append(":");
        }
        return path.toString();
    }

    public void printChildren(BodyTreeNode<T> node) {
        if (node.getParent() != null) {
            if (node.getChildren().isEmpty()) {
                System.out.println(node.getParents(node) + node.getData());
            } else {
                for (BodyTreeNode<T> child : node.getChildren()) {
                    System.out.println(node.getParents(child) + child.getData());
                    printChildren(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        BodyTreeNode<String> root = new BodyTreeNode<>("Life");

        BodyTreeNode<String> archaea = new BodyTreeNode<>("Archaea");
        BodyTreeNode<String> bacteria = new BodyTreeNode<>("Bacteria");
        BodyTreeNode<String> eukaryota = new BodyTreeNode<>("Eukaryota");

        root.addChildren(Arrays.asList(archaea, bacteria, eukaryota));

        BodyTreeNode<String> protists = new BodyTreeNode<>("Protists");
        BodyTreeNode<String> fungi = new BodyTreeNode<>("Fungi");
        BodyTreeNode<String> plants = new BodyTreeNode<>("Plants");
        BodyTreeNode<String> animals = new BodyTreeNode<>("Animals");

        eukaryota.addChildren(Arrays.asList(protists, fungi, plants, animals));

        BodyTreeNode<String> chordates = new BodyTreeNode<>("Chordates");
        BodyTreeNode<String> arthropods = new BodyTreeNode<>("Arthropods");
        BodyTreeNode<String> mollusks = new BodyTreeNode<>("Mollusks");

        animals.addChildren(Arrays.asList(chordates, arthropods, mollusks));

        BodyTreeNode<String> mammals = new BodyTreeNode<>("Mammals");
        BodyTreeNode<String> birds = new BodyTreeNode<>("Birds");
        BodyTreeNode<String> reptiles = new BodyTreeNode<>("Reptiles");

        chordates.addChildren(Arrays.asList(mammals, birds, reptiles));

        root.printChildren(root);
    }
}
