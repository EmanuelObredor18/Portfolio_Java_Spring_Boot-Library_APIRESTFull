package com.obredor.library.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obredor.library.controllers.base.BaseController;
import com.obredor.library.models.embeddables.UserId;
import com.obredor.library.models.entities.User;
import com.obredor.library.services.UserService;

@RestController
@RequestMapping("library/api/v1/user")
public class UserController extends BaseController<User, UserId, UserService>{

}
