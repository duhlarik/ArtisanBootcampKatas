import dependencies.User;
import dependencies.UserMailer;
import dependencies.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import subscriptions.EmailSweeper;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class EmailSweeperTest_Mockito {

    private UserRepository mockUserRepository = mock(UserRepository.class);
    private UserMailer mockUserMailer = mock(UserMailer.class);
    private EmailSweeper sweeper = new EmailSweeper(mockUserRepository, mockUserMailer);

    @Test
    public void whenSweeperIsCalledAnEmailIsSentToARecipientWithAMessage() {
        User user = new User(true,
                LocalDate.of(2019, 5, 1), "");

        when(mockUserRepository.getUsers()).thenReturn(Arrays.asList(user));

        sweeper.sweep();

        verify(mockUserMailer).sendBillingProblemEmailTo(user,"");
    }

    @Test
    public void whenSweeperIsCalledAnEmailIsSentToActiveUsers() {
        when(mockUserRepository.getUsers()).thenReturn(Arrays.asList(
                new User(false, LocalDate.of(2019, 5, 1), "Bill"),
                new User(true, LocalDate.of(2019, 5, 1), "Paula")));

        sweeper.sweep();

        verify(mockUserMailer).sendBillingProblemEmailTo(mockUserRepository.getUsers().get(1),"");
    }

    @Test
    @Ignore
    public void whenSweeperIsCalledAnEmailIsSentToDelinquentUsers(){
        when(mockUserRepository.getUsers()).thenReturn(Arrays.asList(
                new User(true, LocalDate.of(2019, 5, 1), "Bill"),
                new User(true, LocalDate.of(2018, 5, 1), "Paula")));

        sweeper.sweep();

        verify(mockUserMailer).sendBillingProblemEmailTo(mockUserRepository.getUsers().get(1),"");
    }
}
