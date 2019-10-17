# Dział ewidencji ludności
## Opis zasobów ludzkich
Pracownik urzędu gminy może wprowadzić informacje dotyczące zameldowania mieszkańca. Meldunek może być wprowadzony jako meldunek stały, czasowy, przeszły. Pracownik wprowadza wiosek dostarczony przez ubiegajacego się o meldunek mieszkańca do systemu. Pracownik może zatwierdzić lub odrzucić wniosek. Zatwierdzenie prowadzi do faktycznego zarejestrowania meldunku w systemie.
Wniosek meldunkowy zawiera dane takie jak:

* Dane osobowe mieszkańca
* Dane adresowe nowego miejsca pobytu
* Dane adresowe dotychczasowego miejsca pobytu
* Zgody i oświadczenia
* Dane identyfikujące wniosekblabla

Osoba składające wniosek nie ma dostępu do systemu. Wniosek dostarczyć można jedynie drogą papierową, osobiście, lub pocztą. Dalej wniosek przetwarzany jest przez pracowników urzędu.

## Przepisy, strategia firmy
Pracownik jest odpowiedzialny za poprawne wprowadzenie wniosku oraz odpowiada materialnie za niezdogność danych. System jest dostępny tylko dla pracowników urzędu i powinien zapewniać maksymalną prostotę i dostępność na wielu platformach.

## Dane techniczne
Wgląd do dostępnych danych i ich edycja jest możliwa za pośrednictwem strony internetowej ze względu na dużą dostępność na wszystkich platformach i w wielu miejscach bez potrzeby instalacji. Wszyscy pracownicy mają równożędne uprawnienia. Transmisja danych jest szyfrowana.

Dane wniosków są weryfikowane poprzez kontakt z systemem PESEL.

## Wymagania funkcjonalne

### Zarządzanie pracownikami
1. Pracownik może zalogować się na swoje konto i z niego się wylogować.

### Zarządanie wnioskami meldunkowymi

1. Pracownik może wyświetlić dane wniosków.
   1. Pracownik może wyświetlić wnioski tylko danego typu.
   2. Pracownik może wyszukać wniosek podając nr. PESEL.
2. Pracownik może wprowadzić wniosek meldunkowy.
   1. Pracownik może wprowadzić wniosek o typie _stały_ lub _czasowy_.
3. Pracownik może edytować dane wniosku meldunkowego.
   1. Pracownik może zmienić status wniosku - zaakceptować, lub odrzucić po podaniu powodu.
   2. Zaakceptowany wniosek zmienia się w rekord meldunku.
4. Wniosek, by być możliwym do zaakceptowania, musi zawierać komplet danych, które zgadzają się z danymi z systemu PESEL.

### Zarządzanie meldunkami

1. Pracownik może wyświetlić dane meldunków.
   1. Pracownik może wyświetlić dane meldunków tylko danego typu.
   2. Pracownik może wyszukać dane meldunku podając nr. PESEL.
3. Pracownik może edytować dane meldunków.
   1. Pracownik może zmienić status meldunku na przeszły.

## Wymagania niefunkcjonalne

1. Wszyscy użytkownicy, którzy mają dostęp do aplikacji (posiadają indywidualne konto) mają równoważne uprawnienia.
2. System rejestruje historię wszystkich zmian danych.
3. Dane transmitowane pomiędzy aplikacją, a systemem PESEL są szyfrowane.
4. W przypadku braku łączności z systemem PESEL pracownik otrzymuje ostrzeżenie o tym fakcie.