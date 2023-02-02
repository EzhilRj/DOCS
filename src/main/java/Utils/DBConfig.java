package Utils;

import Scripts.BaseClass;
import org.testng.Assert;

import java.io.IOException;
import java.sql.*;

public class DBConfig extends BaseClass {


    public static void ConnectDB(String query, String empname,String Mobile , String Email,int Row , int col) throws ClassNotFoundException, SQLException, SQLException, IOException {

        Connection con = null;

        String Databaseurl = "jdbc:sqlserver://183.83.187.133\\FIELDLYTICSDEVS:1433;DatabaseName=HRMS_ARVIND;encrypt=true;trustServerCertificate=true";
        String Dbusername = "Fieldlytics2021";
        String Dbpassword = "PPMSdevserver$2022";


        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(Databaseurl,Dbusername,Dbpassword);

            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            result.next();
            boolean employeename = result.getString("EmployeeName").equals(empname);
            boolean Mno = result.getString("MobileNo").equals(Mobile);
            boolean mail = result.getString("Emailid").equals(Email);

            if(employeename==true&&Mno==true&&mail==true){

                xlcon.setCellValue(Row,col,"Testcase Passed",excelfilepath);
                Assert.assertTrue(true);

                Statement statement1 = con.createStatement();
                statement1.executeUpdate("delete from Employeeinitiatedocs where MobileNo = "+ Mobile);
                System.out.println("Delete Query Executed");



            }else{

                    Assert.assertTrue(false);
                    xlcon.setCellValue(Row,col,"Testcase Failed",excelfilepath);


            }

        }catch (Exception e){

            System.out.println(e.getMessage());
            Assert.assertTrue(false);
            xlcon.setCellValue(Row,col,"Testcase Failed",excelfilepath);

        }finally {


            if(con!=null){

                con=null;
            }


        }

    }

}
