package com.test.SpringBootApplication.dao;

import com.test.SpringBootApplication.dao.entity.Product;
import com.test.SpringBootApplication.model.ProductRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findProductBasedOnFilter(ProductRequest productRequest) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);

        Root<Product> product = query.from(Product.class);

        List<Predicate> predicates = getWhereClause(productRequest, criteriaBuilder, product);

        query.select(product)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(query).getResultList();
    }

    private List<Predicate> getWhereClause(ProductRequest productRequest, CriteriaBuilder cb, Root<Product> productRoot) {
        List<Predicate> predicates = new ArrayList<>();

        if (nonNull(productRequest.getType())) {
            predicates.add(cb.equal(productRoot.get("type"), productRequest.getType().getValue()));
        }

        if (isNotEmpty(productRequest.getColor())) {
            predicates.add(cb.equal(productRoot.get("color"), productRequest.getColor()));
        }

        if (isNotEmpty(productRequest.getCity())) {
            predicates.add(cb.like(productRoot.get("address"), "%" + productRequest.getCity() + "%"));
        }

        if (nonNull(productRequest.getMax_price())) {
            predicates.add(cb.lessThanOrEqualTo(productRoot.get("price"), productRequest.getMax_price().intValue()));
        }

        if (nonNull(productRequest.getMin_price())) {
            predicates.add(cb.greaterThanOrEqualTo(productRoot.get("price"), productRequest.getMin_price().intValue()));
        }

        if (nonNull(productRequest.getGb_limit_min())) {
            predicates.add(cb.greaterThanOrEqualTo(productRoot.get("gblimit"), productRequest.getGb_limit_min().doubleValue()));
        }

        if (nonNull(productRequest.getGb_limit_max())) {
            predicates.add(cb.lessThanOrEqualTo(productRoot.get("gblimit"), productRequest.getGb_limit_max().doubleValue()));
        }

        return predicates;
    }
}