package populationRegistry.registryApplication.models;

/**
 * RegistryApplicationData
 */
public abstract class RegistrationBase {
  public int id = -1;
  protected RegistryAddressData addressData = new RegistryAddressData();
  protected RegistryPersonalData personalData = new RegistryPersonalData();

  /**
   * @return the addressData
   */
  public RegistryAddressData getAddressData() {
    return addressData;
  }

  /**
   * @return the personalData
   */
  public RegistryPersonalData getPersonalData() {
    return personalData;
  }
}
