package com.first.mysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MenuDriven {
   private static  String driver = "com.mysql.jdbc.Driver";
    private static  String url = "jdbc:mysql://localhost:3306/jdbc1";
    private static  String user = "root";
    private static  String pass = "";

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        while (true){
            try {
                int choice;
                BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("1.Create\r\n2.Insert\r\n3.Update\r\n4.Delete\r\n5.Select");
                System.out.println("which query you want perform?");
                choice=Integer.parseInt(bfr.readLine());

                switch(choice){
                    case 1:
                        try {
                        String Create_QUERY = "create table table1 (id int(10),name varchar(20))";
                        Class.forName(driver);
                        con = DriverManager.getConnection(url, user, pass);
                        st = con.createStatement();
                        st.executeUpdate(Create_QUERY);
                        System.out.println("table Created");
                    }catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                        break;
                    case 2:
                        try {
                            String INSERT_QUERY="INSERT INTO EMP VALUES(3,'abc')";
                            Class.forName(driver);
                            con= DriverManager.getConnection(url,user,pass);
                            st= con.createStatement();
                            st.executeUpdate(INSERT_QUERY);
                            System.out.println("data inserted");
                        }catch (ClassNotFoundException e){
                            e.printStackTrace();
                        } catch (SQLException e){
                            e.printStackTrace();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        String Update_QUERY = "update student set salary=33001 where id=3";
                        try {
                            Class.forName(driver);
                            con = DriverManager.getConnection(url, user, pass);
                            st = con.createStatement();
                            st.executeUpdate(Update_QUERY);
                            System.out.println("table Updated");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        String DELETE_QUERY = "delete from student where id=1";
                        try {
                            Class.forName(driver);
                            con = DriverManager.getConnection(url, user, pass);
                            st = con.createStatement();
                            st.executeUpdate(DELETE_QUERY);
                            System.out.println("Record Deleted");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        ResultSet r=null;
                        String SELECT_QUERY = "select * from student";
                        try {
                            Class.forName(driver);
                            con = DriverManager.getConnection(url, user, pass);
                            st = con.createStatement();
                            r=st.executeQuery(SELECT_QUERY);
                            while (r.next()){
                                System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3));
                            }

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Invalid Query");
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
