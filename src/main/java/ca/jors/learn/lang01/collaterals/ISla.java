package ca.jors.learn.lang01.collaterals;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ISla<T> {
  LocalDateTime getStartDateTime();
  LocalDateTime getEndDateTime();
  Optional<LocalDateTime> getOptionalDueDateTime();
  T start();
  T end();
}
