// SimpleNewProductServiceImpl.java
package com.maveric.productms;

import java.util.List;

public class NewProductServiceImpl implements INewProductService {
    @Override
    public ProductDetails getProductById(long id) {
        return new ProductDetails("Mixer", 5000.0);
    }

    @Override
    public List<ProductDetails> fetchAllProducts() {
        return List.of(new ProductDetails("TV", 70000.0), new ProductDetails("Music_System", 10000.0));
    }
}
