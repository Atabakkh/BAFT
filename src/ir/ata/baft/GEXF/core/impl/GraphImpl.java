package ir.ata.baft.GEXF.core.impl;

import static com.google.common.base.Preconditions.checkArgument;

import ir.ata.baft.GEXF.core.Edge;
import ir.ata.baft.GEXF.core.EdgeType;
import ir.ata.baft.GEXF.core.Graph;
import ir.ata.baft.GEXF.core.IDType;
import ir.ata.baft.GEXF.core.Mode;
import ir.ata.baft.GEXF.core.Node;
import ir.ata.baft.GEXF.core.data.AttributeList;
import ir.ata.baft.GEXF.core.dynamic.TimeFormat;
import ir.ata.baft.GEXF.core.impl.dynamic.DynamicBase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * GraphImpl class is an implementation of the Graph interface.
 *
 */
public class GraphImpl extends DynamicBase<Graph> implements Graph {

	private EdgeType edgeType = EdgeType.UNDIRECTED;
	private List<AttributeList> attributeLists = null;
	private IDType idType = IDType.STRING;
	private Mode mode = Mode.STATIC;
	private List<Node> nodes = null;
	private String timeType = TimeFormat.DOUBLE;
	
	/**
	 * This constructor is called by GexfImpl() constructor
	 */
	public GraphImpl() {
		attributeLists = new ArrayList<AttributeList>();
		nodes = new ArrayList<Node>();
	}
	
	@Override
	protected Graph getSelf() {
		return this;
	}

	@Override
	public EdgeType getDefaultEdgeType() {
		return edgeType;
	}

	@Override
	public IDType getIDType() {
		return idType;
	}

	@Override
	public Mode getMode() {
		return mode;
	}

	@Override
	public String getTimeType() {
		return timeType;
	}

	@Override
	public Graph setDefaultEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
		return this;
	}

	@Override
	public Graph setIDType(IDType idType) {
		this.idType = idType;
		return this;
	}

	@Override
	public Graph setMode(Mode graphMode) {
		this.mode = graphMode;
		return this;
	}

	@Override
	public Graph setTimeType(String timeType) {
		this.timeType = timeType;
		return this;
	}
 
	@Override
	public Node createNode() {
		return createNode(UUID.randomUUID().toString());
	}

	@Override
	public Node createNode(String id) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
				
		Node rv = new NodeImpl(id);
		nodes.add(rv);
		return rv;
	}

	@Override
	public List<Edge> getAllEdges() {
		List<Edge> rv = new ArrayList<Edge>();
		
		for (Node n : nodes) {
			rv.addAll(n.getEdges());
			rv.addAll(n.getAllEdges());
		}
		
		return rv;
	}

	@Override
	public List<Node> getNodes() {
		return nodes;
	}

	@Override
	public List<AttributeList> getAttributeLists() {
		return attributeLists;
	}
}