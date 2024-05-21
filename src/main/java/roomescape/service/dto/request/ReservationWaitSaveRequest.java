package roomescape.service.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import roomescape.domain.ReservationTime;
import roomescape.domain.ReservationWait;
import roomescape.domain.ReservationWaitStatus;
import roomescape.domain.Theme;
import roomescape.domain.member.Member;

public record ReservationWaitSaveRequest(@NotNull(message = "예약 날짜를 입력해주세요.") LocalDate date,
                                         @NotNull(message = "예약 시간을 입력해주세요.") Long time,
                                         @NotNull(message = "예약 테마를 입력해주세요.") Long theme) {

    public ReservationWait toEntity(ReservationTime reservationTime, Theme theme, Member member) {
        return new ReservationWait(member, date, reservationTime, theme, ReservationWaitStatus.WAITING);
    }
}
