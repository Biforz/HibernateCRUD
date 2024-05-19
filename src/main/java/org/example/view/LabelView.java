package org.example.view;

import org.example.controller.LabelController;
import org.example.model.Label;

import java.util.List;
import java.util.Scanner;

public class LabelView {
    private final Scanner scanner;
    private final LabelController labelController;

    public LabelView() {
        this.scanner = new Scanner(System.in);
        this.labelController = new LabelController();
    }

    public void showAllLabel() {
        List<Label> labels = labelController.getAllLabels();
        for (Label label : labels) {
            System.out.println(label);
        }
    }

    public void showLabelById() {
        System.out.print("Введите id для поиска: ");
        Long number = scanner.nextLong();
        System.out.println(labelController.getLabelById(number));
    }

    public void saveNewLabel() {
        Label label = new Label();
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        label.setName(name);
        labelController.addNewLabel(label);
    }

    public void updateLabelById() {
        System.out.print("Введите id для редактирования: ");
        Long id = scanner.nextLong();
        System.out.print("Введите имя: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Label label = new Label();
        label.setName(name);
        labelController.updatedLabelById(id, label);
    }

    public void deletedLabelById() {
        System.out.print("Введите id для удаления: ");
        Long id = scanner.nextLong();
        labelController.deletedLabelById(id);
    }
}
