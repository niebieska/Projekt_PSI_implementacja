PSI - część implementacyjna (etap 4)

System przydzielania powierzeń
Zrealizowane przez grupę 8 (248432, 212800, 248904)

Zrealizowane przypadki użycia :
Logowanie
Tworzenie powierzeń
Zatwierdzanie planu powierzeń
Wyświetlanie planu powierzeń


1. Tworzenie/edycja dokumentów (powierzenia) tylko przez uprawnione osoby.
System zewnętrzny - Projekt_PSI_implementacja/SystemAutoryzacyjny/AuthorizationSystem/
AuthenticationController.java

        public AuthenticationController()
        {
        UserDTO admin = new UserDTO();
        admin.setEmail("mateusz.klimiuk@pwr.edu.pl");
        admin.setPassword("admin");
        admin.setRoles(Arrays.asList("ADMIN", "USER"));

        UserDTO user = new UserDTO();
        user.setEmail("mykhailo.stavniichuk@pwr.edu.pl");
        user.setPassword("user");
        user.setRoles(Arrays.asList("USER"));

        users.put(admin.getEmail(), admin);
        users.put(user.getEmail(), user);
    }

2. Kontrola zmian (rejestracja daty, rodzaju zmiany i osoby, która ją wykonała) w planach/programach/kartach przedmiotуw/planach powierzeń.
 Projekt_PSI_implementacja/Backend/AssignmentsSystem/.../AssignmentsSystem/Powierzenia/Usecase/PowierzenieService.java 
 
            WersjaPowierzenia wersja = new WersjaPowierzenia();
            wersja.setLiczbaGodzin(toSave.getLiczbaGodzin());
            wersja.setZgodaProwadzacego(toSave.isZgodaProwadzacego());
            wersja.setKurs(toSave.getKurs());
            wersja.setProwadzacy(toSave.getUzytkownik());
            wersja.setKoordynatorID(koordynator.get().getId());
            wersja.setWersja(toSave.getWersjePowierzen().stream().map(WersjaPowierzenia::getWersja)
                    .max(Comparator.comparing(Integer::valueOf)).orElse(-1) + 1);
            toSave.getWersjePowierzen().add(wersja);
            planPowierzen.getPowierzenia().add(toSave);
            //TODO jeszcze koordynator - chyba jest
            planPowierzenRepository.save(planPowierzen);

3. Wydajne pobieranie danych (zapytania, przeglądanie) – średni czas odpowiedzi systemu poniżej 5 s przy obciążeniu do 200 użytkowników.
Konfiguracja MemCache MemcachedConfiguration.java 
(Projekt_PSI_implementacja/Backend/AssignmentsSystem/.../AssignmentsSystem/Commons/MemCached/MemcachedConfiguration.java )

Przykład zastosowania 
Projekt_PSI_implementacja/Backend/AssignmentsSystem/.../AssignmentsSystem/Kursy/Usecase/PlanStudiowService.java 
          @Cacheable("PlanStudiowIdentifier")

