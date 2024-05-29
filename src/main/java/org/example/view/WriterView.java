package org.example.view;

import org.example.controller.WriterController;
import org.example.model.Writer;

import java.util.List;
import java.util.Scanner;

public class WriterView {
    private final Scanner scanner;
    private final WriterController writerController;

    public WriterView() {
        this.scanner = new Scanner(System.in);
        this.writerController = new WriterController();
    }

    public void showAllWriter() {
        List<Writer> writers = writerController.getAllWriter();
        for (Writer writer : writers) {
            System.out.println(writer);
        }
    }

    public void showWriterById() {
        System.out.print("Введите id для поиска: ");
        Long numberId = scanner.nextLong();
        System.out.println(writerController.getWriterById(numberId));
    }

    public void saveNewWriter() {
        Writer writer = new Writer();
        System.out.print("Введите firstName: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите lastName: ");
        String lastName = scanner.nextLine();
        writer.setFirstname(firstName);
        writer.setLastname(lastName);
        writerController.addNewWriter(writer);
    }

    public void updatedWriterById() {
        System.out.print("Введите id для редактирования: ");
        Long numberId = scanner.nextLong();
        Writer writer = writerController.getWriterById(numberId);
        scanner.nextLine();
        System.out.print("Введите firstName: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите lastName: ");
        String lastName = scanner.nextLine();
        writer.setFirstname(firstName);
        writer.setLastname(lastName);
        writerController.updatedWriterById(numberId, writer);
    }

    public void deletedWriterById() {
        System.out.print("Введите id для удаления: ");
        Long numberId = scanner.nextLong();
        writerController.deletedWriterById(numberId);
    }
}
