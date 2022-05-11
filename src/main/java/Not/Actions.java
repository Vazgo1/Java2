package Not;

import java.sql.*;
import java.util.Scanner;

public class Actions {
    private static Connection dbConn;
    public static Statement statement;
    private static PreparedStatement pr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            dbConn = DBConnect.getConnection();
            statement = dbConn.createStatement();



            //createTable();
            //updateData(sc.nextLine(),sc.nextLine());
            //insertData(sc.nextLine(), sc.nextLine());
            //System.out.println("Введите имя заметки чтобы удалить");
            //System.out.println(Commands.DEL_MSG.getText());
            //deleteData(sc.nextLine());
            //getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection();
        }
    }


    private static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS note (\n"
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "name TEXT,\n"
                + "content TEXT \n"
                + ")");
    }

    public void insertData(String name, String content) throws SQLException {

        //  statement.executeUpdate("INSERT INTO note (name, content)\n"
        //        + "VALUES ('" + name + "','" + content + "' );");

        String SQL = String.format("INSERT INTO note (name, content)"
                + "VALUES ('%s','%s' );", name, content);
        //System.out.println("Заметка " + name + " успешно созданна.");

        statement.executeUpdate(SQL);


    }

    public void updateData(String name, String content) throws SQLException {
        statement.executeUpdate("UPDATE note SET content = '" + content + "' WHERE name = '" + name + ";");
    }

    public String deleteData(String name) throws SQLException {
        String outgoingMessage = null;

        String sql = String.format("DELETE FROM note WHERE name = '%s'", name);
        int deleteСheck = statement.executeUpdate(sql);
        if (deleteСheck == 0) {
            outgoingMessage = Commands.NOTE_NOT_FOUND_MSG.getText();
        } else outgoingMessage = Commands.NOTE_DELETED_MSG.getText();


        return outgoingMessage;
    }


    public void getData() throws SQLException {
        ResultSet set = statement.executeQuery("SELECT * FROM note ;");
        while (set.next()) {
            System.out.println(set.getInt("id") + " : " + set.getString("name") + " - " + set.getString("content"));

        }
    }

    public void printList() throws SQLException {


        ResultSet resultSet = statement.executeQuery("SELECT title FROM note");

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println("- " + name);
        }

    }

    public void openNoteByName(String nameValue) throws SQLException {

        String sql = String.format("SELECT text FROM notes WHERE title = '%s'", nameValue);
        statement.executeQuery(sql);

        ResultSet resultSet = statement.executeQuery(sql);
        if (!resultSet.isBeforeFirst()) {
            System.out.println(Commands.NOTE_NOT_FOUND_MSG.getText());
        }

        while (resultSet.next()) {
            String text = resultSet.getString("text");
            System.out.println("Текст заметки: " + text);
        }

    }
    public void editNoteByName(String oldTitle, String newName, String content) throws SQLException {



            String sql = String.format("UPDATE notes SET title = '%s', text = '%s' WHERE title = '%s';", newName, content, oldTitle);
            int checkQuery = statement.executeUpdate(sql);
            if (checkQuery == 0) {
                System.out.println(Commands.NOTE_NOT_FOUND_MSG.getText());
            } else System.out.println(Commands.NOTE_CHANGE_MSG.getText());


    }

    public boolean checkQueryByName(String name) throws SQLException {

        boolean result = false;


            String sql = String.format("SELECT title FROM notes WHERE title = '%s'", name);
            ResultSet resultSet = statement.executeQuery(sql);

            if (!resultSet.isBeforeFirst()) {
                result = false;
            } else result = true;

        return result;
    }


    private static void getData2(int id) throws SQLException {
        pr = dbConn.prepareStatement("SELECT * FROM note WHERE id = ?;");
        pr.setInt(1, id);
        ResultSet set = pr.executeQuery();
        while (set.next()) {
            System.out.println(set.getInt("id") + " : " + set.getString("name") + " - " + set.getString("content"));

        }

    }

    private static void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (dbConn != null) {
            try {
                dbConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


