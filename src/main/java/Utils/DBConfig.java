package Utils;

import Scripts.BaseClass;
import com.google.errorprone.annotations.Var;
import org.testng.Assert;

import java.io.IOException;
import java.sql.*;

import static Utils.Constant.*;

public class DBConfig extends BaseClass {
    static Connection con = null;

    //This Method is for Delete and Verify the data is stored or not in Database
    public static void ConnectDB(int Value, String empname, String Mobile , String Email, int Row , int col) throws ClassNotFoundException, SQLException, SQLException, IOException {

        try{

            Class.forName(classname);
            con = DriverManager.getConnection(Databaseurl,Dbusername,Dbpassword);
            log.info(con);

            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select * from EmployeeInitiateDocs where Employeename = '"+empname+"'");
            log.info(empname+Mobile+Email);

            result.next();
            boolean employeename = result.getString("EmployeeName").equals(empname);
            boolean Mno = result.getString("MobileNo").equals(Mobile);
            boolean mail = result.getString("Emailid").equals(Email);

            if(employeename==true&&Mno==true&&mail==true){

                xlcon.setCellValue(Row,col,"Testcase Passed",excelfilepath);
                log.info("TestCase Passed");
                Assert.assertTrue(true);

                Thread.sleep(1000);
                Statement statement1 = con.createStatement();
                statement1.executeUpdate("delete from Employeeinitiatedocs where MobileNo = "+ Mobile);
                log.warn("DeleteQuery Executed");

            }else{
                    xlcon.setCellValue(Row,col,"Testcase Failed",excelfilepath);
                    log.error("TestCase Failed");
                    Assert.assertTrue(false);
            }
        }catch (Exception e){
            xlcon.setCellValue(Row,col,"Testcase Failed",excelfilepath);
            System.out.println(e.getMessage());
            log.debug(e.getMessage());
            Assert.assertTrue(false);

        }finally {

            if(con!=null){
                con=null;
            }
        }

    }

    public static void connectDB2(String query){

        try{
            Class.forName(classname);
            con = DriverManager.getConnection(Databaseurl,Dbusername,Dbpassword);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            log.info(query);


        }catch (Exception e){
            System.out.println(e.getMessage());
            log.debug(e.getMessage());

        }finally {

            if(con!=null){
                con=null;
            }
        }
    }

}
