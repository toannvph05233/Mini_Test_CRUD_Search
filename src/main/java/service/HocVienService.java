package service;

import dao.config.HocVienDao;
import model.HocVien;

import java.util.List;

public class HocVienService {

    public List<HocVien> getAll(){
        return HocVienDao.getAll();
    }
    public List<HocVien> findByName(String name){
        return HocVienDao.findByName(name);
    }

    public void save(HocVien hocVien){
        HocVienDao.saveHocVien(hocVien);
    }
}
