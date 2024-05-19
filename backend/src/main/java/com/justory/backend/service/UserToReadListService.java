package com.justory.backend.service;

import com.justory.backend.api.internal.UserToReadList;

import java.util.List;

public interface UserToReadListService {
    void addBookToUserToReadList(Integer userId, Integer bookId) throws Exception;
    void removeBookFromUserToReadList(Integer userId, Integer bookId);
    List<UserToReadList> getUserToReadList(Integer userId);
}
