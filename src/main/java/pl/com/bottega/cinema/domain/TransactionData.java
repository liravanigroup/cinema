package pl.com.bottega.cinema.domain;

import com.stripe.model.Charge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionData implements Serializable {

    private static final long serialVersionUID = -1243581407898748720L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Temporal(TIMESTAMP)
    private Date transactionDate;
    private BigDecimal amount;
    @OneToOne(cascade = ALL)
    private Reservation reservation;
    private String currency;
    private String description;
    @Enumerated(STRING)
    private PaymentStatus status;

    public TransactionData(Reservation reservation, String currency, PaymentStatus status, String description) {
        this.transactionDate = new Date();
        this.amount = reservation.getTotalPrice();
        this.reservation = reservation;
        this.currency = currency;
        this.description = description;
        this.status = status;
    }

    public TransactionData(Charge charge, Reservation reservation) {
        this.transactionDate = new Date();
        this.amount = new BigDecimal(charge.getAmount() / 100D);
        this.reservation = reservation;
        this.currency = charge.getCurrency();
        this.description = charge.getDescription();
        this.status = PaymentStatus.valueOf(charge.getStatus().toUpperCase());
    }

    public TransactionData(Reservation reservation, String currency) {
        this.transactionDate = new Date();
        this.amount = reservation.getTotalPrice();
        this.currency = currency;
        this.description = "";
        this.status = PaymentStatus.FAILED;
    }
}
