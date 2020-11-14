package runners.training_runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.booking.BookingAddToFavorites;
import tests.booking.BookingHeaderElements;
import tests.booking.BookingNewUser;
import tests.training.training_tests.Common;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookingAddToFavorites.class,
        BookingHeaderElements.class,
        BookingNewUser.class
})
public class BookingJUnitRunner {
}
