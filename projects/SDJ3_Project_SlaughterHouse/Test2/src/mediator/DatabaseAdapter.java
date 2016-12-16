package mediator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Animal;
import model.Part;
import model.Tray;
import model.Product;
import model.Market;


public class DatabaseAdapter implements Persistence {
	private MyDatabase db;
	private static final String DB_NAME = "Slaughterhouse";

	public DatabaseAdapter() throws ClassNotFoundException {
		this.db = new MyDatabase(DB_NAME);
	}

	public Animal[] loadAnimals() throws IOException {
		ArrayList<Animal> array = new ArrayList<Animal>();
		Animal[] result = null;

		String sql = "SELECT * FROM animal";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int animalId = Integer.parseInt(row[0].toString());
				String type = row[1].toString();
				float weight = Float.parseFloat(row[2].toString());
				array.add(new Animal(weight, animalId, type));
			}

			result = new Animal[array.size()];

			for (int i = 0; i < array.size(); i++) {
				result[i] = array.get(i);
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public Part[] loadParts() throws IOException {
		ArrayList<Part> array = new ArrayList<Part>();
		Part[] result = null;

		String sql = "SELECT * FROM part";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int partId = Integer.parseInt(row[0].toString());
				float weight = Float.parseFloat(row[1].toString());
				String type = row[2].toString();
				int animalId = Integer.parseInt(row[3].toString());
				array.add(new Part(animalId, type, partId, weight));
			}

			result = new Part[array.size()];

			for (int i = 0; i < array.size(); i++) {
				result[i] = array.get(i);
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public Tray[] loadTrays() throws IOException {
		ArrayList<Tray> trays = new ArrayList<Tray>();

		Tray[] result = null;

		String sql = "SELECT * FROM tray";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int trayId = Integer.parseInt(row[0].toString());
				String type = row[1].toString();
				float maxWeight = Float.parseFloat(row[2].toString());

				ArrayList<Part> parts = new ArrayList<Part>();
				String sql2 = "SELECT * FROM part WHERE tray_id = " + trayId;
				ArrayList<Object[]> results2 = db.query(sql2);
				for (int j = 0; j < results2.size(); j++) {
					Object[] row2 = results2.get(j);
					int partId = Integer.parseInt(row2[0].toString());
					float weight = Float.parseFloat(row2[1].toString());
					String type2 = row2[2].toString();
					int animalId = Integer.parseInt(row2[3].toString());
					parts.add(new Part(animalId, type2, partId, weight));
				}

				trays.add(new Tray(type, trayId, maxWeight, parts));
			}

			result = new Tray[trays.size()];

			for (int i = 0; i < trays.size(); i++) {
				result[i] = trays.get(i);
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public Market[] loadMarkets() throws IOException {
		ArrayList<Market> markets = new ArrayList<Market>();
		Market[] result = null;

		String sql = "SELECT * FROM market";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int marketId = Integer.parseInt(row[0].toString());
				String address = row[1].toString();

				ArrayList<Product> products = new ArrayList<Product>();
				String sql2 = "SELECT * FROM product WHERE market_id = " + marketId;
				ArrayList<Object[]> results2 = db.query(sql2);
				for (int j = 0; j < results2.size(); j++) {
					Object[] row2 = results2.get(j);
					int productId = Integer.parseInt(row2[0].toString());
					String type = row2[1].toString();
					float weight = Float.parseFloat(row2[3].toString());

					products.add(new Product(productId, type, weight));
				}

				markets.add(new Market(marketId, address, products));
			}

			result = new Market[markets.size()];

			for (int i = 0; i < markets.size(); i++) {
				result[i] = markets.get(i);
			}

		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public Product[] loadProducts() throws IOException {
		ArrayList<Product> products = new ArrayList<Product>();
		Product[] result = null;

		String sql = "SELECT * FROM product";
		try {
			ArrayList<Object[]> results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int productId = Integer.parseInt(row[0].toString());
				String type = row[1].toString();
				float weight = Float.parseFloat(row[3].toString());

				ArrayList<Part> parts = new ArrayList<Part>();
				String sql2 = "SELECT tray_id FROM packing WHERE product_id  = " + productId;
				ArrayList<Object[]> results2 = db.query(sql2);
				for (int j = 0; j < results2.size(); j++) {
					Object[] row2 = results2.get(j);
					int trayId = Integer.parseInt(row2[0].toString());

					String sql3 = "SELECT * FROM part WHERE tray_id  = " + trayId;
					ArrayList<Object[]> results3 = db.query(sql3);
					for (int k = 0; k < results3.size(); k++) {
						Object[] row3 = results3.get(k);
						int partId = Integer.parseInt(row3[0].toString());
						float weight2 = Float.parseFloat(row3[1].toString());
						String type2 = row3[2].toString();
						int animalId = Integer.parseInt(row3[3].toString());
						parts.add(new Part(animalId, type2, partId, weight2));
					}

				}
				products.add(new Product(parts, productId, type, weight));
			}

			result = new Product[products.size()];

			for (int i = 0; i < products.size(); i++) {
				result[i] = products.get(i);
			}
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}

		return result;
	}

	public void updateAnimal(int animalId, float weight) {
		String sql = "UPDATE animal SET weight="+weight+" WHERE animal_id=" + animalId;
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveAnimal(float weight, String type) {
		String sql = "INSERT INTO animal (weight, type) VALUES (" + weight + ", '" + type + "');";
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void savePart(int animalId, String type, float weight) {
		String sql = "INSERT INTO part(weight, type, animal_id ) SELECT " + weight + ", '" + type
				+ "', animal_id FROM animal WHERE animal_id = " + animalId;
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveTray(String type, float maxWeight) {
		String sql = "INSERT INTO tray (type, max_weight) VALUES ('" + type + "', " + maxWeight + ");";
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addToTray(int partId, int trayId) {
		String sql = "UPDATE part SET tray_id = " + trayId + " WHERE part_id = " + partId;
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveMarket(String address) {
		String sql = "INSERT INTO market (address) VALUES ('" + address + "');";
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void packTraysToProduct(String type, float weight, Tray[] trays) {
		String sql = "INSERT INTO product (type, weight) VALUES ('" + type + "', " + weight + ")";
		int productId;
		try {
			db.update(sql);
			ArrayList<Object[]> r = db.query("SELECT MAX(product_id) FROM product;");
			Object[] row = r.get(0);
			productId = Integer.parseInt(row[0].toString());
			for(int i=0;i<trays.length;i++){
				String sql2 = "INSERT INTO packing (tray_id, product_id) VALUES (" + trays[i].getTrayId() + ", " + productId +");";
				db.update(sql2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void transportTomarket(int productId, int marketId){
		String sql = "UPDATE product SET market_id = " + marketId + " WHERE product_id = " + productId;
		try {
			db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
