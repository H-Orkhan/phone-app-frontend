package phonebook.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import phonebook.container.dto.StatusDto;
import phonebook.container.dto.UserDto;
import phonebook.container.dto.UserOperation;
import phonebook.container.dto.UserRequestData;

import java.util.List;


@FeignClient(value = "phonebook-api", url = "${backend.phonebook-backend-api}")
public interface PhonebookClient {

    @GetMapping(value = "/user/list", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> getAllUsers();

    @PostMapping(value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
    UserRequestData postUser(@RequestBody UserRequestData userRequestData);

    @PutMapping(value = "/user/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    UserOperation editUser(@RequestBody UserRequestData userRequestData);

    @DeleteMapping(value = "/user/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    UserOperation deleteUser(@RequestBody UserRequestData userRequestData);

    @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    StatusDto status();
}
