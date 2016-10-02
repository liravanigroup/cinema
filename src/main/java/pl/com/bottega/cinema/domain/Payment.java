package pl.com.bottega.cinema.domain;

import com.stripe.model.Charge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment implements Serializable{

    private static final long serialVersionUID = -3247581407898748720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentType type;
    private Long cashierId;
    private Boolean isSuccessful;
    @OneToOne(cascade = CascadeType.ALL)
    private TransactionData transactionData;

    public Payment(PaymentType type, Charge charge, Reservation reservation) {
        this.type = type;
        this.isSuccessful = charge.getPaid();
        this.transactionData = new TransactionData(charge, reservation);
    }

    public Payment(PaymentType type, Long cashierId, boolean isSuccessful, TransactionData transactionData) {
        this(null, type, cashierId, isSuccessful, transactionData);
    }

    public Payment(PaymentType type, String currency, Reservation reservation) {
        this.type = type;
        this.isSuccessful = false;
        this.transactionData = new TransactionData(reservation, currency);
    }

    public boolean isPayedByCard() {
        return type == PaymentType.CREDIT_CARD;
    }

    public boolean isIsSuccessful() {
        return isSuccessful;
    }
}
