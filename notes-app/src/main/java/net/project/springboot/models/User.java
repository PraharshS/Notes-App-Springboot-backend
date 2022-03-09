package net.project.springboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    // @OneToMany(mappedBy = "notes", orphanRemoval = true, cascade =
    // CascadeType.ALL)
    // private List<Note> notes;

    // public List<Note> getNotes() {
    // return notes;
    // }

    // public void setNotes(List<Note> notes) {
    // this.notes = notes;
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", username=" + username + "]";
    }

}
