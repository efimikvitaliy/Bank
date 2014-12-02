package BusinessService.Entities;

/**
 * @author Владимир
 * @version 1.0
 * @created 01-дек-2014 23:50:13
 */
public class CatalogRecord {

	private String id;
	private String information;
	private int price;
	private Product product;
	public Product m_Product;



	public void finalize() throws Throwable {

	}

	public CatalogRecord(){

	}

	/**
	 * 
	 * @param price
	 * @param information
	 * @param product
	 */
	public CatalogRecord(int price, String information, Product product){

	}

	public String getInformation(){
		return information;
	}

	public int getPrice(){
		return price;
	}

	public Product getProduct(){
		return product;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInformation(String newVal){
		information = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrice(int newVal){
		price = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProduct(Product newVal){
		product = newVal;
	}

}