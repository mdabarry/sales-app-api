package fr.agregio.salesapp.offer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.agregio.salesapp.park.model.Park;
import fr.agregio.salesapp.timebloc.model.TimeBloc;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Offer {
    @Id
    @GeneratedValue
    private UUID id;

    private MarketType marketType;

    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "offer_timeBloc",
               joinColumns = @JoinColumn(name = "offer_id"),
               inverseJoinColumns = @JoinColumn(name = "timeBloc_id"))
    private List<TimeBloc> blocs = new ArrayList<>();

    @ManyToMany(mappedBy = "offers")
    @JsonManagedReference
    private List<Park> parks = new ArrayList<>();

    public Offer(MarketType marketType, BigDecimal price) {
        this.marketType = marketType;
        this.price = price;
    }

    public boolean addTimeBloc(TimeBloc timeBloc) {
        return blocs.add(timeBloc);
    }
}