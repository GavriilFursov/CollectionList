import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> saleList = new ArrayList<>();
        while (true) {
            System.out.println();
            System.out.println("Список покупок!  \n Добавить - 1, Показать - 2, Удалить - 3, Найти товар - 4 , Выход  - 5 ");
            String input = scanner.nextLine();
            if (input.length() > 1) {
                System.out.println("Введено некорректное число!");
                continue;
            }
            if (input.equals("1")) {
                System.out.println("Введите добавляемый продукт? ");
                input = scanner.nextLine();
                saleList.add(input);
                System.out.printf("Вы добавили товар " + input);
                System.out.println();
            }
            if (input.equals("2")) {
                showList(saleList);
            }
            if (input.equals("3")) {
                if (saleList.size() != 0) {
                    System.out.println("Что удалить? (Введите номер или название)");
                    input = scanner.nextLine();
                    int index;
                    String name;
                    try {
                        index = Integer.parseInt(input);
                        if (index <= 0 || (index - 1) >= saleList.size()) {
                            System.out.println("Такого номера нет!!!");
                        } else {
                            System.out.printf("%s - Было удалено!\n", saleList.get(index - 1));
                            saleList.remove(index - 1);
                            showList(saleList);
                        }
                    } catch (NumberFormatException e) {
                        name = input;
                        int containsOrNot = contentIndex(name, saleList);
                        if (containsOrNot >= 0) {
                            System.out.printf("%s - Было удалено!\n", name);
                            saleList.remove(containsOrNot);
                            showList(saleList);
                        } else {
                            System.out.println("Нету такого названия!!!");
                        }
                    }
                } else {
                    System.out.println("Список покупок пуст!");
                }
            }
            if (input.equals("4")) {
                System.out.println("Что надо найти?");
                input = scanner.nextLine();
                if (!input.equals("")) {
                    String partOf = input.toLowerCase();
                    System.out.println("Найдено: ");
                    int count = 0;
                    for (int i = 0; i < saleList.size(); i++) {
                        if (saleList.get(i).toLowerCase().contains(partOf)) {
                            System.out.println((i + 1) + " ." + saleList.get(i));
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Не найдено");
                    }
                } else {
                    System.out.println("Введите название!!!");
                }
            }
            if (input.equals("5")) {
                break;
            }
        }
    }

    public static void showList(List<String> list) {
        if (list.size() != 0) {
            int count = 1;
            for (String sp : list) {
                System.out.println(count + ". " + " " + sp);
                count++;
            }
        } else {
            System.out.println("Список пуст!!!");
        }
    }

    public static int contentIndex(String srt, List<String> list) {
        int contIndx = -1;
        String str = srt.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().equals(str)) {
                contIndx = i;
            }
        }
        return contIndx;
    }
}