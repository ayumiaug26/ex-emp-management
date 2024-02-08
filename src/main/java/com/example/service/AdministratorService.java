package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Administrator;
import com.example.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 管理者情報を挿入する.
     * 
     * @param administrator
     */
    public void insert(Administrator administrator) {
        administratorRepository.insert(administrator);
    }

    /**
     * ログイン処理を行う.
     * 
     * @param メールアドレス
     * @param パスワード
     * @return Asministrator
     */
    public Administrator login(String mailAddress, String password) {
        Administrator admin = administratorRepository.findByMailAddressAndPassword(mailAddress, password);
        return admin;
    }

}
