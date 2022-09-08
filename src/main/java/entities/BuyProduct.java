package entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class BuyProduct {

    Integer productId;
    Integer count;

    public BuyProduct() {

    }

    public BuyProduct(Integer productId, Integer count) {
        this.productId = productId;
        this.count = count;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BuyProduct [count=" + count + ", productId=" + productId + "]";
    }
}
