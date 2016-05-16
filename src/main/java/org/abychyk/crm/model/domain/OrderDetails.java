package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Currency;

/**
 * Created by abychik on 16.05.2016.
 */
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {
    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "UNIT_PRICE")
    private Currency unitPrice;
    @Column(name = "QUANTITY")
    private Long quantity;
    @Column(name = "DISCOUNT")
    private int discount;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Currency unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
