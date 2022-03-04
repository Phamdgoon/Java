package CRUDThuVien;

import java.util.ArrayList;
import java.util.List;


public class ThuVienService {
    private CRUDThuVien crud;
    
    List<ThuVien> persons = new ArrayList<ThuVien>();
    public ThuVienService () {
        crud = new CRUDThuVien();  
    }
    
    //tra ve danh sach kieu Persons
    public List<ThuVien> GetAllPersons() {
        return crud.getAllPersons();     
    }
    
    public void AddNewPersons(ThuVien person) {
        crud.AddPersons(person);
    }
    
    public void DeletePersons(String Id ) {
        crud.DeletePerson(Id);
    }
    
    public ThuVien GetPersonByID(String IDperson) {
        return crud.GetPesronByID(IDperson);
    }
        
    public ThuVien findbyTheLoai(String theloai) {
        for (ThuVien tl : persons) {
            if(tl.getTheLoai().equalsIgnoreCase(theloai)) {
                return tl;
            }
        }
        return null;
    }
}
