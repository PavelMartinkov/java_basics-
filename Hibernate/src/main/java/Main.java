import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<PurchaseList> purchases = session.createQuery("From PurchaseList").getResultList();

        for (PurchaseList purchaseList : purchases) {

            Query<Student> studentQuery = session.createQuery("From Student Where name = :name");
            studentQuery.setParameter("name", purchaseList.getStudentName());
            Student student = studentQuery.uniqueResult();

            Query<Course> courseQuery = session.createQuery("From Course Where name = :name");
            courseQuery.setParameter("name", purchaseList.getCourseName());
            Course course = courseQuery.uniqueResult();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setStudentId(Integer.parseInt(String.valueOf(student.getId())));
            linkedPurchaseList.setCourseId(Integer.parseInt(String.valueOf(course.getId())));
            linkedPurchaseList.setPrice(purchaseList.getPrice());
            linkedPurchaseList.setSubscriptionDate(purchaseList.getSubscriptionDate());
            session.save(linkedPurchaseList);
        }
        transaction.commit();
        sessionFactory.close();
    }
}
