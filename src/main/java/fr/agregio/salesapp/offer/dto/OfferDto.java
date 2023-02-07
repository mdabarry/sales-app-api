package fr.agregio.salesapp.offer.dto;

import fr.agregio.salesapp.offer.model.MarketType;
import fr.agregio.salesapp.park.dto.ParkDto;
import fr.agregio.salesapp.timebloc.dto.TimeBlocDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OfferDto(UUID id, MarketType marketType, BigDecimal price, List<TimeBlocDto> blocs, List<ParkDto> parks) {
}