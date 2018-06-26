package br.cart;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.inventory.InventoryBean;
import br.inventory.Product;

@Stateful
public class CartBean implements ICartBean {
	
	List<Product> cart = new ArrayList<Product>();
	InventoryBean inventory = new InventoryBean();

	@Override
	public void addItem(Product product) {
		this.cart.add(product);
		inventory.removeFromInventory(product);
	}

	@Override
	public void removeItem(int index) {
		Product product = this.cart.get(index);
		this.cart.remove(index);
		inventory.addToInventory(product);
	}

	@Override
	public void showProductsInCart() {
		int i = 1;
		for (Product item : this.cart) {
			System.out.println(i + " " + item.getName() + ' ' + item.getPrice());
			i++;
		}
	}

	@Override
	public double totalValue() {
		double total = 0;
		for (Product item : this.cart) {
			total += item.getPrice();
		}
		return total;
	}
	
	@Override
	public void products() {
		int i = 1;
		for (Product item : this.inventory.getInventory()) {
			System.out.println(i + " " + item.getName() + " " + item.getPrice());
			i++;
		}
	}
	
	@Override
	public List<Product> getInventory() {
		return inventory.getInventory();
	}

}
