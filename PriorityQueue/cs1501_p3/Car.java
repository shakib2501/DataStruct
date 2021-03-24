package cs1501_p3;

class Car implements Car_Inter {
	String VIN;
	String make;
	String model;
	int price;
	int mileage;
	String color;

	public Car(String vin, String make, String model, int price, int mileage, String color){
		this.VIN = vin;
		this.make = make;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.color = color;
	}


	public String getVIN(){
		return this.VIN;
	}

	/**
	 * Getter for the make attribute
	 *
	 * @return 	String The make
	 */
	public String getMake(){
		return this.make;

	}

	/**
	 * Getter for the model attribute
	 *
	 * @return 	String The model
	 */
	public String getModel(){
		return this.model;
	}

	/**
	 * Getter for the price attribute
	 *
	 * @return 	String The price
	 */
	public int getPrice(){
		return this.price;
	}

	/**
	 * Getter for the mileage attribute
	 *
	 * @return 	String The mileage
	 */
	public int getMileage(){
		return this.mileage;
	}

	/**
	 * Getter for the color attribute
	 *
	 * @return 	String The color
	 */
	public String getColor(){
		return this.color;
	}

	/**
	 * Setter for the price attribute
	 *
	 * @param 	newPrice The new Price
	 */
	public void setPrice(int newPrice){
		this.price = newPrice;
	}

	/**
	 * Setter for the mileage attribute
	 *
	 * @param 	newMileage The new Mileage
	 */
	public void setMileage(int newMileage){
		this.mileage = newMileage;
	}

	/**
	 * Setter for the color attribute
	 *
	 * @param 	newColor The new color
	 */
	public void setColor(String newColor){
		this.color = newColor;
	}
}