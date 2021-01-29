package lk.ijse.dep.web.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail implements SuperEntity {

    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    private int qty;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    private Item item;

    public OrderDetail(OrderDetailPK orderDetailPK, int qty, BigDecimal unitPrice) {
        this.orderDetailPK = orderDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(String orderId, String itemCode, int qty, BigDecimal unitPrice) {
        this.orderDetailPK = new OrderDetailPK(orderId, itemCode);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

}
