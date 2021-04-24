package lab.bookings.repositories;

import lab.bookings.models.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    @Query("select b from Booking b " +
            "where b.id = :id")
    Booking getBookingById(@Param("id") Long id);
}
