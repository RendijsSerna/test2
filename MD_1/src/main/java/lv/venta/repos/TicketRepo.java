package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import lv.venta.models.Ticket;

public interface TicketRepo extends CrudRepository<Ticket, Long> {

}
