import java.io.*;
import java.util.*;

public class main {

        private static final int STATIC_COLLECTION_SIZE = 5; // Размер статической коллекции

        public static void main(String[] args) {
            System.out.println("Hello world!");
            // 1. Добавление и удаление объектов
            ArrayList<String> stringList = new ArrayList<>();
            stringList.add("Java");
            stringList.add("Python");
            stringList.add("C++");
            System.out.println("Исходная коллекция: " + stringList);

            // 2. Поиск одинаковых элементов с подсчетом совпадений
            countOccurrences(stringList);

            // 3. Выгрузка в xml-файл
            exportToXml(stringList);

            // 4. Реверс всех строк, входящих в коллекцию
            reverseStrings(stringList);
            System.out.println("Коллекция после реверса: " + stringList);

            // 5. Статистика по всем символам, содержащимся в строках коллекции
            characterStatistics(stringList);

            // 6. Поиск подстроки в строках коллекции
            findSubstring(stringList, "va");

            // 7. Инициализация листа по текстовому файлу и вывод содержимого коллекции на экран
            initializeFromFile("input.txt");

            // 8. Расширить функциональность класса ArrayList методом compareInnerObjects(int firstIndex, int secondIndex)
            compareInnerObjects(stringList, 0, 1);

            // 9. Посчитать длины строк входящих в коллекцию, и вывести результат в упорядоченном виде
            printSortedLengths(stringList);

            // 10. Реализовать возможность добавления в динамическую коллекцию с удалением старых элементов
            dynamicCollectionExample();
        }

        // Методы для решения задач

        private static void countOccurrences(ArrayList<String> list) {
            Map<String, Integer> occurrences = new HashMap<>();
            for (String str : list) {
                occurrences.put(str, occurrences.getOrDefault(str, 0) + 1);
            }

            System.out.println("Подсчет совпадений: " + occurrences);
        }

        private static void exportToXml(ArrayList<String> list) {
            try (PrintWriter writer = new PrintWriter("output.xml")) {
                writer.println("<strings>");
                for (String str : list) {
                    writer.println("  <string>" + str + "</string>");
                }
                writer.println("</strings>");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private static void reverseStrings(ArrayList<String> list) {
            for (int i = 0; i < list.size(); i++) {
                String reversed = new StringBuilder(list.get(i)).reverse().toString();
                list.set(i, reversed);
            }
        }

        private static void characterStatistics(ArrayList<String> list) {
            Map<Character, Integer> charStatistics = new HashMap<>();
            for (String str : list) {
                for (char c : str.toCharArray()) {
                    charStatistics.put(c, charStatistics.getOrDefault(c, 0) + 1);
                }
            }

            System.out.println("Статистика символов: " + charStatistics);
        }

        private static void findSubstring(ArrayList<String> list, String substring) {
            for (String str : list) {
                if (str.contains(substring)) {
                    System.out.println("Подстрока '" + substring + "' найдена в строке: " + str);
                }
            }
        }

        private static void initializeFromFile(String filename) {
            ArrayList<String> fileStrings = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    fileStrings.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Инициализация из файла. Содержимое коллекции: " + fileStrings);
        }

        private static void compareInnerObjects(ArrayList<String> list, int firstIndex, int secondIndex) {
            if (list.get(firstIndex).equals(list.get(secondIndex))) {
                System.out.println("Элементы на позициях " + firstIndex + " и " + secondIndex + " равны.");
            } else {
                System.out.println("Элементы на позициях " + firstIndex + " и " + secondIndex + " не равны.");
            }
        }

        private static void printSortedLengths(ArrayList<String> list) {
            List<Integer> lengths = new ArrayList<>();
            for (String str : list) {
                lengths.add(str.length());
            }

            Collections.sort(lengths);
            System.out.println("Длины строк в упорядоченном виде: " + lengths);
        }

        private static void dynamicCollectionExample() {
            ArrayList<String> dynamicCollection = new ArrayList<>();
            for (int i = 1; i <= 8; i++) {
                dynamicCollection.add("Element " + i);
                if (dynamicCollection.size() > STATIC_COLLECTION_SIZE) {
                    dynamicCollection.remove(0); // Удаление первого элемента при достижении порогового значения
                }
                System.out.println("Текущая коллекция: " + dynamicCollection);
            }
        }
    }






