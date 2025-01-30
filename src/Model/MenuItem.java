package Model;

public class MenuItem {
	    private int itemId;
	    private String itemName;
	    private double price;
	    
		public MenuItem() {
			super();
			
		}

		public MenuItem(int itemId, String itemName, double price) {
			super();
			this.itemId = itemId;
			this.itemName = itemName;
			this.price = price;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "MenuItem [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + "]";
		}
	    
	    

}
