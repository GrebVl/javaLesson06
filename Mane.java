import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Подумать над структурой класса Ноутбук для магазина техники
 * - выделить поля и методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать 
 * у пользователя критерий (или критерии) фильтрации 
 * и выведет ноутбуки, отвечающие фильтру. 
 * Критерии фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев
 * - сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества
 * и вывести проходящие по условиям.
 */

public class Mane {

    public static void rdmNotebook(Notebook nameNotbook) {
        Random rnd = new Random();
        String[] notBookColours = new String[] {"Red", "Blue", "Black", "White", "Green"};
        String[] nameNoteBooks = new String[] {"Dell", "Asus", "Lenovo", "LG", "Sony"};
        int[] RAMs = new int[] {2, 4, 8, 16, 32};
        int[] HDDs = new int[] {250, 500, 1000, 2000};
        String[] nameOpeSystems = new String[] {"Linux Fedora", "Linux Ubuntu", "Windows 10", "Windows 11", "Без системы"};
        nameNotbook.nameNB = nameNoteBooks[rnd.nextInt(4)];
        nameNotbook.nameOS = nameOpeSystems[rnd.nextInt(4)];
        nameNotbook.RAM = RAMs[rnd.nextInt(4)];
        nameNotbook.HDD = HDDs[rnd.nextInt(3)];
        nameNotbook.colourNB = notBookColours[rnd.nextInt(4)];
    }

    public static void main(String[] args) {


        String[] Colours = new String[] {"Red", "Blue", "Black", "White", "Green"};
        String[] OpeSystems = new String[] {"Linux Fedora", "Linux Ubuntu", "Windows 10", "Windows 11", "Без системы"};

        Map<Integer, Notebook> mapNotBook = new HashMap<>();

        Notebook notbookFerst = new Notebook();
        rdmNotebook(notbookFerst);

        Notebook notbookSecond = new Notebook();
        rdmNotebook(notbookSecond);

        Notebook notbookThid = new Notebook();
        rdmNotebook(notbookThid);

        Notebook notbookFourth = new Notebook();
        rdmNotebook(notbookFourth);

        Notebook notbookFifth = new Notebook();
        rdmNotebook(notbookFifth);

        Notebook notbookSixth = new Notebook("ThundeRobot");
        notbookSixth.nameOS = "Без системы";
        notbookSixth.RAM = 8;
        notbookSixth.HDD = 500;
        notbookSixth.colourNB = "Red";

        mapNotBook.put(notbookFerst.id, notbookFerst);
        mapNotBook.put(notbookSecond.id, notbookSecond);
        mapNotBook.put(notbookThid.id, notbookThid);
        mapNotBook.put(notbookFourth.id, notbookFourth);
        mapNotBook.put(notbookFifth.id, notbookFifth);
        mapNotBook.put(notbookSixth.id, notbookSixth);

        Set<Integer> keys = mapNotBook.keySet();

        boolean exFerst = true;

        while(exFerst){
            int count;
            System.out.println("Магазин ноутбуков в ведите номер для вывода:\n" +
                                "1. ОЗУ\n" + "2. объем ЖД\n" + "3. Операционная система\n" +
                                "4. Цвет\n" + "5. Выход\n");
            Scanner imput = new Scanner(System.in);
            int nFer = imput.nextInt();
            boolean exSecond = true;
            if(nFer == 1){
                while(exSecond){
                    System.out.println("ОЗУ:\n" + 
                                        "Введите объем от 2 до 16 Гб\n" +
                                         "Введите 1 для выхода\n");
                int nSec = imput.nextInt();
                count = 0;
                if(nSec >= 2 && nSec <= 16){
                    for(Object k : keys){
                        if(mapNotBook.get(k).IntRam(nSec)){
                            mapNotBook.get(k).infoNB();
                        }else{
                            count++;
                            if(count == mapNotBook.size()){
                                System.out.println("\nВналичие не имеется\n");
                            }
                        }
                    }
                }else if(nSec == 1){
                    exSecond = false;
                }else{
                    System.out.println("Введено не верное значение");
                }
                }
            }else if(nFer == 2){
                while(exSecond){
                    count = 0;
                    System.out.println("объем ЖД:\n" + 
                                        "Введите объем от 250 до 2000 Гб\n" +
                                         "Введите 1 для выхода\n");
                int nSec = imput.nextInt();
                if(nSec >= 250 && nSec <= 2000){
                    for(Object k : keys){
                        if(mapNotBook.get(k).IntHdd(nSec)){
                            mapNotBook.get(k).infoNB();
                        }else{
                            count++;
                            if(count == mapNotBook.size()){
                                System.out.println("\nВналичие не имеется\n");
                            }
                        }
                    }
                }else if(nSec == 1){
                    exSecond = false;
                }else{
                    System.out.println("Введено не верное значение");
                }
                }
            }else if(nFer == 3){
                while(exSecond){
                    System.out.println("Операционная система:\n" + "1. Linux Fedora\n" +
                                        "2. Linux Ubuntu\n" + "3. Windows 10\n" + "4. Windows 11\n" +
                                         "5. Без системы\n" + "6. Выход\n");
                int nSec = imput.nextInt();
                count = 0;
                if(nSec >= 1 && nSec <= 5){
                    for(Object k : keys){
                        if(mapNotBook.get(k).nameOpSyst(OpeSystems[nSec - 1])){
                            mapNotBook.get(k).infoNB();
                        }else{
                            count++;
                            if(count == mapNotBook.size()){
                                System.out.println("\nВналичие не имеется\n");
                            }
                        }
                    }
                }else if(nSec == 6){
                    exSecond = false;
                }else{
                    System.out.println("Введено не верное значение");
                }
                }
            }else if(nFer == 4){
                while(exSecond){
                    System.out.println("Цвет \n1. Red \n2. Blue\n" +
                                         "3. Black \n4. White \n5. Green \n6. Выход");
                int nSec = imput.nextInt();
                count = 0;
                if(nSec >= 1 && nSec <= 5){
                    for(Object k : keys){
                        if(mapNotBook.get(k).colour(Colours[nSec - 1])){
                            mapNotBook.get(k).infoNB();
                        }else{
                            count++;
                            if(count == mapNotBook.size()){
                                System.out.println("\nВналичие не имеется\n");
                            }
                        }
                    }
                }else if(nSec == 6){
                    exSecond = false;
                }else{
                    System.out.println("Введено не верное значение");
                }
                }
            }else if(nFer == 5){
                exFerst = false;
                imput.close();                
            }else{
                System.out.println("Введено не верное значение");
            }
        }
    }
}