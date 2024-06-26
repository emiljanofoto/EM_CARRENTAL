package Project.EM_CarRental.Service;


import Project.EM_CarRental.Controller.SecurityController.UserLogInSecurity;
import Project.EM_CarRental.DTO.CreditCardDTO;
import Project.EM_CarRental.Entities.CreditCard;
import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Repository.CreditCardRepository;
import Project.EM_CarRental.Repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static Project.EM_CarRental.Mapper.CreditCardDTOMapper.mapToCreditCard;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {


    private final UserRepository userRepository;
    private final UserLogInSecurity userLogInSecurity;
    private final CreditCardRepository creditCardRepository;


    public void addCreditCard(CreditCardDTO creditCardDTO) {

        User user = userLogInSecurity.getUser();

        if (user.getCreditCard() != null) {

            throw new IllegalCallerException("You have a credit card already present");

        }
        CreditCard card = creditCardRepository.save(mapToCreditCard(creditCardDTO));
        user.setCreditCard(card);
        card.setUser(user);
        userRepository.save(user);
    }

    public void moneyTransfer(Long moneyAmount) {
        User user = userLogInSecurity.getUser();
        if (user.getCreditCard() == null) {
            throw new IllegalCallerException("You dont have a credit card");

        } else {
            CreditCard creditCard = user.getCreditCard();
            creditCard.setAccountBalance(creditCard.getAccountBalance() + moneyAmount);
            userRepository.save(user);


        }


    }
}
