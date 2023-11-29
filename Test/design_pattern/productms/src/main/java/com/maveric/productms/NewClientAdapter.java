package com.maveric.productms;

import java.util.List;
import java.util.stream.Collectors;

public class NewClientAdapter implements IOldProductService {
	private final INewProductService newService;

	public NewClientAdapter(INewProductService newService) {
		this.newService = newService;
	}

	@Override
	public List<Product> getAll() {
		return newService.fetchAllProducts().stream().map(this::convertToProduct).collect(Collectors.toList());
	}

	@Override
	public Product findProductById(long id) {
		ProductDetails productDetails = newService.getProductById(id);
		return convertToProduct(productDetails);
	}

	private Product convertToProduct(ProductDetails productDetails) {
		return new Product(0, productDetails.getName(), productDetails.getPrice(), "", "");
	}
}
