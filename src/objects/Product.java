package objects;
import java.math.BigDecimal;
import java.util.Comparator;

import org.joda.time.DateTime;
import utilities.Log;
import utilities.Mailosaur;

import java.util.Random;


public class Product {

	private String productName;
	private BigDecimal productPrice;
	private String productColor;
	private String productSize;
	private BigDecimal productQuantity;

	public Product(String productName, BigDecimal productPrice, String productColor, String productSize, BigDecimal productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productQuantity = productQuantity;
	}

	public static Comparator<Product> ProductNameZtoAComparator = new Comparator<Product>()
	{
		public int compare(Product n1, Product n2) {
			String productName1 = n1.getProductName().toUpperCase();
			String productName2 = n2.getProductName().toUpperCase();

			//Sort product name Z to A
			return productName2.compareTo(productName1);
		}};

	public static Comparator<Product> ProductPriceDscComparator = new Comparator<Product>() {
		public int compare(Product p1, Product p2) {
			BigDecimal productPrice1 = p1.getProductPrice();
			BigDecimal productPrice2 = p2.getProductPrice();

			//Sort product price in descending order
			return productPrice2.compareTo(productPrice1);
	}};

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public BigDecimal getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(BigDecimal productQuantity) {
		this.productQuantity = productQuantity;
	}

}