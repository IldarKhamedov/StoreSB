package ru.khamedov.store.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import ru.khamedov.store.model.ProductDTO;
import ru.khamedov.store.model.Product;

import javax.annotation.Resource;
import java.util.*;

public class ProductService {

    @Resource
    private ModelMapper modelMapper;

    private  Map<Long, Product> hashMap=new HashMap();

    public ProductService() {
        fillMap(hashMap);
    }

public  List<Product> getProductList(int count){
    List<Product> productList=new ArrayList<>();
    for(int i=1;i<=count;i++){
        productList.add(new Product(Long.valueOf(i),"name"+i,100+i,10+i));
    }
    return productList;
}

private void fillMap(Map<Long,Product> map){
    map.put(1l,new Product(1l,"1",1.0,2.0));
    map.put(2l,new Product(2l,"2",1.0,2.0));
    map.put(3l,new Product(3l,"3",1.0,2.0));
}

public Product getProduct(Long id){
       if(!hashMap.containsKey(id)){
           throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
       }
        return hashMap.get(id);
}

public  Collection<Product> getAll(){
        return hashMap.values();
}

public Product createProduct(ProductDTO productDTO){
        Product product=modelMapper.map(productDTO,Product.class);
        hashMap.put(product.getId(),product);
        return product;
}
}
