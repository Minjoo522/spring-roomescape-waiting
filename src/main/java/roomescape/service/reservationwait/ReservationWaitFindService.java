package roomescape.service.reservationwait;

import java.util.List;
import org.springframework.stereotype.Service;
import roomescape.domain.ReservationWaitWithRank;
import roomescape.repository.ReservationWaitRepository;

@Service
public class ReservationWaitFindService {

    private final ReservationWaitRepository reservationWaitRepository;

    public ReservationWaitFindService(ReservationWaitRepository reservationWaitRepository) {
        this.reservationWaitRepository = reservationWaitRepository;
    }

    public List<ReservationWaitWithRank> findUserReservationWaits(long memberId) {
        return reservationWaitRepository.findReservationWaitWithRankByMemberId(memberId);
    }
}
