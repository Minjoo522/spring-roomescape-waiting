package roomescape.service.dto.response.reservation;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import roomescape.domain.Reservation;
import roomescape.domain.ReservationWait;

public record UserReservationResponses(List<UserReservationResponse> reservations) {

    public static UserReservationResponses from(List<Reservation> reservations) {
        List<UserReservationResponse> responses = reservations.stream()
                .map(UserReservationResponse::new)
                .toList();
        return new UserReservationResponses(responses);
    }

    public static UserReservationResponses of(List<Reservation> reservations, List<ReservationWait> reservationWaits) {
        List<UserReservationResponse> responses = Stream.concat(mapToReservation(reservations).stream(),
                        mapToReservationWaits(reservationWaits).stream())
                .sorted(Comparator.comparing(r -> LocalDateTime.of(r.date(), r.time())))
                .toList();
        return new UserReservationResponses(responses);
    }

    private static List<UserReservationResponse> mapToReservation(List<Reservation> reservation) {
        return reservation.stream()
                .map(UserReservationResponse::new)
                .toList();
    }

    private static List<UserReservationResponse> mapToReservationWaits(List<ReservationWait> reservationWaits) {
        return reservationWaits.stream()
                .map(UserReservationResponse::new)
                .toList();
    }
}
