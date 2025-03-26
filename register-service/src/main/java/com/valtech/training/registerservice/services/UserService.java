package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO addUserToSubscription(UserVO userVO, long id);

	UserVO createUser(UserVO userVO);

	List<UserVO> getAllUsers();

	UserVO getUser(long id);

}