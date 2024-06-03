package Project.EM_CarRental.Mapper;


import Project.EM_CarRental.DTO.CreditCardDTO;
import Project.EM_CarRental.Entities.CreditCard;
import org.springframework.stereotype.Service;

@Service
public class CreditCardDTOMapper {

    public CreditCard mapToCreditCard(CreditCardDTO creditCardDTO) {

        return CreditCard.builder()
                .cardNumber(creditCardDTO.getCardNumber())
                .month(creditCardDTO.getMonth())
                .year(creditCardDTO.getYear())
                .CVV(creditCardDTO.getCVV())
                .accountBalance(0L)
                .build();
    }
}
