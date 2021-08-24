package models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;
import javax.validation.constraints.*;
@Entity
@Table(name="product")
public class Product extends Model {

    private  static final long serialVersionUID = -9014244086428324652L;
    @NotEmpty(message = "Field must have name = String")
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Max(value = 100000000)
    @Min(value = 0)
    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_product_category", referencedColumnName = "id")
    private ProductCategory productCategory;

    public Product() {
        super();
    }

    public Product(Long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
