import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxGraph;

public class JGraphX2 extends JFrame {

    private static final long serialVersionUID = -2707712944901661771L;
    private BodyTreeNode<String> root = createBiologicalTaxonomyTree();

    public void fillGraphFromModel(mxGraph graph) {
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();

        try {
            Object vRoot = graph.insertVertex(parent, null, root.getData(), 80, 00, 80, 30);
            createGraphPoints(graph, parent, vRoot, root);

            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);
            layout.execute(parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

    public void createGraphPoints(mxGraph graph, Object parent, Object vRoot, BodyTreeNode<String> parentNode) {
        for (BodyTreeNode<String> child : parentNode.getChildren()) {
            Object childVertex = graph.insertVertex(parent, null, child.getData(), 80, 0, 80, 30);
            graph.insertEdge(parent, null, "", vRoot, childVertex);

            List<BodyTreeNode<String>> children = child.getChildren();
            if (!children.isEmpty()) {
                createGraphPoints(graph, parent, childVertex, child);
            }
        }
    }

    public BodyTreeNode<String> createBiologicalTaxonomyTree() {
        BodyTreeNode<String> root = new BodyTreeNode<>("Big Bang");

        BodyTreeNode<String> domains = new BodyTreeNode<>("Universe");
        root.addChild(domains);

        BodyTreeNode<String> earth = new BodyTreeNode<>("Earth");
        BodyTreeNode<String> sun = new BodyTreeNode<>("Sun");
        BodyTreeNode<String> moon = new BodyTreeNode<>("Moon");
        BodyTreeNode<String> water = new BodyTreeNode<>("Water");


        domains.addChild(earth);
        domains.addChild(sun);
        domains.addChild(moon);

        BodyTreeNode<String> earthSubdivision = earth;
        earth.addChild(water);

        water.addChild(new BodyTreeNode<>("Plants"));
        water.addChild(new BodyTreeNode<>("Insects"));

        BodyTreeNode<String> animals = new BodyTreeNode<>("Animals");
        water.addChild(animals);
        BodyTreeNode<String> bacteria = new BodyTreeNode<>("Bacteria");

        water.addChild(bacteria);

        BodyTreeNode<String> bacteriaSubdivision = bacteria;
        bacteria.addChild(new BodyTreeNode<>("Virus"));
        bacteria.addChild(new BodyTreeNode<>("Disease"));


        BodyTreeNode<String> animalsSubdivision = animals;
        animalsSubdivision.addChild(new BodyTreeNode<>("Mammals"));
        animalsSubdivision.addChild(new BodyTreeNode<>("Reptiles"));
        animalsSubdivision.addChild(new BodyTreeNode<>("Birds"));



        return root;
    }

    public JGraphX2() {
        super("Biological Taxonomy Tree");
        mxGraph graph = new mxGraph();
        fillGraphFromModel(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

    public static void main(String[] args) {
        JGraphX2 frame = new JGraphX2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 420);
        frame.setVisible(true);
    }
}
