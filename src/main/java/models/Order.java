package models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order")
public class Order extends Model {

    private  static final long serialVersionUID = 5232347324400724660L;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user1_id", referencedColumnName = "id")
    private User1 user;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private boolean status;

    @Column(name = "count")
    private int count;

    public Order() {
        super();
    }

    public Order(Long id) {
        super(id);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
