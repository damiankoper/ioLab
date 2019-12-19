package populationRegistry.registryApplication.views;

import populationRegistry.App;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

public class RegistryApplicationUpdateView {

  public int getApplicationId() {
    System.out.print("Numer wniosku: ");
    int id = 0;
    id = App.scanner.nextInt();
    return id;
  }

  public RegistryApplicationDTO getUpdateData(RegistryApplicationDTO dto) {
    String input;
    System.out.println();
    System.out.println("--- Aktualizacja danych wniosku " + String.valueOf(dto.id));
    System.out.println("--- Pusta linia nie zmienia danych");
    input = App.scanner.nextLine();
    System.out.print("Imie[" + dto.firstname + "]: ");
    input = App.scanner.nextLine();
    dto.firstname = input.isEmpty() ? dto.firstname : input;
    System.out.print("Nazwisko[" + dto.surname + "]: ");
    input = App.scanner.nextLine();
    dto.surname = input.isEmpty() ? dto.surname : input;
    System.out.print("PESEL[" + dto.pesel + "]: ");
    input = App.scanner.nextLine();
    dto.pesel = input.isEmpty() ? dto.pesel : input;
    System.out.print("Data urodzenia[" + dto.dateOfBirth + "]: ");
    input = App.scanner.nextLine();
    dto.dateOfBirth = input.isEmpty() ? dto.dateOfBirth : input;
    System.out.print("Ulica[" + dto.street + "]: ");
    input = App.scanner.nextLine();
    dto.street = input.isEmpty() ? dto.street : input;
    System.out.print("Nr domu[" + dto.houseNumber + "]: ");
    input = App.scanner.nextLine();
    dto.houseNumber = input.isEmpty() ? dto.houseNumber : input;
    System.out.print("Nr mieszkania[" + dto.apartmentNumber + "]: ");
    input = App.scanner.nextLine();
    dto.apartmentNumber = input.isEmpty() ? dto.apartmentNumber : input;
    System.out.print("Kod pocztowy[" + dto.zipCode + "]: ");
    input = App.scanner.nextLine();
    dto.zipCode = input.isEmpty() ? dto.zipCode : input;
    System.out.print("Miasto[" + dto.city + "]: ");
    input = App.scanner.nextLine();
    dto.city = input.isEmpty() ? dto.city : input;
    System.out.print("Kraj[" + dto.country + "]: ");
    input = App.scanner.nextLine();
    dto.country = input.isEmpty() ? dto.country : input;
    System.out.print("Status[" + dto.status + "][Oczekujacy|Zaakceptowany|Odrzucony]: ");
    input = "sth";
    while (!input.equals("Oczekujacy") && !input.equals("Zaakceptowany") && !input.equals("Odrzucony")) {
      input = App.scanner.nextLine();
      if (input.isEmpty())
        break;
      dto.status = input;
    }
    return dto;
  }

  public void displayNotFoundError() {
    System.out.println();
    System.out.println("Nie znaleziono wniosku!");
  }

  public void displayNotValidError() {
    System.out.println();
    System.out.println("Blad! Dane niezgodne z systemem PESEL!");
  }

  public void displaySuccess() {
    System.out.println();
    System.out.println("Operacja przeprowadzona pomyslnie!");
  }

  public void displayCreatedRegistration() {
    System.out.println();
    System.out.println("Zaakceptowano wniosek. Utworzono rejestracje meldunku.");
  }
}