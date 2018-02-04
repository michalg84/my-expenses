package pl.sda.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.dto.MoveCashDto;
import pl.sda.dto.TransactionDto;
import pl.sda.service.MessageService;
import pl.sda.service.TransactionService;

import javax.validation.Valid;

/**
 * Created by Michał Gałka on 2017-04-09.
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

    public static final String USER_ACCOUNT = "user/account";
    private static final String USER_TRANSACTIONS = "user/list";
    private final Logger log = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private MessageService messageService;
        @Autowired
    private TransactionService transactionService;


    @PostMapping("add")
    public String addNewTransaction(@ModelAttribute("transactionDto") @Valid TransactionDto transactionDto,
                                    BindingResult result, ModelMap modelMap) {
        if (!result.hasErrors()) {
            transactionService.addTransaction(transactionDto);
            return "redirect:/" + USER_TRANSACTIONS;
        }
        messageService.addErrorMessage("Transaction Error. Values aren't correct. Please try again.");
//        transactionList(modelMap, new MessageDto("Bad value! = " + transactionDto.getAmount()));
        return "redirect:/" + USER_TRANSACTIONS;
    }

    @PostMapping("remove/{id}")
    public String removeTransaction(@PathVariable("id") Integer transId) {
        if (transId != null) {
            transactionService.removeById(transId);
        }
        return "redirect:/" + USER_TRANSACTIONS;
    }

    @PostMapping("move")
    public String moveCashBetweenAccounts(@ModelAttribute("moveCash") MoveCashDto moveCashDto) {
        System.out.println(moveCashDto);
        transactionService.moveBetweenAccounts(moveCashDto);
        return "redirect:/" + USER_TRANSACTIONS;
    }


}