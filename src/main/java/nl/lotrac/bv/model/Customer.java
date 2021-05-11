package nl.lotrac.bv.model;
import javax.persistence.*;
import java.util.List;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



//@Getter
//@Setter
@Entity
@Table(name = "customers")
@EqualsAndHashCode
@ToString
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //    @Id
    @Column(nullable = false, unique = true)
    private String customername;

    @Column(length = 255)
    private String street;

    @Column(length = 255)
    private String city;

    @Column(length = 255)
    private String postal_code;

    @Column
    private String email;

    @Column(length = 255)
    private String tel_number;

    @Column(nullable = false, length = 255)
    private String password;

    @Column
    private boolean enabled = true;

//    customer haalt spring uit veld customer in de @MayToOne in order
//
//    @ManyToOne
//    Customer customer;

//    Vegeet niet getter en setter van List<Order> aan te maken
//

    @OneToMany (mappedBy = "customer")
    private List<Order> orders;

    //  waarom is apikey nodig????
    @Column
    private String apikey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}