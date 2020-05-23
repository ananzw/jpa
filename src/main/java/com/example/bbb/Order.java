package com.example.bbb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name="t_order")
public class Order implements Comparator,Serializable {

    private static final long serialVersionUID = -7849861349440231763L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id", length = 100)
    private Long id;

    @Column(name="order_name")
    private String name;


    @JsonIgnoreProperties
    @OneToMany(mappedBy="order",fetch=FetchType.EAGER,cascade={CascadeType.ALL})
    private Set<OrderItem> set = new HashSet<OrderItem>(0);

    public void setSet(Set<OrderItem> set) {
            this.set = set;


    }

    public Set<OrderItem> getSet() {
        return set;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addOrderItem(OrderItem item) {
        if(null!=item&&!set.contains(item)) {
            item.setOrder(this);
            this.set.add(item);
        }
    }

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 == null || o2 == null)
            return 0;
        Order o = (Order)o1;
        Order p = (Order)o2;
        return o.getName().toUpperCase().compareTo(p.getName().toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        return name != null ? name.equals(order.name) : order.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
