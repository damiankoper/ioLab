package populationRegistry.registryApplication.views;

import populationRegistry.App;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

public class RegistryApplicationShowView {

  public int getApplicationId() {
    System.out.print("Numer wniosku: ");
    int id = 0;
    id = App.scanner.nextInt();
    return id;

  }

  public void displayModel(RegistryApplicationDTO dto) {
    System.out.println();
    System.out.println("--- Dane wniosku " + String.valueOf(dto.id));
    System.out.println("Imie: " + dto.firstname);
    System.out.println("Nazwisko: " + dto.surname);
    System.out.println("PESEL: " + dto.pesel);
    System.out.println("Data urodzenia: " + dto.dateOfBirth);
    System.out.println("Ulica: " + dto.street);
    System.out.println("Nr domu: " + dto.houseNumber);
    System.out.println("Nr mieszkania: " + dto.apartmentNumber);
    System.out.println("Kod pocztowy: " + dto.zipCode);
    System.out.println("Miasto: " + dto.city);
    System.out.println("Kraj: " + dto.country);
    System.out.println("Status: " + dto.status);
  }

  public void displayNotFoundError() {
    System.out.println("Nie znaleziono wniosku!");
  }
}