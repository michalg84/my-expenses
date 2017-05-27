package pl.sda.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Michał Gałka on 2017-04-07.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String mail;
    @Column
    private String password;
//    @OneToMany(mappedBy = "user")
//    private List<Transaction> transactionList;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Account> accounts;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
//    @Column
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Category> categories;


    public User() {
    }

//    public User(String username, String login, String mail, String password,
//                List<Transaction> transactionList, List<Account> accounts, List<Category> categories) {
//        this.username = username;
//        this.login = login;
//        this.mail = mail;
//        this.password = password;
//        this.transactionList = transactionList;
//        this.accounts = accounts;
//        this.categories = categories;
//    }




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





    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Transaction> getTransactionList() {
//        return transactionList;
//    }
//
//    public void setTransactionList(List<Transaction> transactionList) {
//        this.transactionList = transactionList;
//    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }
//
//    public List<Category> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(List<Category> categories) {
//        this.categories = categories;
//    }
}



