package com.example.bbb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;

@Entity
@Table(name="t_order_item")
public class OrderItem implements Comparator,Serializable {

    private static final long serialVersionUID = -188903609403774903L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_item_id", length = 100)
    private Long id;

    @Column(name="order_item_name")
    private String name;

    @Column(name="order_id1")
    private Long orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem item = (OrderItem) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        return orderId != null ? orderId.equals(item.orderId) : item.orderId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(
            name = "order_id1",
            referencedColumnName = "order_id",insertable =false,updatable = false
    )
    @JsonIgnoreProperties
    private Order order;

    public void setOrder(Order order) {
        if(null!=order){
            this.order = order;
        }

    }
    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getOrderId() {
        return orderId;
    }




    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderId=" + orderId +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 == null || o2 == null)
            return 0;
        OrderItem o = (OrderItem)o1;
        OrderItem p = (OrderItem)o2;
        return o.getName().toUpperCase().compareTo(p.getName().toUpperCase());
    }

}
