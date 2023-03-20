package ru.yandex.practicum.filmorate.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User add(@Valid @RequestBody User user) {
        log.info("POST запрос на создание пользователя");
        return userService.add(user);
    }

    @PutMapping("/{id}/friends/{friendId}")
    public List<Long> addFriend(@PathVariable long id, @PathVariable long friendId) {
        log.info("PUT запрос на добавление в друзья");
        return userService.addFriend(id, friendId);
    }

    @GetMapping
    public List<User> getAll() {
        log.info("GET запрос на получение списка всех пользователей");
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable long id) {
        log.info("GET запрос на получение пользователя");
        return userService.get(id);
    }

    @GetMapping("/{id}/friends")
    public List<User> getUserFriends(@PathVariable long id) {
        log.info("GET запрос на получение списка друзей");
        return userService.getUserFriends(id);
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public List<User> getMutualUsersFriends(@PathVariable long id, @PathVariable long otherId) {
        log.info("GET запрос на получение списка общих друзей");
        return userService.getMutualFriends(id, otherId);
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) {
        log.info("PUT запрос на обновление пользователя");
        return userService.update(user);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public List<Long> deleteFriend(@PathVariable long id, @PathVariable long friendId) {
        log.info("DELETE запрос на удаление из друзей");
        return userService.deleteFriend(id, friendId);
    }

}
