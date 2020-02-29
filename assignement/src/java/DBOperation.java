import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperation {
    private Connection con = null;
    private PreparedStatement ps = null;
    private Statement st=null;
    private ResultSet rs = null;
    
    
    public void getCon() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        if(con== null){
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/forum","root","");
        }  
    }
    
    public boolean insertOneRecord(Student s){
        try{
            getCon(); 
            ps = con.prepareStatement("insert into Student values(?,?,?)");
            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getAge());
            ps.execute();
            return true;
        }catch(SQLException|ClassNotFoundException e){
            return false;
        }
    }
    
    public int insertMultiRecord(ArrayList<Student> list){
        try{
            int count=0;
            getCon();
            ps = con.prepareStatement("insert into Student values(?,?,?)");
            for(Student s: list){
                ps.setString(1, s.getId());
                ps.setString(2, s.getName());
                ps.setString(3, s.getAge());
                ps.addBatch();
                count++;
            }
            ps.executeBatch();
            return count;
        }catch(SQLException|ClassNotFoundException e){
            return -1;
        }  
    }
    
    public Student readOneRecord(String id){
        try{
            getCon();
            st = con.createStatement();
            rs = st.executeQuery("select * from Student where id='"+id+"'");
            return new Student(rs.getString(1),rs.getString(2),rs.getString(3));
        }catch(SQLException|ClassNotFoundException e){
            return null;
        }
    }  
    
    public ArrayList<Student> readAllRecord(){
        try{
            getCon();
            st = con.createStatement();
            rs = st.executeQuery("select * from Student");
            ArrayList<Student> records = new ArrayList<Student>();
            while(rs.next()){
                records.add(new Student(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            return records;
        }catch(SQLException|ClassNotFoundException e){
            return null;
        }
    }
    public boolean deleteOneRecord(String id){
        try{
            getCon();
            st = con.createStatement();
            st.execute("delete from Student where id='"+id+"'");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean deleteAllRecord(){
        try{
            getCon();
            st = con.createStatement();
            st.execute("delete from Student");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean updateRecord(String id, String name, String age){
        try{
            getCon();
            con.setAutoCommit(false);
            st = con.createStatement();
            st.executeUpdate("update name='"+name+"',age='"+age+"' where id='"+id+"'");
            con.commit();
            return true;
        }catch(Exception e){
            System.out.println(e);
            try{
                con.rollback();
            }catch(Exception y){
                
            }
            return false;
        }
    }
}
