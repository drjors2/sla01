package ca.jors.learn.lang01.collaterals;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
public abstract class BaseSla implements ISla<BaseSla> {

  @Setter
  private Long slaHours;

  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;

  public BaseSla start() {
    this.startDateTime = LocalDateTime.now();
    return this;
  }

  public BaseSla end() {
    this.endDateTime = LocalDateTime.now();
    return this;
  }

  private Optional<LocalDateTime> getOptionalEndDateTime() {
    return Optional.ofNullable(endDateTime);
  }

  public Optional<LocalDateTime> getOptionalDueDateTime() {
    return Optional
      .ofNullable(startDateTime)
      .flatMap(st -> Optional.ofNullable(slaHours).map(st::plusHours));
  }

  public Optional<Boolean> isSlaMet() {
    return Optional.ofNullable(
      getOptionalDueDateTime()
        .map(dueDt ->
          getOptionalEndDateTime()
            .map(endDt -> endDt.isBefore(dueDt))
            .orElseGet(() -> LocalDateTime.now().isAfter(dueDt) ? false : null)
        )
        .orElse(null)
    );
  }
}
