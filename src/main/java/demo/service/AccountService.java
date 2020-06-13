package demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.model.AccountForm;
import demo.model.Accounts;
import demo.repository.AccountsRepository;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountsRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    /* 登録処理 */
    public void insert_accounts(Accounts account,AccountForm form) {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        Date now = new Date();
        account.setMailAddress(form.getEmail());
        account.setPassword(encodedPassword);
        account.setUpdatedAt(now);
        account.setCreatedAt(now);
        accountRepository.insert(account);
        System.out.println("登録完了");
    }
}
