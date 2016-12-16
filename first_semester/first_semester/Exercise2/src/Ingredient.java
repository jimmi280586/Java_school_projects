
public class Ingredient 
{
	private String name;
	private double Weight;
	public Ingredient(String name, double weight)
	{
		this.name = name;
		this.Weight = weight;
	}
	public String getName() {
		return name;
	}
	public double getWeight() {
		return Weight;
	}
	public Ingredient copy()
	{
		return new Ingredient(this.name, this.Weight);
	}
	public boolean equals(Ingredient ingredient)
	{
		return this.name.equals(ingredient.name)
				&& this.Weight == ingredient.Weight;
	}
	@Override
	public String toString()
	{
		return "Ingredient name = " + name + ", Weight = " + Weight + ":";
	}
	
}
