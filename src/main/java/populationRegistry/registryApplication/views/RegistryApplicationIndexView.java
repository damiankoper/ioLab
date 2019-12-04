package populationRegistry.registryApplication.views;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import populationRegistry.App;
import populationRegistry.registryApplication.services.dto.FilterDataDTO;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;
import populationRegistry.registryApplication.views.dto.TableDTO;

public class RegistryApplicationIndexView {

  public FilterDataDTO getFilterData() {
    System.out.print("Włączyć filtrowanie? [y|n]: ");
    FilterDataDTO dto = new FilterDataDTO();
    String input = "";
    while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
      input = App.scanner.nextLine();
    }
    if (input.equalsIgnoreCase("y")) {
      System.out.print("Podaj imiona lub nazwiska (pusta linia aby zakończyć): ");
      while (!input.isEmpty()) {
        input = App.scanner.nextLine();
        dto.names.add(input);
      }
      input = "sth";
      System.out.print("Podaj numery PESEL (pusta linia aby zakończyć): ");
      while (!input.isEmpty()) {
        input = App.scanner.nextLine();
        dto.pesels.add(input);
      }
    }
    return dto;
  }

  public void displayTable(TableDTO dto) {
    System.out.println();
    System.out
        .println(String.format(dto.headerFormat.stream().collect(Collectors.joining(" | ")), dto.header.toArray()));
    System.out.println("-".repeat(120));
    for (LinkedList<String> row : dto.body) {
      System.out.println(String.format(dto.bodyFormat.stream().collect(Collectors.joining(" | ")), row.toArray()));
    }
    System.out.println();
  }

  public void displayNoRecordsInfo() {
    System.out.println("Nie znaleziono wniosków!");
  }

}