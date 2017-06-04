package ir.ata.baft.GEXF.core.dynamic;

import java.util.List;

public interface Spellable<T extends Object> extends Dynamic<T> {

	List<Spell> getSpells();
}