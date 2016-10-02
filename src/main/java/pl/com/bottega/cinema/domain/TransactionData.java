package pl.com.bottega.cinema.domain;

import com.stripe.model.Charge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionData implements Serializable{

    private static final long serialVersionUID = -1243581407898748720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date transactionDate;
    private BigDecimal amount;
    @OneToOne
    private Reservation reservation;

    private String currency;
    private String description;
    private String status;

    public TransactionData(Reservation reservation, String currency, String paymentStatus, Date transactionDate, String description) {
        this.transactionDate = transactionDate;
        this.amount = reservation.getTotalPrice();
        this.reservation = reservation;
        this.currency = currency;
        this.description = description;
        this.status = paymentStatus;
    }

    public TransactionData(Charge charge, Reservation reservation) {
        this.transactionDate = new Date(charge.getCreated());
        this.amount = new BigDecimal(charge.getAmount());
        this.reservation = reservation;
        this.currency = charge.getCurrency();
        this.description = charge.getDescription();
        this.status = charge.getStatus();
    }

    public TransactionData(Reservation reservation, String currency) {
        this.transactionDate = new Date();
    }
}
