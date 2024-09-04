# Hierarchy-of-Life
This project provides a Java-based implementation of a tree structure to represent biological taxonomy, and visualizes it using the JGraphX library. The tree structure is built with custom generic tree nodes, and the hierarchy is displayed as a graphical interface.
## Project Structure
* BodyTreeNode.java: A generic tree node class that represents the nodes in the biological taxonomy tree. Each node can have a parent and multiple children, making it suitable for hierarchical data.
* SimpleTreeNode.java: Another version of the tree node class, demonstrating basic tree operations with a simpler structure.
* JGraphX2.java: The main class that creates the biological taxonomy tree, using BodyTreeNode as the underlying data structure. This class utilizes the JGraphX library to visualize the tree.
## Features
### Tree Node Implementation (BodyTreeNode.java and SimpleTreeNode.java)
* Generic Tree Node: Supports any type of data as the node content.
* Parent-Child Relationship: Nodes can have a parent and multiple children, enabling complex tree structures.
* Tree Traversal: Includes methods to traverse the tree and print the path from the root to each node.
### Tree Visualization (JGraphX2.java)
* Biological Taxonomy Representation: Models a biological taxonomy tree from root (e.g., "Life") to specific categories like "Mammals" and "Birds".
* Graphical Display: Utilizes JGraphX to visually represent the tree structure, allowing for hierarchical layout and clear visualization of relationships.
* Swing Integration: The visualization is integrated with Java Swing to create a user-friendly interface.
## How to Run
1. Clone the Repository: Download the project files to your local machine.
2. Open in respective IDE (VS Code, IntelliJ etc.)
3. Explore the Tree :D
## Example Tree Structure <br/>
*     Root: Life
*       Domains: Archaea, Bacteria, Eukaryota
*         Eukaryota Subcategories: Protists, Fungi, Plants, Animals
*           Animals Subcategories: Chordates, Arthropods, Mollusks
*             Chordates Subcategories: Mammals, Birds, Reptiles
Example In the Program
  ![Capture](https://github.com/user-attachments/assets/1f015872-c3fb-4fe9-994b-4844c5953992)
## Dependencies
* JGraphX: The project uses the JGraphX library for visualizing the tree structure. Ensure that the JGraphX jar is included in your classpath.
## Contributions
Contributions to improve the tree structures, optimize visualization, or expand functionality are welcome. Feel free to submit a pull request or raise an issue.
