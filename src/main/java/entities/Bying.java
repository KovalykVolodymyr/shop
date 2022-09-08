package entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bying")
public class Bying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "totalPrice")
    protected Double totalPrice;

    @ElementCollection(fetch = FetchType.EAGER)
    protected List<BuyProduct> items;

    public Bying() {

    }

    public Bying(int id, Double totalPrice, List<BuyProduct> items) {
        super();
        this.id = id;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public Bying(Double totalPrice, List<BuyProduct> items) {
        super();
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<BuyProduct> getItems() {
        return items;
    }

    public void setItems(List<BuyProduct> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Bying [id=" + id + ", items=" + items + ", totalPrice=" + totalPrice + "]";
    }
}
