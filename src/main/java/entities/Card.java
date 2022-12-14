package entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Card {

    Product product;
    Integer count;
    Double totalPrice;

    public Card(Product product, Integer count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalPrice() {
        return product.price * count;
    }

    @Override
    public String toString() {
        return "Card [count=" + count + ", product=" + product + ", totalPrice=" + totalPrice + "]";
    }
}
