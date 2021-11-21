import contracts.ContractDefault;
import contracts.ContractEthernet;
import contracts.ContractMobile;
import contracts.ContractTV;
import entities.Person;
import helpers.Gender;
import org.junit.Test;
import repository.Repository;
import sorters.BubbleSorter;
import sorters.QuickSorter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Random;

public class exercise2 {
    String[][] names = new String[][]{
            {"Nikita", "Vyacheslav", "Vladislav"},
            {"Lena", "Ekaterina", "Maria"}
    };
    String[][] secondNames = new String[][]{
            {"Kryuchkov", "Kartashov", "Yakushihin"},
            {"Popova", "Shilyaeva", "Konchakova"}
    };
    String[] channels = new String[]{"First Channel", "TNT", "STS", "Disney", "Russia", "TV3", "MusicTV", "Karusel", "Nikelodion", "Kids"};
    Random r = new Random();

    @Test
    public void search() {
        Repository contracts = new Repository();
        int amount = r.nextInt(10), typeOfContract, name, secondName, gender, speed, aChannel, aSms, aMinutes, aGB, y, m, d, yc, mc, dc, sPassport, nPassport;
        System.out.println(amount + " contracts are registered in the system!");
        for (int i = 0; i < amount; i++) {
            typeOfContract = r.nextInt(3) + 1;
            name = r.nextInt(3);
            secondName = r.nextInt(3);
            gender = r.nextInt(2);
            y = 2002 - r.nextInt(70);
            m = r.nextInt(12) + 1;
            d = r.nextInt(28) + 1;
            sPassport = r.nextInt(8999) + 1000;
            nPassport = r.nextInt(899999) + 100000;
            Person human = new Person(i + 1, names[gender][name] + " " + secondNames[gender][secondName], LocalDate.of(y, m, d), Gender.values()[gender], sPassport + " " + nPassport);
            switch (typeOfContract) {
                case 1 -> {
                    speed = r.nextInt(500);
                    contracts.add(new ContractEthernet(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, speed));
                }
                case 2 -> {
                    aSms = r.nextInt(1000);
                    aMinutes = r.nextInt(1000);
                    aGB = r.nextInt(1000);
                    contracts.add(new ContractMobile(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aMinutes, aSms, aGB));
                }
                case 3 -> {
                    aChannel = r.nextInt(10);
                    String[] packageChannels = new String[aChannel];
                    for (int j = 0; j < aChannel; j++) {
                        packageChannels[j] = channels[j];
                    }
                    contracts.add(new ContractTV(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aChannel, packageChannels));
                }
            }
        }
        contracts.toString();
        System.out.println("\n-Search contracts, where human gender is female-");
        contracts.searchByFilter(x -> x.getHuman().getGender() == Gender.Female).toString();
    }

    @Test
    public void quickSort(){
        Repository contracts = new Repository();
        int amount = r.nextInt(10), typeOfContract, name, secondName, gender, speed, aChannel, aSms, aMinutes, aGB, y, m, d, yc, mc, dc, sPassport, nPassport;
        System.out.println(amount + " contracts are registered in the system!");
        for (int i = 0; i < amount; i++) {
            typeOfContract = r.nextInt(3) + 1;
            name = r.nextInt(3);
            secondName = r.nextInt(3);
            gender = r.nextInt(2);
            y = 2002 - r.nextInt(70);
            m = r.nextInt(12) + 1;
            d = r.nextInt(28) + 1;
            sPassport = r.nextInt(8999) + 1000;
            nPassport = r.nextInt(899999) + 100000;
            Person human = new Person(i + 1, names[gender][name] + " " + secondNames[gender][secondName], LocalDate.of(y, m, d), Gender.values()[gender], sPassport + " " + nPassport);
            switch (typeOfContract) {
                case 1 -> {
                    speed = r.nextInt(500);
                    contracts.add(new ContractEthernet(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, speed));
                }
                case 2 -> {
                    aSms = r.nextInt(1000);
                    aMinutes = r.nextInt(1000);
                    aGB = r.nextInt(1000);
                    contracts.add(new ContractMobile(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aMinutes, aSms, aGB));
                }
                case 3 -> {
                    aChannel = r.nextInt(10);
                    String[] packageChannels = new String[aChannel];
                    for (int j = 0; j < aChannel; j++) {
                        packageChannels[j] = channels[j];
                    }
                    contracts.add(new ContractTV(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aChannel, packageChannels));
                }
            }
        }
        contracts.toString();
        System.out.println("\n-Quick sort by year start date of contract-");
        QuickSorter qsort = new QuickSorter();
        System.out.println("\n");
        System.out.println("QuickSorter: \n");
        qsort.sort(contracts.getAll(), Comparator.comparingInt((ContractDefault c) -> c.getdOfStartContract().getYear()));
        contracts.toString();
    }

    @Test
    public void bubbleSort(){
        Repository contracts = new Repository();
        int amount = r.nextInt(10), typeOfContract, name, secondName, gender, speed, aChannel, aSms, aMinutes, aGB, y, m, d, yc, mc, dc, sPassport, nPassport;
        System.out.println(amount + " contracts are registered in the system!");
        for (int i = 0; i < amount; i++) {
            typeOfContract = r.nextInt(3) + 1;
            name = r.nextInt(3);
            secondName = r.nextInt(3);
            gender = r.nextInt(2);
            y = 2002 - r.nextInt(70);
            m = r.nextInt(12) + 1;
            d = r.nextInt(28) + 1;
            sPassport = r.nextInt(8999) + 1000;
            nPassport = r.nextInt(899999) + 100000;
            Person human = new Person(i + 1, names[gender][name] + " " + secondNames[gender][secondName], LocalDate.of(y, m, d), Gender.values()[gender], sPassport + " " + nPassport);
            switch (typeOfContract) {
                case 1 -> {
                    speed = r.nextInt(500);
                    contracts.add(new ContractEthernet(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, speed));
                }
                case 2 -> {
                    aSms = r.nextInt(1000);
                    aMinutes = r.nextInt(1000);
                    aGB = r.nextInt(1000);
                    contracts.add(new ContractMobile(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aMinutes, aSms, aGB));
                }
                case 3 -> {
                    aChannel = r.nextInt(10);
                    String[] packageChannels = new String[aChannel];
                    for (int j = 0; j < aChannel; j++) {
                        packageChannels[j] = channels[j];
                    }
                    contracts.add(new ContractTV(i + 1, LocalDate.of(yc = 2020 - r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), LocalDate.of(yc += r.nextInt(20), mc = m = r.nextInt(12) + 1, dc = d = r.nextInt(28) + 1), i + 1, human, aChannel, packageChannels));
                }
            }
        }
        contracts.toString();
        System.out.println("\n-Bubble sort by year start date of contract-");
        BubbleSorter bsort = new BubbleSorter();
        System.out.println("\n");
        System.out.println("BubbleSorter: \n");
        bsort.sort(contracts.getAll(), Comparator.comparingInt((ContractDefault c) -> c.getdOfStartContract().getYear()));
        contracts.toString();
    }
}
