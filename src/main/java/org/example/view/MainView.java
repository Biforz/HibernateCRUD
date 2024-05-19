package org.example.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);

    public MainView() {}

    private final LabelView labelView = new LabelView();
    private final PostView postView = new PostView();
    private final WriterView writerView = new WriterView();

    public void start() {
        System.out.print("Выберите сущность: \n1 - Writer\n2 - Post\n3 - Label\n0 - Выход\nВведите ваш выбор: ");
        String inputNumber = scanner.nextLine();

        try {
            switch (inputNumber) {
                case "1":
                    startMenuWriter();
                    break;
                case "2":
                    startMenuPost();
                    break;
                case "3":
                    startMenuLabel();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Неверный ввод! Попробуйте еще раз");
                    start();
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода " + e);
            start();
        }
    }

    private void startMenuWriter() {
        System.out.print("Доступные действия: " +
                "\n1 - Показать всех Writers\n2 - Найти Writer по id\n3 - Добавить новый Writer в таблицу" +
                "\n4 - Редактировать Writer по id\n5 - Удалить Writer по id\n0 - Назад в меню" +
                "\nВведите ваш выбор: ");
        String inputNumber = scanner.nextLine();

        switch (inputNumber) {
            case "1":
                writerView.showAllWriter();
                startMenuWriter();
                break;
            case "2":
                writerView.showWriterById();
                startMenuWriter();
                break;
            case "3":
                writerView.saveNewWriter();
                startMenuWriter();
                break;
            case "4":
                writerView.updatedWriterById();
                startMenuWriter();
                break;
            case "5":
                writerView.deletedWriterById();
                startMenuWriter();
                break;
            case "0":
                start();
                break;
            default:
                System.out.println("Неверный ввод! Попробуйте еще раз");
                startMenuWriter();
        }
    }

    private void startMenuPost() {
        System.out.print("Доступные действия: " +
                "\n1 - Показать всех Posts\n2 - Найти Post по id\n3 - Добавить новый Post в таблицу" +
                "\n4 - Редактировать Post по id\n5 - Удалить Post по id\n0 - Назад в меню" +
                "\nВведите ваш выбор: ");
        String inputNumber = scanner.nextLine();

        switch (inputNumber) {
            case "1":
                postView.showAllPost();
                startMenuPost();
                break;
            case "2":
                postView.showPostById();
                startMenuPost();
                break;
            case "3":
                postView.saveNewPost();
                startMenuPost();
                break;
            case "4":
                postView.updatePostById();
                startMenuPost();
                break;
            case "5":
                postView.deletedPostById();
                startMenuPost();
                break;
            case "0":
                start();
                break;
            default:
                System.out.println("Неверный ввод! Попробуйте еще раз");
                startMenuPost();
        }
    }

    private void startMenuLabel() {
        System.out.print("Доступные действия: " +
                "\n1 - Показать всех Labels\n2 - Найти Label по id\n3 - Добавить новый Label в таблицу" +
                "\n4 - Редактировать Label\n5 - Удалить Label по id\n0 - Назад в меню" +
                "\nВведите ваш выбор: ");
        String inputNumber = scanner.nextLine();

        switch (inputNumber) {
            case "1":
                labelView.showAllLabel();
                startMenuLabel();
                break;
            case "2":
                labelView.showLabelById();
                startMenuLabel();
                break;
            case "3":
                labelView.saveNewLabel();
                startMenuLabel();
                break;
            case "4":
                labelView.updateLabelById();
                startMenuLabel();
                break;
            case "5":
                labelView.deletedLabelById();
                startMenuLabel();
                break;
            case "0":
                start();
                break;
            default:
                System.out.println("Неверный ввод! Попробуйте еще раз");
                startMenuLabel();
        }
    }
}
