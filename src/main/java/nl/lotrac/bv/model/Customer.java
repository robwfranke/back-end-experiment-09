package nl.lotrac.bv.model;


import javax.persistence.*;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;



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

//    zorgt ervoor dat password niet in Json terecht komt, maar wel in de database
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 255)
    private String password;

    @Column
    private boolean enabled = true;

    @OneToMany (mappedBy = "customer")
    private List<Order> orders;



}