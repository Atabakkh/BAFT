package ir.ata.baft.GEXF.core.impl.dynamic;

import ir.ata.baft.GEXF.core.dynamic.Spell;
import ir.ata.baft.GEXF.core.dynamic.Spellable;

import java.util.ArrayList;
import java.util.List;


public abstract class SpellableBase<T extends Object> extends DynamicBase<T> implements Spellable<T> {

	private List<Spell> spells = null;
	
	public SpellableBase() {
		spells = new ArrayList<Spell>();
	}
	
	@Override
	public List<Spell> getSpells() {
		return spells;
	}
}