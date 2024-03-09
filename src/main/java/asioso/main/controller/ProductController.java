package asioso.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import asioso.main.client.ProductClient;
import asioso.main.model.Meta;
import asioso.main.model.Product;

@Controller
public class ProductController {

    @Autowired
    private ProductClient productClient;
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @GetMapping("/products")
    public String getAllProducts(Model model) {
        try {
            Product[] allProducts = productClient.getAllProducts();
            model.addAttribute("products", allProducts);
            
            Meta meta = productClient.getMeta();
            String nextLink = meta.getNext_link();
            String prevLink = meta.getPrevious_link();
            model.addAttribute("nextLink", nextLink);
            model.addAttribute("prevLink", prevLink);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred while fetching products.");
        }
        return "products";
    }
    
    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        try {
            Product product = productClient.getProductById(id);
            model.addAttribute("product", product);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred while fetching the product.");
        }
        return "product-detail";
    }


}