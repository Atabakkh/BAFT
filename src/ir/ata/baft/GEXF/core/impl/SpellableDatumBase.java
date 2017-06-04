package ir.ata.baft.GEXF.core.impl;

import ir.ata.baft.GEXF.core.SpellableDatum;
import ir.ata.baft.GEXF.core.data.AttributeValueList;
import ir.ata.baft.GEXF.core.impl.data.AttributeValueListImpl;
import ir.ata.baft.GEXF.core.impl.dynamic.SpellableBase;

public abstract class SpellableDatumBase<T extends Object> extends SpellableBase<T> implements SpellableDatum<T> {

	private AttributeValueList attributes = null;
	
	public SpellableDatumBase() {
		attributes = new AttributeValueListImpl();
	}

	@Override
	public AttributeValueList getAttributeValues() {
		return attributes;
	}
}