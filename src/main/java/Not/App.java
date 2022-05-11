package Not;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {

        Scanner commandInputScanner = new Scanner(System.in);
        Scanner queryInputScanner = new Scanner(System.in);
        Actions actions = new Actions();

        CommandService commandService = new CommandService();

        System.out.println(Commands.START_MSG.getText());
        System.out.println(" - - - ");
        System.out.println(Commands.START_MSG_HELP.getText());
        System.out.println(Commands.START_MSG_NEW.getText());
        System.out.println(Commands.START_MSG_LIST.getText());

        while (true) {

            String message = commandInputScanner.nextLine();
            switch (message) {

                case "End" -> {
                    System.out.println(Commands.APP_OFF_MSG.getText());
                    System.exit(0);
                }

                case "New" -> {
                    System.out.println(Commands.NEW_NOTE_TITLE_MSG.getText());
                    String name = queryInputScanner.nextLine();
                    System.out.println(Commands.NEW_NOTE_TEXT_MSG.getText());
                    String content = queryInputScanner.nextLine();
                    actions.insertData(name, content);
                    System.out.println(Commands.NOTE_SAVED_MSG.getText());
                }

                case "Del" -> {
                    System.out.println(Commands.DEL_MSG.getText());
                    System.out.println(actions.deleteData(queryInputScanner.nextLine()));
                }

                case "All" -> {
                    actions.getData();
                }

                case "List" -> {
                    System.out.println(Commands.LIST_OF_NOTES_MSG.getText());
                    actions.printList();
                }

                case "Open" -> {
                    System.out.println(Commands.OPEN_TITLE_MSG.getText());
                    actions.openNoteByName(queryInputScanner.nextLine());
                }

                case "Edit" -> {
                    System.out.println(Commands.EDIT_TITLE_MSG.getText());
                    String oldTitle = queryInputScanner.nextLine();
                    if (actions.checkQueryByName(oldTitle)) {
                        System.out.println(Commands.NEW_TITLE_MSG.getText());
                        String newName = queryInputScanner.nextLine();
                        System.out.println(Commands.NEW_TEXT_MSG.getText());
                        String content = queryInputScanner.nextLine();
                        actions.editNoteByName(oldTitle, newName, content);
                    } else System.out.println(Commands.NOTE_NOT_FOUND_MSG.getText());
                }

                case "Help" -> {
                    commandService.printCommands();
                }

                default -> {
                    System.out.println(Commands.COMMAND_NOT_FOUND_MSG.getText());
                }
            }
        }
    }
}

