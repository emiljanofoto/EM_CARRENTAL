package Project.EM_CarRental.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreditCardDTO {

    private Long cardNumber;
    private Integer month;
    private Integer year;
    private Integer CVV;
    private Long accountBalance;


}

