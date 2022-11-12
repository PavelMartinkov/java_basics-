import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int age;

    @Column(name = "registration_date", nullable = true)
    private Date registrationDate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
