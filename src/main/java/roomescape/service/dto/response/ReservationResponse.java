package roomescape.service.dto.response;

import java.time.LocalDate;
import roomescape.domain.Reservation;

public record ReservationResponse(Long id,
                                  MemberIdAndNameResponse member,
                                  LocalDate date,
                                  ReservationTimeResponse time,
                                  ThemeResponse theme) {

    public ReservationResponse(Reservation reservation) {
        this(reservation.getId(),
                new MemberIdAndNameResponse(reservation.getMember().getId(), reservation.getMember().getName()),
                reservation.getDate(),
                new ReservationTimeResponse(reservation.getReservationTime()),
                new ThemeResponse(reservation.getTheme()));

    }
}
