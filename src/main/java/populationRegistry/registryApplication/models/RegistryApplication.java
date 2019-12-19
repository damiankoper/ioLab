package populationRegistry.registryApplication.models;

/**
 * RegistryApplication
 */
public class RegistryApplication extends RegistrationBase {
  public Status status = Status.Pending;

  public enum Status {
    Pending("Oczekujacy"), Accepted("Zaakceptowany"), Revoked("Odrzucony");

    private String status;

    Status(String status) {
      this.status = status;
    }

    @Override
    public String toString() {
      return status;
    }

    public static Status valueOfLabel(String label) {
      for (Status e : values()) {
        if (e.status.equals(label)) {
          return e;
        }
      }
      return null;
    }
  }
}