package phonebook.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import phonebook.client.PhonebookClient;
import phonebook.container.dto.UserDto;
import phonebook.container.dto.UserOperation;
import phonebook.container.dto.UserRequestData;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final PhonebookClient phonebookClient;

    @GetMapping("/")
    public String listUsers(Model model) {
        List<UserDto> users = phonebookClient.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("userEntity", new UserRequestData());
        return "user.html";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute UserRequestData userRequestData, Model model) {
        var userOperation = phonebookClient.postUser(userRequestData);
        model.addAttribute("operation", userOperation);
        return "operation";
    }

    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute UserRequestData userRequestData, Model model) {
        UserOperation userOperation = phonebookClient.editUser(userRequestData);
        model.addAttribute("operation", userOperation);
        return "operation";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@ModelAttribute UserRequestData userRequestData, Model model) {
        UserOperation userOperation = phonebookClient.deleteUser(userRequestData);
        model.addAttribute("operation", userOperation);
        return "operation";
    }

    @GetMapping("/status")
    public String status(Model model) {
        var status = phonebookClient.status().getStatus().value();
        model.addAttribute("status", status);
        return "status.html";
    }
}
