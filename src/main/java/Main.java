
import models.Product;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.math.BigDecimal;
import java.util.List;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();

//            saveMethod(session, "Vodka", "STOLICHNAYA", 1000);
//            saveMethod(session, "Meat", "PORK", 400);
//
//            Query query = session.createQuery("delete FROM Product where id = ?");

            Criteria criteria = session.createCriteria(Product.class, "product");
//            criteria.add(Restrictions.eq("title", "MILK"));
//            criteria.add(Restrictions.like("price", BigDecimal.valueOf(10)));
            criteria.createCriteria("ProductCategory.product", "product");
            criteria.add(Restrictions.eq("ProductCategory.title", "MILK"));
            products = criteria.list();

            products.stream().forEach(System.out :: println);
            session.getTransaction().commit();
        } catch (Exception t) {
            session.getTransaction().rollback();
            logger.error("It`s error", t);
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
/* Валидация
    public static void main(String[] args) {

        Validator validator;
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }
        Product product = new Product();
        Set<ConstraintViolation<Product>> consV = validator.validate(product);
        for (ConstraintViolation<Product> c : consV) {
            StringBuilder sb = new StringBuilder("Property: ");
            sb.append(c.getPropertyPath());
            sb.append("value: ");
            sb.append(c.getInvalidValue());
            sb.append("message: ");
            sb.append(c.getMessage());
            System.out.println(sb.toString());
        }
    }*/

    private static void saveMethod(Session session, String a, String b, int c) {
        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(c));
        product.setDescription(a);
        product.setTitle(b);
        session.save(product);
    }
}
