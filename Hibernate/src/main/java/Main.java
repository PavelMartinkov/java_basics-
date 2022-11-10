
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Subscription subscription = session.get(Subscription.class,new Key(2,1));
//        System.out.println(subscription.getStudent().getName() + " - " + subscription.getCourse().getName());



//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<LinkedPurchaseList> query = builder.createQuery(LinkedPurchaseList.class);
//        Root<LinkedPurchaseList> root = query.from(LinkedPurchaseList.class);
//        query.select(root);
//        List<LinkedPurchaseList> linkedPurchaseLists = session.createQuery(query).getResultList();
//
//        for (LinkedPurchaseList list : linkedPurchaseLists) {
//            System.out.println(list.getStudent().getName() + list.getCourse().getName());
//        }




//        NativeQuery query = session.createNativeQuery("INSERT INTO `linkedpurchaselist`" +
//        "(`course_id`, `price`, `student_id`, `subscription_date`)" +
//        " VALUES (1, 1000000, 1, '2022-05-19');");
//
//        query.stream().forEach(System.out::println);
//        List<Object[]> objects = query.list();
//
//        for (Object[] objects1 : objects) {
//            System.out.println(objects1);
//        }


        String hql2 = "FROM " + Course.class.getSimpleName();
        List<Course> courseList = session.createQuery(hql2).getResultList();
        for (Course course : courseList) {
            System.out.println(
                    course.getId() + " - " +
                    course.getName()
            );
        }

        String hql3 = "FROM " + Student.class.getSimpleName();
        List<Student> studentList = session.createQuery(hql3).getResultList();
        for (Student student : studentList) {
            System.out.println(
                    student.getId() + " - " +
                    student.getName()
            );
        }

        String hql1 = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = session.createQuery(hql1).getResultList();
        for (PurchaseList purchaseList : purchaseLists) {
            System.out.println(
                    purchaseList.getStudentName() + " - " +
                            purchaseList.getCourseName() + " - " +
                            purchaseList.getPrice() + " - " +
                            purchaseList.getSubscriptionDate()
            );
        }
        for (int i = 1; i < purchaseLists.size(); i++) {

            Student student = session.get(Student.class, i);
            System.out.println(student.getId() + " - " + student.getName());
            session.save(student);

            Course course = session.get(Course.class, i);
            System.out.println(course.getName());
            session.save(course);
        }



//        String hql1 = "FROM " + list + " INSERT INTO " + LinkedPurchaseList.class.getSimpleName();
//        List<LinkedPurchaseList> linkedPurchaseLists = session.createQuery(hql1).getResultList();
//
//        for (LinkedPurchaseList linkedPurchaseList : linkedPurchaseLists) {
//            System.out.println(linkedPurchaseList.getId() + " - " + linkedPurchaseList.getCourseId() + " - " + linkedPurchaseList.getPrice() +
//                    " - " + linkedPurchaseList.getStudentId() + " - " + linkedPurchaseList.getSubscriptionDate());
//        }

        transaction.commit();
        sessionFactory.close();
    }
}
