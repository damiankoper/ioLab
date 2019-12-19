package populationRegistry.registryApplication.models;

/**
 * Registration
 */
public class Registration extends RegistrationBase {
  public Status status = Status.Current;

  public enum Status {
    Current("Obecny"), Outdated("Przeszly");

    private String status;

    Status(String status) {
      this.status = status;
    }

    @Override
    public String toString() {
      return status;
    }
  }
}