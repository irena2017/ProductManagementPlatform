package asioso.main.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import asioso.main.model.Meta;
import asioso.main.model.Product;
import asioso.main.model.Vendor;
import asioso.main.response.ProductsResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

@Repository
public class ProductClient {
    private static final String PRODUCTS_ENDPOINT = "https://api.predic8.de/shop/v2/products/";

    public Meta getMeta() throws Exception {
        String url = PRODUCTS_ENDPOINT;
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        String responseBody = EntityUtils.toString(httpClient.execute(request).getEntity());
        
        ObjectMapper objectMapper = new ObjectMapper();
        ProductsResponse response = objectMapper.readValue(responseBody, ProductsResponse.class);
        return response.getMeta();
    }
    
    public Product[] getAllProducts() throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        String url = PRODUCTS_ENDPOINT;
        ObjectMapper objectMapper = new ObjectMapper();
        ProductsResponse response;
        List<Product> allProducts = new ArrayList<>();
        
        do {
            HttpGet request = new HttpGet(url);
            String responseBody = EntityUtils.toString(httpClient.execute(request).getEntity());
            response = objectMapper.readValue(responseBody, ProductsResponse.class);
            if (response.getProducts() != null) {
                allProducts.addAll(Arrays.asList(response.getProducts()));
            }
            String nextLink = response.getMeta().getNext_link();
            url = nextLink != null ? "https://api.predic8.de" + nextLink : null;
        } while (url != null);
        
        return allProducts.toArray(new Product[0]);
    }

    public Product[] getProductsByLink(String link) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://api.predic8.de" + link);
        String responseBody = EntityUtils.toString(httpClient.execute(request).getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        ProductsResponse response = objectMapper.readValue(responseBody, ProductsResponse.class);
        return response.getProducts();
    }

    public Product getProductById(int id) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(PRODUCTS_ENDPOINT + id);
        String responseBody = EntityUtils.toString(httpClient.execute(request).getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(responseBody, Product.class);
        
        String imageUrl = "https://api.predic8.de/shop/v2/products/" + id + "/image";
        product.setImage_link(imageUrl);
        
        List<Vendor> vendors = product.getVendors();
        String vendorsUrl = "https://api.predic8.de/" + product.getSelf_link();

        if (vendors != null && !vendors.isEmpty()) {
            for (Vendor vendor : vendors) {
                vendor.setSelf_link(vendorsUrl);
            }
        } else {
            vendors = null;
        }

        product.setVendors(vendors);
        return product;

    }
    
}



