package Day06.shoppingmallexam;

public class ShopLauncher {

	public static void main(String[] args) {
		IShop shop = new MyShop();
		shop.setTitle("MyShop");
		shop.getUser();
		shop.getProduct();
		shop.start();
	}
}
