package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="user1")
public class User1 extends Model  {

    private  static final long serialVersionUID = 2652734099115769567L;

    @Column(name="age", length = 10)
    private int age;
    @Column(name="firstname")
    private String firstName;
    @Column(name="secondname")
    private String secondName;

    @ManyToMany
    @JoinTable(name="user1_role",
            joinColumns = {@JoinColumn(name="user1_id")}, inverseJoinColumns = {@JoinColumn(name="role_id")})
    private Set<Role> roles = new HashSet<>();

    public User1() {
        super();
    }

    public User1(Long id) {
        super(id);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
