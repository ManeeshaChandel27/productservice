package dev.tarun.productservice.services;

import dev.tarun.productservice.models.Category;
import dev.tarun.productservice.models.Product;
import dev.tarun.productservice.repositories.CategoryRepository;
import dev.tarun.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category getCategory(String uuid) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();

        List<Product> products = category.getProducts();


        return category;
    }

//    public List<String> getProductTitles(List<String> categoryUUIDs) {
//        List<UUID> uuids = new ArrayList<>();
//
//        for (String uuid: categoryUUIDs) {
//            uuids.add(UUID.fromString(uuid));
//        }
////
////        List<Category> categories = categoryRepository.findAllById(uuids);
////
////
////        List<String> titles = new ArrayList<>();
////
////        categories.forEach(
////                category -> {
////                    category.getProducts().forEach(
////                            product -> {
////                                titles.add(product.getTitle());
////                            }
////                    );
////                }
////        );
////
////
////        return titles;
//
//        List<Category> categories = categoryRepository.findAllById(uuids);
//
//        List<Product> products = productRepository.findAllByCategoryIn(categories);
//
//        List<String> titles = new ArrayList<>();
//
//        for (Product p: products) {
//            titles.add(p.getTitle());
//        }
//
//        return titles;
//    }
}