package com.minhaapi.bootcamp_santander_dio.service.impl;

import com.minhaapi.bootcamp_santander_dio.domain.model.User;
import com.minhaapi.bootcamp_santander_dio.domain.repository.UserRepository;
import com.minhaapi.bootcamp_santander_dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }else {
            throw new NoSuchElementException("Usuário com ID " + id + " não existe");
        }
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Esse número de conta já existe! / This account number already exists!");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public void update(Long id, User userToUpdate) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {

            User user = userOptional.get();
            user.setName(userToUpdate.getName());
            user.setAccount(user.getAccount());
            user.setCard(userToUpdate.getCard());
            user.setFeature(userToUpdate.getFeature());
            user.setNews(userToUpdate.getNews());

            userRepository.save(user);
        }
        else{
            throw new IllegalArgumentException("Esse número de conta  não existe! / This account number not exists!");
        }
    }


    @Override
    public void deleteUser(Long id) {
        verifyId(id);
        userRepository.deleteById(id);
    }

    private void verifyId(Long id){
        if(!userRepository.existsById(id)){
            throw new NoSuchElementException("Usuário  com ID: "+ id + " não encontrado ! / User with ID: "+ id + " not found!  ");
        }
    }

}
