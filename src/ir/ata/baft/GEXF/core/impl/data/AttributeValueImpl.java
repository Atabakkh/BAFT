package ir.ata.baft.GEXF.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;
import ir.ata.baft.GEXF.core.data.Attribute;
import ir.ata.baft.GEXF.core.data.AttributeValue;
import ir.ata.baft.GEXF.core.impl.dynamic.DynamicBase;

/**
 * AttributeValueImpl class is an implementation of the AttributeValue interface.
 *
 */
public class AttributeValueImpl extends DynamicBase<AttributeValue> implements AttributeValue {

	private Attribute attribute = null;
	private String value = "";
	
	/**
	 * Constructs an AttributeValue object
	 * @param attribute an instance of Attribute interface
	 */
	public AttributeValueImpl(Attribute attribute) {
		checkArgument(attribute != null, "Attribute cannot be null.");
		this.attribute = attribute;
	}
	
	@Override
	protected AttributeValue getSelf() {
		return this;
	}

	@Override
	public Attribute getAttribute() {
		return attribute;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public AttributeValue setValue(String value) {
		checkArgument(value != null, "Value cannot be null.");
		this.value = value;
		return this;
	}
}