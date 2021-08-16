package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class Role extends Model {

    private  static final long serialVersionUID = 3585034474308003857L;

    @Column(name = "title")
    private String title;

   @ManyToMany(mappedBy = "roles")
    private Set<User1> users = new HashSet<>();

    public Role() {
        super();
    }

    public Role(Long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User1> getUsers() {
        return users;
    }

    public void setUsers(Set<User1> users) {
        this.users = users;
    }
}
