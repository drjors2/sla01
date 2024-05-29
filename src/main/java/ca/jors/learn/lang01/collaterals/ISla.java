package ca.jors.learn.lang01.collaterals;

import java.time.LocalDateTime;

public interface ISla {
  LocalDateTime getStartDateTime();
  LocalDateTime getEndDateTime();
  LocalDateTime getDueDateTime();

}
