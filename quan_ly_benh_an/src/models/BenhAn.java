package models;

public abstract class BenhAn {
    String stt;
    String maBenhAn;
    String maBenhNhan;
    String tenBenhNhan;
    String ngayNhapVien;
    String ngayRaVien;
    String lyDoNhapVien;


    public BenhAn(String stt, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.stt = stt;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
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

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
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

    public String writeFile(){
        return this.stt + "," + this.maBenhAn+ "," + this.maBenhNhan + "," + this.tenBenhNhan + ","
                + this.ngayNhapVien + "," + this.ngayRaVien + "," + this.lyDoNhapVien;
    }

    public String showInformation(){
        return "Stt: " + this.stt + ", Mã bệnh án: " + this.maBenhNhan + ", Mã bệnh nhân: " + this.maBenhNhan
                +", Tên bệnh nhân: " + this.tenBenhNhan + ", Ngày nhập viện: " + this.ngayNhapVien + ", Ngày ra viện: " + this.ngayRaVien
                + ", Lý do nhập viện: " + this.lyDoNhapVien;
    }
    @Override
    public String toString() {
        return "BenhAn{" +
                "stt='" + stt + '\'' +
                ", maBenhAn='" + maBenhNhan + '\'' +
                ", tenBenhAn='" + maBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDoNhapVien='" + lyDoNhapVien + '\'' +
                '}';
    }
}
