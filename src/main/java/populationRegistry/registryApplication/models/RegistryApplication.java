package populationRegistry.registryApplication.models;

/**
 * RegistryApplication
 */
public class RegistryApplication extends RegistrationBase {
  public Status status = Status.Pending;

  public enum Status {
    Pending("Oczekujący"), Accepted("Zaakceptowany"), Revoked("Odrzucony");

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