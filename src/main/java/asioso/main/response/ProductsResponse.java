package asioso.main.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import asioso.main.model.Meta;
import asioso.main.model.Product;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsResponse {
    private Meta meta;
    private Product[] products;

    public ProductsResponse () {
    }

	public ProductsResponse(Meta meta, Product[] products) {
		super();
		this.meta = meta;
		this.products = products;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}
    
    
}