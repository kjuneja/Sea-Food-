package vendor;

import java.util.*;
import java.util.regex.Pattern;

public class Test {
	int id;
	String name;
	double price;
	String description;
	double weight;
	double length;
	int stock;

	public Test(int id, String name, double price, String description, double weight, double length, int stock) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.weight = weight;
		this.length = length;
		this.stock = stock;

		// weight, length, stock status (a boolean)

		// System.out.println("in constructor");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		// System.out.println("in getName");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescsription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	/*
	 * public ProductAdd(int id, String name, double price) { super(id, name,
	 * price);
	 * 
	 * }
	 */

	public static int findNextID(ArrayList<Test> products) {
		int id = 0;
		int i = products.size() - 1;
		int total = 0;
		int sum = 0;
		if (products.size() < products.get(i).getId()) {
			total = (products.size()) * (products.size() + 1) / 2;
			for (int k = 0; k < products.size() - 1; k++) {
				sum += products.get(k).getId();
			}
			if (products.get(products.size() - 1).getId() < total - sum) {
				 total = total -sum;
				 int counter =0;
				while(id==0) {
					if (total-counter!= products.get(counter).getId()) {
						id = counter;
					}
					total++;
					counter++;
				}
				
				
			} else {
				id = total - sum;
			}
		} else {
			id = products.size() + 1;

		}

		return id;
	}

	public static void addProduct(int id, String name, double price, String description, double weight, double length,
			int stock, ArrayList<Test> products) {
		Test newProduct = new Test(id, name, price, description, weight, length, stock);
		products.add(newProduct);

		System.out.println("New product has been added\n");

		System.out.println("ID\tName\tPrice\tDescription\tWeight\tLength\tStock\n");

		for (int i = 0; i < products.size(); i++) {
			double value = products.get(i).getPrice();
			System.out.print(products.get(i).getId() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			// System.out.print(products.get(i).getPrice() + "\t" + "\n");
			System.out.printf("%.2f", value); // price
			System.out.print("\t" + products.get(i).getDescsription() + "\t\t");
			System.out.printf("%.1f", products.get(i).getWeight());
			System.out.print("\t");
			System.out.printf("%.1f", products.get(i).getLength());

			System.out.print("\t" + products.get(i).getStock());
			System.out.print("\t\n");
		}
	}

	public static void editProduct(int id, String name, double price, String description, double weight, double length,
			int stock, ArrayList<Test> products) {
		Test edit = new Test(id, name, price, description, weight, length, stock);
		products.set(id - 1, edit);

		System.out.println("Product has been edited\n");

		System.out.println("ID\tName\tPrice\tDescription\tWeight\tLength\tStock\n");
		for (int i = 0; i < products.size(); i++) {
			double value = products.get(i).getPrice();
			System.out.print(products.get(i).getId() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			// System.out.print(products.get(i).getPrice() + "\t" + "\n");
			System.out.printf("%.2f", value); // price
			System.out.print("\t" + products.get(i).getDescsription() + "\t\t");
			System.out.printf("%.1f", products.get(i).getWeight());
			System.out.print("\t");
			System.out.printf("%.1f", products.get(i).getLength());
			System.out.print("\t" + products.get(i).getStock());
			System.out.print("\t\n");
		}

	}

	public static void deleteProduct(int id, ArrayList<Test> products) {
		products.remove(id - 1);
		System.out.println("Product has been removed");
		System.out.println("ID\tName\tPrice\tDescription\tWeight\tLength\tStock\n");
		for (int i = 0; i < products.size(); i++) {
			System.out.print(products.get(i).getId() + "\t");
			System.out.print(products.get(i).getName() + "\t");
			System.out.print(products.get(i).getPrice() + "\t" + "\n");
		}
	}

	public static int checkDigit() {
		String id;
		Scanner scanner = new Scanner(System.in);
		int number = 0;

		int counter = 0;

		id = scanner.nextLine();

		int length = id.length();
		boolean exit = true;
		while (exit != false) {

			// if (Character.isDigit(id.charAt(counter))&& length!=0)
			if (length == 0 || !Character.isDigit(id.charAt(counter))) {
				System.out.println("Enter a valid Number");
				id = scanner.nextLine();
				counter = 0;
				length = id.length();
			} else if (length - 1 <= counter) {
				exit = false;
			} else {
				counter++;
			}
		}

		number = Integer.parseInt(id);
		return number;
	}

	public static double checkDouble() {
		String price;
		Scanner scanner = new Scanner(System.in);
		double number = 0;

		int counter = 0;
		final String check = "[0-9]+([,.][0-9]{1,2})?";
		final Pattern pattern = Pattern.compile(check);
		price = scanner.nextLine();

		int length = price.length();
		boolean exit = true;
		while (exit != false) {

			// if (Character.isDigit(id.charAt(counter))&& length!=0)

			if (price.matches(check) == false || length == 0) {

				System.out.println("Enter a valid number");
				price = scanner.nextLine();
				counter = 0;
				length = price.length();
			} else if (length - 1 <= counter) {
				exit = false;
			} else {
				counter++;
			}
		}
		number = Double.parseDouble(price);

		return number;
	}

	public static String checkName() {
		String name;

		Scanner scanner = new Scanner(System.in);

		int counter = 0;

		System.out.println("enter Product Name");
		name = scanner.nextLine();

		int length = name.length();
		boolean exit = true;
		while (exit != false) {

			// if (Character.isDigit(id.charAt(counter))&& length!=0)
			if (length == 0 || !Character.isLetter(name.charAt(counter))) {
				System.out.println("Enter a valid Name");
				name = scanner.nextLine();
				counter = 0;
				length = name.length();
			} else if (length - 1 <= counter) {
				exit = false;
			} else {
				counter++;
			}
		}

		return name;

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String description = null;
		int option = 0;
		int id = 0;
		String name = "";
		Double price = 0.0;
		double weight = 0.0;
		double length = 0.0;
		int stock = 0;

		ArrayList<Test> products = new ArrayList<Test>();
		// products.add(new Product (1, "red lobster", 20.00));

		Test newProduct = new Test(1, "lobster", 20.69, "yummy", 15, 12, 3);
		Test newProduct2 = new Test(3, "lobster", 20.69, "yummy", 15, 12, 3);
		Test newProduct3 = new Test(2, "lobster", 20.69, "yummy", 15, 12, 3);
		products.add(newProduct);
		products.add(newProduct2);
		products.add(newProduct3);

		// option = Integer.parseInt(scanner.nextLine());

		while (option != 4) {
			Collections.sort(products, new Comparator<Test>() { // sorts
				public int compare(Test a, Test b) {
					return Integer.valueOf(a.id).compareTo(b.id);
				}
			});

			System.out.println("Enter menu option ");
			System.out.println("1: Add");
			System.out.println("2: Edit");
			System.out.println("3: Delete ");
			System.out.println("4: Exit");

			option = checkDigit();
			if (option == 1) {// need to check next available space if user
				id = 0;
				// id = Integer.parseInt(scanner.nextLine());
				// id = products.size() + 1;

				// name = scanner.nextLine();
				id = findNextID(products);
				name = checkName();

				// price = Double.parseDouble(scanner.nextLine());
				System.out.println("enter a price");
				price = checkDouble();
				System.out.println("enter a description");
				description = scanner.nextLine();
				System.out.print("Enter weight ");
				weight = checkDouble();
				System.out.print("Enter length ");
				length = checkDouble();
				System.out.print("Enter stock ");
				stock = checkDigit();
				addProduct(id, name, price, description, weight, length, stock, products);

			}

			else if (option == 2) { // edits designated id

				System.out.println("Enter Product ID: ");
				id = checkDigit();
				/*
				 * int counter = 0; boolean exit = true; while (exit == true) {
				 * if (products.get(counter).getId() == id) exit = false; else
				 * if (counter >= products.size() - 1) {
				 * System.out.println("ID not available"); id = checkDigit(); }
				 * else { counter++; } }
				 */

				// name = scanner.nextLine();
				name = checkName();

				System.out.println("enter a price");
				price = checkDouble();
				System.out.println("enter a description");
				description = scanner.nextLine();
				System.out.print("Enter weight ");
				weight = checkDouble();
				System.out.print("Enter length ");
				length = checkDouble();
				System.out.print("Enter stock ");
				stock = checkDigit();
				editProduct(id, name, price, description, weight, length, stock, products);
			}

			else if (option == 3) {

				System.out.println("Enter Product ID: ");
				id = checkDigit();
				/*
				 * boolean exit = true; int counter = 0; while (exit == true) {
				 * if (products.get(counter).getId() == id) exit = false; else
				 * if (counter >= products.size() - 1) {
				 * System.out.println("ID not available"); id = checkDigit(); }
				 * else { counter++; } }
				 */

				deleteProduct(id, products);
			}
			// option = Integer.parseInt(scanner.nextLine());
		}
		System.out.println("goodbye");
	}

}