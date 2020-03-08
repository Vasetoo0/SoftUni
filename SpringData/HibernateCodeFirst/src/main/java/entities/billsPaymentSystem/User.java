package entities.billsPaymentSystem;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<CreditCard> creditCards;
    private Set<BankAccount> bankAccounts;

    public User() {
    }

    @Column(name = "first_name",nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @Column(name = "last_name",nullable = false,length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    @Column(name = "email",length = 80)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "owner", targetEntity = CreditCard.class,
            cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @OneToMany(mappedBy = "owner", targetEntity = BankAccount.class,
            cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
