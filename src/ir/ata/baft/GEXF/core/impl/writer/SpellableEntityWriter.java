package ir.ata.baft.GEXF.core.impl.writer;

import ir.ata.baft.GEXF.core.dynamic.Spellable;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public abstract class SpellableEntityWriter<T extends Spellable<?>> extends DynamicEntityWriter<T> {

	public SpellableEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
		super.writeAttributes();
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		if (!entity.getSpells().isEmpty()) {
			new SpellsEntityWriter(writer, entity.getSpells());
		}
		super.writeElements();
	}	
}