package models;

public abstract class BenhAn {
    String stt;
    String idBenhAn;
    String nameBenhAn;
    String tenBenhNhan;
    String ngayNhapVien;
    String ngayRaVien;
    String lyDoNhapVien;

    public BenhAn(String stt, String idBenhAn, String nameBenhAn, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.stt = stt;
        this.idBenhAn = idBenhAn;
        this.nameBenhAn = nameBenhAn;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }


    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(String idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public String getNameBenhAn() {
        return nameBenhAn;
    }

    public void setNameBenhAn(String nameBenhAn) {
        this.nameBenhAn = nameBenhAn;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public String showInformation(){
        return "Số thứ tự: " + this.stt + ", Mã bệnh án: " + this.idBenhAn + ", Tên bệnh án: " + this.nameBenhAn
                +", Tên bệnh nhân: " + this.tenBenhNhan + ", Ngày nhập viện: " + this.ngayNhapVien + ", Ngày ra viện: " + this.ngayRaVien
                + ", Lý do nhập viện: " + this.lyDoNhapVien;
    }
    @Override
    public String toString() {
        return "BenhAn{" +
                "stt='" + stt + '\'' +
                ", idBenhAn='" + idBenhAn + '\'' +
                ", nameBenhAn='" + nameBenhAn + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'' +
                '}';
    }
}
