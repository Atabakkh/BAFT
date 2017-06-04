package ir.ata.baft.GEXF.core.impl.writer;

import ir.ata.baft.GEXF.core.dynamic.Spell;

import javax.xml.stream.XMLStreamWriter;


public class SpellEntityWriter extends DynamicEntityWriter<Spell> {
	private static final String ENTITY = "spell";
	
	public SpellEntityWriter(XMLStreamWriter writer, Spell entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}
}