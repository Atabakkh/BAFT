package ir.ata.baft.GEXF.core.impl.writer;

import ir.ata.baft.GEXF.core.viz.NodeShapeEntity;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class NodeShapeEntityWriter extends AbstractEntityWriter<NodeShapeEntity> {
	private static final String ENTITY = "viz:shape";
	private static final String ATTRIB_VALUE = "value";
	private static final String ATTRIB_URI = "uri";
	
	public NodeShapeEntityWriter(XMLStreamWriter writer, NodeShapeEntity entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_VALUE,
				entity.getNodeShape().toString().toLowerCase());
		
		if (entity.hasUri()) {
			writer.writeAttribute(
					ATTRIB_URI,
					entity.getUri());
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}