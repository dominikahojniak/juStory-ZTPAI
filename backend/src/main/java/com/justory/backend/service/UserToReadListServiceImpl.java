package com.justory.backend.service;

import com.justory.backend.api.internal.Books;
import com.justory.backend.api.internal.UserToReadList;
import com.justory.backend.api.internal.Users;
import com.justory.backend.repository.UserToReadListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserToReadListServiceImpl implements UserToReadListService {

    private final UserToReadListRepository userToReadListRepository;

    @Autowired
    public UserToReadListServiceImpl(UserToReadListRepository userToReadListRepository) {
        this.userToReadListRepository = userToReadListRepository;
    }

    public void addBookToUserToReadList(Integer userId, Integer bookId) throws Exception {
        Optional<UserToReadList> existingEntry = userToReadListRepository.findByUserIdAndBookId(userId, bookId);
        if (existingEntry.isPresent()) {
            throw new Exception("Book is already in the user's to-read list");
        }

        Users user = new Users();
        user.setId(userId);

        Books book = new Books();
        book.setId(bookId);

        UserToReadList userToReadList = new UserToReadList();
        userToReadList.setUser(user);
        userToReadList.setBook(book);
        userToReadList.setDateAdded(LocalDate.now());
        userToReadListRepository.save(userToReadList);
    }
    public List<UserToReadList> getUserToReadList(Integer userId) {
        return userToReadListRepository.findByUserId(userId);
    }

    public void removeBookFromUserToReadList(Integer userId, Integer bookId) {
        userToReadListRepository.deleteByUserIdAndBookId(userId, bookId);
    }
}