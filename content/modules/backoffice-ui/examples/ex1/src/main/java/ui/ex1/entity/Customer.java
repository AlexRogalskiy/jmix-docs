package ui.ex1.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.UUID;

@JmixEntity
@Table(name = "UIEX1_CUSTOMER")
@Entity(name = "uiex1_Customer")
public class Customer {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "HOBBY")
    private String hobby;

    @InstanceName
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Email
    @Column(name = "EMAIL", unique = true, length = 100)
    private String email;

    @Column(name = "REWARD_POINTS")
    private Integer rewardPoints;

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Hobby getHobby() {
        return hobby == null ? null : Hobby.fromId(hobby);
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby == null ? null : hobby.getId();
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}