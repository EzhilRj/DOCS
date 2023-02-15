package Utils;

import Scripts.BaseClass;
import org.testng.Assert;

import java.io.IOException;
import java.sql.*;

import static Utils.Constant.*;

public class DBConfig extends BaseClass {


    public static void ConnectDB(String query, String empname,String Mobile , String Email,int Row , int col) throws ClassNotFoundException, SQLException, SQLException, IOException {

        Connection con = null;

        try{

            Class.forName(classname);
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

                Thread.sleep(1000);
                Statement statement1 = con.createStatement();
                statement1.executeUpdate("delete from Employeeinitiatedocs where MobileNo = "+ Mobile);
                System.out.println("Delete Query Executed");



            }else{

                    xlcon.setCellValue(Row,col,"Testcase Failed",excelfilepath);
                    Assert.assertTrue(false);



            }

        }catch (Exception e){

            xlcon.setCellValue(Row,col,"Testcase Failed",excelfilepath);
            System.out.println(e.getMessage());
            Assert.assertTrue(false);


        }finally {


            if(con!=null){

                con=null;
            }


        }

    }

}
