package pl.com.bottega.cinema.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.com.bottega.cinema.api.request.dto.PaymentDto;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollectPaymentRequest {

    private PaymentDto paymentDto;

    public void validate(){
        // TODO: 01.10.2016
    }

}
