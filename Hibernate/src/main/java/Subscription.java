import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private KeyOfSubscription id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", updatable = false, insertable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", updatable = false, insertable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public KeyOfSubscription getId() {
        return id;
    }

    public void setId(KeyOfSubscription id) {
        this.id = id;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
