package dependencies;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmailFilter {

    public static List filterActiveAndDelinquentUsers(List<User> users) {
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);

        List<User> filterUserList = users.stream()
                .filter(user -> user.isActive())
                .filter(user -> user.getLastPaidDate().isBefore(threeMonthsAgo))
                .collect(Collectors.toList());

        return filterUserList;

    }
}