package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.model.AccountForm;
import demo.model.Accounts;
import demo.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	AccountService accountService;

    @ModelAttribute
    public AccountForm setupForm() {
        return new AccountForm();
    }

    @RequestMapping(value="account")
    String accountForm() {
        return "account/accountForm";
    }

    @RequestMapping(value = "account", method = RequestMethod.POST)
    String create(@Validated AccountForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "account/accountForm";
        }

        Accounts account = new Accounts();
        accountService.insert_accounts(account, form);

        return "redirect:/acount/complete";
    }

    @RequestMapping(value = "account/complete", method = RequestMethod.GET)
    String createFinish() {
        return "account/accountComplete";
    }

}