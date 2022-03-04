package CRUDThuVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;


public class CRUDThuVien {
    
    
    //ham tra ve danh sach kieu Persons 
    public List<ThuVien> getAllPersons() {
        List<ThuVien> persons = new ArrayList<ThuVien>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from UserThuVien");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ThuVien user = new ThuVien();
                
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("Name"));
                user.setTheLoai(rs.getString("TheLoai"));
                user.setNhaXuatBan(rs.getString("NhaXuatBan"));
                user.setSoBanXuatHanh(rs.getString("SoBanXuatHanh"));
                user.setSoTrang(rs.getString("SoTrang"));
                user.setSoPhatHanh(rs.getString("SoPhatHanh"));
                user.setNgayPhatHanh(rs.getString("NgayPhatHanh"));
                
                persons.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDThuVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }
    
    //Ham lay ra Persons theo ID
    public ThuVien GetPesronByID(String IDperson) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from UserThuVien where ID = ?");
            ps.setString(1, IDperson);
            ResultSet rs = ps.executeQuery();
            
            ThuVien user = new ThuVien();
            while (rs.next()) {
                user.setID(rs.getString("ID"));
                user.setName(rs.getString("Name"));
                user.setTheLoai(rs.getString("TheLoai"));
                user.setNhaXuatBan(rs.getString("NhaXuatBan"));
                user.setSoBanXuatHanh(rs.getString("SoBanXuatHanh"));
                user.setSoTrang(rs.getString("SoTrang"));
                user.setSoPhatHanh(rs.getString("SoPhatHanh"));
                user.setNgayPhatHanh(rs.getString("NgayPhatHanh"));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDThuVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(IDperson.equals(null)) {
            System.out.println("GetPesronByID() person is null.");
        }
        return null;
    }
    
    //Ham them 1 nguoi dung
    public void AddPersons(ThuVien person) {
        
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into UserThuVien values (?,?,?,?,?,?,?,?)");
            ps.setString(1, person.getID());
            ps.setString(2, person.getName());
            ps.setString(3, person.getTheLoai());  
            ps.setString(4, person.getNhaXuatBan());
            ps.setString(5, person.getSoBanXuatHanh());
            ps.setString(6, person.getSoTrang());
            ps.setString(7, person.getSoPhatHanh());
            ps.setString(8, person.getNgayPhatHanh());
            
            
            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDThuVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    //Ham sua  nguoi dung
    public void UpdatePerson (ThuVien person) {
        
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("update UserThuVien set ID = ?, Name = ? , TheLoai = ?, "
                    + "NhaXuatBan = ?, SoBanXuatHanh = ?, SoTrang = ? , SoPhatHanh = ?, NgayPhatHanh = ?");
            
            ps.setString(1, person.getID());
            ps.setString(2, person.getName());
            ps.setString(3, person.getTheLoai());  
            ps.setString(4, person.getNhaXuatBan());
            ps.setString(5, person.getSoBanXuatHanh());
            ps.setString(6, person.getSoTrang());
            ps.setString(7, person.getSoPhatHanh());
            ps.setString(8, person.getNgayPhatHanh());
            
            int result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDThuVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    // Ham xoa nguoi dung
    public void DeletePerson (String Id) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from UserThuVien where ID = ?");
            ps.setString(1,Id);
            
            int result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDThuVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    
}
