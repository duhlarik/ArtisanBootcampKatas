import dependencies.*;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import subscriptions.EmailSweeper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EmailSweeperTest {


    @Test
    public void whenUserListIsEmptyItReturnsAnEmptyList() {
        List<User> userList = Arrays.asList();
        assertEquals(userList, EmailFilter.filterActiveAndDelinquentUsers(userList));
    }

    @Test
    public void whenUserIsInactiveItIsNotAddedToTheFilteredList() {
        User user1 = new User(false,
                LocalDate.of(2018, 5, 1), "");
        List<User> userList = Arrays.asList(user1);
        assertEquals(Arrays.asList(), EmailFilter.filterActiveAndDelinquentUsers(userList));
    }

    @Test
    public void whenUserHasPaidInLastThreeMonthsItIsNotInTheFilteredList() {
        User user1 = new User(true,
                LocalDate.of(2019, 5, 1), "");
        List<User> userList = Arrays.asList(user1);
        assertEquals(Arrays.asList(), EmailFilter.filterActiveAndDelinquentUsers(userList));
    }

    @Test
    public void whenUserIsEligibleTheUserIsAddedToTheFilteredList() {
        User user1 = new User(true,
                LocalDate.of(2019, 5, 1), "");
        User user2 = new User(true,
                LocalDate.of(2018, 5, 1), "");
        User user3 = new User(false,
                LocalDate.of(2019, 5, 1), "");
        User user4 = new User(false,
                LocalDate.of(2018, 5, 1), "");

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        assertEquals(Arrays.asList(user2), EmailFilter.filterActiveAndDelinquentUsers(userList));

    }

}
