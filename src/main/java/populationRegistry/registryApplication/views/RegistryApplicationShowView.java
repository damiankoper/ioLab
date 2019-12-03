package populationRegistry.registryApplication.views;

import java.util.Scanner;

import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

public class RegistryApplicationShowView {

  public int getApplicationId() {
    System.out.println("Numer wniosku: ");
    int id = 0;
    Scanner scanner = new Scanner(System.in);
    id = scanner.nextInt();
    scanner.close();
    return id;
  }

  public void displayModel(RegistryApplicationDTO dto) {
    System.out.println("Imię: " + dto.firstname);
    System.out.println("Nazwisko: " + dto.firstname);
    System.out.println("PESEL: " + dto.pesel);
    System.out.println("Data urodzenia: " + dto.dateOfBirth);
    System.out.println("Ulica: " + dto.street);
    System.out.println("Nr domu: " + dto.houseNumber);
    System.out.println("Nr mieszkania: " + dto.apartmentNumber);
    System.out.println("Kod pocztowy: " + dto.zipCode);
    System.out.println("Miasto: " + dto.city);
    System.out.println("Kraj: " + dto.country);
  }

  public void displayNotFoundError() {
    System.out.println("Nie znalezioono wniosku!");
  }

  public void displayNotValidError() {
    System.out.println("Bład! Dane niezgodne z systemem PESEL!");
  }

  public void displaySuccess() {
    System.out.println("Operacja przeprowadzona pomyślnie!");
  }
}