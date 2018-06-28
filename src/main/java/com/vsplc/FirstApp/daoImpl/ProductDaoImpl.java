package com.vsplc.FirstApp.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.vsplc.FirstApp.dao.AbstractDao;
import com.vsplc.FirstApp.dao.ProductDao;
import com.vsplc.FirstApp.model.Product;

@Repository("productDao")
public class ProductDaoImpl  extends AbstractDao<Integer, Product> implements ProductDao{

	/*List all product*/
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("productName"));//order by product name
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Product> product = (List<Product>) criteria.list();
        return product;
	}

	@Override
	public void saveProduct(Product product) {
		
	}

}
