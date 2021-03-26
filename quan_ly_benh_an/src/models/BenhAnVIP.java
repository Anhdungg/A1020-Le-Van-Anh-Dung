package models;

public class BenhAnVIP extends BenhAn {
    String loaiVIP;
    String thoiHan;

    public BenhAnVIP(String stt, String idBenhAn, String nameBenhAn, String tenBenhNhan, String ngayNhapVien,
                     String ngayRaVien, String lyDoNhapVien, String loaiVIP, String thoiHan) {
        super(stt, idBenhAn, nameBenhAn, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVIP = loaiVIP;
        this.thoiHan = thoiHan;
    }

    public String getLoaiVIP() {
        return loaiVIP;
    }

    public void setLoaiVIP(String loaiVIP) {
        this.loaiVIP = loaiVIP;
    }

    public String getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(String thoiHan) {
        this.thoiHan = thoiHan;
    }

    @Override
    public String showInformation() {
        return super.showInformation() + ", Loại VIP: " + this.loaiVIP + ", Thời hạn: ";
    }

    @Override
    public String toString() {
        return this.showInformation()+"\n";
    }
}
