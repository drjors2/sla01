package ca.jors.learn.lang01.collaterals;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
public class UserSla implements ISla {

  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;

  @Setter
  private Long slaHours;

  public UserSla start() {
    this.startDateTime = LocalDateTime.now();
    return this;
  }

  public UserSla end() {
    this.endDateTime = LocalDateTime.now();
    return this;
  }

  private Optional<LocalDateTime> getOptionalEndDateTime() {
    return Optional.ofNullable(endDateTime);
  }

  private Optional<LocalDateTime> getOptionalDueDateTime() {
    return Optional
      .ofNullable(startDateTime)
      .flatMap(st -> Optional.ofNullable(slaHours).map(st::plusHours));
  }

  public LocalDateTime getDueDateTime() {
    return getOptionalDueDateTime().orElse(null);
  }

  public Boolean isSlaMet() {
    // if (getOptionalDueDateTime().isEmpty()) return null;
    // if (getEndDateTime() != null) return getEndDateTime()
    //   .isBefore(getOptionalDueDateTime().get());
    // return LocalDateTime.now().isAfter(getEndDateTime()) ? false : null;

    return (getOptionalDueDateTime().isEmpty())
      ? null
      : (getEndDateTime() != null)
        ? getEndDateTime().isBefore(getOptionalDueDateTime().get())
        : LocalDateTime.now().isAfter(getEndDateTime()) ? false : null;

  }
}
