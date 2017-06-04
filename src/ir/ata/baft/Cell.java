package ir.ata.baft;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private Cell Prevoius_Cell;
	private List<Cell> PreviousCells = new ArrayList<Cell>();// / List<Cell>();
	private int row;
	private int Column;
	private int Score;
	private PrevcellType PCType;

	public Cell() {

	}

	public Cell(int row, int Col) {
		this.Column = Col;
		this.row = row;

	}

	public enum PrevcellType {
		Left, Above, Diagonal
	};

	public Cell(int row, int Col, int sco) {
		this.Column = Col;
		this.row = row;
		this.Score = sco;

	}

	public Cell(int row, int Col, int sco, Cell Prev) {
		this.Column = Col;
		this.row = row;
		this.Score = sco;
		this.Prevoius_Cell = Prev;

	}

	public Cell(int row, int Col, int sco, Cell Prev, PrevcellType PType) {
		this.Column = Col;
		this.row = row;
		this.Score = sco;
		this.Prevoius_Cell = Prev;
		this.PCType = PType;

	}

	public void setCellPointer(Cell value) {
		Prevoius_Cell = value;
	}

	public Cell getCellPointer() {
		return Prevoius_Cell;
	}

	public void setPrevCellPointer(List<Cell> value) {
		PreviousCells = value;
	}

	public List<Cell> getPrevCellPointer() {
		return PreviousCells;
	}

	public void setIndex(int index, Cell value) {
		PreviousCells.add(index, value);
	}

	public Cell getIndex(int index) {
		return PreviousCells.get(index);
	}

	public void setCellScore(int value) {
		Score = value;
	}

	public int getCellScore() {
		return Score;
	}

	public void setCellRow(int value) {
		row = value;
	}

	public int getCellRow() {
		return row;
	}

	public void setCellColumn(int value) {
		this.Column = value;
	}

	public int getCellColumn() {
		return Column;
	}

	public void setType(PrevcellType value) {
		PCType = value;
	}

	public PrevcellType getType() {
		return PCType;
	}
}
