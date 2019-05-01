package subscriptions;

import dependencies.EmailFilter;
import dependencies.User;
import dependencies.UserMailer;
import dependencies.UserRepository;

import java.util.List;

public class EmailSweeper {

    private UserRepository repository;
    private UserMailer mailer;

    public EmailSweeper(UserRepository repository, UserMailer mailer) {
        this.repository = repository;
        this.mailer = mailer;
    }

    public void sweep() {
        List<User> users = repository.getUsers();

        List<User> activeAndDelinquentUsers = EmailFilter.filterActiveAndDelinquentUsers(users);

        activeAndDelinquentUsers.forEach(user -> {
            mailer.sendBillingProblemEmailTo(user, "Please pay!");
        });
    }

}
