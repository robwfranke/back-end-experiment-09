package nl.lotrac.bv.model;
import javax.persistence.*;
import java.util.List;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
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

    @OneToMany (mappedBy = "customer")
    private List<Order> orders;

    //  waarom is apikey nodig????
    @Column
    private String apikey;


}