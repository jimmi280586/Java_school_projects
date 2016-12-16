import java.util.ArrayList;


public class Recipe
{
	@SuppressWarnings("unused")
	private String name;
	private ArrayList<Ingredient> ingredients;
	
	public Recipe(String name)
	{
		this.name = name;
		ingredients = new ArrayList<Ingredient>();
	}
	
	public int getNumberOfingrdients()
	{
		return this.ingredients.size();
	}
	
	public Ingredient getIngredient(int index)
	{
		return this.ingredients.get(index-1);
	}
	
	public void addIngredient(Ingredient ingredients)
	{
		this.ingredients.add(ingredients);
	}
	
	public void addIngredient(String name, double Weight)
	{
		this.ingredients.add(new Ingredient(name, Weight));
	}
	
	public double getTotalWeight()
	{
		double total = 0;
		
		for(int i = 0; i < ingredients.size(); i++)
		{
			total += ingredients.get(i).getWeight();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Recipe ingredients = " + ingredients + "";
	}
	
	
}
