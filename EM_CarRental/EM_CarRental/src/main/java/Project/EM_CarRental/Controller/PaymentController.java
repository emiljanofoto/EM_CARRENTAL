package Project.EM_CarRental.Controller;


import Project.EM_CarRental.DTO.CreditCardDTO;
import Project.EM_CarRental.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment/addCreditCard")
    public void addCreditCard(@RequestBody CreditCardDTO creditCardDTO){
        paymentService.addCreditCard(creditCardDTO);


    }

    @PutMapping(("/payment/moneyTransfer"))
    public void moneyTransfer(@RequestParam Long moneyAmount){
        paymentService.moneyTransfer(moneyAmount);
    }

}
