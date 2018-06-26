package br.cart;

import java.util.List;

import javax.ejb.Remote;

import br.inventory.Product;

@Remote
public interface ICartBean {
	
	void addItem(Product product);
	void removeItem(int product);
	void showProductsInCart();
	double totalValue();
	void products();
	List<Product> getInventory();

}
