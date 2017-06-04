package ir.ata.baft.model;

public class Weights {
	private int id;
	private String gene_a;
	private String gene_b;
	private double weight;
	
	public Weights(){
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int value)
	{
		id = value;
	}
	
	public String getGeneA()
	{
		return gene_a;
	} 
	
	public void setGeneA(String value)
	{
		gene_a = value;
	}
	
	public String  getGeneB()
	{
		return gene_b;
	} 
	
	public void setGeneB(String value)
	{
		gene_b = value;
	}
	
	public double  getWeight()
	{
		return weight;
	} 
	
	public void setWeight(double value)
	{
		weight = value;
	}

}
