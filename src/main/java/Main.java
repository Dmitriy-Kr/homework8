import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = "";

        System.out.println("Поиск файлов с расширением .java в текущей и вложенных директориях.");
        System.out.print("Введите путь к директории: ");

        if (scanner.hasNextLine()) {
            path = scanner.nextLine();
        }

        File file = new File(path);

        if (!file.exists() || file.isFile()) {
            System.out.println("Неверно указан путь к директории.");
            System.out.println("Выход из программы.");
            return;
        }

        printFiles(file);
    }

    public static void printFiles(File file) {
        for (File f : file.listFiles(pathname -> pathname.getName().endsWith(".java") || pathname.isDirectory())) {
            if (f.isDirectory()) {
                printFiles(f);
            } else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
